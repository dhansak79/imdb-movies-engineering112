package com.spartaglobal.moviesapi.repository;

import com.spartaglobal.moviesapi.dto.FilmDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmDto, Long> {

}
