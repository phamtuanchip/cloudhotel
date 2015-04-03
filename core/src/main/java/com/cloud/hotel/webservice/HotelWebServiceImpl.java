package com.cloud.hotel.webservice;

import static com.cloud.admin.model.TempTables.BANGPHIEU;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloud.hotel.model.services.Room;
import com.cloud.hotel.service.HotelService;
import com.cloud.hotel.service.HotelServiceFactory;
import com.cloud.log.LogShow;
import com.cloud.model.UploadFile;
import com.cloud.model.User;

@Path("/rest")
@Component
public class HotelWebServiceImpl {
	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "/uploads";
	
	@Autowired
	private HotelServiceFactory  serviceFactory;



	private  HotelService InstanceService(){
		return serviceFactory.getService();
	}

	//Hotel API
	

	@GET
	@Path("healthcheck/list")
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Room> listInorderInvoice() {
		 
		
		
		return BANGPHIEU;
	}
	
	

	@GET
	@Path("healthcheck/search")
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Room> search(@QueryParam(value = "key") String key) {
		key = "004";
		List<Room> list = new ArrayList<Room>();
		for(Room p : BANGPHIEU){
			if(p.getId().equals(key)) {
				list.add(p); return list;
			}
		}
		
		return list;
	}
	
	@POST
	@Path("healthcheck/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Room addInvoice(Room p) {
		BANGPHIEU.add(p);
		
		return p;
	}
	//File Rest API

	@POST
	@Path("file/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public UploadFile uploadFile(@Context HttpServletRequest request,
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition contentDispositionHeader) {
		String fileName = GregorianCalendar.getInstance().getTimeInMillis()+"_"+ contentDispositionHeader.getFileName();
		String OS = System.getProperty("os.name");
		String path = "/";
		if(OS.toLowerCase().startsWith("windows")) path = "\\";
		String folderPath = request.getServletContext().getRealPath(SERVER_UPLOAD_LOCATION_FOLDER);
				
				File folder = new File(folderPath);
		if (!folder.exists()) {
			if (folder.mkdir()) {
				System.out.println("Directory is created!");
			}  
		}
		String filePath = folder.getAbsolutePath() + path + fileName;
		System.out.println("upload...." + filePath);
		// save the file to the server
		saveFile(fileInputStream, filePath);
		
		String downloadLink =  request.getRequestURI().replace("upload", "download") +"/" + fileName;

		return new UploadFile(new Date(),"system",filePath, downloadLink); 

	}

	@GET
	@Path("file/download/{file}")
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response  downloadFile(@Context HttpServletRequest request, @PathParam(value = "file") String file) {
		String filePath = request.getServletContext().getRealPath(SERVER_UPLOAD_LOCATION_FOLDER)+"/"+ file;
		System.out.println("download .." + filePath);
		File download = new File(filePath);
		ResponseBuilder response = Response.ok((Object)download);
		response.header("Content-Disposition", "attachment; " + file);
		return response.build();

	}

	// save uploaded file to a defined location on the server
	private void saveFile(InputStream uploadedInputStream,
			String serverLocation) {

		try {
			OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			outpuStream = new FileOutputStream(new File(serverLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// User Rest API
	@Path("/user/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User register(@Context HttpServletRequest req, @Context HttpHeaders httpHeaders, User userLogin) {

		HttpSession session= req.getSession(true);
		System.out.println("=========userLogin" + userLogin.toString());
		User user = null;
		LogShow.getLogDebug("start check login:"+userLogin.getUsername());
		try{
			user = InstanceService().register(userLogin);
		}catch(Exception ex){
			LogShow.getLogDebug("start check login:"+userLogin.getUsername());
		}
		if(user != null){
			session.setAttribute(user.getUsername(), user.getUsername());
			LogShow.getLogDebug("return id:"+user.getUsername());
			user.setId(user.getUsername());
		} 
		return user;
	}
	
	// User Rest API
		@Path("/user/list")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<User> listUsers() {
			return InstanceService().listUsers();
		}

	@Path("/user/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User checkLogin(@Context HttpServletRequest req, @Context HttpHeaders httpHeaders, User userLogin) {

		HttpSession session= req.getSession(true);

		User user = null;
		LogShow.getLogDebug("start check login:"+userLogin.getUsername());
		try{
			user = InstanceService().login(userLogin);
		}catch(Exception ex){
			LogShow.getLogDebug("start check login:"+userLogin.getUsername());
		}
		if(user != null){
			session.setAttribute(user.getUsername(), user.getUsername());
			LogShow.getLogDebug("return id:"+user.getUsername());
			user.setId(user.getUsername());
		} 
		return user;
	}


	@Path("/user/logout")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkLogout(@Context HttpServletRequest req, @Context HttpHeaders httpHeaders) {

		HttpSession session= req.getSession(true);
		String id = httpHeaders.getRequestHeader("idUser").get(0);
		LogShow.getLogDebug("start check logout id:"+id);
		String checkUser = "ok";// (String)session.getAttribute(id);
		if (checkUser!=null) {
			LogShow.getLogDebug("start logout:"+checkUser);
			//session.removeAttribute(id);
			String result = "Success";
			return Response.status(200).entity(result).build();
		} else {
			LogShow.getLogDebug("logout failure");
			String result = "Failure";
			return Response.status(201).entity(result).build();
		}
	}

	@GET
	@Path("/user/search/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserInJSON(@Context HttpServletRequest req, @Context Response r, @PathParam("username") String username) throws AuthenticationException {
		User user = null;
		if(InstanceService() != null && username != null && !username.isEmpty()) {
			user = InstanceService().findByUsername(username);
			LogShow.getLogDebug("start search:"+user);
			HttpSession session= req.getSession(true);
			if(user != null){
				session.setAttribute(username, username);
				return	user;
			} else {
				r.status(Status.NOT_FOUND);
			}
			
		}
		 return user;

	}
	
	@Path("/user/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User u) {
		String result = "User saved : " + u;
		return InstanceService().update(u);

	}

	@Path("/user/authenticate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public User authenticate(@Context User u)
	{

		return u;
	}

	public HotelServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(HotelServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	 
}