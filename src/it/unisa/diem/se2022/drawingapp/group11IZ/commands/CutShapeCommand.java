/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.clipboard.Clipboard;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.Node;

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
        
        // metodo per aggiungere la figura nella clipboard
    }

    @Override
    public void undo() {
        // prendere la clipboard dal controller, prendere l'elemento uguale a
        // quello che tengo in questa istanza del cut
        // aggiungere tale shape dinuovo nel Pane e Drawing e toglierlo
        // dalla clipboard
    }
    
}
