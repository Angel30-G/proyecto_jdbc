package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.Servicio;
import com.codigomorsa.mycrud.model.Taller;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ServicioRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final ServicioRepository.ServicioMapper mapper = new ServicioRepository.ServicioMapper();


    //private final SimpleJdbcInsert insert;

    public ServicioRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("celebridad").usingGeneratedKeyColumns("id");
    }

    public List<Servicio> getAllServicio(){
        String sql = "select * from servicio";
        return jdbcTemplate.query(sql, mapper);
    }

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
    }

    private static class ServicioMapper implements RowMapper<Servicio> {
        @Override
        public Servicio mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            Date fechaIngreso = sr.getDate("nombre");
            Date fechaConclusion = sr.getDate("provincia");
            String descripcion = sr.getNString("canton");
            int horasInvertidas = sr.getInt("distrito");
            int costoTotalManoDeObra = sr.getInt("otras_señas");
            int costoTotalFacturado = sr.getInt("costo_operacion");
            int porcentajeUtilidad = sr.getInt("horas_de_trabajo");
            int vehiculo = sr.getInt("telefono");
            return new Servicio(id, fechaIngreso, fechaConclusion, descripcion, horasInvertidas, costoTotalManoDeObra, costoTotalFacturado, porcentajeUtilidad, vehiculo);


        }
    }
}
