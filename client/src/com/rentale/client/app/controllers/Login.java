package com.rentale.client.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    public void routeRegister(MouseEvent event) throws Exception{
        Parent view = FXMLLoader.load(getClass().getResource("/com/rentale/client/resources/fxml/register.fxml"));

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setMaximized(false);
        window.setScene(new Scene(view));
        window.show();
    }

    @FXML
    public void authLogin(ActionEvent event) throws Exception{
        Parent view = FXMLLoader.load(getClass().getResource("/com/rentale/client/resources/fxml/dashboard.fxml"));

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setMaximized(false);
        window.setScene(new Scene(view));
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
