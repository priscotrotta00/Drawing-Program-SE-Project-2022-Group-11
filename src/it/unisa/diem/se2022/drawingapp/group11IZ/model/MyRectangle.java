/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;

/**
 *
 * @author saram
 */
public interface MyRectangle extends MyShape {
    public double myGetHeight();
    public double myGetWidth();
    public double myGetX();
    public double myGetY();
    public void mySetHeight(double value);
    public void mySetWidth(double value);
    public void mySetX(double value);
    public void mySetY(double value);
    public DoubleProperty myWidthProperty();
    public DoubleProperty myHeightProperty();
    public DoubleProperty myXProperty();
    public DoubleProperty myYProperty();
    public double getTopLeftX();
    public ReadOnlyDoubleProperty topLeftXProperty();
    public double getTopLeftY();
    public ReadOnlyDoubleProperty topLeftYProperty();
    public double getBottomRightX();
    public ReadOnlyDoubleProperty bottomRightXProperty();
    public double getBottomRightY();
    public ReadOnlyDoubleProperty bottomRightYProperty();
}
