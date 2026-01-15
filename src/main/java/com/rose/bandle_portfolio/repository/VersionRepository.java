package com.rose.bandle_portfolio.repository;

import com.rose.bandle_portfolio.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VersionRepository extends JpaRepository<Version, Integer> {
    List<Version> findBySongSongId(Integer songId);
}
