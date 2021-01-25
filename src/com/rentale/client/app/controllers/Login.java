package com.rentale.client.app.controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    protected JFXTextField email;

    @FXML
    protected JFXPasswordField password;

    @FXML
    public void authLogin(ActionEvent event) throws Exception{
        String userEmail = email.getText().toString();

        String viewSource;
        if(userEmail.equals("admin"))
            viewSource = "/com/rentale/client/resources/fxml/dashboard.fxml";
        else
            viewSource = "/com/rentale/client/resources/fxml/staff/home.fxml";

        Parent view = FXMLLoader.load(getClass().getResource(viewSource));

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.getScene().setRoot(view);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
