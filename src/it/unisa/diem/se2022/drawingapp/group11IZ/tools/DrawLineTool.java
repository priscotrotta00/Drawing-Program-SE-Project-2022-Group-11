package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.paint.Color;

/**
 * Class that represents the Draw Line Tool of a drawing app. It modifies
 * the Pane behaviour in order to create and show a Line according to the
 * mouse coordinates
 * @author Felice Scala
 */
public class DrawLineTool extends DrawShapeTool{
    
    private static Tool instance = null;
    
    private DrawLineTool(){}
    
    public static Tool getInstance(){
        if (instance == null) instance = new DrawLineTool();
        return instance;
    }

    @Override
    double calculateBottomRightY(double startX, double startY, double endX, double endY) {
        return endY;
    }

    @Override
    double calculateBottomRightX(double startX, double startY, double endX, double endY) {
        return endX;
    }

    @Override
    double calculateTopLeftY(double startX, double startY, double endX, double endY) {
        return startY;
    }

    @Override
    double calculateTopLeftX(double startX, double startY, double endX, double endY) {
        return startX;
    }

    /**
     * Method that create a new Line as a Shape using the passed coordinates and
     * strokeColor.
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param strokeColor
     * @param fillColor
     * @return A new line
     */
    @Override
    MyShape createShape(double startX, double startY, double endX, double endY, Color strokeColor, Color fillColor) {
        MyLine result;
                
        result = new MyEnhancedLine();
        result.modifyShape(startX, startY, endX, endY);
        result.mySetStroke(strokeColor);
        result.mySetStrokeWidth(result.myGetStrokeWidth() + STROKE_WIDTH_OFFSET);
        
        return result;
    }

    /**
     * Method that modify the created Line using the passed coordinates.
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    @Override
    void modifyCreatedShape(double startX, double startY, double endX, double endY) {
        MyLine result;
        
        result = (MyLine) this.getCreatedShape();
        result.modifyShape(startX, startY, endX, endY);
    }
    
}
