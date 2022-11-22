/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author utente
 */
public class DrawShapeTest {
    
    private DrawShape tool;
    
    @Before
    public void setUp() {
        tool = DrawRectangle.getInstance();
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
    }
    
}
