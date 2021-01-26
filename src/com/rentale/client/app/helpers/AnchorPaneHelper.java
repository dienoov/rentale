package com.rentale.client.app.helpers;

import javafx.scene.layout.AnchorPane;

public class AnchorPaneHelper {

    public static int TOP_ANCHOR_KEY = 0;
    public static int RIGHT_ANCHOR_KEY = 1;
    public static int BOTTOM_ANCHOR_KEY = 2;
    public static int LEFT_ANCHOR_KEY = 3;

    public static int HORIZONTAL_ANCHOR_KEY = 0;
    public static int VERTICAL_ANCHOR_KEY = 1;

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

    public static AnchorPane setConstraint(AnchorPane parent, AnchorPane child, double[] constraints) {
        switch (constraints.length) {
            case 4:
                parent.setTopAnchor(child, constraints[TOP_ANCHOR_KEY]);
                parent.setRightAnchor(child, constraints[RIGHT_ANCHOR_KEY]);
                parent.setBottomAnchor(child, constraints[BOTTOM_ANCHOR_KEY]);
                parent.setLeftAnchor(child, constraints[LEFT_ANCHOR_KEY]);
                break;

            case 2:
                parent.setTopAnchor(child, constraints[VERTICAL_ANCHOR_KEY]);
                parent.setRightAnchor(child, constraints[HORIZONTAL_ANCHOR_KEY]);
                parent.setBottomAnchor(child, constraints[VERTICAL_ANCHOR_KEY]);
                parent.setLeftAnchor(child, constraints[HORIZONTAL_ANCHOR_KEY]);
                break;

            default:
                parent.setTopAnchor(child, constraints[0]);
                parent.setRightAnchor(child, constraints[0]);
                parent.setBottomAnchor(child, constraints[0]);
                parent.setLeftAnchor(child, constraints[0]);
        }
        return parent;
    }

}
