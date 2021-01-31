package com.rentale.client.app.controllers.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.rentale.client.app.config.DB;
import com.rentale.client.app.dao.Roles;
import com.rentale.client.app.dao.Users;
import com.rentale.client.app.helpers.FXMLHelper;
import com.rentale.client.app.helpers.ModalHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
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
import java.sql.SQLException;
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
    private TableColumn<Users, String> role;

    protected AnchorPane backdrop;

    protected AnchorPane modalUser;

    protected static Connection connection;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
        email.setCellValueFactory(new PropertyValueFactory<Users, String>("email"));
        role.setCellValueFactory(new PropertyValueFactory<Users, String>("roleName"));

        table.setItems(getUsers());
    }

    public static ObservableList<Users> getUsers() {
        ObservableList<Users> users = FXCollections.observableArrayList();

        ResultSet rs = null;
        try {
            connection = DB.getConnection();
            rs = connection.createStatement().executeQuery("select * from users");
            while (rs.next())
                users.add(new Users(rs.getInt("id"), rs.getString("email"), rs.getInt("role_id")));
        } catch (SQLException throwables) {
            System.out.println("Failed to retrieve users");
        }

        return users;
    }

    @FXML
    public void create(ActionEvent event) {
        double[] constraints = {300.0, 200.0};
        userAnchor = ModalHelper.setModal(userAnchor, "admin/user_modal", constraints);
    }

    public static void closeModal(Scene scene) {
        AnchorPane userAnchor = (AnchorPane) scene.lookup("#userAnchor");
        userAnchor.getChildren().remove(userAnchor.lookup("#backdrop"));
        ((TableView) userAnchor.lookup("#table")).setItems(getUsers());
    }

    public static void save(String email, String password, int role) throws Exception {
        connection = DB.getConnection();

        String bcrypt = BCrypt.hashpw(password, BCrypt.gensalt());

        PreparedStatement save = connection.prepareStatement("insert into users (email, password, role_id) values (?, ?, ?)");
        save.setString(1, email);
        save.setString(2, bcrypt);
        save.setInt(3, role);
        save.executeUpdate();
    }

    @FXML
    public void delete(ActionEvent event) throws Exception {
        Users user = (Users) table.getSelectionModel().getSelectedItem();

        connection = DB.getConnection();

        PreparedStatement delete = connection.prepareStatement("delete from users where id = ?");
        delete.setInt(1, user.getId());
        delete.executeUpdate();
        table.setItems(getUsers());
    }

    @FXML
    public void edit(ActionEvent event) {
        if (table.getSelectionModel().getSelectedItem() != null)
            editModal();
    }

    public void editModal() {
        double[] constraints = {300.0, 200.0};
        AnchorPane userModal = FXMLHelper.getView("admin/user_modal");

        ScrollPane scroll = (ScrollPane) userModal.getChildren().get(0);
        AnchorPane form = (AnchorPane) scroll.getContent();

        Users user = (Users) table.getSelectionModel().getSelectedItem();

        JFXTextField email = (JFXTextField) form.lookup("#email");
        email.setText(user.getEmail());

        form.lookup("#password").setDisable(true);

        JFXComboBox role = (JFXComboBox) form.lookup("#role");
        role.getSelectionModel().select(user.getRole() - 1);

        JFXButton save = (JFXButton) form.lookup("#saveBtn");
        save.setOnAction(event -> {
            Roles selected = (Roles) role.getSelectionModel().getSelectedItem();
            update(user.getId(), email.getText(), selected.getId());
            closeModal(userAnchor.getScene());
        });

        userAnchor = ModalHelper.setModal(userAnchor, userModal, constraints);
    }

    public static void update(int id, String email, int role) {
        connection = DB.getConnection();
        PreparedStatement update = null;
        try {
            update = connection.prepareStatement("update users set email = ?, role_id = ? where id = ?");
            update.setString(1, email);
            update.setInt(2, role);
            update.setInt(3, id);
            update.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Failed to Update User");
        }
    }

}
