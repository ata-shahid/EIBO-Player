package com.eibo.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.getChildren().add(new Label("EIBO MP3 Player - JavaFX Version"));

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("EIBO MP3 Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
