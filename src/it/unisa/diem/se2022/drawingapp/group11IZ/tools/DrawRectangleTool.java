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
        MyRectangle rectangle = new MyEnhancedRectangle();
        
        rectangle.modifyShape(topLeftX, topLeftY, bottomRightX, bottomRightY);
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
        MyRectangle rectangle = (MyRectangle) this.getCreatedShape();
        rectangle.modifyShape(topLeftX, topLeftY, bottomRightX, bottomRightY);
    }
    
}
