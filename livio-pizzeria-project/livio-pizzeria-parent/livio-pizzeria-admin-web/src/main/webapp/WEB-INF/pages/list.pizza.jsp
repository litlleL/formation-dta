<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@ page  isELIgnored="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!empty log}">
	<c:set var="idUser" scope="session" value="${log}" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des pizzas</title>
<link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet" type="text/css">

</head>

<c:if test="${!empty user}">
<nav class="navbar navbar-default">
  <div class="container-fluid">
   
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">La florentina</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <form  action="/livio-pizzeria-admin-web/logout" id="sigout" class="navbar-form navbar-right" role="form" method="POST">
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
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">La florentina</a>
    </div>
    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      	<form  action="<c:url value="/login"/>" id="signin" class="navbar-form navbar-right" role="form" method="POST">
             <div class="input-group">
                 <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                 <input id="email" type="email" class="form-control" name="email" value="" placeholder="Email Address">                                        
             </div>
             <div class="input-group">
                 <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                 <input id="password" type="password" class="form-control" name="password" value="" placeholder="Password">                                        
             </div>
             <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>
    
  </div>
</nav>
</c:if>

    
<div class="container">
	<div class="jumbotron">
           <h1>Liste des pizzas</h1>
           <p>Liste des pizzas fourni par nos services</p>
        </div>
    </div> 
    
<div class="container">
 	<div class="page-header">
     	<p>
     		<a class="btn btn-success" href="#Accueil" role="button">Accueil</a>
     		<a class="btn btn-success" href="<c:url value="/pizzas/new"/>" role="button">Ajouter une pizza</a>
     	</p>
     </div>
     <div class="table-responsive">
            <table class="table table-striped">
             <thead>
                <tr>
                  <th class = "col-md-1">Code</th>
                  <th class = "col-md-1">Nom</th>
                  <th class = "col-md-1">Prix</th>
                  <th class = "col-md-1">Categorie</th>
                  <th class = "col-md-6">Photo</th>
                  <th class = "col-md-1">Edition</th>
                  <th class = "col-md-1">Suppression</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="pizza" items="${list}">
              	<tr>
	                  <td class = "col-md-2">${pizza.code}</td>
	                  <td class = "col-md-2">${pizza.nom}</td>
	                  <td class = "col-md-2">${pizza.prix}</td>
	                  <td class = "col-md-2">${pizza.categoriePizza}</td>
	                  <td class = "col-md-2"><img src="<c:url value="/photos/${pizza.urlImage}"/>" width="200 px"/></td>
	                  <td class = "col-md-1"><span><a class="btn btn-success" href="<c:url value="/pizzas/edit?id=${pizza.id}"/>" role="button">Editer</a></span></td>
	                  <td class = "col-md-1"><span><a class="btn btn-success" href="<c:url value="/pizzas/delete?id=${pizza.id}"/>" role="button">Supprimer</a></span></td>
	            </tr>
              </c:forEach>
              </tbody>
            </table>
       </div>
</div>
	
</body>
</html>