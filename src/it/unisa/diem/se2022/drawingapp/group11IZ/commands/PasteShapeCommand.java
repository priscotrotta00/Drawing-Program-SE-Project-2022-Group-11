package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 * Class that represents the "Paste shape" Command that will be executed by
 * the Command Executor Invoker, according to the Command Pattern
 * @author prisc
 */
public class PasteShapeCommand implements Command{

    private final Canvas canvas;
    private final MyShape shape;
    private final static double TOP_LEFT_X = 100.0;
    private final static double TOP_LEFT_Y = 100.0;

    /**
     * Create a new PasteShapeCommand
     * @param canvas The canvas on which you need to execute the commands
     * @param shape The shape that must be pasted
     */
    
    public PasteShapeCommand(Canvas canvas, MyShape shape) {
        if (canvas == null || shape == null) throw new NullPointerException();
        this.canvas = canvas;
        this.shape = shape;
        this.shape.moveShape(TOP_LEFT_X, TOP_LEFT_Y);
    }
    
    @Override
    public void execute() { //Add a new shape on the top let of the drawing
        this.canvas.addShape(shape);
    }

    @Override
    public void undo() {    //Remove from the drawing the last pasted shape
        this.canvas.removeShape(shape);
    }
    
}
