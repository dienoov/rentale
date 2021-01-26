package com.rentale.client.app.controllers.admin;

import com.rentale.client.app.helpers.ModalHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Indemnity implements Initializable {
    @FXML
    protected AnchorPane contentPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void editAct(ActionEvent event) {
        contentPane = ModalHelper.setModal(contentPane, "admin/indemnity_modal");
    }
}
