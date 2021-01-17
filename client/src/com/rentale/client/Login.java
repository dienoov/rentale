package com.rentale.client;

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
        Parent view = FXMLLoader.load(getClass().getResource("register.fxml"));

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(view));
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
