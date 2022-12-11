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
public class MoveForegroundShapeCommand implements Command {
    
    private final Canvas canvas;
    private final MyShape shape;
    private final int layerShape;
    
    /**
     * constructor of MoveForegroundShapeCommand
     * @param controller
     * @param shape 
     */
    public MoveForegroundShapeCommand(Canvas controller, MyShape shape) {
        this.canvas=controller;
        this.shape=shape;
        this.layerShape=this.canvas.getDraw().getShapeLayer(shape);
        
    }
    /**
     * Execute MoveForeground
     */
    @Override
    public void execute() {
        this.canvas.moveShapeToForeground(shape);  
    }

    /**
     * Undo of operation
     */
    @Override
    public void undo() {
        this.canvas.moveToLayer(shape, this.layerShape,true); 
    }
    
}
