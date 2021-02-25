<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap core CSS -->
<link href="" rel="stylesheet">
<link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="<c:url value='/template/web/css/small-business.css'/>" rel="stylesheet" />
<title>Trang chủ Web</title>
</head>
<body>
	<%@ include file="/common/web/header.jsp" %>

	<dec:body/>

	<%@ include file="/common/web/footer.jsp" %>

	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>