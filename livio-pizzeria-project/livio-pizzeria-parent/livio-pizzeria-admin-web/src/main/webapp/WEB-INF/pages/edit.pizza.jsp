<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Pizza pizza = (Pizza) request.getAttribute("pizza");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href= "<%= request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
<title>Modification de la pizza</title>
</head>
<body>
	<div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">La Florentina</a>
            </div>
          </div>
        </nav>

      </div>
    </div>
    
    <div class="container">
		<div class="jumbotron">
           <h1>Modifier la pizza</h1>
           <p>Modification de la pizza</p>
        </div>
    </div> 
    
    <div class="container">
    		<form class="form-horizontal" method="get">
				<fieldset>
				<!-- Form Name -->
				<legend>Modifier</legend>
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="code">code</label>  
				  <div class="col-md-4">
				  <input id="code" name="code" type="text" value="<%= pizza.getCode() %>" class="form-control input-md" >

				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="nom">nom</label>  
				  <div class="col-md-4">
				  <input id="nom" name="nom" type="text" value="<%= pizza.getNom() %>" class="form-control input-md" >
				    
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="prix">prix</label>  
				  <div class="col-md-4">
				  <input id="prix" name="prix" type="number" step="any"  value="<%= pizza.getPrix() %>" class="form-control input-md" >
				    
				  </div>
				</div>
				
				<!-- Button Drop Down -->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="categorie">categorie</label>
				  <div class="col-md-4">
				    <div class="input-group">
				      <input id="categorie" name="categorie" class="form-control" value="<%= pizza.getCategoriePizza()%>" type="text" >
				      <div class="input-group-btn">
				        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
				          choix
				          <span class="caret"></span>
				        </button>
				        <ul class="dropdown-menu pull-right">
				          <li>VIANDE</li>
				          <li>SANS_VIANDE</li>
				          <li>POISSON</li>
				        </ul>
				      </div>
				    </div>
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