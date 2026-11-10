package com.example.projectbd.MAINMENU;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashController implements Initializable {

    @FXML
    private ImageView logoImageView;

    @FXML
    private StackPane splashPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logoImageView.setOpacity(0);
        logoImageView.setScaleX(1.5);
        logoImageView.setScaleY(1.5);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), logoImageView);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1.0);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), logoImageView);
        scaleTransition.setFromX(0.5);
        scaleTransition.setFromY(0.5);
        scaleTransition.setToX(2.0);
        scaleTransition.setToY(2.0);

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, scaleTransition);

        parallelTransition.setOnFinished(event -> {
            loadLoginScreen();
        });

        parallelTransition.play();
    }

    private void loadLoginScreen() {
        try {
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/com/example/projectbd/login.fxml"));
            splashPane.getScene().setRoot(loginRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}