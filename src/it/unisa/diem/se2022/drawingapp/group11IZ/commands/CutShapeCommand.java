/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 *
 * @author daddy
 */
public class CutShapeCommand implements Command{
    private MyShape cuttedShape;
    private Canvas canvas;

    public CutShapeCommand(MyShape cuttedShape, Canvas canvas) {
        this.cuttedShape = cuttedShape;
        this.canvas = canvas;
    }

    /*public MyShape getCuttedShape() {
        return cuttedShape;
    }

    public void setCuttedShape(MyShape cuttedShape) {
        this.cuttedShape = cuttedShape;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }*/

    @Override
    public void execute() {
        this.canvas.removeShape(this.cuttedShape);
        
        this.canvas.copyShape(this.cuttedShape);
        
    }

    @Override
    public void undo() {
        
        this.canvas.addShape(this.cuttedShape);
        
    }
    
}
