package com.rentale.client.app.helpers;

import javafx.scene.layout.AnchorPane;

public class ModalHelper {

    public static AnchorPane getBackdrop() {
        return FXMLHelper.getView("backdrop");
    }

    public static AnchorPane setBackdrop(AnchorPane parentPane, AnchorPane backdrop) {
        parentPane = AnchorPaneHelper.setConstraint(parentPane, backdrop);
        parentPane.getChildren().add(backdrop);
        return parentPane;
    }

    public static AnchorPane setBackdrop(AnchorPane parentPane) {
        return setBackdrop(parentPane, getBackdrop());
    }

    public static AnchorPane setModalOnly(AnchorPane backdrop, AnchorPane modal, double constraint) {
        backdrop = AnchorPaneHelper.setConstraint(backdrop, modal, constraint);
        backdrop.getChildren().add(modal);
        return backdrop;
    }

    public static AnchorPane setModalOnly(AnchorPane backdrop, AnchorPane modal, double[] constraints) {
        backdrop = AnchorPaneHelper.setConstraint(backdrop, modal, constraints);
        backdrop.getChildren().add(modal);
        return backdrop;
    }

    public static AnchorPane setModalOnly(AnchorPane backdrop, AnchorPane modal) {
        return setModalOnly(backdrop, modal, 100.0);
    }

    public static AnchorPane setModal(AnchorPane parentPane, AnchorPane modal, AnchorPane backdrop, double constraint) {
        backdrop = setModalOnly(backdrop, modal, constraint);
        parentPane = setBackdrop(parentPane, backdrop);
        return parentPane;
    }

    public static AnchorPane setModal(AnchorPane parentPane, AnchorPane modal, AnchorPane backdrop) {
        backdrop = setModalOnly(backdrop, modal);
        parentPane = setBackdrop(parentPane, backdrop);
        return parentPane;
    }

    public static AnchorPane setModal(AnchorPane parentPane, AnchorPane modal) {
        AnchorPane backdrop = getBackdrop();
        backdrop = setModalOnly(backdrop, modal);
        parentPane = setBackdrop(parentPane, backdrop);
        return parentPane;
    }

    public static AnchorPane setModal(AnchorPane parentPane, AnchorPane modal, double[] constraints) {
        AnchorPane backdrop = getBackdrop();
        backdrop = setModalOnly(backdrop, modal, constraints);
        parentPane = setBackdrop(parentPane, backdrop);
        return parentPane;
    }

    public static AnchorPane setModal(AnchorPane parentPane, String modal) {
        AnchorPane backdrop = getBackdrop();
        backdrop = setModalOnly(backdrop, FXMLHelper.getView(modal));
        parentPane = setBackdrop(parentPane, backdrop);
        return parentPane;
    }

    public static AnchorPane setModal(AnchorPane parentPane, String modal, double constraint) {
        AnchorPane backdrop = getBackdrop();
        backdrop = setModalOnly(backdrop, FXMLHelper.getView(modal), constraint);
        parentPane = setBackdrop(parentPane, backdrop);
        return parentPane;
    }

    public static AnchorPane setModal(AnchorPane parentPane, String modal, double[] constraints) {
        AnchorPane backdrop = getBackdrop();
        backdrop = setModalOnly(backdrop, FXMLHelper.getView(modal), constraints);
        parentPane = setBackdrop(parentPane, backdrop);
        return parentPane;
    }

}
