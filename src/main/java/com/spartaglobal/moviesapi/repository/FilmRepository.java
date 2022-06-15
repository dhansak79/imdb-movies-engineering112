package com.spartaglobal.moviesapi.repository;

import com.spartaglobal.moviesapi.dto.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

}
