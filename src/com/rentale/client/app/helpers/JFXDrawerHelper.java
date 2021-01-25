package com.rentale.client.app.helpers;

import com.jfoenix.controls.JFXDrawer;
import javafx.scene.layout.AnchorPane;

public class JFXDrawerHelper {

    public static JFXDrawer toggleDrawer(JFXDrawer drawer) {
        if (drawer.isOpened()) {
            drawer.close();
            drawer.setVisible(false);
            drawer.setDisable(true);
            drawer.toBack();
        } else {
            drawer.toFront();
            drawer.open();
            drawer.setVisible(true);
            drawer.setDisable(false);
        }
        return drawer;
    }

    public static JFXDrawer setDrawer(JFXDrawer drawer, String fileName) {
        AnchorPane view = FXMLHelper.getView(fileName);
        drawer.setSidePane(view);
        return drawer;
    }

}
