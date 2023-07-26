<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contraseña nueva</title>
    <link rel="stylesheet" href="recursos/recursos_recupera/css/estilos.css">
    <link href="recursos/recursos_recupera/css/estilos2.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="col-lg-6 login-form">
        <img class="image-logo" src="recursos/recursos_recupera/img/tc.png" />
        <br>
        <br>
        <br>
        <h5> Recuperar Contraseña </h5>
        <p> Una vez que pulse generar nueva contraseña, <br> podrá acceder de nuevo al sitio con ella. </p>
        <form id="passwordForm" method="post" action="CambiarContra">
            <div class="input-form">
                <br>

                <input type="password"
                       id="contrasena"
                       name="contrasena"
                       placeholder="Contraseña nueva"
                       class="effect-1"
                       pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$-_%^&]).{8,}$"
                       title="Tu contraseña debe contener al menos una letra mayúscula, una letra minúscula,
                       un carácter especial y una longitud mínima de 8 caracteres."
                       required>

                <span class="focus-border"></span>
            </div>

            <div class="input-form">
                <br>

                <input type="password"
                       id="contrasena"
                       name="contrasena"
                       placeholder="Confirmar contraseña"
                       class="effect-1"
                       pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$-_%^&]).{8,}$"
                       title="Tu contraseña debe contener al menos una letra mayúscula, una letra minúscula,
                       un carácter especial y una longitud mínima de 8 caracteres."
                       required>

                <span class="focus-border"></span>

                <input type="hidden" name="id_cliente"  value="${infoContra.id_cliente}">


            </div>
            <br>
            <button type="submit" class="btn btn-primary">Generar Nueva Contraseña</button>
        </form>
    </div>
</div>
</body>
</html>

