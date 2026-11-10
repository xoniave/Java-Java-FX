package com.example.projectbd.ANGGOTA;

import com.example.projectbd.CLASS.MahasiswaQuery;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


public class profileController {
    @FXML
    private VBox contentArea;
    @FXML
    private Label memberIdLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label addressLabel;

    MahasiswaQuery mhs = new MahasiswaQuery();

    @FXML
    public void initialize(String nrp) {

        setSemua(nrp);

        contentArea.setOpacity(0);
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1.5), contentArea);
        fadeIn.setToValue(1);
        fadeIn.play();
    }

    void setSemua(String nrp)
    {
        memberIdLabel.setText(nrp);
        nameLabel.setText(mhs.getNama(nrp));
        emailLabel.setText(mhs.getEmail(nrp));
        phoneLabel.setText(mhs.getPhone(nrp));
        addressLabel.setText(mhs.getAddress(nrp));
    }
}
