<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/dist/css/bootstrap.css"/>" rel="stylesheet"
	type="text/css">
<title>Edition des ingredients</title>
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script src="<c:url value='/dist/js/listing.js' />"></script>
</head>
<body>

	<form:form method="post" modelAttribute="ingredient">
		<table>
			<tr>
				<td>Nom</td>
				<td>Prix</td>
				<td>Quantite</td>
			</tr>
			<tr>
				<td><form:input path="nom" />
				<td><form:input path="prix" />
				<td><form:input path="quantite" />
			</tr>
		</table>
		<form:button id="editButton">Envoyer</form:button>
	</form:form>
</body>
</html>