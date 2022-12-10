/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.paint.Color;

/**
 *
 * @author prisc
 */
public abstract class ChangeColorCommand implements Command{
    private MyShape myShape;
    private MyShape.Snapshot snapshot;
    private Color newColor;
    
    /**
     * Return the object myshape
     * @return the object myshape
     */
    
    MyShape getMyShape() {
        return myShape;
    }

    /**
     * Set the object myShape with the passed parameter
     * @param myShape the object myShape that you want to set
     */
    
    void setMyShape(MyShape myShape) {
        if(myShape == null) throw new NullPointerException();
        this.myShape = myShape;
        this.snapshot = myShape.getSnapshot();
    }
    
    /**
     * return the object newColor
     * @return object newcolor
     */
    
    Color getNewColor() {
        return this.newColor;
    }

    /**
     * Set the object newColor with the passed parameter
     * @param newColor the object newColor that you want to set
     */
    
    void setNewColor(Color newColor) {
        if(newColor == null) throw new NullPointerException();
        this.newColor = newColor;
    }
    
    /**
     * Abstract method implemented by subclasses that cange the stroke/fill color of the shape
     * with the color passed as parameter
     * @param color the object newColor that you want to set
     */    
    
    public abstract void changeColor(Color color);
    
    /**
     * Execute the changeColorCommand anche change the Color the previously passed shape in the drawing
     */
    
    @Override
    public void execute(){
        this.changeColor(this.newColor);
    }
    
    /**
     * Undo the last operation made on the color of the shape, so the previously passed shape will change
     * its color with the previous one
     */
    
    @Override
    public void undo(){
        this.snapshot.restore();
    }
    
}
