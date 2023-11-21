package com.codigomorsa.mycrud.repositories;


import com.codigomorsa.mycrud.model.pelicula;
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
public class peliculaRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final PeliculasMapper mapper = new PeliculasMapper();

    //private final SimpleJdbcInsert insert;

    public peliculaRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("peliculas").usingGeneratedKeyColumns("id");
    }

    public List<pelicula> getAllPeliculas(){
        String sql = "select * from peliculas";
        return jdbcTemplate.query(sql, mapper);
    }

    public long createPelicula(pelicula newPelicula) {
        String sql = "INSERT INTO peliculas (titulo, sinopsis, visto, genero, nota, visualizacion, celebridad) " +
                "VALUES (:titulo, :sinopsis, :visto, :genero, :nota, :visualizacion, :celebridad)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("titulo", newPelicula.getTitulo());
        parameters.put("sinopsis", newPelicula.getSinopsis());
        parameters.put("visto", newPelicula.getVisto());
        parameters.put("genero", newPelicula.getGenero());
        parameters.put("nota", newPelicula.getNota());
        parameters.put("visualizacion", newPelicula.getVisualizacion());
        parameters.put("celebridad", newPelicula.getCelebridad());

        return jdbcTemplate.update(sql, parameters);
    }

    private static class PeliculasMapper implements RowMapper<pelicula> {
        @Override
        public pelicula mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            String titulo = sr.getNString("titulo");
            String sinopsis = sr.getNString("sinopsis");
            String visto = sr.getNString("visto");
            String genero = sr.getNString("genero");
            int nota = sr.getInt("nota");
            int visualizacion = sr.getInt("visualizacion");
            int celebridad = sr.getInt("celebridad");

            return new pelicula(id, titulo, sinopsis, visto, genero, nota, visualizacion, celebridad);


        }
    }
}
