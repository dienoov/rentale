package com.rentale.client.app.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.rentale.client.app.helpers.FXMLHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangePassword implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void backToUserMenu(ActionEvent event) {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        JFXDrawer drawer = (JFXDrawer) scene.lookup("#drawer");

        AnchorPane changePassword = FXMLHelper.getView("user_panel");
        drawer.setSidePane(changePassword);
    }

}
