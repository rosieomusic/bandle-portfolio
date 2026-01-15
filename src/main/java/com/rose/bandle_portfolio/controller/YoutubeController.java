package com.rose.bandle_portfolio.controller;

import com.rose.bandle_portfolio.model.Song;
import com.rose.bandle_portfolio.model.Youtube;
import com.rose.bandle_portfolio.repository.SongRepository;
import com.rose.bandle_portfolio.repository.YoutubeRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/youtube")

public class YoutubeController {
    private final YoutubeRepository youtubeRepository;
    private final SongRepository songRepository;

    public YoutubeController(YoutubeRepository youtubeRepository, SongRepository songRepository) {
        this.youtubeRepository = youtubeRepository;
        this.songRepository = songRepository;
    }

    @PostMapping("/{songId}")
    public Youtube addYoutube(@PathVariable int songId, @RequestBody Youtube youtube) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        youtube.setSong(song);
        return youtubeRepository.save(youtube);
    }

    @GetMapping("/{songId}")
    public Youtube getYoutube(@PathVariable int songId) {
        return (Youtube) youtubeRepository.findBySongSongId(songId);

    }


}
