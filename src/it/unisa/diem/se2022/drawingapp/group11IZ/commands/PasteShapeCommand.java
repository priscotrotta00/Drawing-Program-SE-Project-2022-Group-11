/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 * Class that represents the "Paste shape" Command that will be executed by
 * the Command Executor Invoker, according to the Command Pattern
 * @author prisc
 */
public class PasteShapeCommand implements Command{

    private Canvas canvas;
    private MyShape shape;

    /**
     * Create a new PasteShapeCommand
     * @param canvas The canvas on which you need to execute the commands
     * @param shape The shape that must be pasted
     */
    
    public PasteShapeCommand(Canvas canvas, MyShape shape) {
        if (canvas == null || shape == null) throw new NullPointerException();
        this.canvas = canvas;
        this.shape = shape;
        this.shape.moveShape(100.0, 100.0);
    }
    
    @Override
    public void execute() { //Add a new shape on the top let of the drawing
        this.canvas.addShape(shape);
    }

    @Override
    public void undo() {    //Remove from the drawing the last pasted shape
        this.canvas.removeShape(shape);
    }
    
}
