/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;


import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.scene.Parent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author saram
 */
public class MyEnhancedEllipse extends Ellipse implements MyEllipse{

    @Override
    public double myGetCenterX() {
        return super.getCenterX();
    }

    @Override
    public double myGetCenterY() {
        return super.getCenterY();
    }

    @Override
    public double myGetRadiusX() {
        return super.getRadiusX();
    }

    @Override
    public double myGetRadiusY() {
        return super.getRadiusY();
    }

    @Override
    public void mySetCenterX(double value) {
        super.setCenterX(value);
    }

    @Override
    public void mySetCenterY(double value) {
        super.setCenterY(value);
    }

    @Override
    public void mySetRadiusX(double value) {
        super.setRadiusX(value);
    }

    @Override
    public void mySetRadiusY(double value) {
        super.setRadiusY(value);
    }

    @Override
    public DoubleProperty myCenterXProperty() {
        return super.centerXProperty();
    }

    @Override
    public DoubleProperty myCenterYProperty() {
        return super.centerYProperty();
    }

    @Override
    public DoubleProperty myRadiusXProperty() {
        return super.radiusXProperty();
    }

    @Override
    public DoubleProperty myRadiusYProperty() {
        return super.radiusYProperty();
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

    @Override
    public void accept(Visitor v) {
        v.visitEllipse(this);
    }   
    
    public String myGetId() {
        return super.getId();
    }

    @Override
    public double myGetStrokeWidth() {
        return super.getStrokeWidth();
    }

    @Override
    public Parent myGetParent() {
        return super.getParent();
    }

    @Override
    public void mySetStrokeWidth(double value) {
        super.setStrokeWidth(value);
    }

   
    
}

