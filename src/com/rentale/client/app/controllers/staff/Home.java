package com.rentale.client.app.controllers.staff;

import com.jfoenix.controls.JFXDrawer;
import com.rentale.client.app.helpers.FXMLHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    protected JFXDrawer drawer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initDrawer();
    }

    public void initDrawer() {
        AnchorPane userPanel = FXMLHelper.getView("user_panel");
        drawer.setSidePane(userPanel);
    }

    @FXML
    public void toggleUserPanel(MouseEvent event) {
        if (drawer.isOpened()) {
            drawer.close();
            drawer.toBack();
        } else {
            drawer.toFront();
            drawer.open();
        }
    }

}
