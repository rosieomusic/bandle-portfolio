package com.rose.bandle_portfolio.controller;

import com.rose.bandle_portfolio.model.Song;
import com.rose.bandle_portfolio.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/songs")
@CrossOrigin(origins = "http://localhost:3000" )

public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getAllSongs(){
        return songService.getAllSongs();

    }

    @GetMapping("/id")
    public Song getSong(@PathVariable int id){
        return songService.getSongById(id);
    }

    @GetMapping("/search/title")
    public List<Song> searchTitle(@RequestParam String query){
        return songService.searchByTitle(query);
    }

    @GetMapping("/search/artist")
    public List<Song> searchArtist(@RequestParam String query){
        return songService.searchByArtist(query);
    }
}
