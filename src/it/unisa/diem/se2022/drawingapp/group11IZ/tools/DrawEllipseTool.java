/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.paint.Color;

/**
 *
 * @author utente
 */
public class DrawEllipseTool extends DrawShapeTool{
    private static Tool instance = null;
    
    private DrawEllipseTool(){}
    
    /**
     * Get an instance of the DrawEllipseTool, according to the Singleton pattern
     * @return DrawEllipseTool instance
     */
    public static Tool getInstance(){
        if (instance == null) instance = new DrawEllipseTool();
        return instance;
    }

    /**
     * Method that create a new Ellipse as a Shape using the passed coordinates
     * to calculate radiusX, radiusY, centerX and centerY. The new ellipse will 
     * have a black stroke and a white fill
     * @param topLeftX
     * @param topLeftY
     * @param bottomRightX
     * @param bottomRightY
     * @return A new Ellipse
     */
    @Override
    public MyShape createShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        double radiusX = (bottomRightX - topLeftX)/2;
        double radiusY = (bottomRightY - topLeftY)/2;
        double centerX = radiusX + topLeftX;
        double centerY = radiusY + topLeftY;
        Color strokeColor = Color.BLACK;
        Color fillColor = Color.WHITE;
        MyEllipse result = new MyEnhancedEllipse();
        
        result.mySetCenterX(centerX);
        result.mySetCenterY(centerY);
        result.mySetRadiusX(radiusX);
        result.mySetRadiusY(radiusY);
        result.mySetStroke(strokeColor);
        result.mySetFill(fillColor);
        
        return result;
    }
    
}
