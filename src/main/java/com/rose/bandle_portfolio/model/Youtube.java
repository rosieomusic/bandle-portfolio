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

    public Integer getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(Integer youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
