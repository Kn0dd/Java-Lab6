package com.example.lab6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PaintApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaintApplication.class.getResource("paint-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 460);
        primaryStage.setTitle("Paint app");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
