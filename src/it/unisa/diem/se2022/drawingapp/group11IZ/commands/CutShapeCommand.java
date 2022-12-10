/**
 * Implementation of cutting of a shape
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
    
    /**
     * Costructor
     * @param cuttedShape
     * @param controller 
     */
    public CutShapeCommand(MyShape cuttedShape, Controller controller) {
        this.cuttedShape = cuttedShape;
        this.controller = controller;
    }

    /**
     * Execute the cut operation on the cutted Shape
     */
    @Override
    public void execute() {
        this.controller.removeShape(this.cuttedShape);
        this.controller.copyShape(this.cuttedShape);
    }

    /**
     * Add the cutted shape again in the drawing
     */
    @Override
    public void undo() {
        this.controller.addShape(this.cuttedShape);
    }
    
}
