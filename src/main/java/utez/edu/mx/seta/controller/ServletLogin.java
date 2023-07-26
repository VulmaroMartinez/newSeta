package utez.edu.mx.seta.controller;

import utez.edu.mx.seta.models.BeanCliente;
import utez.edu.mx.seta.models.DaoCliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "ServletLogin", urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String correo = req.getParameter("correo");

        String contrasena = req.getParameter("contrasena");

        DaoCliente dao = new DaoCliente();

        BeanCliente cliente = (BeanCliente) dao.findOne(correo, contrasena);

        if(cliente.getId_cliente()!=0){ //Que si existe un usuario en la BD

            req.getSession().setAttribute("sesion",cliente);

            req.getSession().setAttribute("tipoSesion", cliente.getCorreo().equals("correo"));

            // Redirigir a la página de bienvenida.
            resp.sendRedirect("index.jsp");

        } else {

            // Si las credenciales no son válidas, mostrar un mensaje de error en la página de login.
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h3>Login Fallido.</h3>");
            out.println("</body></html>");
        }
    }
}
