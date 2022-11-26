/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import javafx.scene.shape.Line;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

/**
 *
 * @author Felice Scala
 */
public class DrawLineToolTest {
    private DrawLineTool tool;
    
    @Before
    public void setUp(){
        tool = (DrawLineTool) DrawLineTool.getInstance();
    }
    
    @Test
    public void testCreateShapeHLine() {
        Line result = (Line) tool.createShape(10, 10, 30, 10);
        Assert.assertEquals("Test Horizontal Line getStartX == 10", 10, result.getStartX(), 0);
        Assert.assertEquals("Test Horizontal Line getStartY == 10", 10, result.getStartY(), 0);
        Assert.assertEquals("Test Horizontal Line getEndX == 30", 30, result.getEndX(), 0);
        Assert.assertEquals("Test Horizontal Line getEndY == 10", 10, result.getEndY(), 0);
        
        result = (Line) tool.createShape(30, 10, 10, 10);
        Assert.assertEquals("Test Horizontal Line getStartX == 30", 30, result.getStartX(), 0);
        Assert.assertEquals("Test Horizontal Line getStartY == 10", 10, result.getStartY(), 0);
        Assert.assertEquals("Test Horizontal Line getEndX == 10", 10, result.getEndX(), 0);
        Assert.assertEquals("Test Horizontal Line getEndY == 10", 10, result.getEndY(), 0);
    }
    
    @Test
    public void testCreateShapeVLine() {
        Line result = (Line) tool.createShape(10, 10, 10, 30);
        Assert.assertEquals("Test Vertical Line getStartX == 10", 10, result.getStartX(), 0);
        Assert.assertEquals("Test Vertical Line getStartY == 10", 10, result.getStartY(), 0);
        Assert.assertEquals("Test Vertical Line getEndX == 10", 10, result.getEndX(), 0);
        Assert.assertEquals("Test Vertical Line getEndY == 30", 30, result.getEndY(), 0);
        
        result = (Line) tool.createShape(10, 30, 10, 10);
        Assert.assertEquals("Test Vertical Line getStartX == 10", 10, result.getStartX(), 0);
        Assert.assertEquals("Test Vertical Line getStartY == 30", 30, result.getStartY(), 0);
        Assert.assertEquals("Test Vertical Line getEndX == 10", 10, result.getEndX(), 0);
        Assert.assertEquals("Test Vertical Line getEndY == 10", 10, result.getEndY(), 0);
    }
    
    @Test
    public void testCreateShapePoint() {
        Line result = (Line) tool.createShape(10, 10, 10, 10);
        Assert.assertEquals("Test Line as Point getStartX == 10", 10, result.getStartX(), 0);
        Assert.assertEquals("Test Line as Point getStartY == 10", 10, result.getStartY(), 0);
        Assert.assertEquals("Test Line as Point getEndX == 10", 10, result.getEndX(), 0);
        Assert.assertEquals("Test Line as Point getEndY == 10", 10, result.getEndY(), 0);
    }
    
    @Test
    public void testCreateShapeNegativeCoordinates() {
        Line result = (Line) tool.createShape(-10, -10, -30, -20);
        Assert.assertEquals("Test Line (negative coordinates) getStartX == -10", -10, result.getStartX(), 0);
        Assert.assertEquals("Test Line (negative coordinates) getStartY == -10", -10, result.getStartY(), 0);
        Assert.assertEquals("Test Line (negative coordinates) getEndX == -30", -30, result.getEndX(), 0);
        Assert.assertEquals("Test Line (negative coordinates) getEndY == -20", -20, result.getEndY(), 0);
    }
    
    @Test
    public void testCreateShapeNegativePositiveCoordinates() {
        Line result = (Line) tool.createShape(-10, -10, 30, 20);
        Assert.assertEquals("Test Line (neg/pos coordinates) getStartX == -10", -10, result.getStartX(), 0);
        Assert.assertEquals("Test Line (neg/pos coordinates) getStartY == -10", -10, result.getStartY(), 0);
        Assert.assertEquals("Test Line (neg/pos coordinates) getEndX == 30", 30, result.getEndX(), 0);
        Assert.assertEquals("Test Line (neg/pos coordinates) getEndY == 20", 20, result.getEndY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeHLine() {
        this.tool.setCreatedShape(new MyEnhancedLine());
        this.tool.modifyCreatedShape(10, 10, 30, 10);
        Line result = (Line) this.tool.getCreatedShape();
        
        Assert.assertEquals("Test Horizontal Line getStartX == 10", 10, result.getStartX(), 0);
        Assert.assertEquals("Test Horizontal Line getStartY == 10", 10, result.getStartY(), 0);
        Assert.assertEquals("Test Horizontal Line getEndX == 30", 30, result.getEndX(), 0);
        Assert.assertEquals("Test Horizontal Line getEndY == 10", 10, result.getEndY(), 0);
        
        this.tool.modifyCreatedShape(30, 10, 10, 10);
        Assert.assertEquals("Test Horizontal Line getStartX == 30", 30, result.getStartX(), 0);
        Assert.assertEquals("Test Horizontal Line getStartY == 10", 10, result.getStartY(), 0);
        Assert.assertEquals("Test Horizontal Line getEndX == 10", 10, result.getEndX(), 0);
        Assert.assertEquals("Test Horizontal Line getEndY == 10", 10, result.getEndY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeVLine() {
        this.tool.setCreatedShape(new MyEnhancedLine());
        this.tool.modifyCreatedShape(10, 10, 10, 30);
        Line result = (Line) this.tool.getCreatedShape();
        
        Assert.assertEquals("Test Vertical Line getStartX == 10", 10, result.getStartX(), 0);
        Assert.assertEquals("Test Vertical Line getStartY == 10", 10, result.getStartY(), 0);
        Assert.assertEquals("Test Vertical Line getEndX == 10", 10, result.getEndX(), 0);
        Assert.assertEquals("Test Vertical Line getEndY == 30", 30, result.getEndY(), 0);
        
        this.tool.modifyCreatedShape(10, 30, 10, 10);
        Assert.assertEquals("Test Vertical Line getStartX == 10", 10, result.getStartX(), 0);
        Assert.assertEquals("Test Vertical Line getStartY == 30", 30, result.getStartY(), 0);
        Assert.assertEquals("Test Vertical Line getEndX == 10", 10, result.getEndX(), 0);
        Assert.assertEquals("Test Vertical Line getEndY == 10", 10, result.getEndY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapePoint() {
        this.tool.setCreatedShape(new MyEnhancedLine());
        this.tool.modifyCreatedShape(10, 10, 10, 10);
        Line result = (Line) this.tool.getCreatedShape();
        Assert.assertEquals("Test Line as Point getStartX == 10", 10, result.getStartX(), 0);
        Assert.assertEquals("Test Line as Point getStartY == 10", 10, result.getStartY(), 0);
        Assert.assertEquals("Test Line as Point getEndX == 10", 10, result.getEndX(), 0);
        Assert.assertEquals("Test Line as Point getEndY == 10", 10, result.getEndY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeNegativeCoordinates(){
        this.tool.setCreatedShape(new MyEnhancedLine());
        this.tool.modifyCreatedShape(-10, -10, -30, -20);
        Line result = (Line) this.tool.getCreatedShape();
        Assert.assertEquals("Test Line (negative coordinates) getStartX == -10", -10, result.getStartX(), 0);
        Assert.assertEquals("Test Line (negative coordinates) getStartY == -10", -10, result.getStartY(), 0);
        Assert.assertEquals("Test Line (negative coordinates) getEndX == -30", -30, result.getEndX(), 0);
        Assert.assertEquals("Test Line (negative coordinates) getEndY == -20", -20, result.getEndY(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeNegativePositiveCoordinates(){
        this.tool.setCreatedShape(new MyEnhancedLine());
        this.tool.modifyCreatedShape(-10, -10, 30, 20);
        Line result = (Line) this.tool.getCreatedShape();
        Assert.assertEquals("Test Line (neg/pos coordinates) getStartX == -10", -10, result.getStartX(), 0);
        Assert.assertEquals("Test Line (neg/pos coordinates) getStartY == -10", -10, result.getStartY(), 0);
        Assert.assertEquals("Test Line (neg/pos coordinates) getEndX == 30", 30, result.getEndX(), 0);
        Assert.assertEquals("Test Line (neg/pos coordinates) getEndY == 20", 20, result.getEndY(), 0);
    }
    
}
