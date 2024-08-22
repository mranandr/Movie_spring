package com.movie.repository;

import com.movie.entity.movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface movieRepo extends JpaRepository<movie, Integer> {

}
