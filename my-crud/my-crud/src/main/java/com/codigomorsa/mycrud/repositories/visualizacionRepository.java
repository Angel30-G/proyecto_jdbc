package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.visualizacion;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class visualizacionRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final VisualizacionMapper mapper = new VisualizacionMapper();


    //private final SimpleJdbcInsert insert;

    public visualizacionRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("visualizacion").usingGeneratedKeyColumns("id");
    }

    public List<visualizacion> getAllVisualizacion(){
        String sql = "select * from visualizacion";
        return jdbcTemplate.query(sql, mapper);
    }

    public long createVisualizacion(visualizacion newVisualizacion) {
        String sql = "INSERT INTO visualizacion (veces_vista, lugar, fecha, cine) " +
                "VALUES (:veces_vista, :lugar, :fecha, :cine)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("veces_vista", newVisualizacion.getVeces());
        parameters.put("lugar", newVisualizacion.getLugar());
        parameters.put("fecha", newVisualizacion.getFecha());
        parameters.put("cine", newVisualizacion.getCine());

        return jdbcTemplate.update(sql, parameters);
    }

    private static class VisualizacionMapper implements RowMapper<visualizacion> {
        @Override
        public visualizacion mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            int veces = sr.getInt("veces_vista");
            String lugar = sr.getNString("lugar");
            Date fecha = sr.getDate("fecha");
            int cine = sr.getInt("cine");


            return new visualizacion(id, veces, lugar, fecha, cine);


        }
    }
}
