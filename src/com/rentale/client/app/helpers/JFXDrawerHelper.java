package com.rentale.client.app.helpers;

import com.jfoenix.controls.JFXDrawer;
import javafx.scene.layout.AnchorPane;

public class JFXDrawerHelper {

    public static JFXDrawer toggleDrawer(JFXDrawer drawer) {
        if (drawer.isOpened())
            drawer.close();
        else
            drawer.open();

        return drawer;
    }

    public static JFXDrawer setDrawer(JFXDrawer drawer, String fileName) {
        AnchorPane view = FXMLHelper.getView(fileName);
        drawer.setSidePane(view);
        drawer.setDisable(true);
        drawer.setOnDrawerOpened(jfxDrawerEvent -> drawer.setDisable(false));
        drawer.setOnDrawerClosed(jfxDrawerEvent -> drawer.setDisable(true));
        return drawer;
    }

}
