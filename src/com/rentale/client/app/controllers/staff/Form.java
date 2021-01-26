package com.rentale.client.app.controllers.staff;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Form implements Initializable {

    @FXML
    protected JFXButton backBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backBtn.setOnAction(event -> Home.backToMenu(event));
    }

}
