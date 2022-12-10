/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.Node;

/**
 *
 * @author saram
 */
public class MoveForegroundShapeCommand implements Command {
    
    private Canvas canvas;
    private MyShape shape;
    private int layerShape;
    
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
        this.canvas.removeShape(shape);
        //for draw
        this.canvas.getDraw().addShape(shape);
        this.canvas.getDraw().moveToLayer(shape, layerShape);
        //for drawpane
        this.canvas.getDrawPane().getChildren().add(layerShape, (Node)shape);

    }
    
}
