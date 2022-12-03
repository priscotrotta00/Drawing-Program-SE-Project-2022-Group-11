/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.clipboard;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author saram
 */
public class Clipboard {
    private MyShape myShape;
    private BooleanProperty copied;
    
    public Clipboard(){
        
        copied=new SimpleBooleanProperty(false);
        this.myShape=null;
    }
    
    /**
     * Save shape in clipboard
     * @param shape 
     */
    public void copy(MyShape shape){
        this.myShape=shape;
        this.copied.setValue(Boolean.TRUE);
    }
    
    /**
     * Obtain the salved shape
     * @return 
     */
    public MyShape getNewCopy(){
        return this.myShape;
    }
    
    /**
     * Clear clipboard, so delete saved shape
     */
    public void clear(){
        this.copied.setValue(false);
        this.myShape=null;
    }
    
    /**
     * For obtain ReadOnlyBooleanProperty
     * @return 
     */
    public ReadOnlyBooleanProperty copiedProperty(){
       // return ReadOnlyBooleanProperty.readOnlyBooleanProperty(copied);
       return (ReadOnlyBooleanProperty)copied;
    }
    
    /**
     * Return False if clipboard is empty, true in the other case
     * @return 
     */
    public boolean hasCopiedShape(){
        return this.copied.getValue();
       // return this.copied.get();
    }
}