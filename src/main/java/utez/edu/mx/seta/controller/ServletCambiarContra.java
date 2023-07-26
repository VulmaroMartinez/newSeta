package utez.edu.mx.seta.controller;

import utez.edu.mx.seta.models.BeanCliente;
import utez.edu.mx.seta.models.DaoCliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "ServletCambiarContra", urlPatterns = {"/CambiarContra"})
public class ServletCambiarContra extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String contrasena = req.getParameter("contrasena");
        int id_cliente = Integer.parseInt(req.getParameter("id_cliente"));

        DaoCliente dao = new DaoCliente();
        BeanCliente cliente = (BeanCliente) dao.findOne(id_cliente);
        cliente.setContrasena(contrasena);
        cliente.setCodigo(Math.random()+"");

        dao.UpdatePass(id_cliente,cliente);

        req.getSession().removeAttribute("infoContra");
        req.getSession().removeAttribute("sesion");
        req.getSession().removeAttribute("tipoSesion");

        req.getSession().setAttribute("operacion",
                "Se cambio la contraseña existosamente");
        resp.sendRedirect("index.jsp");


    }

}

