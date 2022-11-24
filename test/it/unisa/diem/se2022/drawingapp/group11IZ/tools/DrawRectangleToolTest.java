/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import javafx.scene.shape.Rectangle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author utente
 */
public class DrawRectangleToolTest {
    
    private DrawRectangleTool tool;
    
    @Before
    public void setUp() {
        tool = (DrawRectangleTool) DrawRectangleTool.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCalculateTopLeftX() {
        Assert.assertEquals("Test startX < endX && startY < endY", 10, tool.calculateTopLeftX(10, 10, 30, 20), 0);
        Assert.assertEquals("Test startX > endX && startY < endY", 10, tool.calculateTopLeftX(30, 10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX && startY > endY", 10, tool.calculateTopLeftX(10, 20, 30, 10), 0);
        Assert.assertEquals("Test startX > endX && startY > endY", 10, tool.calculateTopLeftX(30, 20, 10, 10), 0);
        
        Assert.assertEquals("Test startX == endX && startY < endY", 10, tool.calculateTopLeftX(10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX == endX && startY > endY", 10, tool.calculateTopLeftX(10, 20, 10, 10), 0);
        Assert.assertEquals("Test startX > endX && startY == endY", 10, tool.calculateTopLeftX(10, 10, 30, 10), 0);
        Assert.assertEquals("Test startX < endX && startY == endY", 10, tool.calculateTopLeftX(30, 10, 10, 10), 0);
        
        Assert.assertEquals("Test startX == endX && startY == endY", 10, tool.calculateTopLeftX(10, 10, 10, 10), 0);
        
        Assert.assertEquals("Test startX < 0 && endX > 0 && 0 < startY < endY", -10, tool.calculateTopLeftX(-10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX > 0 && endX < 0 && 0 < endY < startY", -10, tool.calculateTopLeftX(10, 10, -10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && 0 < startY < endY", -30, tool.calculateTopLeftX(-30, -10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && endY < startY < 0", -30, tool.calculateTopLeftX(-30, -10, -10, -20), 0);
    }
    
    @Test
    public void testCalculateTopLeftY() {
        Assert.assertEquals("Test startX < endX && startY < endY", 10, tool.calculateTopLeftY(10, 10, 30, 20), 0);
        Assert.assertEquals("Test startX > endX && startY < endY", 10, tool.calculateTopLeftY(30, 10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX && startY > endY", 10, tool.calculateTopLeftY(10, 20, 30, 10), 0);
        Assert.assertEquals("Test startX > endX && startY > endY", 10, tool.calculateTopLeftY(30, 20, 10, 10), 0);
        
        Assert.assertEquals("Test startX == endX && startY < endY", 10, tool.calculateTopLeftY(10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX == endX && startY > endY", 10, tool.calculateTopLeftY(10, 20, 10, 10), 0);
        Assert.assertEquals("Test startX > endX && startY == endY", 10, tool.calculateTopLeftY(10, 10, 30, 10), 0);
        Assert.assertEquals("Test startX < endX && startY == endY", 10, tool.calculateTopLeftY(30, 10, 10, 10), 0);
        
        Assert.assertEquals("Test startX == endX && startY == endY", 10, tool.calculateTopLeftY(10, 10, 10, 10), 0);
        
        Assert.assertEquals("Test startX < 0 && endX > 0 && 0 < startY < endY", 10, tool.calculateTopLeftY(-10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX > 0 && endX < 0 && 0 < endY < startY", 10, tool.calculateTopLeftY(10, 10, -10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && 0 < startY < endY", -10, tool.calculateTopLeftY(-30, -10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && endY < startY < 0", -20, tool.calculateTopLeftY(-30, -10, -10, -20), 0);
    }
    
    @Test
    public void testcalculateBottomRightX() {
        Assert.assertEquals("Test startX < endX && startY < endY", 30, tool.calculateBottomRightX(10, 10, 30, 20), 0);
        Assert.assertEquals("Test startX > endX && startY < endY", 30, tool.calculateBottomRightX(30, 10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX && startY > endY", 30, tool.calculateBottomRightX(10, 20, 30, 10), 0);
        Assert.assertEquals("Test startX > endX && startY > endY", 30, tool.calculateBottomRightX(30, 20, 10, 10), 0);
        
        Assert.assertEquals("Test startX == endX && startY < endY", 10, tool.calculateBottomRightX(10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX == endX && startY > endY", 10, tool.calculateBottomRightX(10, 20, 10, 10), 0);
        Assert.assertEquals("Test startX > endX && startY == endY", 30, tool.calculateBottomRightX(10, 10, 30, 10), 0);
        Assert.assertEquals("Test startX < endX && startY == endY", 30, tool.calculateBottomRightX(30, 10, 10, 10), 0);
        
        Assert.assertEquals("Test startX == endX && startY == endY", 10, tool.calculateBottomRightX(10, 10, 10, 10), 0);
        
        Assert.assertEquals("Test startX < 0 && endX > 0 && 0 < startY < endY", 10, tool.calculateBottomRightX(-10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX > 0 && endX < 0 && 0 < endY < startY", 10, tool.calculateBottomRightX(10, 10, -10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && 0 < startY < endY", 10, tool.calculateBottomRightX(-30, -10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && endY < startY < 0", -10, tool.calculateBottomRightX(-30, -10, -10, -20), 0);
    }
    
    @Test
    public void testcalculateBottomRightY() {
        Assert.assertEquals("Test startX < endX && startY < endY", 20, tool.calculateBottomRightY(10, 10, 30, 20), 0);
        Assert.assertEquals("Test startX > endX && startY < endY", 20, tool.calculateBottomRightY(30, 10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX && startY > endY", 20, tool.calculateBottomRightY(10, 20, 30, 10), 0);
        Assert.assertEquals("Test startX > endX && startY > endY", 20, tool.calculateBottomRightY(30, 20, 10, 10), 0);
        
        Assert.assertEquals("Test startX == endX && startY < endY", 20, tool.calculateBottomRightY(10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX == endX && startY > endY", 20, tool.calculateBottomRightY(10, 20, 10, 10), 0);
        Assert.assertEquals("Test startX > endX && startY == endY", 10, tool.calculateBottomRightY(10, 10, 30, 10), 0);
        Assert.assertEquals("Test startX < endX && startY == endY", 10, tool.calculateBottomRightY(30, 10, 10, 10), 0);
        
        Assert.assertEquals("Test startX == endX && startY == endY", 10, tool.calculateBottomRightY(10, 10, 10, 10), 0);
        
        Assert.assertEquals("Test startX < 0 && endX > 0 && 0 < startY < endY", 20, tool.calculateBottomRightY(-10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX > 0 && endX < 0 && 0 < endY < startY", 20, tool.calculateBottomRightY(10, 10, -10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && 0 < startY < endY", 20, tool.calculateBottomRightY(-30, -10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && endY < startY < 0", -10, tool.calculateBottomRightY(-30, -10, -10, -20), 0);
    }
    
    @Test
    public void testCreateShapeLongX(){
        Rectangle test = (Rectangle) tool.createShape(10, 10, 30, 20);
        Assert.assertEquals("Test getX == 10", test.getX(), 10, 0);
        Assert.assertEquals("Test getY == 10", test.getY() , 10, 0);
        Assert.assertEquals("Test width == 20", test.getWidth(), 20, 0);
        Assert.assertEquals("Test heigth == 10", test.getHeight(), 10, 0);
    }
    
    @Test
    public void testCreateShapeHLine(){
        Rectangle test = (Rectangle) tool.createShape(10, 10, 50, 10);
        Assert.assertEquals("Test Rectangle no Height getX == 10", test.getX(), 10, 0);
        Assert.assertEquals("Test Rectangle no Height getY == 10", test.getX(), 10, 0);
        Assert.assertEquals("Test Rectangle no Height getWidth == 40", test.getWidth(), 40, 0);
        Assert.assertEquals("Test Rectangle no Height getHeight == 0", test.getHeight(), 0, 0);
    }

    @Test
    public void testCreateShapeVLine(){
        Rectangle test = (Rectangle) tool.createShape(10, 10, 10, 50);
        Assert.assertEquals("Test Rectangle no Width getX == 10", test.getX(), 10, 0);
        Assert.assertEquals("Test Rectangle no Width getY == 10", test.getX(), 10, 0);
        Assert.assertEquals("Test Rectangle no Width getWidth == 0", test.getWidth(), 0, 0);
        Assert.assertEquals("Test Rectangle no Width getHeight == 40", test.getHeight(), 40, 0);
    }

    @Test
    public void testCreateShapePoint(){
        Rectangle test = (Rectangle) tool.createShape(10, 10, 10, 10);
        Assert.assertEquals("Test Rectangle as point getX == 10", test.getX(), 10, 0);
        Assert.assertEquals("Test Rectangle as point getY == 10", test.getX(), 10, 0);
        Assert.assertEquals("Test Rectangle as point getWidth == 0", test.getWidth(), 0, 0);
        Assert.assertEquals("Test Rectangle as point getHeight == 0", test.getHeight(), 0, 0);
    }
    
}
