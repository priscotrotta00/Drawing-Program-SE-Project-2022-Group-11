/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.commands.exceptions.NoNewCoordinatesException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;

/**
 *
 * @author utente
 */
public class ResizeRectangleCommand implements ResizeShapeCommand{
    private final MyRectangle shape;
    
    private final Double oldTopLeftX;
    private final Double oldTopLeftY;
    private final Double oldBottomRightX;
    private final Double oldBottomRightY;
    
    private Double newTopLeftX = null;
    private Double newTopLeftY = null;
    private Double newBottomRightX = null;
    private Double newBottomRightY = null;
    
    public ResizeRectangleCommand(MyRectangle shape){
        this.shape = shape;
        this.oldTopLeftX = shape.getTopLeftX();
        this.oldTopLeftY = shape.getTopLeftY();
        this.oldBottomRightX = shape.getBottomRightX();
        this.oldBottomRightY = shape.getBottomRightY();
    }
    
    public ResizeRectangleCommand(
            MyRectangle shape, 
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
    
    private boolean isANewCoordinateNull() {
        return this.newTopLeftX == null 
                || this.newTopLeftY == null 
                || this.newBottomRightX == null 
                || this.newBottomRightY == null;
    }

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

    @Override
    public void undo() {
        this.shape.modifyShape(
                oldTopLeftX, 
                oldTopLeftY, 
                oldBottomRightX, 
                oldBottomRightY
        );
    }
    
}
