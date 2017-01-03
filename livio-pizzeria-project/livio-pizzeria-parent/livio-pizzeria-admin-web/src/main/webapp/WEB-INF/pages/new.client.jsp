<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">
<title>clients</title>

<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
</head>
<body>

	<c:if test="${!empty user}">
		<nav class="navbar navbar-default">
			<div class="container-fluid">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">La florentina</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form action="/livio-pizzeria-admin-web/logout" id="sigout"
						class="navbar-form navbar-right" role="form" method="POST">
						<button type="submit" class="btn btn-primary">Logout</button>
					</form>
				</div>
			</div>
		</nav>
	</c:if>


	<c:if test="${empty user}">
		<nav class="navbar navbar-default">
			<div class="container-fluid">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">La florentina</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form action="<c:url value="/login"/>" id="signin"
						class="navbar-form navbar-right" role="form" method="POST">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="email"
								type="email" class="form-control" name="email" value=""
								placeholder="Email Address">
						</div>
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="password"
								type="password" class="form-control" name="password" value=""
								placeholder="Password">
						</div>
						<button type="submit" class="btn btn-primary">Login</button>
					</form>
				</div>

			</div>
		</nav>
	</c:if>
	<div class="container">
		<div class="jumbotron">
			<h1>Liste des clients</h1>
			<p>Liste des clients ayant un compte pour notre pizzeria</p>
		</div>
	</div>

	<div class="container">
		<div class="page-header">
			<p>
				<a class="btn btn-success" href="<c:url value="/pizzas/list"/>"
					role="button">lister les pizzas</a>
			</p>
		</div>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="col-md-2">Nom</th>
						<th class="col-md-2">Prenom</th>
						<th class="col-md-4">adresse</th>
						<th class="col-md-4">email</th>
					</tr>
				</thead>
				<tbody id="liste">
				</tbody>

			</table>
		</div>
	</div>

	<script>
// 		$.ajax({
// 					type : "GET",
// 					url : "http://localhost:8080/livio-pizzeria-admin-web/api/rest/clients",
// 					dataType : 'JSON',
// 					success : function(data) {
// 						console.log(data);
// 						$.each(data, function(i, item) {
// 							$("#liste").append(
// 									'<tr><td class = "col-md-2">' + item.nom
// 											+ '</td> <td class = "col-md-2">'
// 											+ item.prenom
// 											+ '</td> <td class = "col-md-4">'
// 											+ item.adresse
// 											+ '</td> <td class = "col-md-4">'
// 											+ item.email + '</td></tr>');
// 						});
// 					}

// 				});

		(function() {
			var PizzaApi = "http://localhost:8080/livio-pizzeria-admin-web/api/rest/clients";
			$.getJSON(PizzaApi, {
				format : "json"
			}).done(
					function(data) {
						console.log(data);
						$.each(data, function(i, item) {
							$("#liste").append(
									'<tr><td class = "col-md-2">' + item.nom
											+ '</td> <td class = "col-md-2">'
											+ item.prenom
											+ '</td> <td class = "col-md-4">'
											+ item.adresse
											+ '</td> <td class = "col-md-4">'
											+ item.email + '</td></tr>');
						});
					});
		})();
	</script>

	<div class="container">
		<form class="form-horizontal">
			<fieldset>

				<!-- Form Name -->
				<legend>Creation/modification client</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">nom</label>
					<div class="col-md-4">
						<input id="nom" name="nom" type="text" placeholder="nom"
							class="form-control input-md">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prenom">prenom</label>
					<div class="col-md-4">
						<input id="prenom" name="prenom" type="text" placeholder="prenom"
							class="form-control input-md">

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="motDePasse">mdp</label>
					<div class="col-md-4">
						<input id="motDePasse" name="motDePasse" type="password"
							placeholder="motDePasse" class="form-control input-md">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="mail">mail</label>
					<div class="col-md-4">
						<input id="mail" name="mail" type="text" placeholder="mail"
							class="form-control input-md">

					</div>
				</div>

				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="adresse">adresse</label>
					<div class="col-md-4">
						<textarea class="form-control" id="adresse" name="adresse">Votre adresse</textarea>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="valider">valider</label>
					<div class="col-md-4">
						<button id="valider" name="valider" class="btn btn-primary">valider</button>
					</div>
				</div>

			</fieldset>
		</form>

	</div>

</body>
</html>