package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 * Class that represents the "Create a Shape" Command that will be executed by
 * the Command Executor Invoker, according to the Command Pattern
 * @author Felice Scala
 */
public class CreateShapeCommand implements Command{
    private final Canvas canvas;
    private final MyShape shape;

    /**
     * Create a new CreateShapeCommand, giving the receiver of the action and
     * parameters it requests
     * @param canvas Receiver of the action
     * @param shape Shape to be added to the drawing
     */
    public CreateShapeCommand(Canvas canvas, MyShape shape) {
        //Retrieve receiver and parameters
        this.canvas = canvas;
        this.shape = shape;
    }
    
    /**
     * Execute the command and add the previously given shape in the drawing
     */
    @Override
    public void execute() {
        // Add shape to the Canvas, so in the Drawing and in the View
        this.canvas.addShape(shape);
    }

    /**
     * Undo the Add shape action, so the previously given shape will be deleted
     * from the drawing
     */
    @Override
    public void undo() {
        // Remove shape from Canvas
        this.canvas.removeShape(shape);
    }
    
}
