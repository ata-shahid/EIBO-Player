package com.eibo;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Minimal JavaFX Application class as a starting point.
 * This is a bare-bones implementation that you can extend as needed.
 */
public class JavaFXApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO: Initialize your JavaFX GUI here
        primaryStage.setTitle("EIBO MP3 Player");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
