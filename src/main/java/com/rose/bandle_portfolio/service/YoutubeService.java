package com.rose.bandle_portfolio.service;

import com.rose.bandle_portfolio.model.Song;
import com.rose.bandle_portfolio.model.Youtube;
import com.rose.bandle_portfolio.repository.SongRepository;
import com.rose.bandle_portfolio.repository.YoutubeRepository;
import org.springframework.stereotype.Service;

@Service
public class YoutubeService {
    private final YoutubeRepository youtubeRepository;
    private final SongRepository songRepository;

    public YoutubeService(YoutubeRepository youtubeRepository, SongRepository songRepository) {
        this.youtubeRepository = youtubeRepository;
        this.songRepository = songRepository;
    }

    public Youtube getBySong(int songId){
        return youtubeRepository.findBySongSongId(songId).orElseThrow(()-> new RuntimeException("Song is not found."));

    }
    public Youtube addYoutube(int songId, Youtube youtube){
        Song song = songRepository.findById(songId)
                .orElseThrow(()-> new RuntimeException("Song not found."));
        if(youtubeRepository.findBySongSongId(songId).isPresent()){
            throw new RuntimeException("Song already has a youtube link.");
        }
        youtube.setSong(song);
        return youtubeRepository.save(youtube);
    }
}
