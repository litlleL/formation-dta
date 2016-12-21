<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet" type="text/css">
<title>Modification de la pizza</title>
</head>
<body>
	<c:if test="${!empty log}">
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
      <form  action="/logout" id="sigout" class="navbar-form navbar-right" role="form" method="POST">
          <button type="submit" class="btn btn-primary">Logout</button>
       </form>
    </div>
  </div>
</nav>
</c:if>


<c:if test="${empty log}">
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
           <h1>Ajouter la pizza</h1>
           <p>Ajout de la nouvelle pizza</p>
        </div>
    </div> 
    
    <div class="container">
    		<form class="form-horizontal" method="POST">
				<fieldset>
				<!-- Form Name -->
				<legend>Ajouter</legend>
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="code">code</label>  
				  <div class="col-md-4">
				  <input id="code" name="code" type="text" placeholder="code" class="form-control input-md" >

				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="nom">nom</label>  
				  <div class="col-md-4">
				  <input id="nom" name="nom" type="text" placeholder="nom" class="form-control input-md" >
				    
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="prix">prix</label>  
				  <div class="col-md-4">
				  <input id="prix" name="prix" type="number" step="any"  placeholder="prix" class="form-control input-md" >
				    
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="col-md-4 control-label" for="sel1">categorie</label>
				  <div class="col-md-4">
				  <select class="form-control col-md-4" id="sel1" name="categorie">
				  	<option selected value="VIANDE">VIANDE</option>
				  	<option value="SANS_VIANDE">SANS_VIANDE</option>
				  	<option value="POISSON">POISSON</option>
				  </select>
				  </div>
				</div>
				
				<!-- File Button --> 
				<div class="form-group">
				  <label class="col-md-4 control-label" for="url_image">url_image</label>
				  <div class="col-md-4">
				    <input id="url_image" name="url_image" class="input-file" type="file">
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