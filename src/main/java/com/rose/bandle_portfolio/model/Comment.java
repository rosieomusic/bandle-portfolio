package com.rose.bandle_portfolio.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private String displayName;
    private String commentText;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;


    public void setSong(Song song) {
    }

    public void setCreatedAt(LocalDateTime now) {
    }
}
