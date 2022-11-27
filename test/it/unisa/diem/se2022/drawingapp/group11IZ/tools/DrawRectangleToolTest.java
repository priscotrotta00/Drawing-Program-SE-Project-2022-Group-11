/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import javafx.scene.paint.Color;
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
    public void testCalculateCoordinates1() {
        Assert.assertEquals("Test startX < endX && startY < endY", 10, tool.calculateTopLeftX(10, 10, 30, 20), 0);
        Assert.assertEquals("Test startX < endX && startY < endY", 10, tool.calculateTopLeftY(10, 10, 30, 20), 0);
        Assert.assertEquals("Test startX < endX && startY < endY", 30, tool.calculateBottomRightX(10, 10, 30, 20), 0);
        Assert.assertEquals("Test startX < endX && startY < endY", 20, tool.calculateBottomRightY(10, 10, 30, 20), 0);
    }
    
    @Test
    public void testCalculateCoordinates2() {
        Assert.assertEquals("Test startX > endX && startY < endY", 10, tool.calculateTopLeftX(30, 10, 10, 20), 0);
        Assert.assertEquals("Test startX > endX && startY < endY", 10, tool.calculateTopLeftY(30, 10, 10, 20), 0);
        Assert.assertEquals("Test startX > endX && startY < endY", 30, tool.calculateBottomRightX(30, 10, 10, 20), 0);
        Assert.assertEquals("Test startX > endX && startY < endY", 20, tool.calculateBottomRightY(30, 10, 10, 20), 0);
    }
    
    @Test
    public void testCalculateCoordinates3() {
        Assert.assertEquals("Test startX < endX && startY > endY", 10, tool.calculateTopLeftX(10, 20, 30, 10), 0);
        Assert.assertEquals("Test startX < endX && startY > endY", 10, tool.calculateTopLeftY(10, 20, 30, 10), 0);
        Assert.assertEquals("Test startX < endX && startY > endY", 30, tool.calculateBottomRightX(10, 20, 30, 10), 0);
        Assert.assertEquals("Test startX < endX && startY > endY", 20, tool.calculateBottomRightY(10, 20, 30, 10), 0);
    }
    
    @Test
    public void testCalculateCoordinates4() {
        Assert.assertEquals("Test startX > endX && startY > endY", 10, tool.calculateTopLeftX(30, 20, 10, 10), 0);
        Assert.assertEquals("Test startX > endX && startY > endY", 10, tool.calculateTopLeftY(30, 20, 10, 10), 0);
        Assert.assertEquals("Test startX > endX && startY > endY", 30, tool.calculateBottomRightX(30, 20, 10, 10), 0);
        Assert.assertEquals("Test startX > endX && startY > endY", 20, tool.calculateBottomRightY(30, 20, 10, 10), 0);
    }
    
    @Test
    public void testCalculateCoordinates5() {
        Assert.assertEquals("Test startX == endX && startY < endY", 10, tool.calculateTopLeftX(10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX == endX && startY < endY", 10, tool.calculateTopLeftY(10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX == endX && startY < endY", 10, tool.calculateBottomRightX(10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX == endX && startY < endY", 20, tool.calculateBottomRightY(10, 10, 10, 20), 0);
    }
    
    @Test
    public void testCalculateCoordinates6() {
        Assert.assertEquals("Test startX == endX && startY > endY", 10, tool.calculateTopLeftX(10, 20, 10, 10), 0);
        Assert.assertEquals("Test startX == endX && startY > endY", 10, tool.calculateTopLeftY(10, 20, 10, 10), 0);
        Assert.assertEquals("Test startX == endX && startY > endY", 10, tool.calculateBottomRightX(10, 20, 10, 10), 0);
        Assert.assertEquals("Test startX == endX && startY > endY", 20, tool.calculateBottomRightY(10, 20, 10, 10), 0);
    }
    
    @Test
    public void testCalculateCoordinates7() {
        Assert.assertEquals("Test startX > endX && startY == endY", 10, tool.calculateTopLeftX(10, 10, 30, 10), 0);
        Assert.assertEquals("Test startX > endX && startY == endY", 10, tool.calculateTopLeftY(10, 10, 30, 10), 0);
        Assert.assertEquals("Test startX > endX && startY == endY", 30, tool.calculateBottomRightX(10, 10, 30, 10), 0);
        Assert.assertEquals("Test startX > endX && startY == endY", 10, tool.calculateBottomRightY(10, 10, 30, 10), 0);
    }
    
    @Test
    public void testCalculateCoordinates8() {
        Assert.assertEquals("Test startX < endX && startY == endY", 10, tool.calculateTopLeftX(30, 10, 10, 10), 0);
        Assert.assertEquals("Test startX < endX && startY == endY", 10, tool.calculateTopLeftY(30, 10, 10, 10), 0);
        Assert.assertEquals("Test startX < endX && startY == endY", 30, tool.calculateBottomRightX(30, 10, 10, 10), 0);
        Assert.assertEquals("Test startX < endX && startY == endY", 10, tool.calculateBottomRightY(30, 10, 10, 10), 0);
    }
    
    @Test
    public void testCalculateCoordinates9() {
        Assert.assertEquals("Test startX == endX && startY == endY", 10, tool.calculateTopLeftX(10, 10, 10, 10), 0);
        Assert.assertEquals("Test startX == endX && startY == endY", 10, tool.calculateTopLeftY(10, 10, 10, 10), 0);
        Assert.assertEquals("Test startX == endX && startY == endY", 10, tool.calculateBottomRightX(10, 10, 10, 10), 0);
        Assert.assertEquals("Test startX == endX && startY == endY", 10, tool.calculateBottomRightY(10, 10, 10, 10), 0);
    }
    
    @Test
    public void testCalculateCoordinates10() {
        Assert.assertEquals("Test startX < 0 && endX > 0 && 0 < startY < endY", -10, tool.calculateTopLeftX(-10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX < 0 && endX > 0 && 0 < startY < endY", 10, tool.calculateTopLeftY(-10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX < 0 && endX > 0 && 0 < startY < endY", 10, tool.calculateBottomRightX(-10, 10, 10, 20), 0);
        Assert.assertEquals("Test startX < 0 && endX > 0 && 0 < startY < endY", 20, tool.calculateBottomRightY(-10, 10, 10, 20), 0);
    }
    
    @Test
    public void testCalculateCoordinates11() {
        Assert.assertEquals("Test startX > 0 && endX < 0 && 0 < endY < startY", -10, tool.calculateTopLeftX(10, 10, -10, 20), 0);
        Assert.assertEquals("Test startX > 0 && endX < 0 && 0 < endY < startY", 10, tool.calculateTopLeftY(10, 10, -10, 20), 0);
        Assert.assertEquals("Test startX > 0 && endX < 0 && 0 < endY < startY", 10, tool.calculateBottomRightX(10, 10, -10, 20), 0);
        Assert.assertEquals("Test startX > 0 && endX < 0 && 0 < endY < startY", 20, tool.calculateBottomRightY(10, 10, -10, 20), 0);
    }
    
    @Test
    public void testCalculateCoordinates12() {
        Assert.assertEquals("Test startX < endX < 0 && 0 < startY < endY", -30, tool.calculateTopLeftX(-30, -10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && 0 < startY < endY", -10, tool.calculateTopLeftY(-30, -10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && 0 < startY < endY", 10, tool.calculateBottomRightX(-30, -10, 10, 20), 0);
        Assert.assertEquals("Test startX < endX < 0 && 0 < startY < endY", 20, tool.calculateBottomRightY(-30, -10, 10, 20), 0);
    }

    @Test
    public void testCalculateCoordinates13() {
        Assert.assertEquals("Test startX < endX < 0 && endY < startY < 0", -30, tool.calculateTopLeftX(-30, -10, -10, -20), 0);
        Assert.assertEquals("Test startX < endX < 0 && endY < startY < 0", -20, tool.calculateTopLeftY(-30, -10, -10, -20), 0);
        Assert.assertEquals("Test startX < endX < 0 && endY < startY < 0", -10, tool.calculateBottomRightX(-30, -10, -10, -20), 0);
        Assert.assertEquals("Test startX < endX < 0 && endY < startY < 0", -10, tool.calculateBottomRightY(-30, -10, -10, -20), 0);
    }
    
    @Test
    public void testCreateShapeLongX(){
        Rectangle test = (Rectangle) tool.createShape(10, 10, 30, 20, Color.BLACK, Color.WHITE);
        Assert.assertEquals("Test getX == 10", 10, test.getX(), 0);
        Assert.assertEquals("Test getY == 10", 10, test.getY(), 0);
        Assert.assertEquals("Test width == 20", 20, test.getWidth(), 0);
        Assert.assertEquals("Test heigth == 10", 10, test.getHeight(), 0);
        Assert.assertEquals("Test stroke color", Color.BLACK.toString(), test.getStroke().toString());
        Assert.assertEquals("Test fill color", Color.WHITE.toString(), test.getFill().toString());
    }
    
    @Test
    public void testCreateShapeLongY(){
        Rectangle test = (Rectangle) tool.createShape(10, 10, 20, 30, Color.BLACK, Color.WHITE);
        Assert.assertEquals("Test getX == 10", 10, test.getX(), 0);
        Assert.assertEquals("Test getY == 10", 10, test.getY(), 0);
        Assert.assertEquals("Test width == 10", 10, test.getWidth(), 0);
        Assert.assertEquals("Test heigth == 20", 20, test.getHeight(), 0);
        Assert.assertEquals("Test stroke color", Color.BLACK.toString(), test.getStroke().toString());
        Assert.assertEquals("Test fill color", Color.WHITE.toString(), test.getFill().toString());
    }
    
    @Test
    public void testCreateShapeHLine(){
        Rectangle test = (Rectangle) tool.createShape(10, 10, 50, 10, Color.BLACK, Color.WHITE);
        Assert.assertEquals("Test Rectangle no Height getX == 10", 10, test.getX(), 0);
        Assert.assertEquals("Test Rectangle no Height getY == 10", 10, test.getY(), 0);
        Assert.assertEquals("Test Rectangle no Height getWidth == 40", 40, test.getWidth(), 0);
        Assert.assertEquals("Test Rectangle no Height getHeight == 0", 0, test.getHeight(), 0);
        Assert.assertEquals("Test stroke color", Color.BLACK.toString(), test.getStroke().toString());
        Assert.assertEquals("Test fill color", Color.WHITE.toString(), test.getFill().toString());
    }

    @Test
    public void testCreateShapeVLine(){
        Rectangle test = (Rectangle) tool.createShape(10, 10, 10, 50, Color.BLACK, Color.WHITE);
        Assert.assertEquals("Test Rectangle no Width getX == 10", 10, test.getX(), 0);
        Assert.assertEquals("Test Rectangle no Width getY == 10", 10, test.getY(), 0);
        Assert.assertEquals("Test Rectangle no Width getWidth == 0", 0, test.getWidth(), 0);
        Assert.assertEquals("Test Rectangle no Width getHeight == 40", 40, test.getHeight(), 0);
        Assert.assertEquals("Test stroke color", Color.BLACK.toString(), test.getStroke().toString());
        Assert.assertEquals("Test fill color", Color.WHITE.toString(), test.getFill().toString());
    }

    @Test
    public void testCreateShapePoint(){
        Rectangle test = (Rectangle) tool.createShape(10, 10, 10, 10, Color.BLACK, Color.WHITE);
        Assert.assertEquals("Test Rectangle as point getX == 10", 10, test.getX(), 0);
        Assert.assertEquals("Test Rectangle as point getY == 10", 10, test.getY(), 0);
        Assert.assertEquals("Test Rectangle as point getWidth == 0", 0, test.getWidth(), 0);
        Assert.assertEquals("Test Rectangle as point getHeight == 0", 0, test.getHeight(), 0);
        Assert.assertEquals("Test stroke color", Color.BLACK.toString(), test.getStroke().toString());
        Assert.assertEquals("Test fill color", Color.WHITE.toString(), test.getFill().toString());
    }
    
    @Test
    public void testCreateShapeNegativeCoordinates(){
        Rectangle test = (Rectangle) tool.createShape(-30, -20, -10, -10, Color.BLACK, Color.WHITE);
        Assert.assertEquals("Test Rectangle as point getX == -30", -30, test.getX(), 0);
        Assert.assertEquals("Test Rectangle as point getY == -20", -20, test.getY(), 0);
        Assert.assertEquals("Test Rectangle as point getWidth == 20", 20, test.getWidth(), 0);
        Assert.assertEquals("Test Rectangle as point getHeight == 10", 10, test.getHeight(), 0);
        Assert.assertEquals("Test stroke color", Color.BLACK.toString(), test.getStroke().toString());
        Assert.assertEquals("Test fill color", Color.WHITE.toString(), test.getFill().toString());
    }
    
    @Test
    public void testCreateShapeNegativePositiveCoordinates(){
        Rectangle test = (Rectangle) tool.createShape(-30, -20, 10, 10, Color.BLACK, Color.WHITE);
        Assert.assertEquals("Test Rectangle as point getX == -30", -30, test.getX(), 0);
        Assert.assertEquals("Test Rectangle as point getY == -20", -20, test.getY(), 0);
        Assert.assertEquals("Test Rectangle as point getWidth == 40", 40, test.getWidth(), 0);
        Assert.assertEquals("Test Rectangle as point getHeight == 30", 30, test.getHeight(), 0);
        Assert.assertEquals("Test stroke color", Color.BLACK.toString(), test.getStroke().toString());
        Assert.assertEquals("Test fill color", Color.WHITE.toString(), test.getFill().toString());
    }
    
    @Test
    public void testCreateShapeDifferentColors1(){
        Rectangle test = (Rectangle) tool.createShape(-30, -20, 10, 10, Color.RED, Color.PURPLE);
        Assert.assertEquals("Test stroke color", Color.RED.toString(), test.getStroke().toString());
        Assert.assertEquals("Test fill color", Color.PURPLE.toString(), test.getFill().toString());
    }
    
    @Test
    public void testCreateShapeDifferentColors2(){
        Rectangle test = (Rectangle) tool.createShape(-30, -20, 10, 10, Color.web("#f68"), Color.color(1, 0.5, 0.45));
        Assert.assertEquals("Test stroke color", Color.web("#f68").toString(), test.getStroke().toString());
        Assert.assertEquals("Test fill color", Color.color(1, 0.5, 0.45).toString(), test.getFill().toString());
    }
    
    @Test
    public void testModifyCreatedShapeLongX() {
        this.tool.setCreatedShape(new MyEnhancedRectangle());
        this.tool.modifyCreatedShape(10, 10, 30, 20);
        MyRectangle test = (MyRectangle) this.tool.getCreatedShape();
        Assert.assertEquals("Test getX == 10", 10, test.myGetX(), 0);
        Assert.assertEquals("Test getY == 10", 10, test.myGetY(), 0);
        Assert.assertEquals("Test width == 20", 20, test.myGetWidth(), 0);
        Assert.assertEquals("Test heigth == 10", 10, test.myGetHeight(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeLongY() {
        this.tool.setCreatedShape(new MyEnhancedRectangle());
        this.tool.modifyCreatedShape(10, 10, 20, 30);
        MyRectangle test = (MyRectangle) this.tool.getCreatedShape();
        Assert.assertEquals("Test getX == 10", 10, test.myGetX(), 0);
        Assert.assertEquals("Test getY == 10", 10, test.myGetY(), 0);
        Assert.assertEquals("Test width == 10", 10, test.myGetWidth(), 0);
        Assert.assertEquals("Test heigth == 20", 20, test.myGetHeight(), 0);
    }
    
    @Test
    public void testModifyCreatedShapeHLine() {
        this.tool.setCreatedShape(new MyEnhancedRectangle());
        this.tool.modifyCreatedShape(10, 10, 50, 10);
        MyRectangle test = (MyRectangle) this.tool.getCreatedShape();
        Assert.assertEquals("Test Rectangle no Height getX == 10", 10, test.myGetX(), 0);
        Assert.assertEquals("Test Rectangle no Height getY == 10", 10, test.myGetY(), 0);
        Assert.assertEquals("Test Rectangle no Height getWidth == 40", 40, test.myGetWidth(), 0);
        Assert.assertEquals("Test Rectangle no Height getHeight == 0", 0, test.myGetHeight(), 0);
    }
    
    @Test
    public void testModifyCreatedShapePoint() {
        this.tool.setCreatedShape(new MyEnhancedRectangle());
        this.tool.modifyCreatedShape(10, 10, 10, 10);
        Rectangle test = (Rectangle) this.tool.getCreatedShape();
        Assert.assertEquals("Test Rectangle as point getX == 10", 10, test.getX(), 0);
        Assert.assertEquals("Test Rectangle as point getY == 10", 10, test.getY(), 0);
        Assert.assertEquals("Test Rectangle as point getWidth == 0", 0, test.getWidth(), 0);
        Assert.assertEquals("Test Rectangle as point getHeight == 0", 0, test.getHeight(), 0);
    }
    
    @Test
    public void testModifyShapeNegativeCoordinates() {
        this.tool.setCreatedShape(new MyEnhancedRectangle());
        this.tool.modifyCreatedShape(-30, -20, -10, -10);
        Rectangle test = (Rectangle) this.tool.getCreatedShape();
        Assert.assertEquals("Test Rectangle as point getX == -30", -30, test.getX(), 0);
        Assert.assertEquals("Test Rectangle as point getY == -20", -20, test.getY(), 0);
        Assert.assertEquals("Test Rectangle as point getWidth == 20", 20, test.getWidth(), 0);
        Assert.assertEquals("Test Rectangle as point getHeight == 10", 10, test.getHeight(), 0);
    }
    
    @Test
    public void testModifyShapeNegativePositiveCoordinates() {
        this.tool.setCreatedShape(new MyEnhancedRectangle());
        this.tool.modifyCreatedShape(-30, -20, 10, 10);
        Rectangle test = (Rectangle) this.tool.getCreatedShape();
        Assert.assertEquals("Test Rectangle as point getX == -30", -30, test.getX(), 0);
        Assert.assertEquals("Test Rectangle as point getY == -20", -20, test.getY(), 0);
        Assert.assertEquals("Test Rectangle as point getWidth == 40", 40, test.getWidth(), 0);
        Assert.assertEquals("Test Rectangle as point getHeight == 30", 30, test.getHeight(), 0);
    }
}
