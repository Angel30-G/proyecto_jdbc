package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.Pieza;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PiezaRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final PiezaMapper mapper = new PiezaMapper();


    //private final SimpleJdbcInsert insert;

    public PiezaRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("visualizacion").usingGeneratedKeyColumns("id");
    }

    public List<Pieza> getAllPiezas(){
        String sql = "select * from pieza";
        return jdbcTemplate.query(sql, mapper);
    }

    public long createPieza(Pieza newPieza) {
        String sql = "INSERT INTO pieza (codigo, descripcion, costo) " +
                "VALUES (:codigo, :descripcion, :costo)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("codigo", newPieza.getCodigo());
        parameters.put("descripcion", newPieza.getDescripcion());
        parameters.put("costo", newPieza.getCosto());

        return jdbcTemplate.update(sql, parameters);
    }


    private static class PiezaMapper implements RowMapper<Pieza> {
        @Override
        public Pieza mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            String codigo = sr.getString("codigo");
            String descripcion = sr.getNString("descripcion");
            int costo = sr.getInt("costo");


            return new Pieza(id, codigo, descripcion, costo);


        }
    }
}
