/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
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

    @Override
    public void accept(Visitor v) {
        v.visitLine(this);
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
    public void mySetLayoutX(double value) {
        super.setLayoutX(value);
    }

    @Override
    public void mySetLayoutY(double value) {
        super.setLayoutY(value);
    }
    
    @Override
    public DoubleProperty myLayoutXProperty() {
        return super.layoutXProperty();
    }

    @Override
    public DoubleProperty myLayoutYProperty() {
        return super.layoutYProperty();
    }
    
    @Override
    public ObservableList<Double> myGetStrokeDashArray() {
        return super.getStrokeDashArray();
    }
    
    @Override
    public Bounds myGetLayoutBounds() {
        return super.getLayoutBounds();
    }
    
    /**
     * Change the position of a line changing its start position
     * and consequentely his end position, not changing the line length
     * @param topLeftX
     * @param topLeftY 
     */
    @Override
    public void moveShape(double topLeftX, double topLeftY) {
        MyLine newLine = (MyLine) this;
        
        double lengthX = this.myGetEndX() - this.myGetStartX();
        double lengthY = this.myGetEndY() - this.myGetStartY();
        
        newLine.mySetStartX(topLeftX);
        newLine.mySetStartY(topLeftY);
        newLine.mySetEndX(topLeftX+lengthX);
        newLine.mySetEndY(topLeftY+lengthY);
        
    }

}
