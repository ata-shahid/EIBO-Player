package player;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;

public class MP3Player {
    private SimpleMinim minim;
    private SimpleAudioPlayer audioPlayer;

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
        if (audioPlayer != null && !audioPlayer.isPlaying())
            audioPlayer.play();
    }

    public void pause() {
        if (audioPlayer != null && audioPlayer.isPlaying())
            audioPlayer.pause();
    }

    public void volume(float value) {

        float dbValue = (value - 1.0f) * 40;
        if (audioPlayer != null)
            audioPlayer.setGain(dbValue);

    }
}
