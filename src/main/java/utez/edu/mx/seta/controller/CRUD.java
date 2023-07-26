package utez.edu.mx.seta.controller;

import utez.edu.mx.seta.models.BeanCliente;
import utez.edu.mx.seta.models.DaoCliente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet (name = "CRUD", urlPatterns = {"/newcuenta"})
public class CRUD extends HttpServlet {

    DaoCliente daoCliente = new DaoCliente();
    BeanCliente cliente = new BeanCliente();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        switch (accion) {

            case "Registrar":

                String nombre = req.getParameter("nombre");
                String apaterno = req.getParameter("apaterno");
                String amaterno = req.getParameter("amaterno");
                String contrasena = req.getParameter("contrasena");
                String correo = req.getParameter("correo");
                String estado = req.getParameter("estado");
                String calle = req.getParameter("calle");
                String colonia = req.getParameter("colonia");
                int    codigo_postal = Integer.parseInt(req.getParameter("codigo_postal"));
                String localidad = req.getParameter("localidad");
                String municipio = req.getParameter("municipio");
                String entidad_federativa = req.getParameter("entidad_federativa");
                String codigo = req.getParameter("codigo");

                cliente.setNombre(nombre);
                cliente.setApaterno(apaterno);
                cliente.setAmaterno(amaterno);
                cliente.setContrasena(contrasena);
                cliente.setCorreo(correo);
                cliente.setEstado(estado);
                cliente.setCalle(calle);
                cliente.setColonia(colonia);
                cliente.setCodigo_postal(codigo_postal);
                cliente.setLocalidad(localidad);
                cliente.setMunicipio(municipio);
                cliente.setEntidad_federativa(entidad_federativa);
                cliente.setCodigo(codigo);

                daoCliente.insertar(cliente);

                resp.sendRedirect("login_cliente.jsp");

                return;

            case "Actualizar":


                String Id1 = req.getParameter("id_cliente");
                String nombre1 = req.getParameter("nombre");
                String apaterno1 = req.getParameter("apaterno");
                String amaterno1 = req.getParameter("amaterno");
                String contrasena1 = req.getParameter("contrasena");
                String correo1 = req.getParameter("correo");
                String estado1 = req.getParameter("estado");
                String calle1 = req.getParameter("calle");
                String colonia1 = req.getParameter("colonia");
                int codigo_postal1 = Integer.parseInt(req.getParameter("codigo_postal"));
                String localidad1 = req.getParameter("localidad");
                String municipio1 = req.getParameter("municipio");
                String entidad_federativa1 = req.getParameter("entidad_federativa");
                String codigo1  = req.getParameter("codigo");

                BeanCliente newInfo = new BeanCliente();

                newInfo.setId_cliente(Integer.parseInt(Id1));

                newInfo.setNombre(nombre1);
                newInfo.setApaterno(apaterno1);
                newInfo.setAmaterno(amaterno1);
                newInfo.setContrasena(contrasena1);
                newInfo.setCorreo(correo1);
                newInfo.setEstado(estado1);
                newInfo.setCalle(calle1);
                newInfo.setColonia(colonia1);
                newInfo.setCodigo_postal(codigo_postal1);
                newInfo.setLocalidad(localidad1);
                newInfo.setMunicipio(municipio1);
                newInfo.setEntidad_federativa(entidad_federativa1);
                newInfo.setCodigo(codigo1);


                daoCliente.actualizar(newInfo);
                resp.sendRedirect("index.jsp");

                break;
        }
}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion2 = req.getParameter("accion2");

        switch (accion2) {

            case "update":

                String id_cliente = req.getParameter("id_cliente");

                BeanCliente cliente1 =  (BeanCliente) daoCliente.findOne(Integer.parseInt(id_cliente));

                req.setAttribute("cliente", cliente1);

                req.getRequestDispatcher("editarInfo.jsp").forward(req, resp);

                break;

        }
    }
}
