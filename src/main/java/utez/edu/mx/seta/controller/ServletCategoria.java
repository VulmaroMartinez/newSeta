package utez.edu.mx.seta.controller;


import utez.edu.mx.seta.models.BeanCategoria;
import utez.edu.mx.seta.models.DaoCategoria;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "ServletCategoria", urlPatterns = {"/ServletCategoria"})
public class ServletCategoria extends HttpServlet {

DaoCategoria daoCategoria = new DaoCategoria();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String accion = request.getParameter("accion");

       switch (accion) {
           case "Agregar":

           // Obtener los parámetros del formulario
           String nombre = request.getParameter("nombre");


           BeanCategoria categoria = new BeanCategoria();

           //lógica de programación para un registro de usuario

               categoria.setNombre(nombre);

               daoCategoria.Agregar(categoria);


               response.sendRedirect("ServletCategoria?accion2=findAll");



           break;



           case "Modificar" :

               String Id1 = request.getParameter("id_categoria");
               String Nombre = request.getParameter("nombre");

               BeanCategoria newInfo = new BeanCategoria();


               newInfo.setId_categoria(Integer.parseInt(Id1));
               newInfo.setNombre(Nombre);

               daoCategoria.Actualizar(newInfo);

               response.sendRedirect("ServletCategoria?accion2=findAll");

               break;



       }



    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion2");


        switch (accion) {

            case "findAll":
                List<BeanCategoria> list = daoCategoria.findAll();//LLAMAMOS LA LISTA CON METODO FINDALL DEL DAO

                request.setAttribute("list", list);//AQUI LE DAMOS UN APODO POR EL CUAL LO VAMOS A RECONOCER EN LA VISTA (JSP)

                request.getRequestDispatcher("ver_categoria.jsp").forward(request, response);//REDIRECCIONAMOS AL JSP CON LA INFORMACIÓN


                break;

            case "Add":
                List<BeanCategoria> list2 = daoCategoria.findAll();//LLAMAMOS LA LISTA CON METODO FINDALL DEL DAO

                request.setAttribute("list", list2);//AQUI LE DAMOS UN APODO POR EL CUAL LO VAMOS A RECONOCER EN LA VISTA (JSP)

                request.getRequestDispatcher("agregar_producto.jsp").forward(request, response);//REDIRECCIONAMOS AL JSP CON LA INFORMACIÓN


                break;



            case "update":

                String id_categoria = request.getParameter("id_categoria");

                BeanCategoria categoria1 = (BeanCategoria) daoCategoria.findOne(Integer.parseInt(id_categoria));

                request.setAttribute("categoria",categoria1);

                request.getRequestDispatcher("modificar_categoria.jsp").forward(request,response);

                break;

            case "eliminar":

                String id2 = request.getParameter("id_categoria");

                daoCategoria.delete(Integer.parseInt(id2));

                response.sendRedirect("ServletCategoria?accion2=findAll");

                break;


        }
    }






}

