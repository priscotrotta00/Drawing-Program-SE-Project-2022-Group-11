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
     * Costructor. Initialize the shape and the new top left
     * coordinates of the shape with the shape coordinates. 
     * Inizialize the old coordinates to zero
     * @param shape 
     */
    public MoveShapeCommand(MyShape shape) {
        this.shape = shape;
        this.newX = this.shape.myGetLayoutBounds().getMinX();
        this.newY = this.shape.myGetLayoutBounds().getMinY();
        this.oldX = this.oldY = 0.0;
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
     * This method handle the changing of new and old coordinates
     * of the shape
     */
    @Override
    public void execute() {
        this.oldX = this.newX;
        this.oldY = this.newY;
        this.newX = this.shape.myGetLayoutBounds().getMinX();
        this.newY = this.shape.myGetLayoutBounds().getMinY();
    }
    
    @Override
    public void undo() {
        //this.newX = this.oldX;
        //this.newY = this.oldY;  
    }
    
    

}
