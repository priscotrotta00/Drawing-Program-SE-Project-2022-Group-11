/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.clipboard;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import java.lang.reflect.Field;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author saram
 */
public class ClipboardTest {
    
    @Test
    public void testCopy() {
        MyEnhancedLine line = new MyEnhancedLine();
        Clipboard clipboard = new Clipboard();

        clipboard.copy(line);
        MyEnhancedLine lineClone = (MyEnhancedLine) clipboard.getMyShape();
        assertTrue("error in hasCopiedShape", clipboard.hasCopiedShape());
        assertTrue("Error in copy", lineClone.myGetEndX() == line.myGetEndX());
        assertTrue("Error in copy", lineClone.myGetEndY() == line.myGetEndY());
        assertTrue("Error in copy", lineClone.myGetStartY() == line.myGetStartY());
        assertTrue("Error in copy", lineClone.myGetStartX() == line.myGetStartX());
        assertTrue("Error in copy", lineClone.myGetFill() == line.myGetFill());
        assertTrue("Error in copy", lineClone.myGetStroke() == line.myGetStroke());
        assertTrue("Error in copy", lineClone.myGetStrokeWidth() == line.myGetStrokeWidth());
        
    }

    @Test
    public void testCopy2() {
        Clipboard clipboard = new Clipboard();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        clipboard.copy(rectangle);
        MyEnhancedRectangle rectangleClone = (MyEnhancedRectangle) clipboard.getMyShape();
        assertTrue("error in hasCopiedShape", clipboard.hasCopiedShape());
        assertTrue("Error in copy", rectangleClone.myGetX() == rectangle.myGetX());
        assertTrue("Error in copy", rectangleClone.myGetY() == rectangle.myGetY());
        assertTrue("Error in copy", rectangleClone.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in copy", rectangleClone.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in copy", rectangleClone.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in copy", rectangleClone.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in copy", rectangleClone.myGetStrokeWidth() == rectangle.myGetStrokeWidth());
    }

    @Test
    public void testCopy3() {
        Clipboard clipboard = new Clipboard();
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        clipboard.copy(ellipse);
        MyEnhancedEllipse ellipseClone = (MyEnhancedEllipse) clipboard.getMyShape();
        assertTrue("error in hasCopiedShape", clipboard.hasCopiedShape());
        assertTrue("Error in copy", ellipseClone.myGetRadiusX() == ellipse.myGetRadiusX());
        assertTrue("Error in copy", ellipseClone.myGetRadiusY() == ellipse.myGetRadiusY());
        assertTrue("Error in copy", ellipseClone.myGetCenterX()== ellipse.myGetCenterX());
        assertTrue("Error in copy", ellipseClone.myGetCenterY() == ellipse.myGetCenterY());
        assertTrue("Error in copy", ellipseClone.myGetFill() == ellipse.myGetFill());
        assertTrue("Error in copy", ellipseClone.myGetStroke() == ellipse.myGetStroke());
        assertTrue("Error in copy", ellipseClone.myGetStrokeWidth() == ellipse.myGetStrokeWidth());
    }

    @Test
    public void testGetNewCopy() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Clipboard clipboard = new Clipboard();
        MyEnhancedLine line = new MyEnhancedLine();
        clipboard.copy(line);
        MyEnhancedLine lineClone = (MyEnhancedLine) clipboard.getNewCopy();
        assertTrue("error in hasCopiedShape", clipboard.hasCopiedShape());
        assertTrue("Error in copy", lineClone.myGetEndX() == line.myGetEndX());
        assertTrue("Error in copy", lineClone.myGetEndY() == line.myGetEndY());
        assertTrue("Error in copy", lineClone.myGetStartY() == line.myGetStartY());
        assertTrue("Error in copy", lineClone.myGetStartX() == line.myGetStartX());
        assertTrue("Error in copy", lineClone.myGetFill() == line.myGetFill());
        assertTrue("Error in copy", lineClone.myGetStroke() == line.myGetStroke());
        assertTrue("Error in copy", lineClone.myGetStrokeWidth() == line.myGetStrokeWidth());
        
    }
    
    @Test
    public void testGetNewCopy2() {
        Clipboard clipboard = new Clipboard();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        clipboard.copy(rectangle);
        MyEnhancedRectangle rectangleClone = (MyEnhancedRectangle) clipboard.getNewCopy();
        assertTrue("error in hasCopiedShape", clipboard.hasCopiedShape());
        assertTrue("Error in copy", rectangleClone.myGetX() == rectangle.myGetX());
        assertTrue("Error in copy", rectangleClone.myGetY() == rectangle.myGetY());
        assertTrue("Error in copy", rectangleClone.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in copy", rectangleClone.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in copy", rectangleClone.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in copy", rectangleClone.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in copy", rectangleClone.myGetStrokeWidth() == rectangle.myGetStrokeWidth());
        
    }
    
    @Test
    public void testGetNewCopy3() {
        Clipboard clipboard = new Clipboard();
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        clipboard.copy(ellipse);
        MyEnhancedEllipse ellipseClone = (MyEnhancedEllipse) clipboard.getNewCopy();
        assertTrue("error in hasCopiedShape", clipboard.hasCopiedShape());
        assertTrue("Error in copy", ellipseClone.myGetRadiusX() == ellipse.myGetRadiusX());
        assertTrue("Error in copy", ellipseClone.myGetRadiusY() == ellipse.myGetRadiusY());
        assertTrue("Error in copy", ellipseClone.myGetCenterX()== ellipse.myGetCenterX());
        assertTrue("Error in copy", ellipseClone.myGetCenterY() == ellipse.myGetCenterY());
        assertTrue("Error in copy", ellipseClone.myGetFill() == ellipse.myGetFill());
        assertTrue("Error in copy", ellipseClone.myGetStroke() == ellipse.myGetStroke());
        assertTrue("Error in copy", ellipseClone.myGetStrokeWidth() == ellipse.myGetStrokeWidth());
        
    }


    
    @Test
    public void testClear() {
        MyEnhancedLine line = new MyEnhancedLine();
        Clipboard clipboard = new Clipboard();

        clipboard.copy(line);
        clipboard.clear();
        assertTrue("Error in clear", clipboard.getMyShape() == null);
        assertFalse("Error in clear2", clipboard.hasCopiedShape());
    }

    @Test
    public void testCopiedProperty() {
        Clipboard clipboard = new Clipboard();
        assertFalse("error in hascopiedShape", clipboard.copiedProperty().get());

    }

    @Test
    public void testCopiedProperty2() {
        MyEnhancedLine line = new MyEnhancedLine();
        Clipboard clipboard = new Clipboard();
        clipboard.copy(line);
        assertTrue("error in hascopiedShape", clipboard.copiedProperty().get());

    }

    @Test
    public void testHasCopiedShape() {
        Clipboard clipboard = new Clipboard();
        assertFalse("error in hascopiedShape", clipboard.hasCopiedShape());

    }

    @Test
    public void testHasCopiedShape2() {
        MyEnhancedLine line = new MyEnhancedLine();
        Clipboard clipboard = new Clipboard();
        clipboard.copy(line);
        assertTrue("error in hascopiedShape", clipboard.hasCopiedShape());

    }

}
