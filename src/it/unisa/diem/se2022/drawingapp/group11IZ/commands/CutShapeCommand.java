/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 *
 * @author daddy
 */
public class CutShapeCommand implements Command{
    private MyShape cuttedShape;
    private Controller controller;

    public CutShapeCommand(MyShape cuttedShape, Controller controller) {
        this.cuttedShape = cuttedShape;
        this.controller = controller;
    }

    public MyShape getCuttedShape() {
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
    }

    @Override
    public void execute() {
        this.controller.removeShape(this.cuttedShape);
        
        this.controller.copyShape(this.cuttedShape);
        
    }

    @Override
    public void undo() {
        this.controller.addShape(this.cuttedShape);
        
    }
    
}
