package com.rentale.client.app.controllers.admin;

import com.rentale.client.app.dao.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class User implements Initializable {

    @FXML
    private TableView table;

    @FXML
    private TableColumn<Users, Integer> id;

    @FXML
    private TableColumn<Users, String> email;

    @FXML
    private TableColumn<Users, Character> role;

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

}
