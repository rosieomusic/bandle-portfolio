package com.rose.bandle_portfolio.controller;

import com.rose.bandle_portfolio.model.Comment;
import com.rose.bandle_portfolio.model.Song;
import com.rose.bandle_portfolio.repository.CommentRepository;
import com.rose.bandle_portfolio.repository.SongRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/comment")

public class CommentController {
    private final CommentRepository commentRepository;
    private final SongRepository songRepository;

    public CommentController(CommentRepository commentRepository, SongRepository songRepository) {
        this.commentRepository = commentRepository;
        this.songRepository = songRepository;
    }

    @PostMapping("/songId")
    public Comment addComment(@PathVariable int songId, @RequestBody Comment comment){
        Song song = songRepository.findById(songId)
                .orElseThrow(()-> new RuntimeException("Song not found."));

        comment.setSong(song);
        comment.setCreatedAt(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    @GetMapping("/songId")
    public List<Comment> getComments(@PathVariable int songId){
        return commentRepository.findBySongSongIdOrderByCreatedAtDesc(songId);
    }
}
