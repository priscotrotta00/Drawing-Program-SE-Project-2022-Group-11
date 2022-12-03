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
import javafx.scene.shape.Rectangle;

/**
 *
 * @author saram
 */
public class MyEnhancedRectangle extends Rectangle implements MyRectangle{
    
    public MyEnhancedRectangle(){
        super();
    }
    
    private MyEnhancedRectangle(MyEnhancedRectangle rectangle){
        this();
        this.mySetY(rectangle.myGetY());
        this.mySetX(rectangle.myGetX());
        this.mySetWidth(rectangle.myGetWidth());
        this.mySetHeight(rectangle.myGetHeight());
        this.mySetStroke(rectangle.myGetStroke());
        this.mySetFill(rectangle.myGetFill());
        this.mySetStrokeWidth(rectangle.myGetStrokeWidth());
    }
    
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
     * Change the position of a rectangle changing
     * its top-left coordinates
     * @param topLeftX
     * @param topLeftY 
     */
    @Override
    public void moveShape(double topLeftX, double topLeftY) {
        MyRectangle newRectangle = (MyRectangle) this;
        
        double diffX = this.myGetLayoutBounds().getMaxX()-this.myGetLayoutBounds().getMinX(); 
        double diffY = this.myGetLayoutBounds().getMaxY()-this.myGetLayoutBounds().getMinY(); 
        
        newRectangle.mySetX(topLeftX-(diffX/2));
        newRectangle.mySetY(topLeftY-(diffY/2));
    }

    @Override
    public MyShape clone() {
        return new MyEnhancedRectangle(this);
    }
    
    @Override
    public double myGetLayoutX() {
        return super.getLayoutX();
    }

    @Override
    public double myGetLayoutY() {
        return super.getLayoutY();
    }
}
