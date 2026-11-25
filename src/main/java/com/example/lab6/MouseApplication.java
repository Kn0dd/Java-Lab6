package com.example.lab6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MouseApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MouseApplication.class.getResource("mouse-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 460);
        stage.setTitle("Mouse app!");
        stage.setScene(scene);
        stage.show();
    }
}