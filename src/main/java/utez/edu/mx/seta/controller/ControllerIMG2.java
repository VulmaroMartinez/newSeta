package utez.edu.mx.seta.controller;

import utez.edu.mx.seta.models.BeanProducto;
import utez.edu.mx.seta.models.DaoProducto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerIMG2",urlPatterns = {"/ControllerIMG2"})

public class ControllerIMG2 extends HttpServlet {

    DaoProducto daoProducto = new DaoProducto();
    BeanProducto beanProducto = new BeanProducto();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_producto = Integer.parseInt(request.getParameter("id_producto"));

        daoProducto.findImg2(id_producto, response);

    }
}
