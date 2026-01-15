package com.rose.bandle_portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rating")

public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;

    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;


    public void setSong(Song song) {
    }
}
