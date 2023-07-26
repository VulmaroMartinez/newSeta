<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    if (session.getAttribute("sesion") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<html>


<head>
    <title>Detalles carrito</title>
    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    <!-- Libraries Stylesheet -->
    <link href="recursos/recursos_detalles_compra/lib/animate/animate.min.css" rel="stylesheet">
    <link href="recursos/recursos_detalles_compra/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="recursos/recursos_detalles_compra/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <!-- Customized Bootstrap Stylesheet -->
    <link href="recursos/recursos_detalles_compra/css/bootstrap.min.css" rel="stylesheet">
    <!-- Template Stylesheet -->
    <link href="recursos/recursos_detalles_compra/css/style.css" rel="stylesheet">
    <!-- Icons Fontawesome -->
    <script src="https://kit.fontawesome.com/092eb14ce6.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="recursos/recursos_index/nav/nav_styles.css">


</head>



<link rel="stylesheet" href="recursos/recursos_detalles_compra/dist/css/adminlte.min.css">



<body>
<nav class="navcorregido">
    <div class="navbarizq">
        <img href="index.jsp" src="./recursos/recursos_index/nav/logo.png" alt="Logo" class="logonavcorre">
        <a href="index.jsp" class="navbar-linkk bbigger-font">Telarañas Creativas</a>

        <a href="TiendaServlet?accion=findAll" class="navbar-linkk">Seguir comprando</a>



        <c:if test="${empty sesion}">

            <a class="navbar-linkk" href="login_cliente.jsp"><i class="fas fa-user" style="color: #000000;"></i></a>

        </c:if>

        <c:if test="${not empty sesion}">

            <a class="navbar-linkk" href="newcuenta?accion2=update&id_cliente=${sesion.id_cliente}">${sesion.correo} <i class="fa-solid fa-user"></i>   </a>
            <a class="navbar-linkk" href="logout.jsp"><i class="fa-solid fa-right-from-bracket"></i>  </a>

        </c:if>

    </div>
</nav>


    <div class="container-fluid">

        <div class="row">
            <!-- TABLE: LATEST ORDERS -->

            <div class="card col-md-8">

                <div class="card-header border-transparent">
                    <h3 class="card-title">Ordenes</h3>

                </div>
                <!-- /.card-header -->
                <div class="card-body p-2">
                    <div class="table-responsive">
                        <table class="table m-0">
                            <thead>
                            <tr>
                                <th>ITEM</th>
                                <th>NOMBRES</th>
                                <th>DESCRIPCION</th>
                                <th>PRECIO</th>
                                <th>CANTIDAD</th>
                                <th>SUBTOTAL</th>
                                <th>ACCION</th>

                            </tr>
                            </thead>


                            <tbody>

                            <c:forEach var="car" items="${carrito}">


                                <tr>


                                    <th>${car.getItem()}</th>
                                    <th>${car.getNombres()}
                                        <img src="ControllerIMG?id_producto=${car.getId_producto()}" width="100" height="100">
                                    </th>
                                    <th>${car.getDescripcion()}</th>
                                    <th>${car.getPrecioCompra()}MXN</th>
                                    <th>${car.getCantidad()}</th>
                                    <th>${car.getSubTotal()}MXN</th>
                                    <th></th>


                                </tr>

                            </c:forEach>


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>



        <div class="card col-md-4">
            <div class="card-header border-transparent" style="border: 1px solid black;">
                <h3 class="card-title">Detalles del pedido</h3>
            </div>

            <!-- /.card-header -->
            <div class="card-body p-0">
                <ul class="products-list product-list-in-card pl-2 pr-2">

                    <label>SUBTOTAL:</label>
                    <input type="text"  value=" $${totalPagar} MXN" readonly="" class="form-control">


                    <label>TOTAL A PAGAR:</label>
                    <input type="text"  value=" $${totalPagar} MXN"  readonly="" class="form-control">

                    <label></label>
                    <a href="" class="btn btn-info btn-block">Realizar Compra</a>


                </ul>

            </div>

            <div class="card-footer text-center">
            </div>

        </div>


    </div>


    </div>





</body>
</html>
