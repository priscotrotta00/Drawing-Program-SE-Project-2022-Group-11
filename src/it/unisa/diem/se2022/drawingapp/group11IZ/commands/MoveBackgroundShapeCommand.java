/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.Node;

/**
 *
 * @author saram
 */
public class MoveBackgroundShapeCommand implements Command {

    private Controller controller;
    private MyShape shape;
    private int layerShape;
    
    /**
     * constructor of MoveBackgroundShape
     * @param controller
     * @param shape 
     */
    public MoveBackgroundShapeCommand(Controller controller, MyShape shape) {
        this.controller=controller;
        this.shape=shape;
        this.layerShape=this.controller.getDraw().getShapeLayer(shape);
        
    }
    @Override
    public void execute() {
        this.controller.moveShapeToBackground(shape);
    }

    @Override
    public void undo() {
        this.controller.removeShape(shape);
        //for draw
        this.controller.getDraw().addShape(shape);
        this.controller.getDraw().moveToLayer(shape, layerShape);
        //for drawpane
        this.controller.getDrawPane().getChildren().add(layerShape, (Node)shape);
    }
    
}
