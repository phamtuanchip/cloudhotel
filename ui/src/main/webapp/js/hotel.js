 
function loadDb(){
	var table = $("#danhsachchokham");
	//console.log(table);
	if(table.length >0){
		var link = "service/rest/healthcheck/list" ;
		table.find("tr:gt(0)").remove();
		$.ajax({
			type: "GET",
			url: link,
			dataType: "json" 
			}).success(function(data){
				$.each(data, function(index, value){
					//console.log(value);
					table.append(buildRow(index+1, value));
				});
				
			}).done(function() {
				console.log("page load done!!!");
			}).error(function () {
				console.log("error when get db from " + link);
		});
	}
}
$(function (){
	//setdefault input
	
	if($("#ngaykham").length > 0) {
		setDefaultDate("ngaykham");
	}
	if($("#ngaydangky").length > 0) {
		setDefaultDateTime("ngaydangky");
	}
	//Load table
	loadDb();
	//Quick search
	var form = $("#timkiem");
	var url = "service/rest/healthcheck/search" ;
	var fwd ="ketquatimkiem.jsp";
	var input = form.find("input");
	var searchBtn = form.find("#nuttimkiem");
	searchBtn.bind("click", function (){
		//console.log("search: " + input.val());
		 $.ajax({
				type: "GET",
				url: url,
				dataType: "json" 
				}).success(function(data){
					$.each(data, function(index, value){
						//console.log(value);
						//table.append(buildRow(index+1, value));
					});
					
				}).done(function() {
					console.log("page load done");
				}).error(function () {
					console.log("error when get db from " + link);
		 });
	});
	
	//Register
	
	var regform = $("#dangkykham");
	var regurl = "service/rest/healthcheck/add" ;
	 
	var reginput = regform.find("input");
	var regBtn = regform.find("#nutdangky");
	var obj ='{"maPhieu":"001","ngayLapPhieu":1423073190018,"nguoiLapPhieu":"user01","soThuTu":1,"gioKham":1423073190018,"loaiKham":"dichvu","noiKham":"P2001","bacSiKham":"bs01"}';
	regBtn.bind("click", function (){
		 //console.log("add: " + obj);
		 $.ajax({
				type: "POST",
				url: regurl,
				contentType: 'application/json',
				dataType: "json",
				data: obj
				}).success(function(data){
						loadDb();
						//console.log(data);
					 
					
				}).done(function() {
					console.log("page load done");
				}).error(function () {
					console.log("error when add object to db " + link);
		 });
	});
	
});

function buildRow(i, json){
	var hour = new Date(json.gioKham).getHours();
	var minute = new Date(json.gioKham).getMinutes();
	var day = $.datepicker.formatDate('dd/mm/yy',new Date(json.gioKham),"");
	var date = hour+':'+minute+' ' + day;
	var row ="<tr>";
	row+= '<th scope="row">'+i+'</th>';
	row+= '<td>'+json.maPhieu+'</td>';
		row+= '<td>'+json.nguoiLapPhieu+'</td>';
			row+= '<td>'+date+'</td>';
				row+= '<td>'+json.loaiKham+'</td>';
					row+= '<td>'+json.noiKham+'</td>';
						row+= '<td>'+json.bacSiKham+'</td>';
	row+= '</tr>';
	return row;
	
	 
}

function checkBhyt(id){
	var regform = $("#dangkykham");
	var reginput = regform.find("#"+id);
	
	if("bhyt" === id){
		$("#dangkykham").find("#uploadbhyt").css("display","block");
		console.log($("#dangkykham").find("#uploadbhyt"));
	} else {
		regform.find("#uploadbhyt").css("display","none");
	}
}
function setDefaultDate(id){
	//console.log(new Date().toJSON().slice(0,19));
	var MyDate = new Date();
	var MyDateString;

	//MyDate.setDate(MyDate.getDate() + 20);

	MyDateString = ('0' + MyDate.getDate()).slice(-2) + '/'
	             + ('0' + (MyDate.getMonth()+1)).slice(-2) + '/'
	             + MyDate.getFullYear();
	//console.log($("#"+id).val());
	//var regform = $("#dangkykham");
	$("#"+id).val(MyDateString);
	console.log($("#"+id).val());
	 
}

function setDefaultDateTime(id){
	//console.log(new Date().toJSON().slice(0,19));
	var MyDate = new Date();
	var MyDateString;

	//MyDate.setDate(MyDate.getDate() + 20);

	MyDateString = ('0' + MyDate.getDate()).slice(-2) + '/'
	             + ('0' + (MyDate.getMonth()+1)).slice(-2) + '/'
	             + MyDate.getFullYear() + " "
	             + ('0' + (MyDate.getHours())).slice(-2) + ':'
	             + ('0' + (MyDate.getMinutes())).slice(-2); 
	//console.log($("#"+id).val());
	//var regform = $("#dangkykham");
	$("#"+id).val(MyDateString);
	console.log($("#"+id).val());
	 
}
