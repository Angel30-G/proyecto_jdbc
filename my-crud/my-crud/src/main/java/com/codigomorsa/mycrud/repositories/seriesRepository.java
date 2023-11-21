package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.series;
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
public class seriesRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final SeriesMapper mapper = new seriesRepository.SeriesMapper();

    //private final SimpleJdbcInsert insert;

    public seriesRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<series> getAllSeries(){
        String sql = "select * from series";
        return jdbcTemplate.query(sql, mapper);
    }

    public long createSeries(series newSeries) {
        String sql = "INSERT INTO series (titulo, episodios, temporadas, calificacion, genero, sinopsis, visto, celebridad) " +
                "VALUES (:titulo, :episodios, :temporadas, :calificacion, :genero, :sinopsis, :visto, :celebridad)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("titulo", newSeries.getTitulo());
        parameters.put("episodios", newSeries.getEpisodios());
        parameters.put("temporadas", newSeries.getTemporadas());
        parameters.put("calificacion", newSeries.getCalificacion());
        parameters.put("genero", newSeries.getGenero());
        parameters.put("sinopsis", newSeries.getSinopsis());
        parameters.put("visto", newSeries.getVisto());
        parameters.put("celebridad", newSeries.getCelebridad());

        return jdbcTemplate.update(sql, parameters);
    }

    private static class SeriesMapper implements RowMapper<series> {
        @Override
        public series mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            String titulo = sr.getNString("titulo");
            int episodios = sr.getInt("episodios");
            int temporadas = sr.getInt("temporadas");
            int calificacion = sr.getInt("calificacion");
            String genero = sr.getNString("genero");
            String sinopsis = sr.getNString("sinopsis");
            String visto = sr.getNString("visto");
            int celebridad = sr.getInt("celebridad");

            return new series(id, titulo, episodios, temporadas, calificacion, genero, sinopsis, visto, celebridad);


        }
    }
}
