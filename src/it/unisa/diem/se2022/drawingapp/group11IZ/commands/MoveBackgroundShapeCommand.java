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
public class MoveBackgroundShapeCommand implements Command {

    private Canvas canvas;
    private MyShape shape;
    private int layerShape;
    
    /**
     * constructor of MoveBackgroundShape
     * @param canvas
     * @param shape 
     */
    public MoveBackgroundShapeCommand(Canvas canvas, MyShape shape) {
        this.canvas=canvas;
        this.shape=shape;
        this.layerShape=this.canvas.getDraw().getShapeLayer(shape);
        
    }
    /**
     * Execute the MoveBackground
     */
    @Override
    public void execute() {
        this.canvas.moveShapeToBackground(shape);
    }

    /**
     * Undo of operation MoveBackground
     */
    @Override
    public void undo() {
        this.canvas.moveToLayer(shape,this.layerShape,true);
          }
    
}
