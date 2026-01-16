package com.rose.bandle_portfolio.service;

import com.rose.bandle_portfolio.model.Comment;
import com.rose.bandle_portfolio.model.Song;
import com.rose.bandle_portfolio.repository.CommentRepository;
import com.rose.bandle_portfolio.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final SongRepository songRepository;

    public CommentService(CommentRepository commentRepository, SongRepository songRepository) {
        this.commentRepository = commentRepository;
        this.songRepository = songRepository;
    }

    public List<Comment> getCommentBySongId(int songId){
        return commentRepository.findCommentBySongSongId(songId);
    }
    public Comment addComment(int songId, Comment comment){
        Song song = songRepository.findById(songId)
                .orElseThrow(()-> new RuntimeException("Song not found."));
        return commentRepository.save(comment);
    }
}
