package com.rentale.client.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.rentale.client.app.helpers.AnchorPaneHelper;
import com.rentale.client.app.helpers.FXMLHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

    @FXML
    private AnchorPane anchorContent;

    @FXML
    protected JFXButton dashboardBtn;

    @FXML
    protected JFXButton venueBtn;

    @FXML
    protected JFXButton userBtn;

    @FXML
    protected JFXDrawer drawer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setActiveMenu(dashboardBtn);
        setContent("admin/main");

        dashboardBtn.setOnAction(event -> {
            setActiveMenu(dashboardBtn);
            setContent("admin/main");
        });

        venueBtn.setOnAction(event -> {
            setActiveMenu(venueBtn);
            setContent("admin/venue");
        });

        userBtn.setOnAction(event -> {
            setActiveMenu(userBtn);
            setContent("admin/user");
        });

        initDrawer();
    }

    public void setContent(String fileName) {
        AnchorPane content = FXMLHelper.getView(fileName);
        anchorContent = AnchorPaneHelper.setConstraint(anchorContent, content);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(content);
    }

    public void setActiveMenu(JFXButton clickedMenu) {
        dashboardBtn.getStyleClass().removeIf(style -> style.equals("active"));
        venueBtn.getStyleClass().removeIf(style -> style.equals("active"));
        userBtn.getStyleClass().removeIf(style -> style.equals("active"));

        clickedMenu.getStyleClass().add("active");
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
