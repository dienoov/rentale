package com.rentale.client.app.controllers.admin;

import com.rentale.client.app.config.DB;
import com.rentale.client.app.dao.Users;
import com.rentale.client.app.helpers.ModalHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.mindrot.jbcrypt.BCrypt;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class User implements Initializable {

    @FXML
    protected AnchorPane userAnchor;

    @FXML
    private TableView table;

    @FXML
    private TableColumn<Users, Integer> id;

    @FXML
    private TableColumn<Users, String> email;

    @FXML
    private TableColumn<Users, Character> role;

    protected AnchorPane backdrop;

    protected AnchorPane modalUser;

    protected static Connection connection;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
        email.setCellValueFactory(new PropertyValueFactory<Users, String>("email"));
        role.setCellValueFactory(new PropertyValueFactory<Users, Character>("role"));

        table.setItems(getUsers());
    }

    public ObservableList<Users> getUsers() {
        ObservableList<Users> users = FXCollections.observableArrayList();
        users.add(new Users(1, "alvino@mail.com", "123", 'a'));
        users.add(new Users(2, "admin@mail.com", "12312312", 'a'));
        users.add(new Users(3, "staff@mail.com", "adsjfknak", 's'));
        return users;
    }

    @FXML
    public void newUser(ActionEvent event) {
        double[] constraints = {300.0, 200.0};
        userAnchor = ModalHelper.setModal(userAnchor, "admin/user_modal", constraints);
    }

    public void deleteUser(ActionEvent event) {
        userAnchor.getChildren().remove(backdrop);
    }

    public void closeModal(MouseEvent mouseEvent) {
        Scene scene = ((Node) mouseEvent.getSource()).getScene();
        AnchorPane userAnchor = (AnchorPane) scene.lookup("#userAnchor");
        userAnchor.getChildren().remove(userAnchor.lookup("#backdrop"));
    }

    public static void saveUser(String email, String password) throws Exception {
        connection = DB.getConnection();

        String bcrypt = BCrypt.hashpw(password, BCrypt.gensalt());

        PreparedStatement saveUser = connection.prepareStatement("insert into users (email, password, role_id) values (?, ?, ?);");
        saveUser.setString(1, email);
        saveUser.setString(2, bcrypt);
        saveUser.setInt(3, 2);
        saveUser.executeUpdate();
    }

}
