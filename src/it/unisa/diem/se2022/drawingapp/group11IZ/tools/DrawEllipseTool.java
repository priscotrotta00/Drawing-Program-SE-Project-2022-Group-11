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
     * Methods that returns the RadiusX of a Ellipse given its X coordinates
     * @param topLeftX
     * @param bottomRightX
     * @return Radius X of an ellipse
     */
    private double computeEllipseRadiusX(double topLeftX, double bottomRightX) {
        return (bottomRightX - topLeftX)/2;
    }
    
    /**
     * Methods that returns the RadiusX of a Ellipse given its X coordinates
     * @param topLeftY
     * @param bottomRightY
     * @return Radius X of an ellipse
     */
    private double computeEllipseRadiusY(double topLeftY, double bottomRightY) {
        return (bottomRightY - topLeftY)/2;
    }
    
    /**
     * Methods that returns the X coordinate of an Ellipse's center 
     * given its X coordinates
     * @param radiusX
     * @param topLeftX
     * @return X cooridnate of an ellipse's center
     */
    private double computeEllipseCenterX(double radiusX, double topLeftX) {
        return radiusX + topLeftX;
    }
    
    /**
     * Methods that returns the Y coordinate of an Ellipse's center 
     * given its Y coordinates
     * @param radiusY
     * @param topLeftY
     * @return Y cooridnate of an ellipse's center
     */
    private double computeEllipseCenterY(double radiusY, double topLeftY) {
        return radiusY + topLeftY;
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
    MyShape createShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        double radiusX = this.computeEllipseRadiusX(topLeftX, bottomRightX);
        double radiusY = this.computeEllipseRadiusY(topLeftY, bottomRightY);
        double centerX = this.computeEllipseCenterX(radiusX, topLeftX);
        double centerY = this.computeEllipseCenterY(radiusY, topLeftY);
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

    /**
     * Method that modify the previously created Ellipse using the passed 
     * coordinates to calculateradiusX, radiusY, centerX and centerY. 
     * The new ellipse will have a black stroke and a white fill
     * @param topLeftX
     * @param topLeftY
     * @param bottomRightX
     * @param bottomRightY 
     */
    @Override
    void modifyCreatedShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        double radiusX = this.computeEllipseRadiusX(topLeftX, bottomRightX);
        double radiusY = this.computeEllipseRadiusY(topLeftY, bottomRightY);
        double centerX = this.computeEllipseCenterX(radiusX, topLeftX);
        double centerY = this.computeEllipseCenterY(radiusY, topLeftY);
        Color strokeColor = Color.BLACK;
        Color fillColor = Color.WHITE;
        MyEllipse result = (MyEllipse) this.getCreatedShape();
        
        result.mySetCenterX(centerX);
        result.mySetCenterY(centerY);
        result.mySetRadiusX(radiusX);
        result.mySetRadiusY(radiusY);
        result.mySetStroke(strokeColor);
        result.mySetFill(fillColor);
    }
    
}
