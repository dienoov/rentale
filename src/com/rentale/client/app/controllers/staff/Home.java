package com.rentale.client.app.controllers.staff;

import com.jfoenix.controls.JFXDrawer;
import com.rentale.client.app.helpers.AnchorPaneHelper;
import com.rentale.client.app.helpers.FXMLHelper;
import com.rentale.client.app.helpers.JFXDrawerHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    protected JFXDrawer drawer;

    @FXML
    protected AnchorPane contentPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contentPane = AnchorPaneHelper.setContent(contentPane, "staff/home_menu");

        drawer = JFXDrawerHelper.setDrawer(drawer, "user_panel");
    }

    @FXML
    public void toggleUserPanel(MouseEvent event) {
        drawer = JFXDrawerHelper.toggleDrawer(drawer);
    }

    @FXML
    public static void backToMenu(ActionEvent event) {
        Scene scene = ((Node)event.getSource()).getScene();
        AnchorPane contentPane = (AnchorPane) scene.lookup("#contentPane");
        contentPane = AnchorPaneHelper.setContent(contentPane, "staff/home_menu");
    }

}
