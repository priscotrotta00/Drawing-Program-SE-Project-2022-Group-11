/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.commands.exceptions.NoNewCoordinatesException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;

/**
 *
 * @author utente
 */
public class ResizeLineCommand implements ResizeShapeCommand{
    private final MyLine shape;
    
    private final Double oldStartX;
    private final Double oldStartY;
    private final Double oldEndX;
    private final Double oldEndY;
    
    private Double newStartX = null;
    private Double newStartY = null;
    private Double newEndX = null;
    private Double newEndY = null;
    
    public ResizeLineCommand(MyLine shape){
        this.shape = shape;
        this.oldStartX = shape.myGetStartX();
        this.oldStartY = shape.myGetStartY();
        this.oldEndX = shape.myGetEndX();
        this.oldEndY = shape.myGetEndY();
    }
    
    public ResizeLineCommand(
            MyLine shape, 
            double newStartX, 
            double newStartY, 
            double newEndX, 
            double newEndY
    ){
        this(shape);
        this.newStartX = newStartX;
        this.newStartY = newStartY;
        this.newEndX = newEndX;
        this.newEndY = newEndY;
    }
    
    public void setNewCoordinates(
            double newStartX, 
            double newStartY, 
            double newEndX, 
            double newEndY
    ){
        this.newStartX = newStartX;
        this.newStartY = newStartY;
        this.newEndX = newEndX;
        this.newEndY = newEndY;
    }
    
    private boolean isANewCoordinateNull() {
        return this.newStartX == null 
                || this.newStartY == null 
                || this.newEndX == null 
                || this.newEndY == null;
    }

    @Override
    public void execute() {
        if (this.isANewCoordinateNull()) throw new NoNewCoordinatesException();
        this.shape.modifyShape(
                newStartX, 
                newStartY, 
                newEndX, 
                newEndY
        );
    }

    @Override
    public void undo() {
        this.shape.modifyShape(oldStartX, 
                oldStartY, 
                oldEndX, 
                oldEndY
        );
    }
}
