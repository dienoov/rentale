package com.rentale.client.app.controllers.staff;

import com.jfoenix.controls.JFXDrawer;
import com.rentale.client.app.helpers.JFXDrawerHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    protected JFXDrawer drawer;

    @FXML
    protected JFXDrawer bookDrawer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        drawer = JFXDrawerHelper.setDrawer(drawer, "user_panel");
        bookDrawer = JFXDrawerHelper.setDrawer(bookDrawer, "staff/form");
    }

    @FXML
    public void toggleUserPanel(MouseEvent event) {
        drawer = JFXDrawerHelper.toggleDrawer(drawer);
    }

    @FXML
    public void toggleBookDrawer(MouseEvent event) {
        bookDrawer = JFXDrawerHelper.toggleDrawer(bookDrawer);
    }

}
