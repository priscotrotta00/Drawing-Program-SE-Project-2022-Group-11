/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

/**
 *
 * @author saram
 */
public class MyEnhancedLine extends Line implements MyLine{

    @Override
    public double myGetEndX() {
        return super.getEndX();
    }

    @Override
    public double myGetEndY() {
        return super.getEndY();
    }

    @Override
    public double myGetStartX() {
        return super.getStartX();
    }

    @Override
    public double myGetStartY() {
        return super.getStartY();
    }

    @Override
    public void mySetEndX(double value) {
        super.setEndX(value);
    }

    @Override
    public void mySetEndY(double value) {
        super.setEndY(value);
    }

    @Override
    public void mySetStartX(double value) {
        super.setStartX(value);
    }

    @Override
    public void mySetStartY(double value) {
        super.setStartY(value);
    }

    @Override
    public DoubleProperty myEndXProperty() {
        return super.endXProperty();
    }

    @Override
    public DoubleProperty myEndYProperty() {
        return super.endYProperty();
    }

    @Override
    public DoubleProperty myStartXProperty() {
        return super.startXProperty();
    }

    @Override
    public DoubleProperty myStartYProperty() {
        return super.startYProperty();
    }

    @Override
    public Paint myGetStroke() {
        return super.getStroke();
    }

    @Override
    public Paint myGetFill() {
        return super.getFill();
    }

    @Override
    public void mySetStroke(Paint value) {
        super.setStroke(value);
    }

    @Override
    public void mySetFill(Paint value) {
        super.setFill(value);
    }

    @Override
    public ObjectProperty<Paint> myStrokeProperty() {
        return super.strokeProperty();
    }

    @Override
    public ObjectProperty<Paint> myFillProperty() {
        return super.fillProperty();
    }
    
}