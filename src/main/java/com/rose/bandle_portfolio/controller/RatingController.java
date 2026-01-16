package com.rose.bandle_portfolio.controller;
import com.rose.bandle_portfolio.model.Rating;
import com.rose.bandle_portfolio.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/songs/{songId}/ratings")
@CrossOrigin(origins = "http://localhost:3000")

public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<Rating> getRatings(@PathVariable int songId){
        return ratingService.getRatingBySongId(songId);
    }

    @PostMapping
    public Rating addRating(@PathVariable int songId, @RequestBody Rating rating){
        return ratingService.addRating(songId, rating);
    }

    @GetMapping("/average")
    public double getAverage(@PathVariable int songId){
        return ratingService.getAverageRating(songId);
    }
}
