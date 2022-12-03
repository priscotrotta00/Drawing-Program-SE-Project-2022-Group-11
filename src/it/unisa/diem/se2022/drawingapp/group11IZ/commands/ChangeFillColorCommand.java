/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author prisc
 */
public class ChangeFillColorCommand extends ChangeColorCommand{   

    public ChangeFillColorCommand(MyShape myShape, Color newColor) {
        super.setMyShape(myShape);
        super.setNewColor(newColor);
        super.setOldColor((Color) myShape.myGetFill());
    }
        
    /**
     * Change the fill color of the shape with the color
     * passed as parameter
     * @param color new fill color
     */
    
    @Override
    public void changeColor(Color color) {
        super.getMyShape().mySetFill(color);
    }
    
}