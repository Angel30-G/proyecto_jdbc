package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.Cliente;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final ClienteMapper mapper = new ClienteMapper();

    //private final SimpleJdbcInsert insert;

    public ClienteRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Cliente> getAllClientes(){
        String sql = "select * from cliente";
        return jdbcTemplate.query(sql, mapper);
    }

    public long createCliente(Cliente newCliente) {
        String sql = "INSERT INTO cliente (numero_cliente, cedula, tipo_cedula, telefono, email, taller) " +
                "VALUES (:numeroCliente, :cedula, :tipoCedula, :telefono, :email, :taller)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("numeroCliente", newCliente.getNumero_cliente());
        parameters.put("cedula", newCliente.getCedula());
        parameters.put("tipoCedula", newCliente.getTipo_cedula());
        parameters.put("telefono", newCliente.getTelefono());
        parameters.put("email", newCliente.getEmail());
        parameters.put("taller", newCliente.getTaller());

        return jdbcTemplate.update(sql, parameters);
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
}
