package com.rentale.client.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.rentale.client.app.helpers.FXMLHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

    @FXML
    private AnchorPane anchorContent;

    @FXML
    private JFXButton dashboardBtn;

    @FXML
    private JFXButton userBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setContent("admin/main");

        dashboardBtn.setOnAction(event -> setContent("admin/main"));
        userBtn.setOnAction(event -> setContent("admin/user"));
    }

    public void setConstraint(AnchorPane content) {
        anchorContent.setTopAnchor(content, 0.0);
        anchorContent.setLeftAnchor(content, 0.0);
        anchorContent.setRightAnchor(content, 0.0);
        anchorContent.setBottomAnchor(content, 0.0);
    }

    public void setContent(String fileName) {
        AnchorPane content = FXMLHelper.getView(fileName);
        setConstraint(content);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(content);
    }

}
