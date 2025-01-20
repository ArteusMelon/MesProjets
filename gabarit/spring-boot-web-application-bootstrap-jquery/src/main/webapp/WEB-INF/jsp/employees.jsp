<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Welcome</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
	<link href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="/css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
		<div class="container px-4">
			<a class="navbar-brand" href="#page-top">Start Bootstrap</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link" href="#employees">Employés</a></li>
					<li class="nav-item"><a class="nav-link" href="#services">Services</a></li>
					<li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>
    <!-- About section-->
	<section>
		<div class="container px-4">
			<div class="row gx-4 justify-content-center">
				<div class="col-lg-12">
					<h2>Nos employés</h2>
					<p class="lead">Voici la liste de nos employés</p>
          <div class="text-end">
            <a type="button" class="btn btn-primary btn-md" href="/employees/add">Ajouter Employé</a>
          </div>
					<table class="table">
                        <thead class="thead-dark">
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">Prénom</th>
                            <th scope="col">Nom</th>
                            <th scope="col">Date de naissance</th>
                            <th scope="col">Date d'embauche</th>
                            <th scope="col">Adresse</th>
                            <th scope="col">Code postal</th>
                            <th scope="col">Ville</th>
                            <th scope="col">Téléphone</th>
                            <th scope="col">Email</th>
                            <th scope="col"></th>
                          </tr>
                        </thead>
                        <tbody>
                          <c:forEach var="employee" items="${employees}">
                            <tr>
                              <th scope="row">${employee.employeeId}</th>
                              <td>${employee.firstName}</td>
                              <td>${employee.lastName}</td>
                              <td>
                                <fmt:formatDate value="${employee.birthDate}"
                                pattern="dd/MM/yyyy" /></td>
                                <td>
                                  <fmt:formatDate value="${employee.hireDate}"
                                  pattern="dd/MM/yyyy" /></td>
                                <td>${employee.address}</td>
                                <td>${employee.postalCode}</td>
                                <td>${employee.city}</td>
                                
                                <td>${employee.phone}</td>
                                <td>${employee.email}</td>
                                <td><a type="button" class="btn btn-success"
                                  href="/employees/update?id=${employee.employeeId}">Modifier</a>
                                <a type="button" class="btn btn-warning"
                                  href="/employees/delete?id=${employee.employeeId}">Supprimer</a></td>
                            </tr>
                          </c:forEach>
                        </tbody>
                      </table>
				</div>
			</div>
		</div>
	</section>
    <!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container px-4"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
	</footer>
	<script src="/webjars/jquery/3.6.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
	<script src="/js/scripts.js"></script>
</body>
</html>