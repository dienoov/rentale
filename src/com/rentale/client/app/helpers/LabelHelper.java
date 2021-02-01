package com.rentale.client.app.helpers;

import javafx.scene.control.Label;

public class LabelHelper {

    protected static Label label;

    public static Label dangerLabel(String s) {
        label = new Label(s);
        label.setStyle("-fx-text-fill: red;");
        return label;
    }

    public static Label successLabel(String s) {
        label = new Label(s);
        label.setStyle("-fx-text-fill: green;");
        return label;
    }

}
