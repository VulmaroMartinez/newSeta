<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="recursos/recursos_login/css/estilos.css" type="text/css">
    <title>Login</title>
</head>
<body>

<section class="vh-100" style="background: #f9f6f1;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                            <img src="recursos/recursos_login/img/log.jpg"
                                 alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;">
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form action="login" method="post" >

                                    <div>
                                        <div class="logo-containerr">
                                            <img src="recursos/recursos_login/img/gl.png" alt="Logo" class="logo-imagee mt-6">
                                        </div>
                                    </div>



                                    <center>
                                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px; font-size: 150%;">Inicia sesión para acceder</h5>
                                    </center>

                                    <div class="form-outline mb-4">

                                        <input type="email" name="correo" placeholder="Correo electrónico" style="font-size: 110%;" class="form-control form-control-lg" pattern=".+@.+" required />
                                    </div>

                                    <br>
                                    <div class="form-outline mb-4" >

                                        <input type="password" name="contrasena"  placeholder="Contraseña" class="form-control form-control-lg" minlength="8" required/>
                                    </div>

                                    <div class="pt-1 mb-4 text-center">
                                        <button class="btn btn-dark btn-lg btn-block" type="submit">Acceder</button>
                                    </div>

                                    <center>
                                        <a class="small text-muted" href="correo_contraseña.jsp">¿Olvidaste tu contraseña?</a><br><br>
                                    </center>

                                    <center>
                                        <p class="mb-5 pb-lg-2" style="color: #393f81;">¿Todavía no tienes una cuenta? <a href="crear_cuenta.jsp"
                                                                                                                          style="color: #393f81;">Registrate aquí</a></p>
                                    </center>

                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>