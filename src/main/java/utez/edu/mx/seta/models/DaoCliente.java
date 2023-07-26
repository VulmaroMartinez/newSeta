package utez.edu.mx.seta.models;

import utez.edu.mx.seta.utils.MysqlConector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCliente implements DaoRepository {

    Connection conn;
    PreparedStatement pstn;
    ResultSet rs;
    MysqlConector mysqlConector = new MysqlConector();

    private final String GET_CLIENTES = "select * from cliente";

    private final String GET_CATEGORIA = "select * from categoria where id_categoria = ?";



    public Object findOne(String correo, String contrasena) {
        BeanCliente cliente = new BeanCliente();
        MysqlConector conector = new MysqlConector();
        Connection con = conector.connect();
        try {
            PreparedStatement stmt =
                    con.prepareStatement("select * from cliente " +
                            "where correo = ? AND contrasena = ?");
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                cliente.setId_cliente(res.getInt("id_cliente"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setContrasena(res.getString("contrasena"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public boolean actualizar (BeanCliente newInfo) {
        boolean flag = false;

        Connection con = new MysqlConector().connect();

        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE cliente SET " +
                            "nombre = ?, " +
                            "apaterno = ?, " +
                            "amaterno = ?, " +
                            "contrasena = ?, " +
                            "correo = ?, " +
                            "estado = ?, " +
                            "calle = ?, " +
                            "colonia = ?, " +
                            "codigo_postal = ?, " +
                            "localidad = ?, " +
                            "municipio = ?, " +
                            "entidad_federativa = ? " +
                            "WHERE id_cliente = ?"
            );

            stmt.setString(1, newInfo.getNombre());
            stmt.setString(2, newInfo.getApaterno());
            stmt.setString(3, newInfo.getAmaterno());
            stmt.setString(4, newInfo.getContrasena());
            stmt.setString(5, newInfo.getCorreo());
            stmt.setString(6, newInfo.getEstado());
            stmt.setString(7, newInfo.getCalle());
            stmt.setString(8, newInfo.getColonia());
            stmt.setInt(9, newInfo.getCodigo_postal());
            stmt.setString(10, newInfo.getLocalidad());
            stmt.setString(11, newInfo.getMunicipio());
            stmt.setString(12, newInfo.getEntidad_federativa());
            stmt.setInt(13, newInfo.getId_cliente());

            flag = stmt.executeUpdate() > 0 ? true : false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public boolean insertar (BeanCliente cliente){
        Connection con = new MysqlConector().connect();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "insert into cliente (nombre, apaterno, amaterno, contrasena, correo, estado, calle, colonia, codigo_postal, localidad, municipio, entidad_federativa, codigo) " +
                            "values (?,?,?,?,?,?,?,?,?,?,?,?,sha2(?,224))"
            );
            stmt.setString(1,cliente.getNombre());
            stmt.setString(2,cliente.getApaterno());
            stmt.setString(3,cliente.getAmaterno());
            stmt.setString(4,cliente.getContrasena());
            stmt.setString(5,cliente.getCorreo());
            stmt.setString(6,cliente.getEstado());
            stmt.setString(7,cliente.getCalle());
            stmt.setString(8,cliente.getColonia());
            stmt.setInt(9,cliente.getCodigo_postal());
            stmt.setString(10,cliente.getLocalidad());
            stmt.setString(11,cliente.getMunicipio());
            stmt.setString(12,cliente.getEntidad_federativa());
            stmt.setString(13,cliente.getCodigo());

            if (stmt.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public BeanCliente Recupera(String correo) {
        BeanCliente cliente = new BeanCliente();
        MysqlConector conector = new MysqlConector();
        Connection con = conector.connect();
        try {
            PreparedStatement stmt =
                    con.prepareStatement("select * from cliente " +
                            "where correo = ?");
            stmt.setString(1,correo);
            ResultSet res = stmt.executeQuery();

            if(res.next()){
                cliente.setId_cliente(res.getInt("id_cliente"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setContrasena(res.getString("contrasena"));
                cliente.setCodigo(res.getString("codigo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cliente;
    }

    public BeanCliente Code(String codigo) {

        BeanCliente cliente = new BeanCliente();
        MysqlConector conector = new MysqlConector();
        Connection con = conector.connect();
        try {
            PreparedStatement stmt =
                    con.prepareStatement("select * from cliente " +
                            "where codigo = ?");
            stmt.setString(1,codigo);
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApaterno(rs.getString("apaterno"));
                cliente.setAmaterno(rs.getString("amaterno"));
                cliente.setContrasena(rs.getString("contrasena"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCalle(rs.getString("calle"));
                cliente.setColonia(rs.getString("colonia"));
                cliente.setCodigo_postal(rs.getInt("codigo_postal"));
                cliente.setLocalidad(rs.getString("localidad"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setEntidad_federativa(rs.getString("entidad_federativa"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public boolean UpdatePass(int id_cliente, Object object){

        boolean estado = false;
        Connection con = new MysqlConector().connect();
        try {

            PreparedStatement stmt = con.prepareStatement(
                    "update cliente set correo = ?," +
                            "contrasena = ?," +
                            "codigo = sha2(?,224)" +
                            "where id_cliente = ?"
            );

            BeanCliente cliente = (BeanCliente) object;
            stmt.setString(1,cliente.getCorreo());
            stmt.setString(2,cliente.getContrasena());
            stmt.setString(3,cliente.getCodigo());
            stmt.setInt(4,id_cliente);
            estado = stmt.executeUpdate() > 0 ? true:false;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return estado;
    }

    @Override
    public Object findOne(int id) {
        BeanCliente cliente = new BeanCliente();
        MysqlConector conector = new MysqlConector();
        Connection con = conector.connect();
        try {
            PreparedStatement stmt =
                    con.prepareStatement("select * from cliente " +
                            "where id_cliente = ?");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){

                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApaterno(rs.getString("apaterno"));
                cliente.setAmaterno(rs.getString("amaterno"));
                cliente.setContrasena(rs.getString("contrasena"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCalle(rs.getString("calle"));
                cliente.setColonia(rs.getString("colonia"));
                cliente.setCodigo_postal(rs.getInt("codigo_postal"));
                cliente.setLocalidad(rs.getString("localidad"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setEntidad_federativa(rs.getString("entidad_federativa"));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cliente;
    }

    @Override
    public List findAll() {
        List<BeanCliente> clientes = new ArrayList<>();
        try{
            conn = mysqlConector.connect();
            String query = GET_CLIENTES;
            pstn = conn.prepareStatement(query);
            rs = pstn.executeQuery();

            while(rs.next()){
                BeanCliente cliente = new BeanCliente();

                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApaterno(rs.getString("apaterno"));
                cliente.setAmaterno(rs.getString("amaterno"));
                cliente.setContrasena(rs.getString("contrasena"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCalle(rs.getString("calle"));
                cliente.setColonia(rs.getString("colonia"));
                cliente.setCodigo_postal(rs.getInt("codigo_postal"));
                cliente.setLocalidad(rs.getString("localidad"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setEntidad_federativa(rs.getString("entidad_federativa"));
                cliente.setRol(rs.getString("rol"));

                clientes.add(cliente);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
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