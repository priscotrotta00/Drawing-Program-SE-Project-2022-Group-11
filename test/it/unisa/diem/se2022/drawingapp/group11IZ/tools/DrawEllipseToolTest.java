/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import javafx.scene.shape.Ellipse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Felice Scala
 */
public class DrawEllipseToolTest {
    private DrawEllipseTool tool;
    
    @Before
    public void setUp(){
        tool = (DrawEllipseTool) DrawEllipseTool.getInstance();
    }
    
    @Test
    public void testCreateShapeCirlce(){
        Ellipse test = (Ellipse) tool.createShape(10, 10, 30, 30);
        Assert.assertEquals("Test Circle getCenterX == 20", test.getCenterX(), 20, 0);
        Assert.assertEquals("Test Circle getCenterY == 20", test.getCenterY(), 20, 0);
        Assert.assertEquals("Test Circle getRadiusX == 10", test.getRadiusX(), 10, 0);
        Assert.assertEquals("Test Circle getRadiusY == 10", test.getRadiusY(), 10, 0);
    }
       
    @Test
    public void testCreateShapeLongX(){
        Ellipse test = (Ellipse) tool.createShape(10, 10, 30, 20);
        Assert.assertEquals("Test Long X Ellipse getCenterX == 20", test.getCenterX(), 20, 0);
        Assert.assertEquals("Test Long X Ellipse getCenterY == 15", test.getCenterY(), 15, 0);
        Assert.assertEquals("Test Long X Ellipse getRadiusX == 10", test.getRadiusX(), 10, 0);
        Assert.assertEquals("Test Long X Ellipse getRadiusY == 5", test.getRadiusY(), 5, 0);
    }

    @Test
    public void testCreateShapeLongY(){
        Ellipse test = (Ellipse) tool.createShape(10, 10, 20, 50);
        Assert.assertEquals("Test Long Y Ellipse getCenterX == 15", test.getCenterX(), 15, 0);
        Assert.assertEquals("Test Long Y Ellipse getCenterY == 30", test.getCenterY(), 30, 0);
        Assert.assertEquals("Test Long Y Ellipse getRadiusX == 5", test.getRadiusX(), 5, 0);
        Assert.assertEquals("Test Long Y Ellipse getRadiusY == 20", test.getRadiusY(), 20, 0);
    }

    @Test
    public void testCreateShapePoint(){
        Ellipse test = (Ellipse) tool.createShape(10, 10, 10, 10);
        Assert.assertEquals("Test Ellipse as point getCenterX == 10", test.getCenterX(), 10, 0);
        Assert.assertEquals("Test Ellipse as point getCenterY == 10", test.getCenterY(), 10, 0);
        Assert.assertEquals("Test Ellipse as point getRadiusX == 0", test.getRadiusX(), 0, 0);
        Assert.assertEquals("Test Ellipse as point getRadiusY == 0", test.getRadiusY(), 0, 0);
    }

    @Test
    public void testCreateShapeHLine(){
        Ellipse test = (Ellipse) tool.createShape(0, 10, 100, 10);
        Assert.assertEquals("Test Ellipse as horizontal line getCenterX == 50", test.getCenterX(), 50, 0);
        Assert.assertEquals("Test Ellipse as horizontal line getCenterY == 10", test.getCenterY(), 10, 0);
        Assert.assertEquals("Test Ellipse as horizontal line getRadiusX == 50", test.getRadiusX(), 50, 0);
        Assert.assertEquals("Test Ellipse as horizontal line getRadiusY == 0", test.getRadiusY(), 0, 0);
    } 
    
    @Test
    public void testCreateShapeVLine(){
        Ellipse test = (Ellipse) tool.createShape(0, 0, 0, 100);
        Assert.assertEquals("Test Ellipse as vertical line getCenterX == 0", test.getCenterX(), 0, 0);
        Assert.assertEquals("Test Ellipse as vertical line getCenterY == 50", test.getCenterY(), 50, 0);
        Assert.assertEquals("Test Ellipse as vertical line getRadiusX == 0", test.getRadiusX(), 0, 0);
        Assert.assertEquals("Test Ellipse as vertical line getRadiusY == 50", test.getRadiusY(), 50, 0);
    }
    
}
