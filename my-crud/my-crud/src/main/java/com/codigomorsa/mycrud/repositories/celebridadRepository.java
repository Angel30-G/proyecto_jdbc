package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.celebridad;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class celebridadRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

   private final CelebridadMapper mapper = new CelebridadMapper();


    //private final SimpleJdbcInsert insert;

    public celebridadRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("celebridad").usingGeneratedKeyColumns("id");
    }

    public List<celebridad> getAllCelebridades(){
        String sql = "select * from celebridad";
        return jdbcTemplate.query(sql, mapper);
    }

    public long createCelebridad(celebridad newCelebridad) {
        String sql = "INSERT INTO celebridad (nombre, rol) VALUES (:nombre, :rol)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre", newCelebridad.getNombre());
        parameters.put("rol", newCelebridad.getRol());

        return jdbcTemplate.update(sql, parameters);
    }

    private static class CelebridadMapper implements RowMapper<celebridad> {
        @Override
        public celebridad mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            String nombre = sr.getNString("nombre");
            String rol = sr.getNString("rol");


            return new celebridad(id, nombre, rol);


        }
    }
}
