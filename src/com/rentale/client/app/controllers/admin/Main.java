package com.rentale.client.app.controllers.admin;

import com.rentale.client.app.dao.Venues;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    @FXML
    private TableView<Venues> table;

    @FXML
    private TableColumn<Venues, String> name;

    @FXML
    private TableColumn<Venues, String> location;

    @FXML
    private TableColumn<Venues, String> desc;

    @FXML
    private LineChart<?, ?> transactionChart;

    @FXML
    private CategoryAxis xChart;

    @FXML
    private NumberAxis yChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setCellValueFactory(new PropertyValueFactory<Venues, String>("name"));
        location.setCellValueFactory(new PropertyValueFactory<Venues, String>("location"));
        desc.setCellValueFactory(new PropertyValueFactory<Venues, String>("desc"));

        table.setItems(getVenue());

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Jan", 500));
        series.getData().add(new XYChart.Data("Feb", 750));
        series.getData().add(new XYChart.Data("Mar", 200));
        series.getData().add(new XYChart.Data("Apr", 200));
        series.getData().add(new XYChart.Data("May", 600));
        series.getData().add(new XYChart.Data("Jun", 500));
        series.getData().add(new XYChart.Data("Jul", 800));
        series.getData().add(new XYChart.Data("Aug", 820));
        series.getData().add(new XYChart.Data("Sep", 250));
        series.getData().add(new XYChart.Data("Oct", 900));
        series.getData().add(new XYChart.Data("Nov", 800));
        series.getData().add(new XYChart.Data("Dec", 700));
        series.setName("Rent");

        XYChart.Series series2 = new XYChart.Series();
        series2.getData().add(new XYChart.Data("Jan", 100));
        series2.getData().add(new XYChart.Data("Feb", 200));
        series2.getData().add(new XYChart.Data("Mar", 50));
        series2.getData().add(new XYChart.Data("Apr", 300));
        series2.getData().add(new XYChart.Data("May", 250));
        series2.getData().add(new XYChart.Data("Jun", 100));
        series2.getData().add(new XYChart.Data("Jul", 100));
        series2.getData().add(new XYChart.Data("Aug", 200));
        series2.getData().add(new XYChart.Data("Sep", 500));
        series2.getData().add(new XYChart.Data("Oct", 100));
        series2.getData().add(new XYChart.Data("Nov", 220));
        series2.getData().add(new XYChart.Data("Dec", 200));
        series2.setName("Indemnity");

        transactionChart.getData().addAll(series, series2);
    }

    public ObservableList<Venues> getVenue() {
        ObservableList<Venues> venues = FXCollections.observableArrayList();
        venues.add(new Venues("Hotel", "Bali", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras mattis eros eu sapien suscipit dignissim. Proin vel mauris efficitur, bibendum purus at, interdum arcu. Maecenas ac porttitor erat. Sed vitae diam iaculis."));
        venues.add(new Venues("Apart", "Bandung", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi aliquet sagittis lectus, quis laoreet lorem gravida ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec sed erat orci. Donec."));
        venues.add(new Venues("Hotel", "Malang", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque vestibulum sodales urna in pharetra. Quisque lobortis faucibus turpis. In a metus vitae lorem vestibulum consequat eu ut nisi. Nulla sed lobortis augue."));
        return venues;
    }

}
