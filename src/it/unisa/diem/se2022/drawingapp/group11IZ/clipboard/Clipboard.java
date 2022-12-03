/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.clipboard;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;

/**
 *
 * @author saram
 */
public class Clipboard {
    private MyShape myShape;
    private BooleanProperty copied;
    
    public void copy(MyShape shape){
        
    }
    public MyShape getNewCopy(){
        return null;
    }
    
    public void clear(){
        
    }
    public ReadOnlyBooleanProperty copiedProperty(){
        return null;
    }
    
    public boolean hasCopiedShape(){
        return this.copied.get();
    }
}