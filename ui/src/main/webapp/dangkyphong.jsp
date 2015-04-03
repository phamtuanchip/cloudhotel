<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />

<body>
	<jsp:include page="menu.jsp" />

	<div class="container" style="margin-top: 110px;">


		<div class="row">
		<form id="dangkyphong">
			<div class="form-group">
						<label for="ngaykham">Ngày vào viện</label> <input
							type="date"  id="ngaykham"
							class="form-control">
					</div>
			<label for="exampleInputText">Chọn khoa</label> 
			<select class="form-control">
			  <option>Nội</option>
			  <option>Ngoại</option>
			  <option>Lây</option>
			  <option>Cấp cứu</option>
			  <option>Nhi</option>
			</select>
			 
		</form>
		<div class="table-responsive">
			<span>Danh sách phòng bệnh</span>
			<table id="danhsachnamvien" class="table table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Stt</th>
						<th>Họ và tên</th>
						<th>Ngày nhập viện</th>
						<th>Khoa</th>
						<th>Phòng</th>
						<th>Giường</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
						<td>Table cell</td>
					</tr>
				</tbody>
			</table>

		</div>
		
		</div>

	</div>
	<jsp:include page="footer.jsp" />
</body>