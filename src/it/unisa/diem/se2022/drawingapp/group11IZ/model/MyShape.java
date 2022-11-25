/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.Paint;



/**
 *
 * @author saram
 */
public interface MyShape  {
    /*Contains the most commonly used Shape methods*/
    
    public Paint myGetStroke();
    public Paint myGetFill();
    public void mySetStroke(Paint value);
    public void mySetFill(Paint value);
    public ObjectProperty<Paint> myStrokeProperty();
    public ObjectProperty<Paint> myFillProperty();
    public void mySetVisible(boolean value);
    
}
