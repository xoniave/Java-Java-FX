package com.example.datamenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    ArrayList<Data_Menu> DataMenu = new ArrayList<>();

    @FXML
    private TableColumn<Data_Menu, String> tbC1;

    @FXML
    private TableColumn<Data_Menu, String> tbC2;

    @FXML
    private TableColumn<Data_Menu, Integer> tbC3;

    @FXML
    private TableColumn<Data_Menu, Integer> tbC4;

    @FXML
    private TableView<Data_Menu> tv;

    @FXML
    private RadioButton rbFood,rbDrink;

    @FXML
    private TextField txtNama,txtHarga,txtStock;

    @FXML
    private Button btnSimpan,btnClear,btnHapus,btnClearSession;

    @FXML
    public void initialize(URL location, ResourceBundle resources)
    {
        tbC1.setCellValueFactory(new PropertyValueFactory<Data_Menu,String>("jenis"));
        tbC2.setCellValueFactory(new PropertyValueFactory<Data_Menu,String>("nama"));
        tbC3.setCellValueFactory(new PropertyValueFactory<Data_Menu,Integer>("harga"));
        tbC4.setCellValueFactory(new PropertyValueFactory<Data_Menu,Integer>("stock"));
    }


    @FXML
    protected void onClear()
    {
        txtNama.setText("");
        txtHarga.setText("");
        txtStock.setText("");
    }

    @FXML
    protected void onSimpan()
    {
        String Nama = txtNama.getText();
        int HARGA = Integer.parseInt(txtHarga.getText());
        int STOCK = Integer.parseInt(txtStock.getText());
        String JENIS = "";

        if(rbFood.isSelected())
        {
            JENIS = "Food";
        }
        else if(rbDrink.isSelected())
        {
            JENIS = "Drink";
        }


        DataMenu.add(new Data_Menu(Nama,HARGA,STOCK,JENIS));
        refreshTableView();

    }

    @FXML
    public void refreshTableView()
    {
        ObservableList<Data_Menu> observe = FXCollections.observableArrayList(DataMenu);
        tv.setItems(observe);
    }



}