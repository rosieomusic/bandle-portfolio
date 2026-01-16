package com.rose.bandle_portfolio.controller;

import com.rose.bandle_portfolio.model.Version;
import com.rose.bandle_portfolio.service.VersionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/songs/{songId}/versions")
@CrossOrigin(origins = "http://localhost:3000")
public class VersionController {
    private final VersionService versionService;

    public VersionController(VersionService versionService) {
        this.versionService = versionService;
    }

    @GetMapping
    public List<Version> getAllVersions(@PathVariable int songId){
        return versionService.getVersionsBySongId(songId);
    }

    @PostMapping
    public Version addVersion(@PathVariable int songId, @RequestBody Version version){
        return versionService.addVersion(songId, version);
    }
}
