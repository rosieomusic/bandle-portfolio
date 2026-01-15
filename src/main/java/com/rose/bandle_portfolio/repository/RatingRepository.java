package com.rose.bandle_portfolio.repository;

import com.rose.bandle_portfolio.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findBySongSongId(Integer songId);
}
