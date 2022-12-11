package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 * The class MoveShapeCommand handle changing position of shape
 * @author daddy
 */
public class MoveShapeCommand implements Command{
    private double newX;
    private double newY;
    private final MyShape shape;
    private final MyShape.Snapshot snapshot;
    
    /**
     * Costructor. Initialize the shape and creates
     * @param shape 
     */
    public MoveShapeCommand(MyShape shape) {
        this.shape = shape;;
        this.snapshot = shape.getSnapshot();
    }
    
    /**
     * Sets the new coordinates. Values newX and NewY are
     * passed as parameter.
     * @param newX
     * @param newY 
     */
    public void setNewCoordinates(double newX, double newY){
        this.newX = newX;
        this.newY = newY;
    }
    
    /**
     * This method calls the method moveShape passing as values this newX and
     * newY
     */
    @Override
    public void execute() {
        shape.moveShape(this.newX, this.newY);
    }
    
    /**
     * Restore the original state of the shape thanks to the 
     * snapshot the commands creates when it is created.
     */
    @Override
    public void undo() {
        snapshot.restore();
    }

}
