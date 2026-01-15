package com.rose.bandle_portfolio.repository;

import com.rose.bandle_portfolio.model.Youtube;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YoutubeRepository extends JpaRepository<Youtube, Integer> {
    List<Youtube>findBySongSongId(Integer songId);
}
