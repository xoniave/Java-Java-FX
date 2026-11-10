package com.example.datamenu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Pola {
    @FXML
    private RadioButton rbSegitiga,rbKotak,rbX,rbDiamond,rbIkan;

    @FXML
    private Button btnPrint;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtField;

    @FXML
    public void onPrint()
    {
        if(rbSegitiga.isSelected())
        {

        }
        else if(rbKotak.isSelected())
        {

        }
        else if(rbX.isSelected())
        {

        }
        else if(rbDiamond.isSelected())
        {

        }
        else if(rbIkan.isSelected())
        {
            
        }
    }
}
