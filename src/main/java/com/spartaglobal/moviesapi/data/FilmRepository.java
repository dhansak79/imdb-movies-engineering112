package com.spartaglobal.moviesapi.data;

import com.spartaglobal.moviesapi.model.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

}
