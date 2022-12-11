package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.commands.exceptions.NoNewCoordinatesException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 * Class that represents the "Resize a Shape" Command that will be executed by
 * the Command Executor Invoker, according to the Command Pattern
 * @author Felice Scala
 */
public class ResizeShapeCommand implements Command{
    private final MyShape shape;
    private final MyShape.Snapshot snapshot;
    
    private Double newTopLeftX = null;
    private Double newTopLeftY = null;
    private Double newBottomRightX = null;
    private Double newBottomRightY = null;
    
    /**
     * Creates a new Resize Shape Command, given the rectangle on which the 
     * action will be performed
     * @param shape 
     */
    public ResizeShapeCommand(MyShape shape){
        this.shape = shape;
        this.snapshot = shape.getSnapshot();
    }
    
    /**
     * Creates a new Resize Shape Command, given the shape and its new 
     * coordinates
     * @param shape
     * @param newTopLeftX
     * @param newTopLeftY
     * @param newBottomRightX
     * @param newBottomRightY 
     */
    public ResizeShapeCommand(
            MyShape shape, 
            double newTopLeftX, 
            double newTopLeftY, 
            double newBottomRightX, 
            double newBottomRightY
    ){
        this(shape);
        this.newTopLeftX = newTopLeftX;
        this.newTopLeftY = newTopLeftY;
        this.newBottomRightX = newBottomRightX;
        this.newBottomRightY = newBottomRightY;
    }
    
    /**
     * Defines (again) the new coordinates of the shape
     * @param newTopLeftX
     * @param newTopLeftY
     * @param newBottomRightX
     * @param newBottomRightY 
     */
    public void setNewCoordinates(
            double newTopLeftX, 
            double newTopLeftY, 
            double newBottomRightX, 
            double newBottomRightY
    ){
        this.newTopLeftX = newTopLeftX;
        this.newTopLeftY = newTopLeftY;
        this.newBottomRightX = newBottomRightX;
        this.newBottomRightY = newBottomRightY;
    }
    
    /**
     * Checks if all new coordinates were given
     * @return True is everything has been given
     */
    private boolean isANewCoordinateNull() {
        return this.newTopLeftX == null 
                || this.newTopLeftY == null 
                || this.newBottomRightX == null 
                || this.newBottomRightY == null;
    }

    /**
     * Executes the action, so the shape will be resized.
     */
    @Override
    public void execute() {
        if (this.isANewCoordinateNull()) throw new NoNewCoordinatesException();
        this.shape.modifyShape(
                newTopLeftX, 
                newTopLeftY, 
                newBottomRightX, 
                newBottomRightY
        );
    }

    /**
     * Undo the operation, so the shape will gain its previous size.
     */
    @Override
    public void undo() {
        this.snapshot.restore();
    }
    
}
