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
}
