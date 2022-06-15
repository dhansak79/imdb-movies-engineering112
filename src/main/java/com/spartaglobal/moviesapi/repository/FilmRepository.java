package com.spartaglobal.moviesapi.repository;

import com.spartaglobal.moviesapi.dto.FilmDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<FilmDto, Long> {

}
