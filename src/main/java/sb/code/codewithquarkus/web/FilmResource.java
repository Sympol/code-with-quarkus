package sb.code.codewithquarkus.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sb.code.codewithquarkus.model.Film;
import sb.code.codewithquarkus.repository.FilmRepository;

import java.util.Optional;

@Path("/")
public class FilmResource {

    @Inject
    FilmRepository repository;

    @GET
    @Path("/films/{filmId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film getFilm(short filmId){
        Optional<Film> film = repository.getFilm(filmId);
        return film.orElseThrow();
    }
}
