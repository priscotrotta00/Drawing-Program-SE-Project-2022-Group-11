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
 * Class that represents the Draw Ellipse Tool of a drawing app. It modifies
 * the Pane behaviour in order to create and show an Ellipse according to the
 * mouse coordinates
 * @author Felice Scala
 */
public class DrawEllipseTool extends DrawShapeTool{
    private static Tool instance = null;
    
    private DrawEllipseTool(){}
    
    /**
     * Get an instance of the DrawEllipseTool, according to the Singleton 
     * pattern
     * @return DrawEllipseTool instance
     */
    public static Tool getInstance(){
        if (instance == null) instance = new DrawEllipseTool();
        return instance;
    }

    /**
     * Method that create a new Ellipse as a Shape using the passed coordinates
     * to calculate radiusX, radiusY, centerX and centerY, and the passed colors
     * @param topLeftX
     * @param topLeftY
     * @param bottomRightX
     * @param bottomRightY
     * @param strokeColor
     * @param fillColor
     * @return A new Ellipse
     */
    @Override
    MyShape createShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY, Color strokeColor, Color fillColor) {
        MyEllipse result;
                
        result = new MyEnhancedEllipse();
        result.modifyShape(topLeftX, topLeftY, bottomRightX, bottomRightY);
        result.mySetStroke(strokeColor);
        result.mySetFill(fillColor);
        
        return result;
    }

    /**
     * Method that modify the previously created Ellipse using the passed 
     * coordinates to calculateradiusX, radiusY, centerX and centerY.
     * @param topLeftX
     * @param topLeftY
     * @param bottomRightX
     * @param bottomRightY 
     */
    @Override
    void modifyCreatedShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        MyEllipse result;
        
        result = (MyEllipse) this.getCreatedShape();
        result.modifyShape(topLeftX, topLeftY, bottomRightX, bottomRightY);
    }
    
}
