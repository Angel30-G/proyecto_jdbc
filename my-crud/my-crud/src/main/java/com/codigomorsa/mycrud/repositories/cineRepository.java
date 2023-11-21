package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.cine;
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
public class cineRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final CineMapper mapper = new CineMapper();


    //private final SimpleJdbcInsert insert;

    public cineRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("cine").usingGeneratedKeyColumns("id");
    }

    public List<cine> getAllCine(){
        String sql = "select * from cine";
        return jdbcTemplate.query(sql, mapper);
    }

    public long createCine(cine newCine) {
        String sql = "INSERT INTO cine (nombre, ubicacion) VALUES (:nombre, :ubicacion)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre", newCine.getNombre());
        parameters.put("ubicacion", newCine.getUbicacion());

        return jdbcTemplate.update(sql, parameters);
    }

    private static class CineMapper implements RowMapper<cine> {
        @Override
        public cine mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            String nombre = sr.getNString("nombre");
            String ubicacion = sr.getNString("ubicacion");


            return new cine(id, nombre, ubicacion);


        }
    }
}
