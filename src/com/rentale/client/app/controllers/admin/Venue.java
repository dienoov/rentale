package com.rentale.client.app.controllers.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.rentale.client.app.config.DB;
import com.rentale.client.app.dao.Venues;
import com.rentale.client.app.helpers.AnchorPaneHelper;
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

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Venue implements Initializable {

    @FXML
    protected AnchorPane managePane;

    protected AnchorPane backdrop;

    protected AnchorPane manageModal;

    @FXML
    private TableView<Venues> table;

    @FXML
    private TableColumn<Venues, String> name;

    @FXML
    private TableColumn<Venues, String> location;

    @FXML
    private TableColumn<Venues, String> address;

    @FXML
    private TableColumn<Venues, String> desc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        desc.setCellValueFactory(new PropertyValueFactory<>("desc"));

        table.setItems(getVenues());
    }

    public ObservableList<Venues> getVenues() {
        ObservableList<Venues> venues = FXCollections.observableArrayList();
        Connection connection = DB.getConnection();
        try {
            ResultSet rs = connection.createStatement().executeQuery("select * from venues");
            while (rs.next())
                venues.add(new Venues(rs.getInt("id"), rs.getString("name"), rs.getString("location"), rs.getString("address"), rs.getString("description")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return venues;
    }

    @FXML
    public void create(ActionEvent actionEvent) {
        double[] constraints = {250.0, 150.0};
        AnchorPane modal = FXMLHelper.getView("admin/venue_modal");

        AnchorPane form = (AnchorPane) ((ScrollPane) modal.getChildren().get(0)).getContent();

        ((JFXButton) form.lookup("#save")).setOnAction(event -> {
            save(
                    ((JFXTextField) form.lookup("#name")).getText(),
                    ((JFXTextField) form.lookup("#location")).getText(),
                    ((JFXTextField) form.lookup("#address")).getText(),
                    ((JFXTextArea) form.lookup("#description")).getText()
            );
            closeModal(event);
        });

        ((JFXButton) form.lookup("#back")).setOnAction(event -> closeModal(event));

        managePane = ModalHelper.setModal(managePane, modal, constraints);
    }

    @FXML
    public void edit(ActionEvent actionEvent) {
        if (table.getSelectionModel().getSelectedItem() != null)
            editModal(actionEvent);
    }

    @FXML
    public void delete(ActionEvent actionEvent) {
        if (table.getSelectionModel().getSelectedItem() != null)
            delete();
    }

    public void editModal(ActionEvent actionEvent) {
        double[] constraints = {250.0, 150.0};
        AnchorPane modal = FXMLHelper.getView("admin/venue_modal");

        AnchorPane form = (AnchorPane) ((ScrollPane) modal.getChildren().get(0)).getContent();

        Venues venue = table.getSelectionModel().getSelectedItem();

        JFXTextField name = (JFXTextField) form.lookup("#name");
        name.setText(venue.getName());

        JFXTextField location = (JFXTextField) form.lookup("#location");
        location.setText(venue.getLocation());

        JFXTextField address = (JFXTextField) form.lookup("#address");
        address.setText(venue.getAddress());

        JFXTextArea description = (JFXTextArea) form.lookup("#description");
        description.setText(venue.getDesc());

        ((JFXButton) form.lookup("#save")).setOnAction(event -> {
            save(venue.getId(), name.getText(), location.getText(), address.getText(), description.getText());
            closeModal(event);
        });

        ((JFXButton) form.lookup("#back")).setOnAction(event -> closeModal(event));

        managePane = ModalHelper.setModal(managePane, modal, constraints);
    }

    public void save(String name, String location, String address, String description) {
        Connection connection = DB.getConnection();

        try {
            PreparedStatement save = connection.prepareStatement("insert into venues (name, location, address, description) values (?, ?, ?, ?)");
            save.setString(1, name);
            save.setString(2, location);
            save.setString(3, address);
            save.setString(4, description);
            save.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void save(int id, String name, String location, String address, String description) {
        Connection connection = DB.getConnection();

        try {
            PreparedStatement save = connection.prepareStatement("update venues set name = ?, location = ?, address = ?, description = ? where id = ?");
            save.setString(1, name);
            save.setString(2, location);
            save.setString(3, address);
            save.setString(4, description);
            save.setInt(5, id);
            save.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void delete() {
        Connection connection = DB.getConnection();

        try {
            PreparedStatement delete = connection.prepareStatement("delete from venues where id = ?");
            delete.setInt(1, (table.getSelectionModel().getSelectedItem()).getId());
            delete.executeUpdate();
            table.setItems(getVenues());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeModal(ActionEvent event) {
        closeModal(((Node) event.getSource()).getScene());
    }

    public void closeModal(Scene scene) {
        AnchorPane managePane = (AnchorPane) scene.lookup("#managePane");
        managePane.getChildren().remove(managePane.lookup("#backdrop"));
        ((TableView) managePane.lookup("#table")).setItems(getVenues());
    }

}
