/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 * Class that represents the "Create a Shape" Command that will be executed by
 * the Command Executor Invoker, according to the Command Pattern
 * @author utente
 */
public class CreateShapeCommand implements Command{
    private Controller controller;
    private MyShape shape;

    /**
     * Create a new CreateShapeCommand, giving the receveir of the action and
     * parameters it requests
     * @param controller Receiver of the action
     * @param shape Shape to be added to the drawing
     */
    public CreateShapeCommand(Controller controller, MyShape shape) {
        //Retrieve receiver and parameters
        this.controller = controller;
        this.shape = shape;
    }
    
    /**
     * Execute the command and add the previously passed shape in the drawing
     */
    @Override
    public void execute() {
        this.controller.addShape(shape);
    }

    /**
     * Undo the Add shape action, so the previously passed shape will be deleted
     * from the drawing
     */
    @Override
    public void undo() {
        this.controller.removeShape(shape);
    }
    
}
