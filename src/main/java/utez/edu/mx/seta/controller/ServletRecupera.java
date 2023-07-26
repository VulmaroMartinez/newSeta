package utez.edu.mx.seta.controller;

import utez.edu.mx.seta.models.BeanCliente;
import utez.edu.mx.seta.models.DaoCliente;
import utez.edu.mx.seta.utils.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@WebServlet(name = "ServletRecupera", urlPatterns = {"/Recuperar"})
public class ServletRecupera extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Inicio del método doPost");


        String correo = req.getParameter("correo");

        if (!correo.isEmpty()){
            DaoCliente dao = new DaoCliente();
            BeanCliente cliente = (BeanCliente) dao.Recupera(correo);

            System.out.println("Cliente recuperado: " + cliente);

            if (cliente.getId_cliente()!=0){

                //si existe un usuario con ese correo en la base de datos

                SendEmail mail = new SendEmail();

                try {
                    String url = req.getRequestURL().toString();
                    mail.sendEmail(
                            cliente.getCorreo(),
                            "Recuperación de contraseña",
                            "<!DOCTYPE html>\n" +
                                    "<html lang=\"en\">\n" +
                                    "<head>\n" +
                                    "    <title>Home</title>\n" +
                                    "    <meta charset=\"UTF-8\" />\n" +
                                    "    <meta name=\"viewport\" content=\"width=device-width\" />\n" +
                                    "    <style>\n" +
                                    "        p {\n" +
                                    "            font-family: 'Consolas', sans-serif;\n" +
                                    "        }\n" +
                                    "        .btn:link,\n" +
                                    "        .btn:visited {\n" +
                                    "            text-transform: uppercase;\n" +
                                    "            text-decoration: none;\n" +
                                    "            color: rgb(27, 27, 27);\n" +
                                    "            padding: 10px 30px;\n" +
                                    "            border: 1px solid;\n" +
                                    "            border-radius: 1000px;\n" +
                                    "            display: inline-block;\n" +
                                    "            transition: all .2s;\n" +
                                    "            position: relative;\n" +
                                    "        }\n" +
                                    "        .btn:hover {\n" +
                                    "            transform: translateY(-5px);\n" +
                                    "            box-shadow: 0 10px 20px rgba(27, 27, 27, .5);\n" +
                                    "        }\n" +
                                    "        .btn:active {\n" +
                                    "            transform: translateY(-3px);\n" +
                                    "        }\n" +
                                    "        .btn::after {\n" +
                                    "            content: \"\";\n" +
                                    "            display: inline-block;\n" +
                                    "            height: 100%;\n" +
                                    "            width: 100%;\n" +
                                    "            border-radius: 100px;\n" +
                                    "            top: 0;\n" +
                                    "            left: 0;\n" +
                                    "            position: absolute;\n" +
                                    "            z-index: -1;\n" +
                                    "            transition: all .3s;\n" +
                                    "        }\n" +
                                    "        .btn:hover::after {\n" +
                                    "            background-color: rgb(0, 238, 255);\n" +
                                    "            transform: scaleX(1.4) scaleY(1.5);\n" +
                                    "            opacity: 0;\n" +
                                    "        }\n" +
                                    "    </style>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "    <nav>\n" +
                                    "        <a href=\"/\" aria-current=\"page\">Home</a>\n" +
                                    "        <a href=\"/page2.html\">Other page</a>\n" +
                                    "    </nav>\n" +
                                    "    <main>\n" +
                                    "        <center>\n" +
                                    "            <h1>¡Hola arañita!</h1>\n" +
                                    "            <p>Seguro que entre tantas telarañas perdiste tu contraseña.</p>\n" +
                                    "            <p>Da click en el siguiente enlace para recuperarla</p>\n" +
                                    "            <a href=\"" + url + "?codigo = " + cliente.getCodigo() + "\"  class=\"btn\"> Enlace</a>" +
                                    "            <p>Ten cuidado a la siguiente, Ten un día creativo</p>\n" +
                                    "        </center>\n" +
                                    "    </main>\n" +
                                    "</body>\n" +
                                     "</html>",

                            new File(
                                    req.getSession().
                                            getServletContext().
                                            getResource("./recursos/recursos_index/img/logo.png").
                                            toURI()));

                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("Final del método doPost");


        req.getSession().setAttribute("operacion",
                "porfavor revisa tu correo electronico para continuar con el proceso de recuperación de contraseña");
        resp.sendRedirect("index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codigo = req.getParameter("codigo");
        String url = "index.jsp";

        /*
        1 usamos el codigo para checar si existe
        en la base de datos y recuperar la información del
        usuario
        */

        DaoCliente dao = new DaoCliente();
        BeanCliente cliente = (BeanCliente) dao.Code(codigo);

        if (cliente.getId_cliente()==0){
            ;
        }else{
            if(cliente.getCodigo().isEmpty()){
                //Que no existe el codigo en la BD
                //Avisarle al usuario o no

            }else{
                //Que si existe la información
                req.getSession().setAttribute("infoContra",cliente);
                url="recuperacion.jsp   ";
            /*


        1.5 Obtener la nueva contraseña del usuario
        2. Hacer el update del campo contraseña del usuario
        Y DEL CAMPO CODIGO <--- mediante java con un String random
        3. Quitar toda la informacion de las sesiones y regresar
        al index.jsp
         */
            }
        }

        resp.sendRedirect(url);
    }
}
