package com.rentale.client.app.controllers.staff;

import com.jfoenix.controls.JFXDrawer;
import com.rentale.client.app.helpers.AnchorPaneHelper;
import com.rentale.client.app.helpers.FXMLHelper;
import com.rentale.client.app.helpers.JFXDrawerHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    protected JFXDrawer drawer;

    @FXML
    protected JFXDrawer bookDrawer;

    @FXML
    protected JFXDrawer searchDrawer;

    @FXML
    protected AnchorPane contentPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contentPane = AnchorPaneHelper.setContent(contentPane, "staff/home_menu");

        drawer = JFXDrawerHelper.setDrawer(drawer, "user_panel");
        bookDrawer = JFXDrawerHelper.setDrawer(bookDrawer, "staff/form");
        searchDrawer = JFXDrawerHelper.setDrawer(searchDrawer, "staff/rent_payment");
    }

    @FXML
    public void toggleUserPanel(MouseEvent event) {
        drawer = JFXDrawerHelper.toggleDrawer(drawer);
    }

    @FXML
    public void toggleBookDrawer(MouseEvent event) {
        bookDrawer = JFXDrawerHelper.toggleDrawer(bookDrawer);
    }

    @FXML
    public void toggleSearchDrawer(MouseEvent event) {
        searchDrawer = JFXDrawerHelper.toggleDrawer(searchDrawer);
    }

    @FXML
    public void routeBook(MouseEvent event) {

    }

}
