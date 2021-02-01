package com.rentale.client.app.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXPasswordField;
import com.rentale.client.app.config.DB;
import com.rentale.client.app.helpers.FXMLHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.mindrot.jbcrypt.BCrypt;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.rentale.client.app.helpers.LabelHelper.dangerLabel;
import static com.rentale.client.app.helpers.LabelHelper.successLabel;

public class ChangePassword implements Initializable {

    @FXML
    protected JFXPasswordField oldPassword;

    @FXML
    protected JFXPasswordField newPassword;

    @FXML
    protected JFXPasswordField confirmPassword;

    @FXML
    protected VBox errors;

    @FXML
    protected JFXButton save;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        save.setOnAction(actionEvent -> savePassword());
    }

    @FXML
    public void backToUserMenu(ActionEvent event) {
        Scene scene = ((Node) event.getSource()).getScene();
        JFXDrawer drawer = (JFXDrawer) scene.lookup("#drawer");

        AnchorPane changePassword = FXMLHelper.getView("user_panel");
        drawer.setSidePane(changePassword);
    }

    public void savePassword() {
        String userEmail = ((Label) this.oldPassword.getScene().lookup("#userEmail")).getText();
        String oldPassword = this.oldPassword.getText();
        String newPassword = this.newPassword.getText();
        String confirmPassword = this.confirmPassword.getText();
        String userOldPassword = null;
        int userId = 0;

        Connection connection = DB.getConnection();
        ResultSet rs;

        try {
            PreparedStatement checkOldPassword = connection.prepareStatement("select id, password from users where email = ?");
            checkOldPassword.setString(1, userEmail);
            rs = checkOldPassword.executeQuery();
            rs.next();
            userOldPassword = rs.getString("password");
            userId = rs.getInt("id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        errors.getChildren().clear();

        if (!BCrypt.checkpw(oldPassword, userOldPassword))
            errors.getChildren().add(dangerLabel("Old password does not match"));

        else if (newPassword.length() < 8)
            errors.getChildren().add(dangerLabel("Password must be at least 8 characters long"));

        else if (!newPassword.equals(confirmPassword))
            errors.getChildren().add(dangerLabel("New password does not match"));

        else
            proceedChangePassword(userId, newPassword);
    }

    public void proceedChangePassword(int id, String password) {
        Connection connection = DB.getConnection();

        try {
            PreparedStatement save = connection.prepareStatement("update users set password = ? where id = ?");
            save.setString(1, BCrypt.hashpw(password, BCrypt.gensalt()));
            save.setInt(2, id);
            save.executeUpdate();
            errors.getChildren().add(successLabel("Password successfully changed"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
