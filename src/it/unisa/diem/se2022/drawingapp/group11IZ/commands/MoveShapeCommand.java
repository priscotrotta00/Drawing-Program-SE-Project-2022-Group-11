/**
 * The class MoveShapeCommand handle changing position of shape
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 *
 * @author daddy
 */
public class MoveShapeCommand implements Command{
    private double newX;
    private double newY;
    private final MyShape shape;
    private final MyShape.Snapshot snapshot;
    
    /**
     * Costructor. Initialize the shape and the old top left
     * coordinates of the shape with the shape coordinates.
     * @param shape 
     */
    public MoveShapeCommand(MyShape shape) {
        this.shape = shape;
        double diffX = this.shape.myGetLayoutBounds().getMaxX() - this.shape.myGetLayoutBounds().getMinX();
        double diffY = this.shape.myGetLayoutBounds().getMaxY() - this.shape.myGetLayoutBounds().getMinY();
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
     * This method calls the method moveShape passing as values this oldX and
     * oldY
     */
    @Override
    public void undo() {
        snapshot.restore();
    }

}
