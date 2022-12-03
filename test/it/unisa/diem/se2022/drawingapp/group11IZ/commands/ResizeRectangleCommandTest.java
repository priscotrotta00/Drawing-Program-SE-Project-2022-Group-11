/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.commands.exceptions.NoNewCoordinatesException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.InvalidCoordinatesException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author utente
 */
public class ResizeRectangleCommandTest {
    private MyRectangle shape;
    private ResizeShapeCommand command;
    
    @Before
    public void setUp(){
        this.shape = new MyEnhancedRectangle();
    }
    
    @Test(expected=NoNewCoordinatesException.class)
    public void testExecute1(){
        this.command = new ResizeRectangleCommand(shape);
        this.command.execute();
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testExecute2(){
        this.command = new ResizeRectangleCommand(shape, 10, 30, -10, -20);
        this.command.execute();
    }
    
    @Test
    public void testExecute3(){
        this.command = new ResizeRectangleCommand(shape, 10, 10, 30, 20);
        this.command.execute();
        
        Assert.assertEquals(10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(10, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(20, this.shape.getBottomRightY(), 0);
    }
    
    @Test
    public void testExecute4(){
        this.command = new ResizeRectangleCommand(shape, 10, 10, 50, 20);
        this.command.execute();
        
        Assert.assertEquals(10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(10, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(50, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(20, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(40, this.shape.myGetWidth(), 0);
        Assert.assertEquals(10, this.shape.myGetHeight(), 0);
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testExecute5(){
        this.command = new ResizeRectangleCommand(shape, 50, 20, 10, 10);
        this.command.execute();
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testExecute6(){
        this.command = new ResizeRectangleCommand(shape, 50, 20, 70, 10);
        this.command.execute();
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testExecute7(){
        this.command = new ResizeRectangleCommand(shape, 50, 20, 10, 70);
        this.command.execute();
    }
    
    @Test
    public void testExecute8(){
        this.command = new ResizeRectangleCommand(shape, -10, -20, 30, 60);
        this.command.execute();
        
        Assert.assertEquals(-10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(-20, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(60, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(40, this.shape.myGetWidth(), 0);
        Assert.assertEquals(80, this.shape.myGetHeight(), 0);
    }
    
    @Test
    public void testExecute9(){
        this.command = new ResizeRectangleCommand(shape, 10, -20, 30, 60);
        this.command.execute();
        
        Assert.assertEquals(10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(-20, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(60, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(20, this.shape.myGetWidth(), 0);
        Assert.assertEquals(80, this.shape.myGetHeight(), 0);
    }
    
    @Test
    public void testExecute10(){
        this.command = new ResizeRectangleCommand(shape, -50, 20, 30, 60);
        this.command.execute();
        
        Assert.assertEquals(-50, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(20, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(60, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(80, this.shape.myGetWidth(), 0);
        Assert.assertEquals(40, this.shape.myGetHeight(), 0);
    }
    
    @Test
    public void testExecute11(){
        this.command = new ResizeRectangleCommand(shape, -30, -60, -20, -20);
        this.command.execute();
        
        Assert.assertEquals(-30, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(-60, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(-20, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(-20, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(10, this.shape.myGetWidth(), 0);
        Assert.assertEquals(40, this.shape.myGetHeight(), 0);
    }
    
    @Test
    public void testExecute12(){
        this.command = new ResizeRectangleCommand(shape, -50, 20, -30, 60);
        this.command.execute();
        
        Assert.assertEquals(-50, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(20, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(-30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(60, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(20, this.shape.myGetWidth(), 0);
        Assert.assertEquals(40, this.shape.myGetHeight(), 0);
    }
    
    @Test
    public void testExecute13(){
        this.command = new ResizeRectangleCommand(shape, 10, -60, 30, -20);
        this.command.execute();
        
        Assert.assertEquals(10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(-60, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(-20, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(20, this.shape.myGetWidth(), 0);
        Assert.assertEquals(40, this.shape.myGetHeight(), 0);
    }
    
    @Test
    public void testUndo1(){
        new ResizeRectangleCommand(shape, 10, 40, 50, 60).execute();
        
        this.command = new ResizeRectangleCommand(shape, 10, 40, 80, 70);
        this.command.execute();
        this.command.undo();
        
        Assert.assertEquals(10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(40, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(50, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(60, this.shape.getBottomRightY(), 0);
    }
    
    @Test
    public void testUndo2(){
        ResizeRectangleCommand command1;
        ResizeRectangleCommand command2;
        ResizeRectangleCommand command3;
        
        command1 = new ResizeRectangleCommand(shape, -10, -35, 40, 50);
        command1.execute();
        
        command2 = new ResizeRectangleCommand(shape);
        command2.setNewCoordinates(20, 20, 20, 20);
        command2.execute();
        
        command3 = new ResizeRectangleCommand(shape);
        command3.setNewCoordinates(30, 40, 100, 60);
        command3.execute();
        
        command3.undo();
        command2.undo();
        
        Assert.assertEquals(-10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(-35, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(40, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(50, this.shape.getBottomRightY(), 0);
    }
}
