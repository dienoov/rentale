package com.rentale.client.app.controllers.admin;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.rentale.client.app.dao.Roles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.SVGPath;

import java.net.URL;
import java.util.ResourceBundle;

import static com.rentale.client.app.controllers.admin.User.closeModal;

public class UserModal implements Initializable {

    @FXML
    protected SVGPath closeModalBtn;

    @FXML
    protected JFXTextField email;

    @FXML
    protected JFXPasswordField password;

    @FXML
    protected JFXComboBox role;

    protected int selectedRoleId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        closeModalBtn.setOnMouseClicked(mouseEvent -> closeModal(mouseEvent));

        role.setItems(Roles.getAllRoles());

        role.setOnAction(event -> {
            Roles selected = (Roles) role.getSelectionModel().getSelectedItem();
            selectedRoleId = selected.getId();
        });
    }

    @FXML
    public void save(ActionEvent event) throws Exception {
        User.save(email.getText(), password.getText(), selectedRoleId);
    }

}
