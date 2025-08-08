package controller;

import de.hsrm.mi.prog.util.StaticScanner;
import player.MP3Player;

public class KeyboardController {

    private static final String SONGS_PATH = "src/main/resources/songs/";
    private static final String MP3_EXTENSION = ".mp3";

    private MP3Player mp3Player = new MP3Player();
    private String input;

    public void start() {
        while (true) {
            System.out.println("Enter the command: ");
            input = StaticScanner.nextString();

            String command;
            String parameter = null;

            if (input.contains(" ")) {
                int firstSpace = input.indexOf(' ');
                command = input.substring(0, firstSpace);
                parameter = input.substring(firstSpace + 1);
            } else {
                command = input;
            }

            switch (command) {
                case "play":
                    if (parameter != null && !parameter.isEmpty()) {
                        mp3Player.play(SONGS_PATH + parameter + MP3_EXTENSION);
                    } else {
                        mp3Player.play();
                    }
                    break;
                case "pause":
                    mp3Player.pause();
                    break;
                case "volume":
                    if (parameter != null && !parameter.isEmpty()) {
                        try {
                            float value = Float.parseFloat(parameter);
                            mp3Player.volume(value);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid volume value. Please enter a number between 0.0 and 1.0");
                        }
                    } else {
                        System.out.println("Volume command requires a value (e.g., volume 0.5)");
                    }
                    break;
                case "quit":
                    mp3Player.pause();
                    System.out.println("Goodbye!");

                    return;
                default:
                    System.out.println("Unknown command: " + command);
                    System.out.println("Available commands: play [filename], play, pause, volume [0.0-1.0], quit");
                    break;
            }
        }
    }
}
