<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <jsp:include page="./templates/header.jsp" />

<!-- Carousel Start -->
<div class="container-fluid p-0 mb-5 wow fadeIn" data-wow-delay="0.1s">
  <div id="header-carousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#header-carousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1">
        <img class="img-fluid" src="./recursos/recursos_index/img/carousel-2.jpg" alt="Image">
      </button>
      <button type="button" data-bs-target="#header-carousel" data-bs-slide-to="1" aria-label="Slide 2">
        <img class="img-fluid" src="./recursos/recursos_index/img/carousel-1.jpg" alt="Image">
      </button>
      <button type="button" data-bs-target="#header-carousel" data-bs-slide-to="2" aria-label="Slide 3">
        <img class="img-fluid" src="./recursos/recursos_index/img/carousel-3.jpg" alt="Image">
      </button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img class="w-100" src="recursos/recursos_index/img/carousel-2.jpg" alt="Image">
        <div class="carousel-caption">
          <div class="p-3" style="max-width: 900px;">
            <h4 class="text-white text-uppercase mb-4 animated zoomIn">Enreda tus sentidos en el arte del tejido con</h4>
            <h1 class="display-1 text-white mb-0 animated zoomIn">Telarañas Creativas</h1>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <img class="w-100" src="recursos/recursos_index/img/carousel-1.jpg" alt="Image">
        <div class="carousel-caption">
          <div class="p-3" style="max-width: 900px;">
            <h4 class="text-white text-uppercase mb-4 animated zoomIn">Explora un mundo de</h4>
            <h1 class="display-1 text-white mb-0 animated zoomIn">Texturas y Colores Vibrantes</h1>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <img class="w-100" src="recursos/recursos_index/img/carousel-3.jpg" alt="Image">
        <div class="carousel-caption">
          <div class="p-3" style="max-width: 900px;">
            <h4 class="text-white text-uppercase mb-4 animated zoomIn">Tejidos artesanales</h4>
            <h1 class="display-1 text-white mb-0 animated zoomIn">De Primera Calidad</h1>
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#header-carousel"
            data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#header-carousel"
            data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
</div>
<!-- Carousel End -->

<!-- PRODUCTOS A ENCONTRAR -->
<div class="container-xxl py-5">
  <div class="container">
    <div class="text-center mx-auto mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 600px;">
      <h1 class="display-6 mb-4">Productos Que Marcan La Diferencia En Tu Día A Día</h1>
    </div>
    <div class="owl-carousel project-carousel wow fadeInUp" data-wow-delay="0.1s">
      <div class="project-item border rounded h-100 p-4" data-dot="01">
        <div class="position-relative mb-4">
          <img class="img-fluid rounded" src="recursos/recursos_index/img/project-1.jpg" alt="">
          <a href="recursos/recursos_index/img/project-1.jpg" data-lightbox="project"><i class="fa fa-eye fa-2x"></i></a>
        </div>
        <h6>Suéteres</h6>
        <span>De distintos colores, calientitos y bien tejidos</span>
      </div>
      <div class="project-item border rounded h-100 p-4" data-dot="02">
        <div class="position-relative mb-4">
          <img class="img-fluid rounded" src="recursos/recursos_index/img/project-2.jpg" alt="">
          <a href="recursos/recursos_index/img/project-2.jpg" data-lightbox="project"><i class="fa fa-eye fa-2x"></i></a>
        </div>
        <h6>Muñecos</h6>
        <span>Los hay para niños y para adultos</span>
      </div>
      <div class="project-item border rounded h-100 p-4" data-dot="03">
        <div class="position-relative mb-4">
          <img class="img-fluid rounded" src="recursos/recursos_index/img/project-3.jpg" alt="">
          <a href="recursos/recursos_index/img/project-3.jpg" data-lightbox="project"><i class="fa fa-eye fa-2x"></i></a>
        </div>
        <h6>Bufandas</h6>
        <span>No solo se puede vestir bien en invierno</span>
      </div>
      <div class="project-item border rounded h-100 p-4" data-dot="04">
        <div class="position-relative mb-4">
          <img class="img-fluid rounded" src="recursos/recursos_index/img/project-4.jpg" alt="">
          <a href="recursos/recursos_index/img/project-4.jpg" data-lightbox="project"><i class="fa fa-eye fa-2x"></i></a>
        </div>
        <h6>Camisas tradicionales</h6>
        <span>Con bordados a lo mexicano. Para ambos géneros</span>
      </div>
      <div class="project-item border rounded h-100 p-4" data-dot="05">
        <div class="position-relative mb-4">
          <img class="img-fluid rounded" src="recursos/recursos_index/img/project-5.jpg" alt="">
          <a href="recursos/recursos_index/img/project-5.jpg" data-lightbox="project"><i class="fa fa-eye fa-2x"></i></a>
        </div>
        <h6>Bordados</h6>
        <span>Unos muy buenos detalles para regalar</span>
      </div>
      <div class="project-item border rounded h-100 p-4" data-dot="06">
        <div class="position-relative mb-4">
          <img class="img-fluid rounded" src="recursos/recursos_index/img/project-6.jpg" alt="">
          <a href="recursos/recursos_index/img/project-6.jpg" data-lightbox="project"><i class="fa fa-eye fa-2x"></i></a>
        </div>
        <h6>Prendas para hombre</h6>
        <span>En especial suéteres, ponchos y algunas camisas</span>
      </div>
      <div class="project-item border rounded h-100 p-4" data-dot="07">
        <div class="position-relative mb-4">
          <img class="img-fluid rounded" src="recursos/recursos_index/img/project-7.jpg" alt="">
          <a href="recursos/recursos_index/img/project-7.jpg" data-lightbox="project"><i class="fa fa-eye fa-2x"></i></a>
        </div>
        <h6>Guantes</h6>
        <span>Calientitos y ajustados para ambos géneros</span>
      </div>
      <div class="project-item border rounded h-100 p-4" data-dot="08">
        <div class="position-relative mb-4">
          <img class="img-fluid rounded" src="recursos/recursos_index/img/project-8.jpg" alt="">
          <a href="recursos/recursos_index/img/project-8.jpg" data-lightbox="project"><i class="fa fa-eye fa-2x"></i></a>
        </div>
        <h6>Bolsos y Mochilas</h6>
        <span>Económicas y listas para acompañarte a donde vayas</span>
      </div>
    </div>
  </div>
</div>
</div>
<!-- Project End -->

<!-- PARTEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE -->
<!-- Testimonial Start -->
<div class="container-xxl py-5">
  <div class="container">
    <div class="text-center mx-auto mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 600px;">
      <h1 class="display-6 mb-4">Para tener la mejor experiencia en este sitio sigue los siguientes pasos</h1>
    </div>
    <div class="owl-carousel testimonial-carousel wow fadeInUp" data-wow-delay="0.1s">
      <div class="testimonial-item bg-light rounded p-4">
        <div class="d-flex align-items-center mb-4">
          <img class="flex-shrink-0 rounded-circle border p-1" src="recursos/recursos_index/img/acceder.png" alt="">
          <div class="ms-4">
            <h5 class="mb-1">Primer Paso</h5>
            <span>Inicia Sesión</span>
          </div>
        </div>
        <p class="mb-0">Para poder pedir tus productos y disfrutar completamente de las funcionalidades de este sitio, accede con tu cuenta de correo electrónico.</p>
      </div>
      <div class="testimonial-item bg-light rounded p-4">
        <div class="d-flex align-items-center mb-4">
          <img class="flex-shrink-0 rounded-circle border p-1" src="recursos/recursos_index/img/carrito.png" alt="">
          <div class="ms-4">
            <h5 class="mb-1">Segundo Paso</h5>
            <span>Pide tus productos</span>
          </div>
        </div>
        <p class="mb-0">Añade tus productos favoritos al carrito, seleccionada la cantidad deseada, agrega más articulos y confirma tu pedido cuando estés listo.</p>
      </div>
      <div class="testimonial-item bg-light rounded p-4">
        <div class="d-flex align-items-center mb-4">
          <img class="flex-shrink-0 rounded-circle border p-1" src="recursos/recursos_index/img/email.png" alt="">
          <div class="ms-4">
            <h5 class="mb-1">Tercer Paso</h5>
            <span>Recibe por correo electrónico</span>
          </div>
        </div>
        <p class="mb-0">Una vez pedida tu orden, dirígete al correo electrónico que proporcionaste. Ahí encontrarás tu orden y el número bancario donde depositar tu pago total.</p>
      </div>
      <div class="testimonial-item bg-light rounded p-4">
        <div class="d-flex align-items-center mb-4">
          <img class="flex-shrink-0 rounded-circle border p-1" src="recursos/recursos_index/img/comprobante.png" alt="">
          <div class="ms-4">
            <h5 class="mb-1">Cuarto Paso</h5>
            <span>Verifica tu pago</span>
          </div>
        </div>
        <p class="mb-0">Una vez pagado tu pedido, adjunta el comprobante de pago al correo <i>telarañascreativas@gmail.com</i> y escríbenos tu nombre completo en el asunto. </p>
      </div>
      <div class="testimonial-item bg-light rounded p-4">
        <div class="d-flex align-items-center mb-4">
          <img class="flex-shrink-0 rounded-circle border p-1" src="recursos/recursos_index/img/paquete.png" alt="">
          <div class="ms-4">
            <h5 class="mb-1">Quinto Paso</h5>
            <span>Notificación de envío</span>
          </div>
        </div>
        <p class="mb-0">Finalmente, una vez que hayas enviado tu comprobante de pago, espera un correo electrónico donde se notificará que tu pedido está en camino. </p>
      </div>
    </div>
  </div>
</div>
<!-- Testimonial End -->

<!-- Nosotros -->
<div class="container-xxl py-5">
  <div class="container">
    <div class="row g-5">
      <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
        <div class="img">
          <img class="img-fluid" src="recursos/recursos_index/img/tc.jpg" alt="">
        </div>
      </div>
      <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
        <div class="h-100">
          <br><br> <br><br>
          <h1 class="display-6 mb-4">¿Estás listo para dar un paseo por <span class="text-primary">Telarañas Creativas </span>? Navega en nuestro catálogo de productos ¡Ahora!</h1>
          <p>Puedes escoger por categoría y añadir los artículos que quieras al carrito. No olvides confirmar tu pedido.</p>
          <a class="btn btn-primary rounded-pill py-3 px-5" href="TiendaServlet?accion=findAll">Ver Catálogo</a>
        </div>

      </div>
    </div>
  </div>
</div>
<!-- Nosotros End -->

<!-- Footer-->
<footer class="py-5 bg-dark">
  <div class="container"><p class="m-0 text-center text-white"><i class="fa-solid fa-envelope" style="color: #ffffff;"></i><strong> Contáctanos: </strong> <em>telarañascreativas@gmail.com</em></p></div>
</footer>


<!-- Back to Top -->
<a href="index.html" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="recursos/recursos_index/lib/wow/wow.min.js"></script>
<script src="recursos/recursos_index/lib/easing/easing.min.js"></script>
<script src="recursos/recursos_index/lib/waypoints/waypoints.min.js"></script>
<script src="recursos/recursos_index/lib/counterup/counterup.min.js"></script>
<script src="recursos/recursos_index/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="recursos/recursos_index/lib/lightbox/js/lightbox.min.js"></script>

<!-- Template Javascript -->
<script src="recursos/recursos_index/js/main.js"></script>
</body>

</html>