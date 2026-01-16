package com.rose.bandle_portfolio.service;

import com.rose.bandle_portfolio.model.Song;
import com.rose.bandle_portfolio.model.Version;
import com.rose.bandle_portfolio.repository.SongRepository;
import com.rose.bandle_portfolio.repository.VersionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionService {
    private final VersionRepository versionRepository;
    private final SongRepository songRepository;

    public VersionService(VersionRepository versionRepository, SongRepository songRepository) {
        this.versionRepository = versionRepository;
        this.songRepository = songRepository;
    }
    public List<Version> getVersionsBySongId(int songId){
        return versionRepository.findBySongSongId(songId);
    }
    public Version addVersion(int songId, Version version){
        Song song = songRepository.findById(songId)
                .orElseThrow(()-> new RuntimeException("Song not found."));
        version.setSong(song);
        return versionRepository.save(version);
    }
}
