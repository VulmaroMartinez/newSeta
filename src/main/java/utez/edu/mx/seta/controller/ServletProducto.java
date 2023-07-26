package utez.edu.mx.seta.controller;


import utez.edu.mx.seta.models.BeanCategoria;
import utez.edu.mx.seta.models.BeanProducto;
import utez.edu.mx.seta.models.DaoCategoria;
import utez.edu.mx.seta.models.DaoProducto;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@MultipartConfig
@WebServlet (name = "ServletProducto", urlPatterns = {"/ServletProducto"})
public class ServletProducto extends HttpServlet {

    DaoProducto daoProducto = new DaoProducto();

    DaoCategoria daoCategoria = new DaoCategoria();


    BeanProducto producto = new BeanProducto();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion2 = request.getParameter("accion2");


        switch (accion2){

            case "Agregar":

                String nombre = request.getParameter("nombre");
                double precio = Double.parseDouble(request.getParameter("precio"));
                int existencias = Integer.parseInt(request.getParameter("existencias"));
                String estado = request.getParameter("estado");
                String descripcion = request.getParameter("descripcion");
                int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
                Part imagen_1 = request.getPart("imagen_1");
                InputStream imagen_1Stream = imagen_1.getInputStream();
                Part imagen_2 = request.getPart("imagen_2");
                InputStream imagen_2Stream = imagen_2.getInputStream();
                Part imagen_3 = request.getPart("imagen_3");
                InputStream imagen_3Stream = imagen_3.getInputStream();



        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setExistencias(existencias);
        producto.setEstado(estado);
        producto.setDescripcion(descripcion);
        producto.setId_categoria(id_categoria);
        producto.setImagen_1(imagen_1Stream);
        producto.setImagen_2(imagen_2Stream);
        producto.setImagen_3(imagen_3Stream);

        daoProducto.insert(producto);

        response.sendRedirect("ServletProducto?accion=findAll");
break;




            case "Modificar" :

                String Id1 = request.getParameter("id_producto");

                String Nombre = request.getParameter("nombre");
                Double Precio = Double.parseDouble(request.getParameter("precio"));
                int Existencias = Integer.parseInt(request.getParameter("existencias"));
                String Estado = request.getParameter("estado");
                String Descripcion = request.getParameter("descripcion");
                int Id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
                Part Imagen_1 = request.getPart("imagen_1");
                InputStream Imagen_1Stream = Imagen_1.getInputStream();
                Part Imagen_2 = request.getPart("imagen_2");
                InputStream Imagen_2Stream = Imagen_2.getInputStream();
                Part Imagen_3 = request.getPart("imagen_3");
                InputStream Imagen_3Stream = Imagen_3.getInputStream();

                BeanProducto newInfo = new BeanProducto();

                newInfo.setId_producto(Integer.parseInt(Id1));


                newInfo.setNombre(Nombre);
                newInfo.setPrecio(Precio);
                newInfo.setExistencias(Existencias);
                newInfo.setEstado(Estado);
                newInfo.setDescripcion(Descripcion);
                newInfo.setId_categoria(Id_categoria);

                newInfo.setImagen_1(Imagen_1Stream);
                newInfo.setImagen_2(Imagen_2Stream);
                newInfo.setImagen_3(Imagen_3Stream);

                daoProducto.Update(newInfo);

                response.sendRedirect("ServletProducto?accion=findAll");

                break;

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");


        switch (accion) {

            case "findAll":
                List<BeanProducto> list = daoProducto.findAll();   //LLAMAMOS LA LISTA CON METODO FINDALL DEL DAO

                request.setAttribute("list", list);  //AQUI LE DAMOS UN APODO POR EL CUAL LO VAMOS A RECONOCER EN LA VISTA (JSP)

                request.getRequestDispatcher("ver_producto.jsp").forward(request, response);   //REDIRECCIONAMOS AL JSP CON LA INFORMACIÓN


                break;

            case "update":


                List<BeanCategoria> list2 = daoCategoria.findAll();//LLAMAMOS LA LISTA CON METODO FINDALL DEL DAO

                request.setAttribute("list", list2);//AQUI LE DAMOS UN APODO POR EL CUAL LO VAMOS A RECONOCER EN LA VISTA (JSP)

                String id_producto = request.getParameter("id_producto");

                BeanProducto producto = (BeanProducto) daoProducto.findOne(Integer.parseInt(id_producto));

                request.setAttribute("producto",producto);

                request.getRequestDispatcher("modificar_producto.jsp").forward(request,response);

                break;

            case "eliminar":

                String id2 = request.getParameter("id_producto");

                daoProducto.del(Integer.parseInt(id2));

                response.sendRedirect("ServletProducto?accion=findAll");

                break;





        }




    }
}













