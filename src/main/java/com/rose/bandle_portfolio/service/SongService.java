package com.rose.bandle_portfolio.service;

import com.rose.bandle_portfolio.model.Song;
import com.rose.bandle_portfolio.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    public Song getSongById(int id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found."));
    }

    public List<Song>searchByTitle(String title){
        return songRepository.findByTitleIgnoreCase(title);
    }

    public List<Song>searchByArtist(String artist){
        return songRepository.findByArtistIgnoreCase(artist);
    }
}
