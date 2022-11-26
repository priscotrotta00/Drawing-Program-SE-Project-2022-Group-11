/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

/**
 * Abstract class that represents a drawing shape tool, which defines the basic 
 * behavior
 * @author Felice Scala
 */
public abstract class DrawShapeTool implements Tool{
    private Double startX, startY;
    private Double endX, endY;
    private MyShape createdShape;
    
    MyShape getCreatedShape(){
        return this.createdShape;
    }
    
    void setCreatedShape(MyShape shape){
        this.createdShape = shape;
    }

    /**
     * Method that handle the OnDragDetected event genereated on the drawPane
     * @param c Controller
     * @param event Generated Event
     */
    @Override
    public void handleOnDragBegin(Controller c, MouseEvent event) {
        this.startX = event.getX();
        this.startY = event.getY();
        
        this.setCreatedShape(this.createShape(startX, startY, startX, startY));
        this.getCreatedShape().mySetVisible(true);
        try {
            c.addShape(createdShape);
        } catch (Exception ex) {
            Logger.getLogger(DrawShapeTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method that handle the OnMouseDragged event genereated on the drawPane
     * @param c Controller
     * @param event Generated Event
     */
    @Override
    public void handleOnMouseDrag(Controller c, MouseEvent event) {
        double topLeftX, topLeftY, bottomRightX, bottomRightY;
        
        this.endX = event.getX();
        this.endY = event.getY();
        
        if (this.startX == null || this.startY == null) return;
        
        topLeftX = this.calculateTopLeftX(startX, startY, endX, endY);
        topLeftY = this.calculateTopLeftY(startX, startY, endX, endY);
        bottomRightX = this.calculateBottomRightX(startX, startY, endX, endY);
        bottomRightY = this.calculateBottomRightY(startX, startY, endX, endY);
        
        this.modifyCreatedShape(topLeftX, topLeftY, bottomRightX, bottomRightY);
    }

    /**
     * Method that handle the OnMouseReleased event generated on the drawPane
     * after a MouseDragged event
     * @param c Controller
     * @param event Generated Event
     */
    @Override
    public void handleOnDragEnd(Controller c, MouseEvent event) {
        this.setCreatedShape(null);
        this.startX = null;
        this.startY = null;
        this.endX = null;
        this.endY = null;
    }

    @Override
    public void handleOnPrimaryMouseClick(Controller c, MouseEvent event) {
        //NOP
    }

    @Override
    public void handleOnContextMenuRequested(Controller c, ContextMenuEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    double calculateTopLeftX(double startX, double startY, double endX, double endY){
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
    double calculateTopLeftY(double startX, double startY, double endX, double endY){
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
    double calculateBottomRightX(double startX, double startY, double endX, double endY){
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
    double calculateBottomRightY(double startX, double startY, double endX, double endY){
        return endY > startY ? endY : endY == startY ? endY : startY;
    }
    
    abstract MyShape createShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY);
    
    abstract void modifyCreatedShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY);
    
}
