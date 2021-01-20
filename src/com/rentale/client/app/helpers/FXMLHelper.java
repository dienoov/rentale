package com.rentale.client.app.helpers;

import com.rentale.client.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class FXMLHelper {

    public static AnchorPane getView(String fileName) {
        AnchorPane view;
        try {
            view = FXMLLoader.load(Main.class.getResource("/com/rentale/client/resources/fxml/" + fileName + ".fxml"));
        } catch (Exception e){
            System.out.println("Not Found");
            view = null;
        }

        return view;
    }

}
