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
import javafx.scene.shape.Rectangle;

/**
 *
 * @author saram
 */
public class MyEnhancedRectangle extends Rectangle implements MyRectangle{

    @Override
    public double myGetHeight() {
        return super.getHeight();
    }

    @Override
    public double myGetWidth() {
        return super.getWidth();
    }

    @Override
    public double myGetX() {
        return super.getX();
    }

    @Override
    public double myGetY() {
        return super.getY();
    }

    @Override
    public void mySetHeight(double value) {
        super.setHeight(value);
    }

    @Override
    public void mySetWidth(double value) {
        super.setWidth(value);
    }

    @Override
    public void mySetX(double value) {
        super.setX(value);
    }

    @Override
    public void mySetY(double value) {
        super.setY(value);
    }

    @Override
    public DoubleProperty myWidthProperty() {
        return super.widthProperty();
    }

    @Override
    public DoubleProperty myHeightProperty() {
        return super.heightProperty();
    }

    @Override
    public DoubleProperty myXProperty() {
        return super.xProperty();
    }

    @Override
    public DoubleProperty myYProperty() {
        return super.yProperty();
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

    @Override
    public void mySetVisible(boolean value) {
        super.setVisible(value);
    }
        
    @Override
    public void accept(Visitor v) {
        v.visitRectangle(this);
    }
   
}
