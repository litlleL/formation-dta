<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%   List<Pizza> list = (List<Pizza>) request.getAttribute("list.pizza");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href= "<%= request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
<title>Liste des pizzas</title>
</head>

 <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">La florentina</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li ><a href="#">Accueil</a></li>
            <li class="active"><a href="#Pizzas">Pizzas</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div>
      </div>
    </nav>
    
<div class="container">
	<div class="jumbotron">
           <h1>Liste des pizzas</h1>
           <p>Liste des pizzas fourni par nos services</p>
        </div>
    </div> 
    
<div class="container">
 	<div class="page-header">
     	<h1>tableau des pizzas </h1>
     </div>
     <div class="table-responsive">
            <table class="table table-striped">
             <thead>
                <tr>
                  <th>Code</th>
                  <th>Nom</th>
                  <th>Prix</th>
                  <th>Categorie</th>
                  <th>Edition</th>
                  <th>Suppression</th>
                </tr>
              </thead>
              <tbody>
                <%
                for (Pizza pizza : list) {
           		%>
	            	<tr>
	                  <td><%=pizza.getCode()%></td>
	                  <td><%=pizza.getCode()%></td>
	                  <td><%=pizza.getCode()%></td>
	                  <td><%=pizza.getCode()%></td>
	                  <td>Editer</td>
	                  <td>Supprimer</td>
	                </tr>
            <%
                }
            %>
                
              </tbody>
            </table>
       </div>
</div>
	
</body>
</html>