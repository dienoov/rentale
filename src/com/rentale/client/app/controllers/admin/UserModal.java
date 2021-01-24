package com.rentale.client.app.controllers.admin;

import javafx.fxml.FXML;
import javafx.scene.shape.SVGPath;

import java.net.URL;
import java.util.ResourceBundle;

public class UserModal extends User {

    @FXML
    protected SVGPath closeModalBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        closeModalBtn.setOnMouseClicked(mouseEvent -> closeModal(mouseEvent));
    }

}
