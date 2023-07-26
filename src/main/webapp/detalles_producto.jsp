<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>  
    <title>Detalles producto</title>
  <!-- Google Web Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">
  <!-- Icon Font Stylesheet -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

  <!-- Customized Bootstrap Stylesheet -->
  <link href="recursos/recursos_detalleproducto/css/bootstrap.min.css" rel="stylesheet">

  <link href="recursos/recursos_detalleproducto/css/style.css" rel="stylesheet">
  <!-- Icons Fontawesome -->
  <script src="https://kit.fontawesome.com/092eb14ce6.js" crossorigin="anonymous"></script>

  <link href="recursos/recursos_detalleproducto/css/styles.css" rel="stylesheet">
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


<section class="py-5">

  <div class="container px-4 px-lg-5 my-5">
    <div class="row gx-4 gx-lg-5 align-items-center">
      <div class="col-sm-6">


        <div class="img-container">
          <img class="d-block w-100" src="ControllerIMG?id_producto=${producto.getId_producto()}">
        </div>

      </div>

      <br>
      <div class="col-md-6 product-info">
        <div class="small mb-1"></div>

        <h1 class="display-5 fw-bolder product-title">${producto.getNombre()}</h1>
        <p class="lead product-description">Descripción:</p>
        <p class="product-description">${producto.getDescripcion()}</p>

        <div class="fs-5 mb-5 product-price">

          <span>$ ${producto.getPrecio()} MXN</span>
        </div>

        <div class="d-flex flex-wrap">
          <span> Cantidad: ${producto.getExistencias()} </span>
          <div class="product-buttons">
            <br>
            <br>
            <br>

            <button class="btn btn-outline-primary me-2" type="button" onclick="agregarAlCarrito()">
              <i class="bi-cart-fill me-1"></i>
              Agregar al carrito
            </button>

            <button class="btn btn-primary" type="button" onclick="comprarAhora()">
              Comprar ahora
            </button>

          </div>
        </div>
      </div>

    </div>
    <div class="row mt-4">
      <div class="col-sm-2 col-6">
        <div class="img-container">
          <img class="d-block w-100" src="ControllerIMG2?id_producto=${producto.getId_producto()}">
        </div>
      </div>
      <div class="col-sm-2 col-6">
        <div class="img-container">
          <img class="d-block w-100" src="ControllerIMG3?id_producto=${producto.getId_producto()}">
        </div>
      </div>
    </div>
    <div class="mt-4 product-comments">
      <h3>Comentarios:</h3>
      <textarea class="form-control" rows="4" placeholder="Queremos saber tu opinión. Escríbela aquí."></textarea>
      <button class="btn btn-primary mt-3" type="button">Enviar</button>
    </div>
  </div>
</section>

</body>
</html>
