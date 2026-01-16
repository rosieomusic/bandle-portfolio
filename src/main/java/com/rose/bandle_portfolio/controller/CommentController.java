package com.rose.bandle_portfolio.controller;
import com.rose.bandle_portfolio.model.Comment;
import com.rose.bandle_portfolio.service.CommentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/songs/{songId}/comments")
@CrossOrigin(origins = "http://localhost:3000")

public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping
    public List<Comment>getComments(@PathVariable int songId){
        return commentService.getCommentBySongId(songId);
    }

    @PostMapping
    public Comment addComment(@PathVariable int songId, @RequestBody Comment comment){
        return commentService.addComment(songId, comment);
    }
}
