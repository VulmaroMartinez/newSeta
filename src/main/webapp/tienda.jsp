<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<html>
<head>
    <title>Catálogo</title>
    <!-- Customized Bootstrap Stylesheet -->
    <link href="recursos/recursos_index/css/bootstrap.min.css" rel="stylesheet">
    <!-- Icons Fontawesome -->
    <script src="https://kit.fontawesome.com/092eb14ce6.js" crossorigin="anonymous"></script>
    <!-- ========================= CSS here ========================= -->
    <link rel="stylesheet" href="recursos/recursos_catalogo/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="recursos/recursos_catalogo/assets/css/LineIcons.3.0.css" />
    <link rel="stylesheet" href="recursos/recursos_catalogo/assets/css/main.css" />
    <link href="recursos/recursos_index/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="recursos/recursos_index/nav/nav_styles.css">
</head>
<body>

<nav class="navcorregido">
    <div class="navbarizq">
        <img href="index.jsp" src="./recursos/recursos_index/nav/logo.png" alt="Logo" class="logonavcorre">
        <a href="index.jsp" class="navbar-linkk bbigger-font">Telarañas Creativas</a>
        <a href="TiendaServlet?accion=findAll" class="navbar-linkk">Tienda</a>
    </div>


    <div class="">
        <c:if test="${not empty sesion}">


                <a href="CarritoServlet?accion=car"   class="navbar-linkk"><label style="color: #0a58ca ">  (${contador})   </label>   <i class="fa-solid fa-cart-shopping"></i>     </a>





        </c:if>

        <c:if test="${empty sesion}">

            <a class="navbar-linkk" href="login_cliente.jsp"><i class="fas fa-user" style="color: #000000;"></i></a>

        </c:if>

        <c:if test="${not empty sesion}">

            <a class="navbar-linkk" href="newcuenta?accion2=update&id_cliente=${sesion.id_cliente}">${sesion.correo} <i class="fa-solid fa-user"></i>   </a>
            <a class="navbar-linkk" href="logout.jsp"><i class="fa-solid fa-right-from-bracket"></i>  </a>

        </c:if>


    </div>


</nav>



<ul class="menu">
    <li><a href="#" >Todo</a></li>

    <c:forEach var="categoria" items="${list2}">
        <li><a href="#" >${categoria.getNombre()}</a></li>
    </c:forEach>

</ul>

<!-- Catálogo -->
<!--<section class="trending-product section" style="margin-top: 12px;">-->
<div class="container">

    <div class="row">

        <!-- Start Card Producto -->
        <c:forEach var="producto" items="${list}">

            <!-- Start Single Product -->
            <div class="col-lg-3 col-md-6 col-12">

                <div class="single-product">

                    <div class="product-image">


                        <img src="ControllerIMG?id_producto=${producto.getId_producto()}" style="height: 350px">

                        <!-- Espacio Status --><span class="new-tag">${producto.getEstado()}</span>

                        <c:if test="${not empty sesion}">
                            <div class="button">
                                <!-- Añadir a Carrito --><a href="CarritoServlet?accion=Addcar&id_producto=${producto.getId_producto()}" class="btn"><i class="lni lni-cart"></i>Añadir a Carrito</a>
                            </div>
                        </c:if>


                        <c:if test="${not empty sesion}">

                        <div class="button">

                            <!-- Añadir a Carrito --><a href="CarritoServlet?accion=Addcar&id_producto=${producto.getId_producto()}" class="btn"><i class="lni lni-cart"></i>Añadir a Carrito</a>
                        </div>

                        </c:if>



                    </div>
                    <div class="product-info">
                        <!-- Espacio Categoría --><span class="category">${producto.getCategoria().getNombre()}</span>
                        <h4 class="title">
                            <!-- Espacio Nombre del Producto --><a href="TiendaServlet?accion=data&id_producto=${producto.getId_producto()}">${producto.getNombre()}</a>
                        </h4>
                        <div class="price">
                            <!-- Espacio Precio Unitario --><span> $ ${producto.getPrecio()} MXN</span>
                        </div>
                    </div>
                </div>


            </div>
            <!-- End Single Product -->

        </c:forEach>
        <!-- End Card Producto -->


    </div>
</div>
<!--</section>-->
<!-- End Catálogo -->


<!-- ========================= scroll-top ========================= -->
<a href="#" class="scroll-top">
    <i class="lni lni-chevron-up"></i>
</a>



<!-- ========================= JS here ========================= -->
<script>
    document.addEventListener('DOMContentLoaded', function() {
        // Obtener elementos del menú de categorías
        const menuItems = document.querySelectorAll('.menu li');

        // Obtener elementos de los productos
        const products = document.querySelectorAll('.single-product');

        // Agregar evento click a cada elemento del menú de categorías
        menuItems.forEach(item => {
            item.addEventListener('click', () => {
                // Remover la clase 'active' de todos los elementos del menú
                menuItems.forEach(menuItem => {
                    menuItem.classList.remove('active');
                });
                // Agregar la clase 'active' al elemento seleccionado
                item.classList.add('active');

                // Obtener la categoría seleccionada
                const category = item.textContent;

                // Mostrar u ocultar los productos según la categoría
                products.forEach(product => {
                    const productCategory = product.querySelector('.category').textContent;
                    if (category === 'Todo' || category === productCategory) {
                        product.style.display = 'block';
                    } else {
                        product.style.display = 'none';
                    }
                });
            });
        });
    });
</script>



<script src="recursos/recursos_catalogo/assets/js/bootstrap.min.js"></script>
<script src="recursos/recursos_catalogo/assets/js/tiny-slider.js"></script>
<script src="recursos/recursos_catalogo/assets/js/glightbox.min.js"></script>
<script src="recursos/recursos_catalogo/assets/js/main.js"></script>
<script type="text/javascript">
    //========= Hero Slider
    tns({
        container: '.hero-slider',
        slideBy: 'page',
        autoplay: true,
        autoplayButtonOutput: false,
        mouseDrag: true,
        gutter: 0,
        items: 1,
        nav: false,
        controls: true,
        controlsText: ['<i class="lni lni-chevron-left"></i>', '<i class="lni lni-chevron-right"></i>'],
    });

    //======== Brand Slider
    tns({
        container: '.brands-logo-carousel',
        autoplay: true,
        autoplayButtonOutput: false,
        mouseDrag: true,
        gutter: 15,
        nav: false,
        controls: false,
        responsive: {
            0: {
                items: 1,
            },
            540: {
                items: 3,
            },
            768: {
                items: 5,
            },
            992: {
                items: 6,
            }
        }
    });
</script>

</body>
</html>
