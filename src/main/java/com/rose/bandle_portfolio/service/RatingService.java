package com.rose.bandle_portfolio.service;

import com.rose.bandle_portfolio.model.Rating;
import com.rose.bandle_portfolio.model.Song;
import com.rose.bandle_portfolio.repository.RatingRepository;
import com.rose.bandle_portfolio.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final SongRepository songRepository;

    public RatingService(RatingRepository ratingRepository, SongRepository songRepository) {
        this.ratingRepository = ratingRepository;
        this.songRepository = songRepository;
    }

    public List<Rating> getRatingBySongId(int songId){
        return ratingRepository.findBySongSongId(songId);
    }

    public Rating addRating(int songId, Rating rating){
        Song song = songRepository.findById(songId)
                .orElseThrow(()-> new RuntimeException("Song not found."));
        rating.setSong(song);
        return ratingRepository.save(rating);
    }

    public double getAverageRating(int songId){
        return ratingRepository.findBySongSongId(songId)
                .stream()
                .mapToInt(Rating::getRating)
                .average()
                .orElse(0.0);

    }
}
