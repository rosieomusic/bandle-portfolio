package com.rose.bandle_portfolio.controller;

import com.rose.bandle_portfolio.model.Song;
import com.rose.bandle_portfolio.model.Youtube;
import com.rose.bandle_portfolio.repository.SongRepository;
import com.rose.bandle_portfolio.repository.YoutubeRepository;
import com.rose.bandle_portfolio.service.YoutubeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/songs/{songId}/youtube")
@CrossOrigin(origins = "http://localhost:3000")

public class YoutubeController {
    private final YoutubeService youtubeService;

    public YoutubeController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }

    @GetMapping
    public Youtube getYoutube(@PathVariable int songId){
        return youtubeService.getBySong(songId);
    }

    @PostMapping
    public Youtube addYoutube(@PathVariable int songId, @RequestBody Youtube youtube){
        return youtubeService.addYoutube(songId, youtube);
    }
}
