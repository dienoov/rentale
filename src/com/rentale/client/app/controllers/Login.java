package com.rentale.client.app.controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.rentale.client.app.config.DB;
import com.rentale.client.app.dao.Roles;
import com.rentale.client.app.helpers.FXMLHelper;
import com.rentale.client.app.helpers.LabelHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static com.rentale.client.app.helpers.LabelHelper.dangerLabel;

public class Login implements Initializable {

    @FXML
    protected JFXTextField email;

    @FXML
    protected JFXPasswordField password;

    @FXML
    protected HBox errors;

    @FXML
    public void authLogin(ActionEvent event) throws Exception {
        String userEmail = email.getText();
        String userPassword = password.getText();

        Connection connection = DB.getConnection();

        PreparedStatement getUser = connection.prepareStatement("select * from users where email = ?;");
        getUser.setString(1, userEmail);
        ResultSet user = getUser.executeQuery();

        errors.getChildren().clear();

        if (!user.next())
            errors.getChildren().add(dangerLabel("No user with that address"));

        else if (!BCrypt.checkpw(userPassword, user.getString("password")))
            errors.getChildren().add(dangerLabel("Wrong password, please try again"));

        else
            loginProcess(event, user.getInt("role_id"), userEmail);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    protected void loginProcess(ActionEvent event, int role_id, String userEmail) {
        String viewSource;
        if (role_id == 1)
            viewSource = "dashboard";
        else
            viewSource = "staff/home";

        Parent view = FXMLHelper.getView(viewSource);

        ((Label) view.lookup("#userRole")).setText(Roles.getRoleNameById(role_id));
        ((Label) view.lookup("#userEmail")).setText(userEmail);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getScene().setRoot(view);
    }
}
