/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author saram
 */
public interface MyEllipse extends MyShape {
    public double myGetCenterX();
    public double myGetCenterY();
    public double myGetRadiusX();
    public double myGetRadiusY();
    public void mySetCenterX(double value);
    public void mySetCenterY(double value);
    public void mySetRadiusX(double value);
    public void mySetRadiusY(double value);
    public DoubleProperty myCenterXProperty();
    public DoubleProperty myCenterYProperty();
    public DoubleProperty myRadiusXProperty();
    public DoubleProperty myRadiusYProperty();
    public double getTopLeftX();
    public ReadOnlyDoubleProperty topLeftXProperty();
    public double getTopLeftY();
    public ReadOnlyDoubleProperty topLeftYProperty();
    public double getBottomRightX();
    public ReadOnlyDoubleProperty bottomRightXProperty();
    public double getBottomRightY();
    public ReadOnlyDoubleProperty bottomRightYProperty();
    @Override
    public Ellipse getView();
}
