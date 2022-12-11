package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 * Implementation of cutting of a shape
 * @author daddy
 */
public class CutShapeCommand implements Command{
    private MyShape cuttedShape;
    private Canvas canvas;
    
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
        // Remove the shape from the canvas and put a copy inside the clipboard
        this.canvas.removeShape(this.cuttedShape);
        this.canvas.copyShape(this.cuttedShape);
    }

    /**
     * Add the cutted shape again in the drawing
     */
    @Override
    public void undo() {
        // Add again the shape inside the Canvas
        this.canvas.addShape(this.cuttedShape);
        
    }
    
}
