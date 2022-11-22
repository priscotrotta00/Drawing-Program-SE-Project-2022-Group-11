/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.models.MyShape;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.scene.Group;

/**
 *
 * @author daddy
 */
public class Selection {
    private Group selectionBorder;
    private MyShape selectedItem;
    private ObservableBooleanValue selected;

    public Selection() {
        this.selectionBorder = null;
        this.selectedItem = null;
        this.selected = new SimpleBooleanProperty();
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

    public void setSelected(ObservableBooleanValue selected) {
        this.selected = selected;
    }
    
    public void select(MyShape shape){
        setSelectedItem(shape);
    }
    
    public void unSelect(){
        setSelectedItem(null);
    }
    
    public ObservableBooleanValue selectedProperty(){
        return getSelected();
    }
    
}
