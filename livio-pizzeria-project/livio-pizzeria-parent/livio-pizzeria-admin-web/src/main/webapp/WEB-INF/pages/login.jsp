<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty log}">
	<c:set var="idUser" scope="session" value="${log}" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 100%;
	height: auto;
	left: 50%;
	margin: auto;
}

.carousel-caption {
	font-size: 32px;
}

.jumbotron {
	background-color: coral;
	color: white;
}

.thumbnail>a>img {
	height: 200px;
}

.thumbnail>.caption>p {
	color: cadetblue;
	width: 100%;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

/* Style du template des tooltips pour les pizzas */
.tooltip-head {
	color: #fff;
	background-color: crimson;
	padding: 5px 30px 5px 30px;
	border-radius: 4px 4px 0 0;
	text-align: center;
	margin-bottom: -2px; /* Hide default tooltip rounded corner from top */
}

.tooltip-head h2 {
	margin: 0;
	font-size: 20px;
}
</style>
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
					<form action="/logout" id="sigout" class="navbar-form navbar-right"
						role="form" method="POST">
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
	
        
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">

                <div id="monCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#monCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#monCarousel" data-slide-to="1"></li>
                        <li data-target="#monCarousel" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">

                        <div class="item active">
                        	<img src="<c:url value="/carousel/Carousel1.jpg"/>"/>
                            <div class="carousel-caption">
                                <h1>La Florentina</h1>
                                <p>L'italie est dans votre pizza !</p>
                            </div>
                        </div>

                        <div class="item">
                        	<img src="<c:url value="/carousel/Carousel2.jpg"/>"/>
                            <div class="carousel-caption">
                                <h1>Nos pizzas</h1>
                                <p>Il y a en a pour tous les goûts :-)</p>
                            </div>
                        </div>

                        <div class="item">
                        	<img src="<c:url value="/carousel/Carousel3.jpg"/>"/>
                            <div class="carousel-caption">
                                <h1>Four à bois</h1>
                                <p>Quoi de mieux qu'un four à bois pour faire de bonnes pizzas ?</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
  </div>
    </body>
</html>

</body>
</html>