/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import javafx.beans.property.ObjectProperty;
import javafx.scene.Parent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;



/**
 *
 * @author saram
 */
public interface MyShape{
    /*Contains the most commonly used Shape methods*/
    
    public Paint myGetStroke();
    public Paint myGetFill();
    public void mySetStroke(Paint value);
    public void mySetFill(Paint value);
    public ObjectProperty<Paint> myStrokeProperty();
    public ObjectProperty<Paint> myFillProperty();
    public String myGetId();
    public Parent myGetParent();
    public double myGetStrokeWidth();
    public void mySetStrokeWidth(double value);
    public void accept(Visitor v);
    
}
