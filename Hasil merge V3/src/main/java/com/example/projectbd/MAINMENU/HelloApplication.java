package com.example.projectbd.MAINMENU;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppins-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppins-Medium.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppins-Bold.ttf"), 10);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/projectbd/splash-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}