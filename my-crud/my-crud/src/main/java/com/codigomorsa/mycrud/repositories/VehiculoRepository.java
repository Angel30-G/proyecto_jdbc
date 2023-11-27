package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.Cliente;
import com.codigomorsa.mycrud.model.Vehiculo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class VehiculoRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final VehiculoMapper mapper = new VehiculoMapper();

    private final RowMapper<Cliente> Cmapper = new VehiculoRepository.ClienteMapper();


    //private final SimpleJdbcInsert insert;

    public VehiculoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("celebridad").usingGeneratedKeyColumns("id");
    }

    public List<Vehiculo> getAllVehiculo(){
        String sql = "select * from vehiculo";
        return jdbcTemplate.query(sql, mapper);
    }


    public long createVehiculo(Vehiculo newVehiculo) {
        String sql = "INSERT INTO vehiculo (numero_placa, marca, modelo, año_fabricacion, VIN, cliente) " +
                "VALUES (:numeroPlaca, :marca, :modelo, :año_fabricacion, :VIN, :cliente)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("numeroPlaca", newVehiculo.getNumero_placa());
        parameters.put("marca", newVehiculo.getMarca());
        parameters.put("modelo", newVehiculo.getModelo());
        parameters.put("año_fabricacion", newVehiculo.getAnofabricacion());
        parameters.put("VIN", newVehiculo.getVIN());
        parameters.put("cliente", newVehiculo.getCliente());

        return jdbcTemplate.update(sql, parameters);
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

    public long createVehiculoPlaca(Vehiculo newVehiculo) {
        String sql = "INSERT INTO vehiculo (numero_placa) " +
                "VALUES (:numeroPlaca)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("numeroPlaca", newVehiculo.getNumero_placa());

        return jdbcTemplate.update(sql, parameters);
    }


    public Vehiculo getVehiculoByPlaca(String placa) {
        String sql = "SELECT c.*, v.* FROM cliente c " +
                "JOIN vehiculo v ON v.cliente = c.id " +
                "WHERE v.numero_placa = :placa";

        Map<String, Object> parameters = Collections.singletonMap("placa", placa);
        Vehiculo vehiculo = jdbcTemplate.queryForObject(sql, parameters, new VehiculoMapper());

        // Obtener la información del cliente relacionado
        String sqlCliente = "SELECT c.* FROM cliente c WHERE c.id = :clienteId";
        Map<String, Object> clienteParameters = Collections.singletonMap("clienteId", vehiculo.getCliente());
        Cliente cliente = jdbcTemplate.queryForObject(sqlCliente, clienteParameters, Cmapper);

        // Configurar la lista de clientes en el vehículo
        vehiculo.setClienteList(Collections.singletonList(cliente));  // Corregir aquí

        return vehiculo;
    }
}
