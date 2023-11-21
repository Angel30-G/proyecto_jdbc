package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.Piezas_Compradas;
import com.codigomorsa.mycrud.model.Taller;
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
public class PiezasCompradasRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final PiezasCompradasRepository.PiezasCompradasMapper mapper = new PiezasCompradasRepository.PiezasCompradasMapper();


    //private final SimpleJdbcInsert insert;

    public PiezasCompradasRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("celebridad").usingGeneratedKeyColumns("id");
    }

    public List<Piezas_Compradas> getAllPiezasCompradas(){
        String sql = "select * from piezas_compradas";
        return jdbcTemplate.query(sql, mapper);
    }

    public long createPiezasCompradas(Piezas_Compradas newPiezasCompradas) {
        String sql = "INSERT INTO piezas_compradas (codigo, cantidad, costo_total, pieza, servicio) " +
                "VALUES (:codigo, :cantidad, :costo_total, :pieza, :servicio)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("codigo", newPiezasCompradas.getCodigo());
        parameters.put("cantidad", newPiezasCompradas.getCantidad());
        parameters.put("costo_total", newPiezasCompradas.getCosto_total());
        parameters.put("pieza", newPiezasCompradas.getPieza());
        parameters.put("servicio", newPiezasCompradas.getServicio());

        return jdbcTemplate.update(sql, parameters);
    }

    private static class PiezasCompradasMapper implements RowMapper<Piezas_Compradas> {
        @Override
        public Piezas_Compradas mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            String codigo = sr.getNString("codigo");
            int cantidad = sr.getInt("cantidad");
            int costoTotal = sr.getInt("costoTotal");
            int pieza = sr.getInt("pieza");
            int servicio = sr.getInt("servicio");
            return new Piezas_Compradas(id, codigo, cantidad, costoTotal, pieza, servicio);


        }
    }
}
