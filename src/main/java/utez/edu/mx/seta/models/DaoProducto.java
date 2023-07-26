package utez.edu.mx.seta.models;
import utez.edu.mx.seta.utils.MysqlConector;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DaoProducto implements DaoRepository {

    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    MysqlConector mysqlConector = new MysqlConector();

    private final String UPDATE_PRODUCTO = "update producto set nombre = ?, precio = ?, existencias = ?, estado = ?, descripcion = ?, id_categoria = ?, imagen_1 = ?, imagen_2 = ?, imagen_3 = ? where id_producto = ?";

    private final String GET_PRODUCTO = "SELECT p.*, c.* " +
            "FROM producto p " +
            "INNER JOIN categoria c ON p.id_categoria = c.id_categoria where id_producto = ?";

    private final  String DELETE_PRODUCTO = "delete from producto where id_producto = ?";



    @Override
    public List findAll() {
        List<BeanProducto> productos = new ArrayList<>();
        String sql = "SELECT p.*, c.* " +
                     "FROM producto p " +
                     "INNER JOIN categoria c ON p.id_categoria = c.id_categoria";
        try {
            conn = mysqlConector.connect();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()){
                BeanProducto producto = new BeanProducto();

                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setExistencias(rs.getInt("existencias"));
                producto.setEstado(rs.getString("estado"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setId_categoria(rs.getInt("id_categoria"));
                producto.setImagen_1(rs.getBinaryStream("imagen_1"));
                producto.setImagen_2(rs.getBinaryStream("imagen_2"));
                producto.setImagen_3(rs.getBinaryStream("imagen_3"));

                BeanCategoria categoria = new BeanCategoria();
                categoria.setNombre(rs.getString("c.nombre"));

                producto.setCategoria(categoria);


                productos.add(producto);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productos;
    }

    @Override
    public Object findOne(int id_producto) {
        BeanProducto producto = new BeanProducto();
        try{
            conn = mysqlConector.connect();
            String sql = GET_PRODUCTO;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_producto);
            rs = stmt.executeQuery();

            if (rs.next()){
                producto = new BeanProducto();

                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setExistencias(rs.getInt("existencias"));
                producto.setEstado(rs.getString("estado"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setId_categoria(rs.getInt("id_categoria"));
                producto.setImagen_1(rs.getBinaryStream("imagen_1"));
                producto.setImagen_2(rs.getBinaryStream("imagen_2"));
                producto.setImagen_3(rs.getBinaryStream("imagen_3"));

                BeanCategoria categoria = new BeanCategoria();
                categoria.setNombre(rs.getString("c.nombre"));

                producto.setCategoria(categoria);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return producto;
    }

    public void Update(BeanProducto newInfo){

        try {

            mysqlConector.connect();
            String sql = UPDATE_PRODUCTO;
            stmt = conn.prepareStatement(sql);

            stmt.setString(1,newInfo.getNombre());
            stmt.setDouble(2,newInfo.getPrecio());
            stmt.setInt(3,newInfo.getExistencias());
            stmt.setString(4,newInfo.getEstado());
            stmt.setString(5,newInfo.getDescripcion());
            stmt.setInt(6,newInfo.getId_categoria());
            stmt.setBlob(7,newInfo.getImagen_1());
            stmt.setBlob(8,newInfo.getImagen_2());
            stmt.setBlob(9,newInfo.getImagen_3());
            stmt.setInt(10,newInfo.getId_producto());

            if (stmt.executeUpdate() ==1){
                System.out.println("nothing");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void del (int id_producto){

        try {
            conn = mysqlConector.connect();
            String sql = DELETE_PRODUCTO;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id_producto);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public BeanProducto carId(int id_producto) {
        BeanProducto producto = null;

        try {
            conn = mysqlConector.connect();
            String sql = "select * from producto where id_producto="+id_producto;
            stmt = conn.prepareStatement(sql);
            rs= stmt.executeQuery();

            if (rs.next()){
                producto = new BeanProducto();

                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setExistencias(rs.getInt("existencias"));
                producto.setEstado(rs.getString("estado"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setId_categoria(rs.getInt("id_categoria"));
                producto.setImagen_1(rs.getBinaryStream("imagen_1"));
                producto.setImagen_2(rs.getBinaryStream("imagen_2"));
                producto.setImagen_3(rs.getBinaryStream("imagen_3"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return producto;
    }


    public void findImg(int id_producto, HttpServletResponse response){

        String sql="SELECT * FROM producto WHERE Id_producto="+id_producto;

        InputStream inputStream=null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        response.setContentType("image/*");

        try {

            outputStream=response.getOutputStream();
            conn=mysqlConector.connect();
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            if (rs.next()){
                inputStream=rs.getBinaryStream("imagen_1");

            }

            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            int i=0;
            while ((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {



            // Cierre de los flujos
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // Manejo del error al cerrar el inputStream
                    e.printStackTrace();
                }

            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    // Manejo del error al cerrar el outputStream
                    e.printStackTrace();
                }
            }
        }


    }


    public void findImg2(int id_producto, HttpServletResponse response){

        String sql="SELECT * FROM producto WHERE Id_producto="+id_producto;
        InputStream inputStream=null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        response.setContentType("image/*");

        try {

            outputStream=response.getOutputStream();
            conn=mysqlConector.connect();
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            if (rs.next()){
                inputStream=rs.getBinaryStream("imagen_2");

            }

            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            int i=0;
            while ((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            // Cierre de los flujos
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // Manejo del error al cerrar el inputStream
                    e.printStackTrace();
                }

            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    // Manejo del error al cerrar el outputStream
                    e.printStackTrace();
                }
            }
        }


    }

    public void findImg3(int id_producto, HttpServletResponse response){

        String sql="SELECT * FROM producto WHERE Id_producto="+id_producto;
        InputStream inputStream=null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        response.setContentType("image/*");

        try {
            outputStream=response.getOutputStream();
            conn=mysqlConector.connect();
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            if (rs.next()){
                inputStream=rs.getBinaryStream("imagen_3");

            }

            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            int i=0;
            while ((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            // Cierre de los flujos
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // Manejo del error al cerrar el inputStream
                    e.printStackTrace();
                }

            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    // Manejo del error al cerrar el outputStream
                    e.printStackTrace();
                }
            }
        }
    }

    public void insert (BeanProducto producto){
        MysqlConector conector = new MysqlConector();
        Connection con = conector.connect();
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO producto (nombre, precio, existencias, estado, descripcion, id_categoria, imagen_1, imagen_2, imagen_3) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            stmt.setString(1,producto.getNombre());
            stmt.setDouble(2,producto.getPrecio());
            stmt.setInt(3,producto.getExistencias());
            stmt.setString(4,producto.getEstado());
            stmt.setString(5,producto.getDescripcion());
            stmt.setInt(6,producto.getId_categoria());
            stmt.setBlob(7,producto.getImagen_1());
            stmt.setBlob(8,producto.getImagen_2());
            stmt.setBlob(9,producto.getImagen_3());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(int id, Object object) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
