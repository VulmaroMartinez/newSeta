<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Cuenta</title>
    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.css">

    <!-- STYLE CSS -->
    <link rel="stylesheet" href="recursos/recursos_cuenta/css/style.css">

</head>
<body>

<div class="wrapper">
    <form action="newcuenta" method="post" style="width: 1000px; height: auto;">
        <!-- SECTION 1 -->
        <section>
            <div class="inner">
                <img class="image-fluid" src="recursos/recursos_cuenta/img/lanas.jpg" style="width: 430px; height: auto; border-radius: 5px;"  alt="">
                <div class="form-content" >
                    <div class="form-header">
                        <div class="logo-containerr">
                            <img src="recursos/recursos_cuenta/img/gl.png" alt="Logo" class="logo-imagee mt-6">
                        </div>
                        <h3>Crear Cuenta</h3>
                    </div>
                    <br>
                    <!--p>Please fill with your details</p-->
                    <div class="form-row">
                        <div class="form-holder">
                            <input type="text" placeholder="Nombre" name="nombre" class="form-control effect-1" required>
                            <span class="focus-border"></span>
                        </div>
                        <div class="form-holder">
                            <input type="text" placeholder="Primer Apellido" name="apaterno" class="form-control effect-1" required>
                            <span class="focus-border"></span>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-holder">
                            <input type="text" placeholder="Segundo Apellido" name="amaterno" class="form-control effect-1">
                            <span class="focus-border"></span>
                        </div>
                        <div class="form-holder">
                            <input type="email" placeholder="Correo Electrónico" name="correo" class="form-control effect-1" required>
                            <span class="focus-border"></span>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-holder">

                            <input type="password"
                                   id="contrasena"
                                   name="contrasena"
                                   placeholder="Contraseña"
                                   class="form-control effect-1"
                                   pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$-_%^&]).{8,}$"
                                   title="Tu contraseña debe contener al menos una letra mayúscula, una letra minúscula,
                            un carácter especial y una longitud mínima de 8 caracteres."
                                   required>
                            <span class="focus-border"></span>
                        </div>
                    </div>


                    <p>Dirección</p>
                    <div class="form-row">
                        <div class="form-holder">
                            <input type="text" placeholder="Calle" name="calle" class="form-control effect-1" required>
                            <span class="focus-border"></span>
                        </div>
                        <div class="form-holder">
                            <input type="text" placeholder="Colonia" name="colonia" class="form-control effect-1" required>
                            <span class="focus-border"></span>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-holder">
                            <input type="text" placeholder="Localidad" name="localidad" class="form-control effect-1">
                            <span class="focus-border"></span>
                        </div>
                        <div class="form-holder">
                            <input type="text" placeholder="Estado" name="entidad_federativa" class="form-control effect-1" required>
                            <span class="focus-border"></span>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-holder">
                            <input type="int" placeholder="Código Postal" name=codigo_postal class="form-control effect-1" required>
                            <span class="focus-border"></span>
                        </div>
                        <div class="form-holder">
                            <input type="text" placeholder="Municipio" name="municipio" class="form-control effect-1" required>
                            <span class="focus-border"></span>
                        </div>

                        <input type="hidden" name="estado" value="ACTIVO">
                        <input type="hidden" name="codigo" value="codigo">

                    </div>

                    <center>
                        <input type="submit" name="accion" value="Registrar"><br><br>
                        Ya tienes cuenta?
                        <a href="login_cliente.jsp">Inicia Sesión</a><br><br>
                    </center>


                </div>
            </div>
        </section>

    </form>
</div>

</body>
</html>