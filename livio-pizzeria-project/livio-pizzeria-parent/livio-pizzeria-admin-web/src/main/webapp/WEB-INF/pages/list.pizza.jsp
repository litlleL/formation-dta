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

<div class="container">
	<div class="jumbotron">
           <h1>Liste des pizzas</h1>
           <p>Liste des pizzas fourni par nos service</p>
        </div>
    </div> 
    
    
     
<div class="container">
 	<div class="page-header">
     	<h1>tableau des pizzas</h1>
     </div>
     <div class="row">
     	<div class="col-md-6">
     		<div class="col-md-2">Code</div>
            <div class="col-md-2">Nom</div>
            <div class="col-md-2">Prix</div>
            <div class="col-md-2">Categorie</div>
            <div class="col-md-2">Edition</div>
            <div class="col-md-2">Suppression</div>
            <%
             
                for (Pizza pizza : list) {
            %>
            <div class="col-md-2"><%=pizza.getCode()%></div>
            <div class="col-md-2"><%=pizza.getNom()%></div>
            <div class="col-md-2"><%=pizza.getCode()%></div>
            <div class="col-md-2"><%=pizza.getCode()%></div>
            <div class="col-md-2"><%=pizza.getCode()%></div>
            <div class="col-md-2"><%=pizza.getCode()%></div>
            <%
                }
            %>
     	</div>
     </div>
</div>
	
</body>
</html>