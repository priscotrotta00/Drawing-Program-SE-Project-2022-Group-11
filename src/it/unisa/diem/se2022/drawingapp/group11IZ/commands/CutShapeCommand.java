/**
 * Implementation of cutting of a shape
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 *
 * @author daddy
 */
public class CutShapeCommand implements Command{
    private final MyShape cuttedShape;
    private final Canvas canvas;
    
    /**
     * Costructor
     * @param cuttedShape
     * @param canvas 
     */
    public CutShapeCommand(MyShape cuttedShape, Canvas canvas) {
        this.cuttedShape = cuttedShape;
        this.canvas = canvas;
    }

    /**
     * Execute the cut operation on the cutted Shape
     */
    @Override
    public void execute() {
        this.canvas.removeShape(this.cuttedShape);
        this.canvas.copyShape(this.cuttedShape);
    }

    /**
     * Add the cutted shape again in the drawing
     */
    @Override
    public void undo() {
        this.canvas.addShape(this.cuttedShape);
    }
    
}
