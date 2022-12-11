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
        MyRectangle result = new MyEnhancedRectangle();
        
        result.modifyShape(topLeftX, topLeftY, bottomRightX, bottomRightY);
        result.mySetStroke(strokeColor);
        result.mySetFill(fillColor);
        result.mySetStrokeWidth(result.myGetStrokeWidth() + STROKE_WIDTH_OFFSET);
        
        return result;
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
