package com.rentale.client.app.controllers;

import com.rentale.client.app.helpers.FXMLHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

    @FXML
    private AnchorPane anchorContent;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnchorPane content = FXMLHelper.getView("admin/main");
        anchorContent.setTopAnchor(content, 0.0);
        anchorContent.setLeftAnchor(content, 0.0);
        anchorContent.setRightAnchor(content, 0.0);
        anchorContent.setBottomAnchor(content, 0.0);
        anchorContent.getChildren().add(content);
    }

}
