package com.rose.bandle_portfolio.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "song")

public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;

    private String title;
    private String artist;

    @OneToMany(mappedBy =  "song", cascade = CascadeType.ALL)
    private List<Version> versions;

    @OneToMany(mappedBy =  "song", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy =  "song", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToOne(mappedBy =  "song", cascade = CascadeType.ALL)
    private Youtube youtube;

    public int getSongId() { return songId; }
    public void setSongId(int songId) { this.songId = songId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

}
