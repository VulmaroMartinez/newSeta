
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


<%
    if (session.getAttribute("sesion") == null) {
        response.sendRedirect("login.jsp");
    }
%>
    <title>Pagina Principal</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    <!-- Libraries Stylesheet -->
    <link href="recursos/recursos_index/lib/animate/animate.min.css" rel="stylesheet">
    <link href="recursos/recursos_index/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="recursos/recursos_index/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <!-- Customized Bootstrap Stylesheet -->
    <link href="recursos/recursos_index/css/bootstrap.min.css" rel="stylesheet">
    <!-- Template Stylesheet -->
    <link href="recursos/recursos_index/css/style.css" rel="stylesheet">
    <!-- Icons Fontawesome -->
    <script src="https://kit.fontawesome.com/092eb14ce6.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="recursos/recursos_index/nav/nav_styles.css">

</head>
<body>

<nav class="navcorregido">

    <div class="navbarizq">
        <img href="index.jsp" src="./recursos/recursos_index/nav/logo.png" alt="Logo" class="logonavcorre">
        <a href="index.jsp" class="navbar-linkk bbigger-font">Telarañas Creativas</a>
        <a href="TiendaServlet?accion=findAll" class="navbar-linkk">Tienda</a>



        <c:if test="${not empty operacion}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>${operacion}</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <% request.getSession().removeAttribute("operacion"); %>
        </c:if>






    </div>


    <div class="">


    <c:if test="${empty sesion}">

            <a class="navbar-linkk" href="login_cliente.jsp">  Inicia sesión   <i class="fas fa-user" style="color: #000000;"></i></a>

        </c:if>




        <c:if test="${not empty sesion}">

            <a class="navbar-linkk" href="newcuenta?accion2=update&id_cliente=${sesion.id_cliente}">${sesion.correo} <i class="fa-solid fa-user"></i>   </a>
            <a class="navbar-linkk" href="logout.jsp"> Cerrar sesión     <i class="fa-solid fa-right-from-bracket"></i>  </a>

        </c:if>
    </div>


</nav>



