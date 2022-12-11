/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.paint.Color;

/**
 * Class that represents the "Change fill color of a shape" Command that will be executed by
 * the Command Executor Invoker, according to the Command Pattern
 * @author prisc
 */
public class ChangeFillColorCommand extends ChangeColorCommand{   

    /**
     * Create a new ChangeFillColorCommand
     * @param canvas Canvas that represents the Receiver of the action. It contains the logic for modifying the shape
     * @param myShape Shape whose fill color needs to be changed
     * @param newColor The new fill color of the shape
     */
    public ChangeFillColorCommand(Canvas canvas, MyShape myShape, Color newColor) {
        super.setMyShape(myShape);
        super.setNewColor(newColor);
        super.setCanvas(canvas);
    }
        
    /**
     * Change the fill color of the shape with the color
     * passed as parameter
     * @param color New fill color
     */
    @Override
    public void changeColor(Color color) {
        super.getCanvas().changeShapeFillColor(this.getMyShape(), color);
    }
    
}
