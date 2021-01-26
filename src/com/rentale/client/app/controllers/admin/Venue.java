package com.rentale.client.app.controllers.admin;

import com.rentale.client.app.helpers.AnchorPaneHelper;
import com.rentale.client.app.helpers.FXMLHelper;
import com.rentale.client.app.helpers.ModalHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Venue implements Initializable {

    @FXML
    protected AnchorPane managePane;

    protected AnchorPane backdrop;

    protected AnchorPane manageModal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void newAct(ActionEvent event) {
        double[] constraints = {250.0, 150.0};
        managePane = ModalHelper.setModal(managePane, "admin/venue_modal", constraints);
    }

    public void closeModal(MouseEvent mouseEvent) {
        Scene scene = (Scene) ((Node)mouseEvent.getSource()).getScene();
        AnchorPane managePane = (AnchorPane) scene.lookup("#managePane");
        managePane.getChildren().remove(managePane.lookup("#backdrop"));
    }

}
