/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.paint.Color;

/**
 * Class that represents the "Change color of a shape" Command that will be executed by
 * the Command Executor Invoker, according to the Command Pattern. The class is abstract. 
 * So it is extended by concrete classes for the "Change Stroke Color" and the "Change Fill Color" Command.
 * @author prisc
 */
public abstract class ChangeColorCommand implements Command{
    private MyShape myShape;
    private MyShape.Snapshot snapshot;
    private Canvas canvas;
    private Color newColor;
    
    /**
     * Return the object myshape
     * @return The object myshape that represents the shape whose color is changed
     */
    MyShape getMyShape() {
        return myShape;
    }

    /**
     * Set the object myShape with the passed parameter
     * @param myShape The object myShape whose color you want to change
     */
    void setMyShape(MyShape myShape) {
        if(myShape == null) throw new NullPointerException();
        this.myShape = myShape;
        this.snapshot = myShape.getSnapshot();
    }
    
    /**
     * Return the object newColor
     * @return Object newcolor that represents the new color for the shape
     */
    Color getNewColor() {
        return this.newColor;
    }

    /**
     * Set the object newColor with the passed parameter
     * @param newColor The object newColor that you want to set for the shape
     */
    void setNewColor(Color newColor) {
        if(newColor == null) throw new NullPointerException();
        this.newColor = newColor;
    }
    
    /**
     * Return the object canvas
     * @return Object canvas that represents the Receiver of the action
     */
    Canvas getCanvas(){
        return canvas;
    }
    
    /**
     * Set the object canvas with the passed parameter
     * @param canvas The object canvas that contains the shape whose you want to change the color
     */
    void setCanvas(Canvas canvas){
        this.canvas = canvas;
    }
    
    /**
     * Abstract method implemented by subclasses that changes the stroke/fill color of the shape
     * with the color passed as parameter
     * @param color The new color you want to add to the figure
     */    
    public abstract void changeColor(Color color);
    
    /**
     * Executes the changeColorCommand method: it changes the color of the shape passed in the constructor
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
