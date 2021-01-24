package com.rentale.client.app.helpers;

import javafx.scene.layout.AnchorPane;

public class AnchorPaneHelper {

    public static AnchorPane setConstraint(AnchorPane parent, AnchorPane child, double constraint) {
        parent.setTopAnchor(child, constraint);
        parent.setLeftAnchor(child, constraint);
        parent.setRightAnchor(child, constraint);
        parent.setBottomAnchor(child, constraint);
        return parent;
    }

    public static AnchorPane setConstraint(AnchorPane parent, AnchorPane child) {
        return setConstraint(parent, child, 0.0);
    }

}
