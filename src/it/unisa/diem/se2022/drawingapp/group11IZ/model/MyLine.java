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
public interface MyLine extends MyShape{
    /*methods most used by the Line interface*/
    public double myGetEndX();
    public double myGetEndY();
    public double myGetStartX();
    public double myGetStartY();
    public void mySetEndX(double value);
    public void mySetEndY(double value);
    public void mySetStartX(double value);
    public void mySetStartY(double value);
    public DoubleProperty myEndXProperty();
    public DoubleProperty myEndYProperty();
    public DoubleProperty myStartXProperty();
    public DoubleProperty myStartYProperty();
    
}
