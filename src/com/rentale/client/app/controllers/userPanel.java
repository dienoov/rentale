package com.rentale.client.app.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.rentale.client.app.helpers.FXMLHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class userPanel implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void changePassword(ActionEvent event) {
        Scene scene = (Scene) ((Node)event.getSource()).getScene();
        JFXDrawer drawer = (JFXDrawer) scene.lookup("#drawer");

        AnchorPane changePassword = FXMLHelper.getView("change_password");
        drawer.setSidePane(changePassword);
    }

    @FXML
    public void logOut(ActionEvent event) throws Exception {
        Parent view = FXMLLoader.load(getClass().getResource("/com/rentale/client/resources/fxml/login.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.getScene().setRoot(view);
    }

}
