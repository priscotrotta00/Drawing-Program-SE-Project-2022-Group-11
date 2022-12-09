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
    private double oldX;
    private double oldY;
    private double newX;
    private double newY;
    private MyShape shape;
    
    /**
     * Costructor. Initialize the shape and the old top left
     * coordinates of the shape with the shape coordinates.
     * @param shape 
     */
    public MoveShapeCommand(MyShape shape) {
        this.shape = shape;
        double diffX = this.shape.myGetLayoutBounds().getMaxX() - this.shape.myGetLayoutBounds().getMinX();
        double diffY = this.shape.myGetLayoutBounds().getMaxY() - this.shape.myGetLayoutBounds().getMinY();
        this.oldX = this.shape.myGetLayoutBounds().getMinX() + diffX/2;
        this.oldY = this.shape.myGetLayoutBounds().getMinY() + diffY/2;
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

    public double getOldX() {
        return oldX;
    }

    public void setOldX(double oldX) {
        this.oldX = oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public void setOldY(double oldY) {
        this.oldY = oldY;
    }

    public double getNewX() {
        return newX;
    }

    public void setNewX(double newX) {
        this.newX = newX;
    }

    public double getNewY() {
        return newY;
    }

    public void setNewY(double newY) {
        this.newY = newY;
    }

    public MyShape getShape() {
        return shape;
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }
    
    /**
     * This method calls the method moveShape passing as values this newX and
     * newY and than it change this oldX and oldY value with newX and newY
     */
    @Override
    public void execute() {
        shape.moveShape(this.newX, this.newY);
                
    }
    
    /**
     * This method calls the method moveShape passing as values this oldX and
     * oldY and than it change this newX and newY value with oldX and oldY
     */
    @Override
    public void undo() {
        shape.moveShape(this.oldX, this.oldY);
        
    }
    
    

}
