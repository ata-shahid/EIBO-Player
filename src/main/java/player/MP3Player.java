package player;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;
import entities.Playlist;
import entities.Track;

public class MP3Player {
    private SimpleMinim minim;
    private SimpleAudioPlayer audioPlayer;
    private Playlist aktPlaylist;
    private int aktTrackNr = 0;
    private String loadedSoundFile;

    public MP3Player() {
        this.minim = new SimpleMinim(true);
    }

    public void play(String fileName) {
        if (audioPlayer != null && audioPlayer.isPlaying())

            pause();

        audioPlayer = minim.loadMP3File(fileName);
        audioPlayer.play();

    }

    public void play() {
        if (aktPlaylist != null) {
            if (audioPlayer != null && audioPlayer.isPlaying()) {
                pause();
            }

            Track aktTrack = aktPlaylist.getTrack(aktTrackNr);
            String soundFile = aktTrack.getSoundFile();
            if (loadedSoundFile == null || !loadedSoundFile.equalsIgnoreCase(soundFile)) {
                audioPlayer = minim.loadMP3File(soundFile);
                loadedSoundFile = soundFile;
            }

            audioPlayer.play();

        }

    }

    public void pause() {
        if (audioPlayer != null && audioPlayer.isPlaying())
            audioPlayer.pause();
    }

    public void volume(float value) {
        if (value < 0.0f || value > 1.0f) {
            System.out.println("Volume must be between 0.0 and 1.0. Provided: " + value);
            return;
        }

        float dbValue = (value - 1.0f) * 40;
        if (audioPlayer != null)
            audioPlayer.setGain(dbValue);

    }

    // load a playlist
    public void setPlaylist(Playlist aktPlaylist) {
        this.aktPlaylist = aktPlaylist;
    }

    // Skip to next song
    public void skip() {
        if (aktPlaylist != null) {
            int lastIndex = aktPlaylist.numberOfTracks() - 1;
            if (aktTrackNr < lastIndex) {
                aktTrackNr += 1;
            }
            play();

        }
    }

    // Go back to previous song
    public void skipBack() {
        if (aktPlaylist != null) {

            if (aktTrackNr > 0) {
                aktTrackNr -= 1;
            }
            play();

        }
    }
    // TODO: Add shuffle method

    // TODO: Add repeat method

}
