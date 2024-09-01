package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movie.entity.movieModel;
import org.springframework.stereotype.Repository;

@Repository
public interface movieRepository extends JpaRepository<movieModel, Integer> {

}
