package com.rose.bandle_portfolio.repository;

import com.rose.bandle_portfolio.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song>findByTitleIgnoreCase(String title);
    List<Song>findByArtistIgnoreCase(String artist);
}
