package com.rentale.client.app.controllers;

import com.jfoenix.controls.JFXRippler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    private AnchorPane scrollAnchor;

    @FXML
    private VBox cover;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXRippler coverRippler = new JFXRippler(cover);
        coverRippler.setRipplerFill(Paint.valueOf("#51d7a0"));

        scrollAnchor.setLeftAnchor(coverRippler, 0.0);
        scrollAnchor.setRightAnchor(coverRippler, 0.0);
        scrollAnchor.getChildren().add(coverRippler);
    }
}
