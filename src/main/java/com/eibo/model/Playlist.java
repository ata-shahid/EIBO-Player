package com.eibo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Playlist {

    private String playlistName;
    private List<Track> tracks;
    private Date creationDate;

    public Playlist(String playlistName) {
        this.tracks = new ArrayList<>();
        this.playlistName = playlistName;
        this.creationDate = new Date();
    }

    public void addTrack(Track track) {

        tracks.add(track);
    }

    public int numberOfTracks() {

        return tracks.size();
    }

    public Track getTrack(int index) {
        if (index < 0 || index >= tracks.size()) {
            throw new IndexOutOfBoundsException("Track index out of bounds");
        }
        return tracks.get(index);
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public Date getCreationDate() {
        return creationDate;
    }

}