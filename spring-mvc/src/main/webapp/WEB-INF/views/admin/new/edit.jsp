<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach"/>
<c:url var="editNewURL" value="/quan-tri/bai-viet/chinh-sua"/>
<c:url var="newAPI" value="/api/new"/>
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>

					<li><a href="#">Forms</a></li>
					<li class="active">Form Elements</li>
				</ul>
				<!-- /.breadcrumb -->

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty message}">	
								<div class="alert alert-${alert}">
									${message}
								</div>
							</c:if>	
							<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
							<!-- Cái tên   modelAttribute="model"   phải trùng với model bên phương thức editNew để nó có thể tìm thấy   -->
							<!-- dc tất cả các name chứa trong form như: categoryCode, title, thumbnail, shortDescription, content so với bên NewDTO-->
								
								<div class="form-group">
									<label for="categoryCode"
										class="col-sm-3 control-label no-padding-right">Thể loại:</label>
									<div class="col-sm-9">
										<%-- 
										<select class="form-control" id="categoryCode"
											name="categoryCode">
											<option value="">-- Chọn thể loại --</option>
											<c:forEach var="item" items="${categories}"><!-- categories này dc lấy tù bên NewController trong admin -->
												<option value="${item.code}">${item.name}</option>
											</c:forEach>
										</select> 
										--%>
										<form:select path="categoryCode" id="categoryCode"><!-- Đây là select của form -->
											<form:option value="" label="-- Chọn thể loại --"/>
											<form:options items="${categories}"/> <!-- Khi sử dụng form kiểu này thì bên xử lí phải dùng map bên ICategoryService còn nếu dùng như bên trên thì sử dụng list giống bên INewService -->
										</form:select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> Tên bài viết </label>
									<div class="col-sm-9">
										<%-- 
											<input type="text" class="col-xs-10 col-sm-5" id="title" name="title" value="${model.title}"/>
											Cách cũ 
										--%>
										
										<!-- Cách mới sử dụng theo form -->
										<form:input path="title" cssClass="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> Ảnh đại diện </label>
									<div class="col-sm-9">
										<input type="file" class="col-xs-10 col-sm-5" id="thumbnail" name="thumbnail" />
									</div>
								</div>

								<div class="form-group">
									<label for="shortDescription"
										class="col-sm-3 control-label no-padding-right">Mô tả ngắn:</label>
									<div class="col-sm-9">
										<%-- <textarea class="form-control" rows="5" cols="10 "
											id="shortDescription" name="shortDescription">${model.shortDescription}</textarea> --%>
											
										<form:textarea path="shortDescription" rows="5" cols="10" id="shortDescription" cssClass="form-control"/>
									</div>
								</div>

								<div class="form-group">
									<label for="content"
										class="col-sm-3 control-label no-padding-right">Nội dung:</label>
									<div class="col-sm-9">
										<%-- <textarea class="form-control" rows="7" cols="10 "
											id="content" name="content">${model.content}</textarea> --%>
										<form:textarea path="content" rows="7" cols="10 " id="content" cssClass="form-control"/>
									</div>
								</div>
								<form:hidden path="id" id="newId"/>
								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
										<c:if test="${not empty model.id}">
											<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
												<i class="ace-icon fa fa-check bigger-110">Cập nhật bài viết</i> 
											</button>
										</c:if>
										<c:if test="${empty model.id}">
											<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
												<i class="ace-icon fa fa-check bigger-110">Thêm bài viết</i> 
											</button>
										</c:if>

										&nbsp; &nbsp; &nbsp;
										<button class="btn" type="reset">
											<i class="ace-icon fa fa-undo bigger-110">Hủy</i> 
										</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#btnAddOrUpdateNew').click(function (e) {
	        e.preventDefault();//Khai báo để tránh lấy url đang đứng hiện tại. Chúng ta cần url ben api để cos thể thực hiện dc các thao tác
	        /* var title = $('#title').val();
	        var shortDescription = $('#shortDescription').val(); //Khai báo tuần tự các giá trị muốn lấy từ form. Việc này 
	        var content = $('#content').val();  				// làm mất thời gian quá nhiều nếu như có nhiều dữ liệu
	        var content = $('#content').val(); */				// Chính vì vậy nên sử dụng vòng lặp để có thể tiết kiệm thời gian.
	        
	        var data = {}; // Mảng data này sẽ dùng để put thông tin lấy từ bên formData qua
	        var formData = $('#formSubmit').serializeArray(); //Sử dụng như một vòng lặp để lấy thông tin từ form ra. 
	        //Form này sẽ lấy thông tin từ người dùng và đưa vô data để thành kiểu json cho bên api nhận dc và thực hiện các thao tác
	        
	        $.each(formData, function (i, v) { //Sử dụng vòng lặp để put thông tin vô biến data
            	data[""+v.name+""] = v.value;
        	});
	       
	        var id = $('#newId').val();
	        if(id == ""){
	        	addNew(data);
	        }else{
	        	updateNew(data);
	        } 
	    });
		//trong ajax: POST là thêm mới, PUT là cập nhật, GET là lấy dữ liệu, DELETE là xóa dữ liệu
		
		function addNew(data) {
			$.ajax({
	            url: '${newAPI}',
	            type: 'POST', //Chức năng thêm mới
	            contentType: 'application/json', //Kiều dữ liệu dc  gửi từ client về server
	            data: JSON.stringify(data), //sử dụng khái niệm JSON.stringify vì data ở bên ngoài dg là một javascript object mà chúng ta cần nhận vào json thì phải sử dụng hàm để chuyển đổi
	            dataType: 'json', // kiểu dữ liệu đẩy từ server về client
	            success: function (result) {
	            	window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success";
	            },
	            error: function (error) {
	            	window.location.href = "${newURL}?page=1&limit=2&message=error_system";
	            }
	        });
		}
		
		function updateNew(data) {
			$.ajax({
	            url: '${newAPI}',
	            type: 'PUT',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${editNewURL}?id="+result.id+"&message=update_success";
	            },
	            error: function (error) {
	            	window.location.href = "${editNewURL}?id="+result.id+"&message=error_system";
	            }
	        });
		}
	</script>
</body>
</html>
