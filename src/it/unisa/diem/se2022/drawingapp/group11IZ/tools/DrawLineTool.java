/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 *
 * @author utente
 */
public class DrawLineTool extends DrawShapeTool{
    
    private static Tool instance = null;
    
    private DrawLineTool(){}
    
    public static Tool getInstance(){
        if (instance == null) instance = new DrawLineTool();
        return instance;
    }

    @Override
    public double calculateBottomRightY(double startX, double startY, double endX, double endY) {
        return endY;
    }

    @Override
    public double calculateBottomRightX(double startX, double startY, double endX, double endY) {
        return endX;
    }

    @Override
    public double calculateTopLeftY(double startX, double startY, double endX, double endY) {
        return startY;
    }

    @Override
    public double calculateTopLeftX(double startX, double startY, double endX, double endY) {
        return startX;
    }

    /**
     * Method that create a new Line as a Shape using the passed coordinates. 
     * The new line will have a black stroke and a white fill
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return A new line
     */
    @Override
    public MyShape createShape(double startX, double startY, double endX, double endY) {
        MyLine result = new MyEnhancedLine();
        
        result.mySetStartX(startX);
        result.mySetStartY(startY);
        result.mySetEndX(endX);
        result.mySetEndY(endY);
        
        return result;
    }

    @Override
    protected void modifyPreviewShape(double startX, double startY, double endX, double endY) {
        MyLine result = (MyLine) this.getPreviewShape();
        
        result.mySetStartX(startX);
        result.mySetStartY(startY);
        result.mySetEndX(endX);
        result.mySetEndY(endY);
    }
    
}
