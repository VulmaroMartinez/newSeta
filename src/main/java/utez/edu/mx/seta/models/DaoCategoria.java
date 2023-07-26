package utez.edu.mx.seta.models;

import utez.edu.mx.seta.utils.MysqlConector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCategoria implements DaoRepository {

    Connection conn;
    PreparedStatement pstn;
    ResultSet rs;
    MysqlConector mysqlConector = new MysqlConector();

    private final String GET_CATEGORIAS = "select * from categoria";

    private final  String GET_CATEGORIA = "select * from categoria where id_categoria = ?";

    // Definir la consulta SQL con los parámetros adecuados
    private final String INSERT_CATEGORIA = "INSERT INTO categoria (nombre) VALUES (?)";
    private final String UPDATE_CATEGORIA = "UPDATE categoria SET nombre = ? where id_categoria = ?";
    private final String DELETE_CATEGORIA = "DELETE  FROM categoria WHERE id_categoria = ?";


    @Override
    public List findAll() {
        List<BeanCategoria> categorias = new ArrayList<>();

        try{
            conn = mysqlConector.connect();
            String query = GET_CATEGORIAS;
            pstn = conn.prepareStatement(query);
            rs = pstn.executeQuery();

            while(rs.next()){
                BeanCategoria categoria = new BeanCategoria();

                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));

                categorias.add(categoria);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorias;
    }

    @Override
    public Object findOne(int id_categoria) {
        BeanCategoria categoria = null;
        try{
            conn = mysqlConector.connect();
            String query = GET_CATEGORIA;
            pstn = conn.prepareStatement(query);
            pstn.setInt(1, id_categoria);
            rs = pstn.executeQuery();

            while(rs.next()){
                categoria = new BeanCategoria();

                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoria;
    }

    public void Actualizar (BeanCategoria newInfo){
        try{
            conn = mysqlConector.connect();
            String sql = UPDATE_CATEGORIA;
            pstn = conn.prepareStatement(sql);

            pstn.setString(1, newInfo.getNombre());
            pstn.setInt(2, newInfo.getId_categoria());

            if(pstn.executeUpdate() == 1){
                System.out.println("nothing");
            }
            pstn.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(int id, Object object) {
        return false;
    }

    @Override
    public boolean delete(int id_categoria) {
        boolean flag = false;
        try {
            conn = mysqlConector.connect();
            String sql = DELETE_CATEGORIA;
            pstn = conn.prepareStatement(sql);
            pstn.setInt(1, id_categoria);
            pstn.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public void Agregar(BeanCategoria categoria) {
        try {

            //Establecemos conexion
            conn = mysqlConector.connect();
            String query = INSERT_CATEGORIA;

            // Crear la declaración preparada con la consulta SQL
            pstn = conn.prepareStatement(query);


            // Establecer los valores de los parámetros
            pstn.setString(1, categoria.getNombre());
            if (pstn.executeUpdate() == 1) {
                System.out.println("Ok");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
