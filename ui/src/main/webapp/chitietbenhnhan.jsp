<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />

<body>
	<jsp:include page="menu.jsp" />

	 
	<div class="container" style="margin-top: 110px;">
		<div class="row">
			 

				<form id="dangkykham">
					<div class="form-group">
						<label for="ngaydangky">Ngày đăng ký</label> <input
							type="datetime-local"  id="ngaydangky"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="ngaykham">Ngày khám</label> <input
							type="date"  id="ngaykham"
							class="form-control">
					</div>
					
					<div class="form-group">
						<label for="exampleInputText">Họ và tên</label> <input type="text"
							placeholder="Họ tên" id="exampleInputText" class="form-control">
					</div>
					<div class="radio">
						<label> <input name="Giới tính" type="radio"> Nam
						</label>
						<label> <input name="Giới tính" type="radio"> Nữ
						</label>
					</div>
					 

					<div class="form-group">
						<label for="exampleInputEmail1">Tuổi</label> <input type="number"
							placeholder="" id="exampleInputEmail1" class="form-control">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Địa chỉ</label> <input
							type="text" placeholder="Địa chỉ" id="exampleInputPassword1"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Điện thoại</label> <input
							type="text" placeholder="Địa chỉ" id="exampleInputPassword1"
							class="form-control">
					</div>
					<div class="form-group">
						<label> <input id="cc"name="bhyt" type="checkbox" onclick="" /> Khám cấp cứu 
						|
						<label for="exampleInputFile">Thẻ bảo hiểm:</label>
						<label> <input id="bhyt"name="bhyt" type="radio" onclick="checkBhyt(this.id);" /> Có
						</label>
						<label> <input id="kgbhyt" name="bhyt" type="radio" onclick="checkBhyt(this.id);" /> Không
						</label>
					 
					</div>
					<div class="form-group" id="uploadbhyt" style="display:none;">
						<label for="exampleInputFile">Tải lên</label> <input
							type="file" id="exampleInputFile">
						<p class="help-block">Chỉ upload ảnh scan của thẻ bảo hiểm y
							tế</p>
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">Ghi chú</label> <textarea
							type="text" placeholder="Ghi chú" id="exampleInputPassword1"
							class="form-control"> </textarea>
					</div>
					<div class="form-group">
						<button id="nutdangky" class="btn btn-default" type="button">Luu</button>
					</div>
				</form>
			 
		</div>
		<div class="table-responsive">

			<table id="danhsachchokham" class="table table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Stt</th>
						<th>Họ và tên</th>
						<th>Giờ đăng ký</th>
						<th>Trạng thái</th>
						<th>Phòng khám</th>
						<th>Bác sĩ khám</th>
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
	<jsp:include page="footer.jsp" />
</body>