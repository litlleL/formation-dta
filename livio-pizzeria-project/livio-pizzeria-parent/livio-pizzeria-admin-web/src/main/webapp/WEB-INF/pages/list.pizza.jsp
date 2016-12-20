<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<% List<Pizza> list = (List<Pizza>) request.getAttribute("list.pizza");
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
<div class="jumbotron">
        <div class="container">


            <div class="col-md-3">Code</div>
            <div class="col-md-3">Nom</div>
            <div class="col-md-3">Prix</div>
            <div class="col-md-3">Categorie</div>
            <%
             
                for (Pizza pizza : list) {
            %>
            <div class="col-md-3"><%=pizza.getCode()%></div>
            <div class="col-md-3"><%=pizza.getNom()%></div>
            <div class="col-md-3"><%=pizza.getCode()%></div>
            <div class="col-md-3"><%=pizza.getCode()%></div>
            <%
                }
            %>
        </div>
    </div>
	</body>
</html>