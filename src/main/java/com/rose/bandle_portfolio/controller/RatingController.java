package com.rose.bandle_portfolio.controller;

import com.rose.bandle_portfolio.model.Rating;
import com.rose.bandle_portfolio.model.Song;
import com.rose.bandle_portfolio.repository.RatingRepository;
import com.rose.bandle_portfolio.repository.SongRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rating")

public class RatingController {
    private final RatingRepository ratingRepository;
    private final SongRepository songRepository;

    public RatingController(RatingRepository ratingRepository, SongRepository songRepository) {
        this.ratingRepository = ratingRepository;
        this.songRepository = songRepository;
    }

    @PostMapping("/songId")
    public Rating addRating(@PathVariable int songId, @RequestBody Rating rating){
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found."));

        rating.setSong(song);

        return ratingRepository.save(rating);
    }
}
