package utez.edu.mx.seta.controller;

import javax.servlet.annotation.WebServlet;

import utez.edu.mx.seta.models.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "CarritoServlet", value = "/CarritoServlet")

public class ServletCarrito extends HttpServlet {



    BeanProducto p = new BeanProducto();
    DaoProducto pdao = new DaoProducto();
    List<BeanProducto> productos = new ArrayList<>();

    List<BeanCarrito> listaCarrito = new ArrayList<BeanCarrito>();
    int item;
    double totalPagar = 0.0;
    int cantidad=1;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");
        productos = pdao.findAll();
        switch (accion)  {

            case "Addcar":


                int idp = Integer.parseInt(req.getParameter("id_producto"));
                p = pdao.carId(idp);
                item=item+1;
                BeanCarrito car = new BeanCarrito();
                car.setItem(item);
                car.setId_producto(p.getId_producto());
                car.setNombres(p.getNombre());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad*p.getPrecio());

                listaCarrito.add(car);

                req.setAttribute("contador", listaCarrito.size());
                req.getRequestDispatcher("TiendaServlet?accion=findAll").forward(req,resp);



                break;

            case "car":
                totalPagar=0.0;
                req.setAttribute("carrito",listaCarrito);
                for (int i = 0; i <listaCarrito.size(); i++) {
                    totalPagar=totalPagar+listaCarrito.get(i).getSubTotal();

                }

                req.setAttribute("totalPagar", totalPagar);

                req.getRequestDispatcher("carrito.jsp").forward(req,resp);

                break;


        }




    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}
