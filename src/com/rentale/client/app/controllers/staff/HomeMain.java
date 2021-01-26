package com.rentale.client.app.controllers.staff;

import com.jfoenix.controls.JFXButton;
import com.rentale.client.app.helpers.AnchorPaneHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeMain implements Initializable {

    protected AnchorPane contentPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void book(MouseEvent event) {
        Scene scene = ((Node) event.getSource()).getScene();
        contentPane = (AnchorPane) scene.lookup("#contentPane");
        contentPane = AnchorPaneHelper.setContent(contentPane, "staff/form");
    }

    @FXML
    public void rentPayment(MouseEvent event) {
        Scene scene = ((Node) event.getSource()).getScene();
        contentPane = (AnchorPane) scene.lookup("#contentPane");
        contentPane = AnchorPaneHelper.setContent(contentPane, "staff/rent_payment");
    }

    @FXML
    public void indemnityPayment(MouseEvent event) {
        Scene scene = ((Node) event.getSource()).getScene();
        contentPane = (AnchorPane) scene.lookup("#contentPane");
        contentPane = AnchorPaneHelper.setContent(contentPane, "staff/indemnity_payment");
    }

}
