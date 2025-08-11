package com.eibo.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.HBox;

import javafx.stage.Stage;

import com.eibo.service.MP3Player;
import com.eibo.service.PlaylistManager;
import com.eibo.model.Playlist;

public class JavaFXApp extends Application {
    private MP3Player mp3Player;
    private PlaylistManager playlistManager;
    private Playlist playlist;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mp3Player = new MP3Player();
        playlistManager = new PlaylistManager();
        playlist = playlistManager.getAllTracks();
        mp3Player.setPlaylist(playlist);

        HBox hBoxRoot = new HBox();
        Button playButton = new Button("Play");
        playButton.setOnAction(event -> mp3Player.play());

        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(event -> mp3Player.pause());

        Button skipButton = new Button("Skip");
        skipButton.setOnAction(event -> mp3Player.skip());

        // Add buttons to layout
        hBoxRoot.getChildren().add(playButton);
        hBoxRoot.getChildren().add(pauseButton);
        hBoxRoot.getChildren().add(skipButton);

        Scene scene = new Scene(hBoxRoot, 600, 300);
        primaryStage.setTitle("EIBO MP3 Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
