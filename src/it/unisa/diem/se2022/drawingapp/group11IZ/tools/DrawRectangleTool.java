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
 *
 * @author utente
 */
public class DrawRectangleTool extends DrawShapeTool{
    
    private static DrawRectangleTool singleton = null;
    
    private DrawRectangleTool(){}
    
    public static Tool getInstance(){
        if (singleton == null) singleton = new DrawRectangleTool();
        return singleton;
    }

    /***
     * Method that create a new Rectangle as a Shape using the passed coordinates
     * to calculate width and height. The new rectangle will have a black stroke 
     * and a white fill
     * @param topLeftX
     * @param topLeftY
     * @param bottomRightX
     * @param bottomRightY
     * @return A new Rectangle
     */
    @Override
    public MyShape createShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        double width = bottomRightX - topLeftX;
        double height = bottomRightY - topLeftY;
        Color strokeColor = Color.BLACK;
        Color fillColor = Color.WHITE;
        MyRectangle rectangle = new MyEnhancedRectangle();
        
        rectangle.mySetX(topLeftX);
        rectangle.mySetY(topLeftY);
        rectangle.mySetWidth(width);
        rectangle.mySetHeight(height);
        rectangle.mySetStroke(strokeColor);
        rectangle.mySetFill(fillColor);
        
        return rectangle;
    }
    
}
