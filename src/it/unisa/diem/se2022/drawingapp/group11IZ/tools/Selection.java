/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.models.MyShape;
import javafx.beans.value.ObservableBooleanValue;
import javafx.scene.Group;

/**
 *
 * @author daddy
 */
public class Selection {
    private static Group selectionBorder;
    private static MyShape selectedItem;
    private static ObservableBooleanValue selected;

    public Selection() {
        this.selectionBorder = null;
        this.selectedItem = null;
        this.selected = null;
    }

    public static Group getSelectionBorder() {
        return selectionBorder;
    }

    public static void setSelectionBorder(Group selectionBorder) {
        Selection.selectionBorder = selectionBorder;
    }

    public static MyShape getSelectedItem() {
        return selectedItem;
    }

    public static void setSelectedItem(MyShape selectedItem) {
        Selection.selectedItem = selectedItem;
    }

    public static ObservableBooleanValue getSelected() {
        return selected;
    }

    public static void setSelected(ObservableBooleanValue selected) {
        Selection.selected = selected;
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
