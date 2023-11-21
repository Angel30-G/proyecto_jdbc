package com.codigomorsa.mycrud.repositories;

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
public class TallerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

   private final TallerMapper mapper = new TallerMapper();


    //private final SimpleJdbcInsert insert;

    public TallerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("celebridad").usingGeneratedKeyColumns("id");
    }

    public List<Taller> getAllTaller(){
        String sql = "select * from taller";
        return jdbcTemplate.query(sql, mapper);
    }

    public long createTaller(Taller newTaller) {
        String sql = "INSERT INTO taller (nombre, provincia, canton, distrito, otras_señas, costo_operacion, horas_de_trabajo, telefono, nombre_usuario, email, contraseña) VALUES (:nombre, :provincia, :canton, :distrito, :otras_senas, :costo_operacion, :horas_de_trabajo, :telefono, :nombre_usuario, :email, :contraseña)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre", newTaller.getNombre());
        parameters.put("provincia", newTaller.getProvincia());
        parameters.put("canton", newTaller.getCanton());
        parameters.put("distrito", newTaller.getDistrito());
        parameters.put("otras_señas", newTaller.getOtras_señas());
        parameters.put("costo_operacion", newTaller.getCosto_operacion());
        parameters.put("horas_de_trabajo", newTaller.getHoras_de_trabajo());
        parameters.put("telefono", newTaller.getTelefono());
        parameters.put("nombre_usuario", newTaller.getNombre_usuario());
        parameters.put("email", newTaller.getEmail());
        parameters.put("contraseña", newTaller.getContraseña());

        return jdbcTemplate.update(sql, parameters);
    }

    private static class TallerMapper implements RowMapper<Taller> {
        @Override
        public Taller mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            String nombre = sr.getNString("nombre");
            String provincia = sr.getNString("provincia");
            String canton = sr.getNString("canton");
            String distrito = sr.getNString("distrito");
            String otrasSeñas = sr.getNString("otras_señas");
            int costoOperacion = sr.getInt("costo_operacion");
            int horasDeTrabajo = sr.getInt("horas_de_trabajo");
            int telefono = sr.getInt("telefono");
            String nombreUsuario = sr.getNString("nombre_usuario");
            String email = sr.getNString("email");
            String contraseña = sr.getNString("contraseña");
            return new Taller(id, nombre, provincia, canton, distrito, otrasSeñas, costoOperacion, horasDeTrabajo, telefono, nombreUsuario, email, contraseña);


        }
    }
}
