package com.rentale.client.app.controllers.admin;

import com.rentale.client.app.dao.Venues;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    @FXML
    private LineChart<?, ?> transactionChart;

    @FXML
    private CategoryAxis xChart;

    @FXML
    private NumberAxis yChart;

    @FXML
    private BarChart<?, ?> rentBar;

    @FXML
    private CategoryAxis xBar;

    @FXML
    private NumberAxis yBar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

        XYChart.Series barSeries = new XYChart.Series();
        barSeries.getData().add(new XYChart.Data("Jan", 5));
        barSeries.getData().add(new XYChart.Data("Feb", 7));
        barSeries.getData().add(new XYChart.Data("Mar", 2));
        barSeries.getData().add(new XYChart.Data("Apr", 2));
        barSeries.getData().add(new XYChart.Data("May", 6));
        barSeries.getData().add(new XYChart.Data("Jun", 5));
        barSeries.getData().add(new XYChart.Data("Jul", 8));
        barSeries.getData().add(new XYChart.Data("Aug", 8));
        barSeries.getData().add(new XYChart.Data("Sep", 2));
        barSeries.getData().add(new XYChart.Data("Oct", 9));
        barSeries.getData().add(new XYChart.Data("Nov", 8));
        barSeries.getData().add(new XYChart.Data("Dec", 7));
        barSeries.setName("Rent");

        rentBar.getData().addAll(barSeries);
    }

}
