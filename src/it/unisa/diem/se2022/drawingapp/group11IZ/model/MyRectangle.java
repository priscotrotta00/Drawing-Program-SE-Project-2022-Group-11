/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import javafx.beans.property.DoubleProperty;

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
}
