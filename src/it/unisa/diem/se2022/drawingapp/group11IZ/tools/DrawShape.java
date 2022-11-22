/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 *
 * @author utente
 */
public abstract class DrawShape implements Tool{
    private double startX, startY;
    private double endX, endY;

    @Override
    public void handleOnDragBegin(Controller c, MouseEvent event) {
        this.startX = event.getX();
        this.startY = event.getY();
    }

    @Override
    public void handleOnMouseDrag(Controller c, MouseEvent event) {
        
    }

    @Override
    public void handleOnDragEnd(Controller c, MouseEvent event) {
        double topLeftX, topLeftY, bottomRightX, bottomRightY;
        Shape shape;
        
        this.endX = event.getX();
        this.endY = event.getY();
        
        topLeftX = this.calculateTopLeftX(startX, startY, endX, endY);
        topLeftY = this.calculateTopLeftY(startX, startY, endX, endY);
        bottomRightX = this.calculateBottomRightX(startX, startY, endX, endY);
        bottomRightY = this.calculateBottomRightY(startX, startY, endX, endY);
        
        shape = this.createShape(topLeftX, topLeftY, bottomRightX, bottomRightY);
        
        //c.addShape(shape);
    }

    @Override
    public void handleOnPrimaryMouseClick(Controller c, MouseEvent event) {
        
    }

    @Override
    public void handleOnSecondaryMouseClick(Controller c, MouseEvent event) {
        
    }
    
    /**
     * Method that calculate the top left X coordinate according to the diagonal
     * drawn with the mouse during a Mouse drag operation
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return 
     */
    public double calculateTopLeftX(double startX, double startY, double endX, double endY){
        return startX < endX ? startX : startX == endX ? startX : endX;
    }
    
    /**
     * Method that calculate the top left Y coordinate according to the diagonal
     * drawn with the mouse during a Mouse drag operation
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return 
     */
    public double calculateTopLeftY(double startX, double startY, double endX, double endY){
        return startY < endY ? startY : startY == endY ? startY : endY;
    }
    
    /**
     * Method that calculate the bottom right X coordinate according to the diagonal
     * drawn with the mouse during a Mouse drag operation
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return 
     */
    public double calculateBottomRightX(double startX, double startY, double endX, double endY){
        return endX > startX ? endX : endX == startX ? endX : startX;
    }
    
    /**
     * Method that calculate the bottom right Y coordinate according to the diagonal
     * drawn with the mouse during a Mouse drag operation
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return 
     */
    public double calculateBottomRightY(double startX, double startY, double endX, double endY){
        return endY > startY ? endY : endY == startY ? endY : startY;
    }
    
    public abstract Shape createShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY);
    
}
