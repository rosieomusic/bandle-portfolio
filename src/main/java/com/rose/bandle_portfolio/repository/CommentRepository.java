package com.rose.bandle_portfolio.repository;

import com.rose.bandle_portfolio.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment>findBySongSongIdOrderByCreatedAtDesc(Integer songId);
}
