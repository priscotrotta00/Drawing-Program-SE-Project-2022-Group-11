/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import javafx.scene.paint.Color;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author saram
 */
public class MyEnhancedLineTest {

    @Test
    public void testMyGetEndX() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myGetEndX()", l.myGetEndX() == l.getEndX());
    }

    @Test
    public void testMyGetEndX1() {
        MyEnhancedLine l = new MyEnhancedLine();
        l.mySetEndX(5.0);
        //check if get center x!=get center y after modified only center x
        assertFalse("Error in myGetEndX", l.myGetEndX() == l.myGetEndY());
    }

    @Test
    public void testMyGetEndY() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myGetEndY()", l.myGetEndY() == l.getEndY());
    }

    @Test
    public void testMyGetEndY1() {
        MyEnhancedLine l = new MyEnhancedLine();
        l.mySetEndY(5.0);
        //check if get center x!=get center y after modified only center x
        assertFalse("Error in myGetEndY", l.myGetEndX() == l.myGetEndY());
    }

    @Test
    public void testMyGetStartX() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myGetStartX()", l.myGetStartX() == l.getStartX());
    }

    @Test
    public void testMyGetStartX1() {
        MyEnhancedLine l = new MyEnhancedLine();
        l.mySetStartX(5.0);
        //check if get center x!=get center y after modified only center x
        assertFalse("Error in myGetStartX", l.myGetStartX() == l.myGetStartY());
    }

    @Test
    public void testMyGetStartY() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myGetStartY()", l.myGetStartY() == l.getStartY());
    }

    @Test
    public void testMyGetStartY1() {
        MyEnhancedLine l = new MyEnhancedLine();
        l.mySetStartY(5.0);
        //check if get center x!=get center y after modified only center x
        assertFalse("Error in myGetStartY", l.myGetStartX() == l.myGetStartY());
    }

    @Test
    public void testMySetStartX() {
        MyEnhancedLine l = new MyEnhancedLine();
        l.mySetStartX(5.0);
        assertTrue("Error in mySetStartX", l.myGetStartX() == 5.0);
    }

    @Test
    public void testMySetStartY() {
        MyEnhancedLine l = new MyEnhancedLine();
        l.mySetStartY(5.0);
        assertTrue("Error in mySetStartY", l.myGetStartY() == 5.0);
    }

    @Test
    public void testMySetEndX() {
        MyEnhancedLine l = new MyEnhancedLine();
        l.mySetEndX(5.0);
        assertTrue("Error in mySetEndX", l.myGetEndX() == 5.0);
    }

    @Test
    public void testMySetEndY() {
        MyEnhancedLine l = new MyEnhancedLine();
        l.mySetEndY(5.0);
        assertTrue("Error in mySetEndY", l.myGetEndY() == 5.0);
    }

    @Test
    public void testMyEndXProperty() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myEndXProperty()", l.myEndXProperty() == l.endXProperty());
    }

    @Test
    public void testMyEndYProperty() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myEndYProperty()", l.myEndYProperty() == l.endYProperty());
    }

    @Test
    public void testMyStartXProperty() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myStartXProperty()", l.myStartXProperty() == l.startXProperty());
    }

    @Test
    public void testMyStartYProperty() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myStartYProperty()", l.myStartYProperty() == l.startYProperty());
    }

    @Test
    public void testMySetStroke() {
        MyEnhancedLine l = new MyEnhancedLine();
        Color c = Color.BLACK;
        l.mySetStroke(c);
        assertTrue("Error in mySetStroke", l.myGetStroke() == c);
    }

    @Test
    public void testMySetFill() {
        MyEnhancedLine l = new MyEnhancedLine();
        Color c = Color.BLACK;
        l.mySetFill(c);
        assertTrue("Error in mySetFill", l.myGetFill() == c);
    }

    @Test
    public void testMyGetStroke() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myGetStroke", l.myGetStroke() == l.getStroke());
    }

    @Test
    public void testMyGetFill() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myGetFill", l.myGetFill() == l.getFill());
    }

    @Test
    public void testMyGetId() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myGetId", (l.myGetId() == null ? l.getId() == null : l.myGetId().equals(l.getId())));
    }

    @Test
    public void testMyStrokeProperty() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myStrokeProperty", l.myStrokeProperty() == l.strokeProperty());
    }

    @Test
    public void testMyFillProperty() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myFillProperty", l.myFillProperty() == l.fillProperty());
    }

    @Test
    public void testMySetStrokeWidth() {
        MyEnhancedLine l = new MyEnhancedLine();
        l.mySetStrokeWidth(8.0);
        assertTrue("Error in mySetStrokeWidth", l.myGetStrokeWidth() == 8.0);

    }

    @Test
    public void testMyGetStrokeWidth() {
        MyEnhancedLine l = new MyEnhancedLine();
        l.mySetStrokeWidth(8.0);
        assertTrue("Error in myGetStrokeWidth", l.myGetStrokeWidth() == l.getStrokeWidth());

    }

    @Test
    public void testMyGetParent() {
        MyEnhancedLine l = new MyEnhancedLine();
        assertTrue("Error in myGetPartent", l.myGetParent() == l.getParent());
    }

}