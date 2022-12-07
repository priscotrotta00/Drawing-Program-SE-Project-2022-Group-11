/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 *
 * @author prisc
 */
public class PasteShapeCommand implements Command{

    private Controller controller;
    private MyShape shape;

    public PasteShapeCommand(Controller controller, MyShape shape) {
        if (controller == null || shape == null) throw new NullPointerException();
        this.controller = controller;
        this.shape = shape;
        this.shape.mySetLayoutX(0);
        this.shape.mySetLayoutY(0);
    }
    
    @Override
    public void execute() {
        this.controller.addShape(shape);
    }

    @Override
    public void undo() {
        this.controller.removeShape(shape);
    }
    
}
