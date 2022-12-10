/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.paint.Color;

/**
 * Class that represents the "Change stroke color of a shape" Command that will be executed by
 * the Command Executor Invoker, according to the Command Pattern
 * @author prisc
 */
public class ChangeStrokeColorCommand extends ChangeColorCommand{  

    /**
     * Create a new ChangeStrokeColorCommand
     * @param myShape Shape whose stroke color needs to be changed
     * @param newColor The new stroke color of the shape
     */
    
    public ChangeStrokeColorCommand(MyShape myShape, Color newColor) {
        super.setMyShape(myShape);
        super.setNewColor(newColor);
    }
    
    /**
     * Change the stroke color of the shape with the color
     * passed as parameter
     * @param color new fill color
     */
    
    @Override
    public void changeColor(Color color) {
        super.getMyShape().mySetStroke(color);
    }
    
}
