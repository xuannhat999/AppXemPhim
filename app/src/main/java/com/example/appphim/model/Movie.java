package com.example.appphim.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String title;
    private String year;
    private String overview;
    private int posterResId;
    private String youtubeTrailerId;  // ID trailer YouTube
    private String videoUrl;           // URL video MP4 (xem trong app)

    // Constructor có videoUrl
    public Movie(int id, String title, String year, String overview, int posterResId, String youtubeTrailerId, String videoUrl) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.overview = overview;
        this.posterResId = posterResId;
        this.youtubeTrailerId = youtubeTrailerId;
        this.videoUrl = videoUrl;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getYear() { return year; }
    public String getOverview() { return overview; }
    public int getPosterResId() { return posterResId; }
    public String getYoutubeTrailerId() { return youtubeTrailerId; }
    public String getVideoUrl() { return videoUrl; }
}