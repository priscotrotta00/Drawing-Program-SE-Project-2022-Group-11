/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author daddy
 */
public class Selection {
    private Group selectionBorder;
    private MyShape selectedItem;
    private BooleanProperty selected;

    public Selection() {
        this.selectionBorder = new Group();
        this.selectedItem = null;
        this.selected = new SimpleBooleanProperty(false);
    }

    public Group getSelectionBorder() {
        return selectionBorder;
    }

    public void setSelectionBorder(Group selectionBorder) {
        this.selectionBorder = selectionBorder;
    }

    public MyShape getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(MyShape selectedItem) {
        this.selectedItem = selectedItem;
    }

    public ObservableBooleanValue getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected.set(selected);
    }
    
    /*public void select(MyEnhancedEllipse myEnhancedEllipse){
        setSelectedItem(myEnhancedEllipse);
        
        
    }
    
    public void select(MyEnhancedLine myEnhancedLine){
        setSelectedItem(myEnhancedLine);
        
        
        
    }
    
    public void select(MyEnhancedRectangle myEnhancedRectangle){
        double x, y, width, height;
        MyEnhancedRectangle newRectangle = new MyEnhancedRectangle();;
        
        setSelectedItem(myEnhancedRectangle);
        
        x = myEnhancedRectangle.myGetX();
        y = myEnhancedRectangle.myGetY();
        width = myEnhancedRectangle.myGetWidth();
        height = myEnhancedRectangle.myGetHeight();
        
        newRectangle.mySetX(x);
        newRectangle.mySetY(y);
        newRectangle.mySetWidth(width);
        newRectangle.mySetHeight(height);
        
        newRectangle.mySetFill(Color.TRANSPARENT);
        newRectangle.mySetStroke(Color.BLACK);
        
        newRectangle.setStrokeWidth(myEnhancedRectangle.getStrokeWidth()+2);
        
        selectionBorder.getChildren().add(newRectangle);
        setSelected(true);
        
    }*/
    
    public void select(MyRectangle myRectangle){
        MyRectangle newRectangle = new MyEnhancedRectangle();
        
        setSelectedItem(myRectangle);
        
        newRectangle.myXProperty().bind(myRectangle.myXProperty());
        newRectangle.myYProperty().bind(myRectangle.myYProperty());
        newRectangle.myHeightProperty().bind(myRectangle.myHeightProperty());
        newRectangle.myWidthProperty().bind(myRectangle.myHeightProperty());
        
        newRectangle.mySetFill(Color.TRANSPARENT);
        newRectangle.mySetStroke(Color.BLACK);
        
        newRectangle.mySetStrokeWidth(myRectangle.myGetStrokeWidth()+2);
        
        selectionBorder.getChildren().add((Shape)newRectangle);
        
        Parent parent = myRectangle.myGetParent();
        
        if(!(parent instanceof Pane)) return;
        
        Pane pane = (Pane) parent;
        pane.getChildren().add((Shape)newRectangle);
        
        
        setSelected(true);
        
    }
    
    public void select(MyLine myLine){
        MyLine newLine = new MyEnhancedLine();;
        
        setSelectedItem(myLine);
        
        newLine.myStartXProperty().bind(myLine.myStartXProperty());
        newLine.myStartYProperty().bind(myLine.myStartYProperty());
        newLine.myEndXProperty().bind(myLine.myEndXProperty());
        newLine.myEndYProperty().bind(myLine.myEndYProperty());
        
        newLine.mySetFill(Color.TRANSPARENT);
        newLine.mySetStroke(Color.BLACK);
        
        newLine.mySetStrokeWidth(myLine.myGetStrokeWidth()+2);
        
        selectionBorder.getChildren().add((Shape)newLine);
        
        Parent parent = myLine.myGetParent();
        
        if(!(parent instanceof Pane)) return;
        
        Pane pane = (Pane) parent;
        pane.getChildren().add((Shape)newLine);
        
        setSelected(true);
        
    }
    
    public void select(MyEllipse myEllipse){
        MyEllipse newEllipse = new MyEnhancedEllipse();
        
        setSelectedItem(myEllipse);
        
        newEllipse.myCenterXProperty().bind(myEllipse.myCenterXProperty());
        newEllipse.myCenterYProperty().bind(myEllipse.myCenterYProperty());
        newEllipse.myRadiusXProperty().bind(myEllipse.myRadiusXProperty());
        newEllipse.myRadiusYProperty().bind(myEllipse.myRadiusYProperty());
        
        newEllipse.mySetFill(Color.TRANSPARENT);
        newEllipse.mySetStroke(Color.BLACK);
        
        newEllipse.mySetStrokeWidth(myEllipse.myGetStrokeWidth()+2);
        
        selectionBorder.getChildren().add((Shape)newEllipse);
        Parent parent = myEllipse.myGetParent();
        
        if(!(parent instanceof Pane)) return;
        
        Pane pane = (Pane) parent;
        pane.getChildren().add((Shape)newEllipse);
        
        setSelected(true);
        
    }
    
    
    
    public void unSelect(){
        setSelectedItem(null);
        setSelected(false);
        selectionBorder.getChildren().removeAll();
    }
    
    public ObservableBooleanValue selectedProperty(){
        return getSelected();
    }
    
}
