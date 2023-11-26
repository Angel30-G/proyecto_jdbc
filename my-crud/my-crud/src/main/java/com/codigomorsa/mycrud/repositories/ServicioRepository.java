package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.Cliente;
import com.codigomorsa.mycrud.model.Servicio;
import com.codigomorsa.mycrud.model.Vehiculo;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ServicioRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final ServicioMapper mapper = new ServicioMapper();

    private final RowMapper<Vehiculo> Vmapper = new VehiculoMapper();
    private final RowMapper<Cliente> Cmapper = new ClienteMapper();


    private static class ClienteMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            int numero_cliente = sr.getInt("numero_cliente");
            int cedula = sr.getInt("cedula");
            String tipoCedula = sr.getString("tipo_cedula");
            int telefono = sr.getInt("telefono");
            String email = sr.getNString("email");
            int taller = sr.getInt("taller");

            return new Cliente(id, numero_cliente, cedula, tipoCedula, telefono, email, taller);


        }
    }

    private static class VehiculoMapper implements RowMapper<Vehiculo> {
        @Override
        public Vehiculo mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            String numeroPlaca = sr.getString("numero_placa");
            String marca = sr.getNString("marca");
            String modelo = sr.getNString("modelo");
            Date anoFabricacion = sr.getDate("año_fabricacion");
            String VIN = sr.getNString("VIN");
            int cliente = sr.getInt("cliente");



            return new Vehiculo(id, numeroPlaca, marca, modelo, anoFabricacion, VIN, cliente);


        }
    }


    //private final SimpleJdbcInsert insert;

    public ServicioRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("celebridad").usingGeneratedKeyColumns("id");
    }

    public List<Servicio> getAllServicio(){
        String sql = "select * from servicio";
        return jdbcTemplate.query(sql, mapper);
    }

    /* 
    public long createServicio(Servicio newServicio) {
        String sql = "INSERT INTO servicio (fecha_ingreso, fecha_conclusion, descripcion, horas_invertidas, costo_total_mano_de_obra, costo_total_facturado, porcentaje_utilidad, vehiculo) " +
                "VALUES (:fecha_ingreso, :fecha_conclusion, :descripcion, :horas_invertidas, :costo_total_mano_de_obra, :costo_total_facturado, :porcentaje_utilidad, :vehiculo)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fecha_ingreso", newServicio.getFecha_ingreso());
        parameters.put("fecha_conclusion", newServicio.getFecha_conclusion());
        parameters.put("descripcion", newServicio.getDescripcion());
        parameters.put("horas_invertidas", newServicio.getHoras_invertidas());
        parameters.put("costo_total_mano_de_obra", newServicio.getCosto_total_mano_de_obra());
        parameters.put("costo_total_facturado", newServicio.getCosto_total_facturado());
        parameters.put("porcentaje_utilidad", newServicio.getPorcentaje_utilidad());
        parameters.put("vehiculo", newServicio.getVehiculo());

        return jdbcTemplate.update(sql, parameters);
    }*/

     public long createServicioInicial(Servicio newServicioInicial) {
        String sql = "INSERT INTO servicio (fecha_ingreso, descripcion, horas_invertidas,costo_total_mano_de_obra, vehiculo) " +
                "VALUES (:fecha_ingreso, :descripcion, :horas_invertidas, :costo_total_mano_de_obra, :vehiculo)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fecha_ingreso", newServicioInicial.getFecha_ingreso());
        parameters.put("descripcion", newServicioInicial.getDescripcion());
        parameters.put("horas_invertidas", newServicioInicial.getHoras_invertidas());
        parameters.put("costo_total_mano_de_obra", newServicioInicial.getCosto_total_mano_de_obra());
        parameters.put("vehiculo", newServicioInicial.getVehiculo());

        return jdbcTemplate.update(sql, parameters);
    }

    /*public long createCierreServicio(Servicio newServicioCierreServicio){
        String sql = "UPDATE SERVICIO " +
        "SET fecha_conclusion = :fecha_conclusion, " +
        "horas_invertidas = :horas_invertidas, " +
        "costo_total_mano_de_obra = :costo_total_mano_de_obra, " +
        "costo_total_facturado = :costo_total_facturado, " +
        "porcentaje_utilidad = :porcentaje_utilidad " +
        "WHERE id = :id";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fecha_conclusion", newServicioCierreServicio.getFecha_conclusion());
        parameters.put("horas_invertidas", newServicioCierreServicio.getHoras_invertidas());
        parameters.put("costo_total_mano_de_obra", newServicioCierreServicio.getCosto_total_mano_de_obra());
        parameters.put("costo_total_facturado", newServicioCierreServicio.getCosto_total_facturado());
        parameters.put("porcentaje_utilidad", newServicioCierreServicio.getPorcentaje_utilidad());

        return jdbcTemplate.update(sql, parameters);
    }
    */

    public long createCierreServicio(Servicio newServicioCierreServicio, long idServicio){
        String sql = "UPDATE SERVICIO " +
            "SET fecha_conclusion = :fecha_conclusion, " +
            "horas_invertidas = :horas_invertidas, " +
            "costo_total_mano_de_obra = :costo_total_mano_de_obra, " +
            "costo_total_facturado = :costo_total_facturado, " +
            "porcentaje_utilidad = :porcentaje_utilidad " +
            "WHERE id = :idServicio";  
    
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fecha_conclusion", newServicioCierreServicio.getFecha_conclusion());
        parameters.put("horas_invertidas", newServicioCierreServicio.getHoras_invertidas());
        parameters.put("costo_total_mano_de_obra", newServicioCierreServicio.getCosto_total_mano_de_obra());
        parameters.put("costo_total_facturado", newServicioCierreServicio.getCosto_total_facturado());
        parameters.put("porcentaje_utilidad", newServicioCierreServicio.getPorcentaje_utilidad());
        parameters.put("idServicio", idServicio);
    
        return jdbcTemplate.update(sql, parameters);
    }
    
    public Servicio getServicioById(long id) {
        String sql = "SELECT s.*, c.* FROM servicio s " +
                "JOIN vehiculo v ON s.vehiculo = v.id " +
                "JOIN cliente c ON v.cliente = c.id " +
                "WHERE s.id = :id";

        Map<String, Object> parameters = Collections.singletonMap("id", id);
        return jdbcTemplate.queryForObject(sql, parameters, new ServicioMapper());
    }

    public List<Servicio> getAllServicios() {
        String sql = "SELECT s.*, c.* FROM servicio s " +
                "JOIN vehiculo v ON s.vehiculo = v.id " +
                "JOIN cliente c ON v.cliente = c.id ";
        List<Servicio> servicioList = jdbcTemplate.query(sql, mapper);
        for(Servicio currentServicio: servicioList) {
            String sqlVehiculo = "select v.* from vehiculo v, servicio s where v.id = s.vehiculo";
            String sqlCliente = "select c.* from cliente c, vehiculo v where c.id = v.cliente";
            List<Vehiculo> vehiculoList = jdbcTemplate.query(sqlVehiculo, Vmapper);
            List<Cliente> clienteList = jdbcTemplate.query(sqlCliente, Cmapper);
            currentServicio.setVehiculoList(vehiculoList);
            currentServicio.setClienteList(clienteList);
        }
        return servicioList;
    }



    private static class ServicioMapper implements RowMapper<Servicio> {
        @Override
        public Servicio mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            Date fechaIngreso = sr.getDate("fecha_ingreso");
            Date fechaConclusion = sr.getDate("fecha_conclusion");
            String descripcion = sr.getNString("descripcion");
            int horasInvertidas = sr.getInt("horas_invertidas");
            int costoTotalManoDeObra = sr.getInt("costo_total_mano_de_obra");
            int costoTotalFacturado = sr.getInt("costo_total_facturado");
            int porcentajeUtilidad = sr.getInt("porcentaje_utilidad");
            int vehiculo = sr.getInt("vehiculo");
            return new Servicio(id, fechaIngreso, fechaConclusion, descripcion, horasInvertidas, costoTotalManoDeObra, costoTotalFacturado, porcentajeUtilidad, vehiculo);


        }
    }
}
