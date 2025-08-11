package com.eibo.service;

import java.io.File;
import java.io.IOException;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import com.eibo.model.Playlist;
import com.eibo.model.Track;

public class PlaylistManager {

    private static final String SONGS_PATH = "src/main/resources/songs/";// TODO: Fix path resolution

    public Playlist getAllTracks() {

        File musicFolder = new File(SONGS_PATH);
        Playlist playlist = new Playlist("All Tracks");

        if (musicFolder.exists() && musicFolder.isDirectory()) {
            File[] files = musicFolder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().toLowerCase().endsWith(".mp3")) {
                        Track track = createTrack(file);
                        if (track != null) {
                            playlist.addTrack(track);
                        }
                    }

                }

            }

        }
        return playlist;

    }
    // TODO:M3U file loading
    // public Playlist getPlaylist(String name)

    public Track createTrack(File file) {
        try {
            Mp3File mp3File = new Mp3File(file);
            String soundFile = file.getPath();
            String title = null;
            String artistName = null;
            String albumTitle = null;
            long id = file.getAbsolutePath().hashCode();

            if (mp3File.hasId3v2Tag()) {
                ID3v2 tag = mp3File.getId3v2Tag();
                title = tag.getTitle();
                artistName = tag.getArtist();
                albumTitle = tag.getAlbum();

            } else if (mp3File.hasId3v1Tag()) {
                ID3v1 tag = mp3File.getId3v1Tag();
                title = tag.getTitle();
                artistName = tag.getArtist();
                albumTitle = tag.getAlbum();

            } else {
                // if no tags are present
                title = file.getName();
                artistName = "Unknown";
                albumTitle = "";
                id = file.hashCode();
            }

            // if metadata is missing
            if (title == null || title.isEmpty()) {
                title = file.getName();
            }
            if (artistName == null || artistName.isEmpty()) {
                artistName = "Unknown";
            }
            if (albumTitle == null) {
                albumTitle = "";
            }

            int length = (int) mp3File.getLengthInSeconds();

            return new Track(title, artistName, albumTitle, length, soundFile, id);

        } catch (UnsupportedTagException | InvalidDataException | IOException e) {
            System.out.println("Could not read MP3 file: " + file.getName());
            System.out.println("Reason: " + e.getMessage());
        }

        return null;
    }

}
