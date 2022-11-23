/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author daddy
 */
public class Selection implements Visitor{
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
    
    public void select(MyEnhancedEllipse myEnhancedEllipse){
        setSelectedItem(myEnhancedEllipse);
        
        
    }
    
    public void select(MyEnhancedLine myEnhancedLine){}
    
    public void select(MyEnhancedRectangle myEnhancedRectangle){
        setSelectedItem(myEnhancedRectangle);
        
        double x = myEnhancedRectangle.myGetX();
        double y = myEnhancedRectangle.myGetY();
        double width = myEnhancedRectangle.myGetWidth();
        double height = myEnhancedRectangle.myGetHeight();
        
        MyEnhancedRectangle newRectangle = new MyEnhancedRectangle();
        
        newRectangle.mySetX(x);
        newRectangle.mySetY(y);
        newRectangle.mySetWidth(width);
        newRectangle.mySetHeight(height);
        
        newRectangle.mySetFill(Color.TRANSPARENT);
        
        newRectangle.setStrokeWidth(myEnhancedRectangle.getStrokeWidth()+2);
        
        selectionBorder.getChildren().add(newRectangle);
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
