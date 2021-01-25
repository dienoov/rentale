package com.rentale.client.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.rentale.client.app.helpers.AnchorPaneHelper;
import com.rentale.client.app.helpers.FXMLHelper;
import com.rentale.client.app.helpers.JFXDrawerHelper;
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
    protected JFXButton rentBtn;

    @FXML
    protected JFXButton venueBtn;

    @FXML
    protected JFXButton indemnityBtn;

    @FXML
    protected JFXButton userBtn;

    @FXML
    protected JFXButton rentReportBtn;

    @FXML
    protected JFXButton indemnityReportBtn;

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

        rentBtn.setOnAction(event -> {
            setActiveMenu(rentBtn);
            setContent("admin/rent");
        });

        venueBtn.setOnAction(event -> {
            setActiveMenu(venueBtn);
            setContent("admin/venue");
        });

        indemnityBtn.setOnAction(event -> {
            setActiveMenu(indemnityBtn);
            setContent("admin/indemnity");
        });

        userBtn.setOnAction(event -> {
            setActiveMenu(userBtn);
            setContent("admin/user");
        });

        rentReportBtn.setOnAction(event -> {
            setActiveMenu(rentReportBtn);
            setContent("admin/reports/rent");
        });

        indemnityReportBtn.setOnAction(event -> {
            setActiveMenu(indemnityReportBtn);
            setContent("admin/reports/indemnity");
        });

        drawer = JFXDrawerHelper.setDrawer(drawer, "user_panel");
    }

    public void setContent(String fileName) {
        AnchorPane content = FXMLHelper.getView(fileName);
        anchorContent = AnchorPaneHelper.setConstraint(anchorContent, content);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(content);
    }

    public void setActiveMenu(JFXButton clickedMenu) {
        dashboardBtn.getStyleClass().removeIf(style -> style.equals("active"));
        rentBtn.getStyleClass().removeIf(style -> style.equals("active"));
        venueBtn.getStyleClass().removeIf(style -> style.equals("active"));
        indemnityBtn.getStyleClass().removeIf(style -> style.equals("active"));
        userBtn.getStyleClass().removeIf(style -> style.equals("active"));
        rentReportBtn.getStyleClass().removeIf(style -> style.equals("active"));
        indemnityReportBtn.getStyleClass().removeIf(style -> style.equals("active"));

        clickedMenu.getStyleClass().add("active");
    }

    @FXML
    public void toggleUserPanel(MouseEvent event) {
        drawer = JFXDrawerHelper.toggleDrawer(drawer);
    }

}
