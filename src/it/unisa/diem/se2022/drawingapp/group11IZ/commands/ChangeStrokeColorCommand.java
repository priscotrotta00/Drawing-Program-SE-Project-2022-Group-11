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
public class ChangeStrokeColorCommand extends ChangeColorCommand{  

    public ChangeStrokeColorCommand(MyShape myShape, Color newColor) {
        super.setMyShape(myShape);
        super.setNewColor(newColor);
        super.setOldColor((Color) myShape.myGetStroke());
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
