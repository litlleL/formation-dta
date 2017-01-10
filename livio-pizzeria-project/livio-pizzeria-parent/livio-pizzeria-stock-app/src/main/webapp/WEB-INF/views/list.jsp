<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/dist/css/bootstrap.css"/>" rel="stylesheet"
	type="text/css">
<title>Liste des ingredients</title>
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script src="<c:url value='/dist/js/listing.js' />"></script>
</head>
<body>

	<table id="tableCLi" style="margin-top: 100px;">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prix</th>
				<th>Quantité</th>
			</tr>
		</thead>
		<tbody>



		</tbody>
	</table>

</body>
</html>