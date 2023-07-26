<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Correo</title>
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
        <h3> Solicitación de nueva contraseña </h3>
        <p>Para poder recuperar tu contraseña, proporciona en este apartado tu correo electrónico
            y espera un mensaje, en donde se te indicara el enlace para generar tu nueva contraseña.</p>

        <form method="post" action="Recuperar">
            <div class="input-form">
                <br>
                <input name="correo" class="effect-1" type="text" placeholder="Correo electrónico">
                <span class="focus-border"></span>
            </div>

            <br>

            <button type="submit" class="btn btn-primary">Recibir correo </button>
            <br>
        </form>


    </div>
</div>

</body>
</html>
