package com.spartaglobal.moviesapi.data;

import com.spartaglobal.moviesapi.model.Film;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

  @Query(value = "SELECT * FROM films WHERE title LIKE :title%", nativeQuery = true)
  List<Film> searchTitleUsingBeginningLetter(@Param( "title")String title);


}
