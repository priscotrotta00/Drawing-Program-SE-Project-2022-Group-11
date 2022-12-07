/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saram
 */
public class DeleteShapeCommand implements Command {
    
    private Controller controller;
    private MyShape shape;
    private int layerShape;
    
    /**
     * constructor of Delete Command
     * @param controller
     * @param shape 
     */
    public DeleteShapeCommand(Controller controller, MyShape shape) {
        this.controller=controller;
        this.shape=shape;
        this.layerShape=this.controller.getDraw().getShapeLayer(shape);
        
    }
    /**
     * Execute the command and remove the previously passed shape in the drawing
     */
    @Override
    public void execute() {
        this.controller.removeShape(shape);
        
    }

    /**
     * Undo the Remove shape action, so the previously passed shape will be added
     * in the drawing
     */
    @Override
    public void undo() {
        this.controller.addShape(shape);
        //change layer
        this.controller.getDraw().moveToLayer(shape, layerShape);
        
    }
    
}
