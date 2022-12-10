/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 *
 * @author saram
 */
public class DeleteShapeCommand implements Command {
    private Canvas canvas;
    private MyShape shape;
    private int layerShape;
    
    /**
     * constructor of Delete Command
     * @param canvas
     * @param shape 
     */
    public DeleteShapeCommand(Canvas canvas, MyShape shape) {
        this.canvas = canvas;
        this.shape=shape;
        this.layerShape=this.canvas.getDraw().getShapeLayer(shape);
        
    }
    /**
     * Execute the command and remove the previously passed shape in the drawing
     */
    @Override
    public void execute() {
        this.canvas.removeShape(shape);
        
    }

    /**
     * Undo the Remove shape action, so the previously passed shape will be added
     * in the drawing
     */
    @Override
    public void undo() {
        //this.canvas.addShape(shape);
        //change layer
        //this.canvas.getDraw().moveToLayer(shape, layerShape);
        this.canvas.moveToLayer2(shape, layerShape);
    }
    
}
