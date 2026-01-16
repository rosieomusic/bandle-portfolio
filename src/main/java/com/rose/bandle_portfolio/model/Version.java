package com.rose.bandle_portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "version")

public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer versionId;

    private String filePath;
    private String versionType;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    public int getVersionId() {return versionId;}
    public void setVersionId(int versionId) {this.versionId = versionId;}

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getVersionType() {
        return versionType;
    }

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
