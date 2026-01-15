package com.rose.bandle_portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "youtube")

public class Youtube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer youtubeId;

    private String link;

    @OneToOne
    @JoinColumn(name = "song_id")
    private Song song;

    public void setSong(Song song) {
    }
}
