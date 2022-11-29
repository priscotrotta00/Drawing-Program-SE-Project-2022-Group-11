/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 *
 * @author utente
 */
public class CreateShapeCommand implements Command{
    private Controller controller;
    private MyShape shape;

    public CreateShapeCommand(Controller controller, MyShape shape) {
        this.controller = controller;
        this.shape = shape;
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
