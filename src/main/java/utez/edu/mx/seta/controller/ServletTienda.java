package utez.edu.mx.seta.controller;

import utez.edu.mx.seta.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet (name = "TiendaServlet", urlPatterns = {"/TiendaServlet"})
public class ServletTienda extends HttpServlet {
    DaoProducto  daoProducto = new DaoProducto();
    DaoCategoria daoCategoria = new DaoCategoria();
    BeanProducto producto = new BeanProducto();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        switch (accion){

            case "findAll":

                List<BeanCategoria> list2 = daoCategoria.findAll();

                req.setAttribute("list2", list2);

                List<BeanProducto> list = daoProducto.findAll();

                req.setAttribute("list", list);

                req.getRequestDispatcher("tienda.jsp").forward(req,resp);

                break;

            case "inf":

                List<BeanProducto> list3 = daoProducto.findAll();

                req.setAttribute("list", list3);

                req.getRequestDispatcher("detalles_producto.jsp").forward(req,resp);


                break;

            case "data":

                String id_producto = req.getParameter("id_producto");

                BeanProducto producto1 = (BeanProducto) daoProducto.findOne(Integer.parseInt(id_producto));

                req.setAttribute("producto",producto1);

                req.getRequestDispatcher("detalles_producto.jsp").forward(req,resp);

                break;

        }
    }

}
