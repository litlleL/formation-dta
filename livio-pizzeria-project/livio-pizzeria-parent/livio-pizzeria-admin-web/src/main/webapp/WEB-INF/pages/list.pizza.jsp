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
           <h1>Liste des pizzas</h1>
           <p>Liste des pizzas fourni par nos services</p>
        </div>
    </div> 
    
<div class="container">
 	<div class="page-header">
     	<p>
     		<a class="btn btn-success" href="#Accueil" role="button">Accueil</a>
     		<a class="btn btn-success" href="<%= request.getContextPath()%>/api/servlet/pizzas/new" role="button">Ajouter une pizza</a>
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
                <%
                for (Pizza pizza : list) {
           		%>
	            	<tr>
	                  <td class = "col-md-2"><%=pizza.getCode()%></td>
	                  <td class = "col-md-2"><%=pizza.getNom()%></td>
	                  <td class = "col-md-2"><%=pizza.getPrix()%></td>
	                  <td class = "col-md-2"><%=pizza.getCategoriePizza() %></td>
	                  <td class = "col-md-2"><img src="<%= request.getContextPath()%>/photos/<%= pizza.getUrlImage() %>" width="200 px"/></td>
	                  <td class = "col-md-1"><span><a class="btn btn-success" href="<%= request.getContextPath()%>/api/servlet/pizzas/edit?id=<%=pizza.getId() %>" role="button">Editer</a></span></td>
	                  <td class = "col-md-1"><span><a class="btn btn-success" href="<%= request.getContextPath()%>/api/servlet/pizzas/delete?id=<%=pizza.getId() %>" role="button">Supprimer</a></span></td>
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