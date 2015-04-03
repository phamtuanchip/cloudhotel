 
package com.cloud.config;

import javax.ws.rs.container.ContainerResponseFilter;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.cloud.hotel.webservice.HotelWebServiceImpl;

 
public class WSRegister extends ResourceConfig {

   
    public WSRegister () {
       
    	register(RequestContextFilter.class);
    	//for Rest Service
        //register(TaskWebservice.class);
    	register(HotelWebServiceImpl.class);
        register(ContainerResponseFilter.class);
        //for CORS request
       
        //for upload
        register(MultiPartFeature.class);
        
    }
}
