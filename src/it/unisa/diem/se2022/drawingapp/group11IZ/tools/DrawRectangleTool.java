/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.paint.Color;

/**
 * Class that represents the Draw Rectangle Tool of a drawing app. It modifies
 * the Pane behaviour in order to create and show a Rectangle according to the
 * mouse coordinates
 * @author Felice Scala
 */
public class DrawRectangleTool extends DrawShapeTool{
    
    private static DrawRectangleTool singleton = null;
    
    private DrawRectangleTool(){}
    
    /**
     * Get the instance of Draw Rectangle Tool, according to the Singleton Pattern
     * @return Instance of Draw Rectangle Tool
     */
    public static Tool getInstance(){
        if (singleton == null) singleton = new DrawRectangleTool();
        return singleton;
    }
    
    /**
     * Method that returns the width of a rectangle gven its X coordinates
     * @param topLeftX X coordinate of the upper-left point
     * @param bottomRightX X coordinate of the bottom-right point
     * @return Width of rectangle
     */
    private double computeRectangleWidth(double topLeftX, double bottomRightX){
        return bottomRightX - topLeftX;
    }
    
    /**
     * Method that returns the height of a rectangle gven its X coordinates
     * @param topLeftY Y coordinate of the upper-left point
     * @param bottomRightY Y coordinate of the bottom-right point
     * @return Height
     */
    private double computeRectangleHeight(double topLeftY, double bottomRightY){
        return bottomRightY - topLeftY;
    }

    /***
     * Method that create a new Rectangle as a Shape using the passed coordinates
     * to calculate width and height and the passed colors
     * @param topLeftX
     * @param topLeftY
     * @param bottomRightX
     * @param bottomRightY
     * @param strokeColor
     * @param fillColor
     * @return A new Rectangle
     */
    @Override
    MyShape createShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY, Color strokeColor, Color fillColor) {
        double width = this.computeRectangleWidth(topLeftX, bottomRightX);
        double height = this.computeRectangleHeight(topLeftY, bottomRightY);
        MyRectangle rectangle = new MyEnhancedRectangle();
        
        rectangle.mySetX(topLeftX);
        rectangle.mySetY(topLeftY);
        rectangle.mySetWidth(width);
        rectangle.mySetHeight(height);
        rectangle.mySetStroke(strokeColor);
        rectangle.mySetFill(fillColor);
        
        return rectangle;
    }
    
    /**
     * Method that modify the previously created Rectangel using the passed coordinates
     * to calculate width and height.
     * @param topLeftX
     * @param topLeftY
     * @param bottomRightX
     * @param bottomRightY 
     */
    @Override
    void modifyCreatedShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        double width = this.computeRectangleWidth(topLeftX, bottomRightX);
        double height = this.computeRectangleHeight(topLeftY, bottomRightY);
        MyRectangle rectangle = (MyRectangle) this.getCreatedShape();
        
        rectangle.mySetX(topLeftX);
        rectangle.mySetY(topLeftY);
        rectangle.mySetWidth(width);
        rectangle.mySetHeight(height);
    }
    
}
