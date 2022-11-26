/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
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
        Assert.assertEquals("Test Circle getCenterX == 20", 20, test.getCenterX(), 0);
        Assert.assertEquals("Test Circle getCenterY == 20", 20, test.getCenterY(), 0);
        Assert.assertEquals("Test Circle getRadiusX == 10", 10, test.getRadiusX(), 0);
        Assert.assertEquals("Test Circle getRadiusY == 10", 10, test.getRadiusY(), 0);
    }
       
    @Test
    public void testCreateShapeLongX(){
        Ellipse test = (Ellipse) tool.createShape(10, 10, 30, 20);
        Assert.assertEquals("Test Long X Ellipse getCenterX == 20", 20, test.getCenterX(), 0);
        Assert.assertEquals("Test Long X Ellipse getCenterY == 15", 15, test.getCenterY(), 0);
        Assert.assertEquals("Test Long X Ellipse getRadiusX == 10", 10, test.getRadiusX(), 0);
        Assert.assertEquals("Test Long X Ellipse getRadiusY == 5", 5, test.getRadiusY(), 0);
    }

    @Test
    public void testCreateShapeLongY(){
        Ellipse test = (Ellipse) tool.createShape(10, 10, 20, 50);
        Assert.assertEquals("Test Long Y Ellipse getCenterX == 15", 15, test.getCenterX(), 0);
        Assert.assertEquals("Test Long Y Ellipse getCenterY == 30", 30, test.getCenterY(), 0);
        Assert.assertEquals("Test Long Y Ellipse getRadiusX == 5", 5, test.getRadiusX(), 0);
        Assert.assertEquals("Test Long Y Ellipse getRadiusY == 20", 20, test.getRadiusY(), 0);
    }

    @Test
    public void testCreateShapePoint(){
        Ellipse test = (Ellipse) tool.createShape(10, 10, 10, 10);
        Assert.assertEquals("Test Ellipse as point getCenterX == 10", 10, test.getCenterX(), 0);
        Assert.assertEquals("Test Ellipse as point getCenterY == 10", 10, test.getCenterY(), 0);
        Assert.assertEquals("Test Ellipse as point getRadiusX == 0", 0, test.getRadiusX(), 0);
        Assert.assertEquals("Test Ellipse as point getRadiusY == 0", 0, test.getRadiusY(), 0);
    }

    @Test
    public void testCreateShapeHLine(){
        Ellipse test = (Ellipse) tool.createShape(0, 10, 100, 10);
        Assert.assertEquals("Test Ellipse as horizontal line getCenterX == 50", 50, test.getCenterX(), 0);
        Assert.assertEquals("Test Ellipse as horizontal line getCenterY == 10", 10, test.getCenterY(), 0);
        Assert.assertEquals("Test Ellipse as horizontal line getRadiusX == 50", 50, test.getRadiusX(), 0);
        Assert.assertEquals("Test Ellipse as horizontal line getRadiusY == 0", 0, test.getRadiusY(), 0);
    } 
    
    @Test
    public void testCreateShapeVLine(){
        Ellipse test = (Ellipse) tool.createShape(0, 0, 0, 100);
        Assert.assertEquals("Test Ellipse as vertical line getCenterX == 0", 0, test.getCenterX(), 0);
        Assert.assertEquals("Test Ellipse as vertical line getCenterY == 50", 50, test.getCenterY(), 0);
        Assert.assertEquals("Test Ellipse as vertical line getRadiusX == 0", 0, test.getRadiusX(), 0);
        Assert.assertEquals("Test Ellipse as vertical line getRadiusY == 50", 50, test.getRadiusY(), 0);
    }
    
    @Test
    public void testCreateShapeNegativeCoordinates(){
        Ellipse test = (Ellipse) tool.createShape(-30, -20, -10, -10);
        Assert.assertEquals("Test Ellipse (negative coordinates) getCenterX == -20", -20, test.getCenterX(), 0);
        Assert.assertEquals("Test Ellipse (negative coordinates) getCenterY == -15", -15, test.getCenterY(), 0);
        Assert.assertEquals("Test Ellipse (negative coordinates) getRadiusX == 10", 10, test.getRadiusX(), 0);
        Assert.assertEquals("Test Ellipse (negative coordinates) getRadiusY == 5", 5, test.getRadiusY(), 0);
    }
    
    @Test
    public void testCreateShapeNegativePositiveCoordinates(){
        Ellipse test = (Ellipse) tool.createShape(-30, -20, 10, 10);
        Assert.assertEquals("Test Ellipse (neg/pos coordinates) getCenterX == -10", -10, test.getCenterX(), 0);
        Assert.assertEquals("Test Ellipse (neg/pos coordinates) getCenterY == -5", -5, test.getCenterY(), 0);
        Assert.assertEquals("Test Ellipse (neg/pos coordinates) getRadiusX == 20", 20, test.getRadiusX(), 0);
        Assert.assertEquals("Test Ellipse (neg/pos coordinates) getRadiusY == 15", 15, test.getRadiusY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeCircle() {
        this.tool.setCreatedShape(new MyEnhancedEllipse());
        this.tool.modifyCreatedShape(10, 10, 30, 30);
        Ellipse test = (Ellipse) this.tool.getCreatedShape();
        
        Assert.assertEquals("Test Circle getCenterX == 20", 20, test.getCenterX(), 0);
        Assert.assertEquals("Test Circle getCenterY == 20", 20, test.getCenterY(), 0);
        Assert.assertEquals("Test Circle getRadiusX == 10", 10, test.getRadiusX(), 0);
        Assert.assertEquals("Test Circle getRadiusY == 10", 10, test.getRadiusY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapePoint(){
        this.tool.setCreatedShape(new MyEnhancedEllipse());
        this.tool.modifyCreatedShape(10, 10, 10, 10);
        Ellipse test = (Ellipse) this.tool.getCreatedShape();
        
        Assert.assertEquals("Test Ellipse as point getCenterX == 10", 10, test.getCenterX(), 0);
        Assert.assertEquals("Test Ellipse as point getCenterY == 10", 10, test.getCenterY(), 0);
        Assert.assertEquals("Test Ellipse as point getRadiusX == 0", 0, test.getRadiusX(), 0);
        Assert.assertEquals("Test Ellipse as point getRadiusY == 0", 0, test.getRadiusY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeLongX(){
        this.tool.setCreatedShape(new MyEnhancedEllipse());
        this.tool.modifyCreatedShape(10, 10, 30, 20);
        Ellipse test = (Ellipse) this.tool.getCreatedShape();
        
        Assert.assertEquals("Test Long X Ellipse getCenterX == 20", 20, test.getCenterX(), 0);
        Assert.assertEquals("Test Long X Ellipse getCenterY == 15", 15, test.getCenterY(), 0);
        Assert.assertEquals("Test Long X Ellipse getRadiusX == 10", 10, test.getRadiusX(), 0);
        Assert.assertEquals("Test Long X Ellipse getRadiusY == 5", 5, test.getRadiusY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeLongY(){
        this.tool.setCreatedShape(new MyEnhancedEllipse());
        this.tool.modifyCreatedShape(10, 10, 20, 50);
        Ellipse test = (Ellipse) this.tool.getCreatedShape();
        
        Assert.assertEquals("Test Long Y Ellipse getCenterX == 15", 15, test.getCenterX(), 0);
        Assert.assertEquals("Test Long Y Ellipse getCenterY == 30", 30, test.getCenterY(), 0);
        Assert.assertEquals("Test Long Y Ellipse getRadiusX == 5", 5, test.getRadiusX(), 0);
        Assert.assertEquals("Test Long Y Ellipse getRadiusY == 20", 20, test.getRadiusY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeHLine(){
        this.tool.setCreatedShape(new MyEnhancedEllipse());
        this.tool.modifyCreatedShape(0, 10, 100, 10);
        Ellipse test = (Ellipse) this.tool.getCreatedShape();
        
        Assert.assertEquals("Test Ellipse as horizontal line getCenterX == 50", 50, test.getCenterX(), 0);
        Assert.assertEquals("Test Ellipse as horizontal line getCenterY == 10", 10, test.getCenterY(), 0);
        Assert.assertEquals("Test Ellipse as horizontal line getRadiusX == 50", 50, test.getRadiusX(), 0);
        Assert.assertEquals("Test Ellipse as horizontal line getRadiusY == 0", 0, test.getRadiusY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeVLine(){
        this.tool.setCreatedShape(new MyEnhancedEllipse());
        this.tool.modifyCreatedShape(0, 0, 0, 100);
        Ellipse test = (Ellipse) this.tool.getCreatedShape();
        Assert.assertEquals("Test Ellipse as vertical line getCenterX == 0", 0, test.getCenterX(), 0);
        Assert.assertEquals("Test Ellipse as vertical line getCenterY == 50", 50, test.getCenterY(), 0);
        Assert.assertEquals("Test Ellipse as vertical line getRadiusX == 0", 0, test.getRadiusX(), 0);
        Assert.assertEquals("Test Ellipse as vertical line getRadiusY == 50", 50, test.getRadiusY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeNegativeCoordinates(){
        this.tool.setCreatedShape(new MyEnhancedEllipse());
        this.tool.modifyCreatedShape(-30, -20, -10, -10);
        Ellipse test = (Ellipse) this.tool.getCreatedShape();
        Assert.assertEquals("Test Ellipse (negative coordinates) getCenterX == -20", -20, test.getCenterX(), 0);
        Assert.assertEquals("Test Ellipse (negative coordinates) getCenterY == -15", -15, test.getCenterY(), 0);
        Assert.assertEquals("Test Ellipse (negative coordinates) getRadiusX == 10", 10, test.getRadiusX(), 0);
        Assert.assertEquals("Test Ellipse (negative coordinates) getRadiusY == 5", 5, test.getRadiusY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeNegativePositiveCoordinates(){
        this.tool.setCreatedShape(new MyEnhancedEllipse());
        this.tool.modifyCreatedShape(-30, -20, 10, 10);
        Ellipse test = (Ellipse) this.tool.getCreatedShape();
        Assert.assertEquals("Test Ellipse (neg/pos coordinates) getCenterX == -10", -10, test.getCenterX(), 0);
        Assert.assertEquals("Test Ellipse (neg/pos coordinates) getCenterY == -5", -5, test.getCenterY(), 0);
        Assert.assertEquals("Test Ellipse (neg/pos coordinates) getRadiusX == 20", 20, test.getRadiusX(), 0);
        Assert.assertEquals("Test Ellipse (neg/pos coordinates) getRadiusY == 15", 15, test.getRadiusY(), 0);
    }
}
