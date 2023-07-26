<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar información</title>
    <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.css">
    <link rel="stylesheet" href="recursos/recursos_cuenta/css/style.css">

</head>
<body>

<div class="wrapper">
    <form action="newcuenta" method="post" style="width: 1000px; height: auto;">
        <!-- SECTION 1 -->
        <section>
            <div class="inner">
                <img class="image-fluid" src="recursos/recursos_cuenta/img/editarperfil.jpg" style="width: 430px; height: auto; border-radius: 5px;"  alt="">
                <div class="form-content" >
                    <div class="form-header">
                        <div class="logo-containerr">
                            <img src="recursos/recursos_cuenta/img/gl.png" alt="Logo" class="logo-imagee mt-6">
                        </div>
                        <h3>Editar perfil</h3>
                    </div>
                    <br>
                    <!--p>Please fill with your details</p-->

                    <div class="form-row">
                        <input type="hidden" name="id_cliente" value="${cliente.getId_cliente()}">
                        <div class="form-holder">
                            Nombre:
                            <input type="text" name="nombre" value="${cliente.getNombre()}" class="form-control effect-1" required>
                            <span class="focus-border"></span>
                        </div>
                        <div class="form-holder">
                            Primer Apellido:
                            <input type="text" name="apaterno" value="${cliente.getApaterno()}" class="form-control effect-1" required >
                            <span class="focus-border"></span>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-holder">
                            Segundo Apellido:
                            <input type="text" name="amaterno" value="${cliente.getAmaterno()}" class="form-control effect-1">
                            <span class="focus-border"></span>
                        </div>

                        <div class="form-holder">
                            Contraseña:
                            <input type="password" id="contrasena"
                                   name="contrasena"
                                   value="${cliente.getContrasena()}"
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
                            Calle:
                            <input type="text" name="calle" value="${cliente.getCalle()}" class="form-control effect-1" required >
                            <span class="focus-border"></span>
                        </div>
                        <div class="form-holder">
                            Colonia:
                            <input type="text" name="colonia" value="${cliente.getColonia()}" class="form-control effect-1" required >
                            <span class="focus-border"></span>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-holder">
                            Localidad:
                            <input type="text" name="localidad" value="${cliente.getLocalidad()}" class="form-control effect-1" >
                            <span class="focus-border"></span>
                        </div>
                        <div class="form-holder">
                            Estado:
                            <input type="text" name="entidad_federativa" value="${cliente.getEntidad_federativa()}" class="form-control effect-1" required >
                            <span class="focus-border"></span>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-holder">
                            Código Postal:
                            <input type="int" name="codigo_postal" value="${cliente.getCodigo_postal()}" class="form-control effect-1" required >
                            <span class="focus-border"></span>
                        </div>
                        <div class="form-holder">
                            Municipio:
                            <input type="text" name="municipio" value="${cliente.getMunicipio()}" class="form-control effect-1" required >
                            <span class="focus-border"></span>
                        </div>

                        <input type="hidden" name="estado" value="${cliente.getEstado()}">

                    </div>

                    <center>
                        <input type="submit" name="accion" value="Actualizar"><br><br>


                    </center>


                </div>
            </div>
        </section>

    </form>
</div>

</body>
</html>
