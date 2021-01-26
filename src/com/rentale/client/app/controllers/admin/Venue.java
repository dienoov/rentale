package com.rentale.client.app.controllers.admin;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
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
    private TableColumn<Venues, String> desc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setCellValueFactory(new PropertyValueFactory<Venues, String>("name"));
        location.setCellValueFactory(new PropertyValueFactory<Venues, String>("location"));
        desc.setCellValueFactory(new PropertyValueFactory<Venues, String>("desc"));

        table.setItems(getVenue());
    }

    public ObservableList<Venues> getVenue() {
        ObservableList<Venues> venues = FXCollections.observableArrayList();
        venues.add(new Venues("Hotel", "Bali", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras mattis eros eu sapien suscipit dignissim. Proin vel mauris efficitur, bibendum purus at, interdum arcu. Maecenas ac porttitor erat. Sed vitae diam iaculis."));
        venues.add(new Venues("Apart", "Bandung", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi aliquet sagittis lectus, quis laoreet lorem gravida ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec sed erat orci. Donec."));
        venues.add(new Venues("Hotel", "Malang", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque vestibulum sodales urna in pharetra. Quisque lobortis faucibus turpis. In a metus vitae lorem vestibulum consequat eu ut nisi. Nulla sed lobortis augue."));
        return venues;
    }

    @FXML
    public void newAct(ActionEvent event) {
        double[] constraints = {250.0, 150.0};
        managePane = ModalHelper.setModal(managePane, "admin/venue_modal", constraints);
    }

    public void closeModal(MouseEvent mouseEvent) {
        Scene scene = (Scene) ((Node)mouseEvent.getSource()).getScene();
        AnchorPane managePane = (AnchorPane) scene.lookup("#managePane");
        managePane.getChildren().remove(managePane.lookup("#backdrop"));
    }

}
