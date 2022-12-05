/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.commands.exceptions.NoNewCoordinatesException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.InvalidCoordinatesException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author utente
 */
public class ResizeEllipseCommandTest {
    private MyEllipse shape;
    private ResizeShapeCommand command;
    
    @Before
    public void setUp(){
        this.shape = new MyEnhancedEllipse();
    }
    
    @Test
    public void testExecute1(){
        this.command = new ResizeEllipseCommand(shape, 10, 10, 50, 20);
        this.command.execute();
        
        Assert.assertEquals(10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(10, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(50, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(20, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(30, this.shape.myGetCenterX(), 0);
        Assert.assertEquals(15, this.shape.myGetCenterY(), 0);
        Assert.assertEquals(20, this.shape.myGetRadiusX(), 0);
        Assert.assertEquals(5, this.shape.myGetRadiusY(), 0);
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testExecute2(){
        this.command = new ResizeEllipseCommand(shape, 50, 20, 10, 10);
        this.command.execute();
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testExecute3(){
        this.command = new ResizeEllipseCommand(shape, 50, 20, 70, 10);
        this.command.execute();
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testExecute4(){
        this.command = new ResizeEllipseCommand(shape, 50, 20, 10, 70);
        this.command.execute();
    }
    
    @Test
    public void testExecute5(){
        this.command = new ResizeEllipseCommand(shape, -10, -20, 30, 60);
        this.command.execute();
        
        Assert.assertEquals(-10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(-20, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(60, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(10, this.shape.myGetCenterX(), 0);
        Assert.assertEquals(20, this.shape.myGetCenterY(), 0);
        Assert.assertEquals(20, this.shape.myGetRadiusX(), 0);
        Assert.assertEquals(40, this.shape.myGetRadiusY(), 0);
    }
    
    @Test
    public void testExecute6(){
        this.command = new ResizeEllipseCommand(shape, 10, -20, 30, 60);
        this.command.execute();
        
        Assert.assertEquals(10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(-20, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(60, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(20, this.shape.myGetCenterX(), 0);
        Assert.assertEquals(20, this.shape.myGetCenterY(), 0);
        Assert.assertEquals(10, this.shape.myGetRadiusX(), 0);
        Assert.assertEquals(40, this.shape.myGetRadiusY(), 0);
    }
    
    @Test
    public void testExecute7(){
        this.command = new ResizeEllipseCommand(shape, -50, 20, 30, 60);
        this.command.execute();
        
        Assert.assertEquals(-50, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(20, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(60, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(-10, this.shape.myGetCenterX(), 0);
        Assert.assertEquals(40, this.shape.myGetCenterY(), 0);
        Assert.assertEquals(40, this.shape.myGetRadiusX(), 0);
        Assert.assertEquals(20, this.shape.myGetRadiusY(), 0);
    }
    
    @Test
    public void testExecute8(){
        this.command = new ResizeEllipseCommand(shape, -30, -60, -20, -20);
        this.command.execute();
        
        Assert.assertEquals(-30, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(-60, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(-20, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(-20, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(-25, this.shape.myGetCenterX(), 0);
        Assert.assertEquals(-40, this.shape.myGetCenterY(), 0);
        Assert.assertEquals(5, this.shape.myGetRadiusX(), 0);
        Assert.assertEquals(20, this.shape.myGetRadiusY(), 0);
    }
    
    @Test
    public void testExecute9(){
        this.command = new ResizeEllipseCommand(shape, -50, 20, -30, 60);
        this.command.execute();
        
        Assert.assertEquals(-50, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(20, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(-30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(60, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(-40, this.shape.myGetCenterX(), 0);
        Assert.assertEquals(40, this.shape.myGetCenterY(), 0);
        Assert.assertEquals(10, this.shape.myGetRadiusX(), 0);
        Assert.assertEquals(20, this.shape.myGetRadiusY(), 0);
    }
    
    @Test
    public void testExecute10(){
        this.command = new ResizeEllipseCommand(shape, 10, -60, 30, -20);
        this.command.execute();
        
        Assert.assertEquals(10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(-60, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(30, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(-20, this.shape.getBottomRightY(), 0);
        
        Assert.assertEquals(20, this.shape.myGetCenterX(), 0);
        Assert.assertEquals(-40, this.shape.myGetCenterY(), 0);
        Assert.assertEquals(10, this.shape.myGetRadiusX(), 0);
        Assert.assertEquals(20, this.shape.myGetRadiusY(), 0);
    }
    
    @Test(expected = NoNewCoordinatesException.class)
    public void testExecute11(){
        this.command = new ResizeEllipseCommand(shape);
        this.command.execute();
    }
    
    @Test
    public void testUndo1(){
        new ResizeEllipseCommand(shape, 10, 40, 50, 60).execute();
        
        this.command = new ResizeEllipseCommand(shape, 10, 40, 80, 70);
        this.command.execute();
        this.command.undo();
        
        Assert.assertEquals(10, this.shape.getTopLeftX(), 0);
        Assert.assertEquals(40, this.shape.getTopLeftY(), 0);
        Assert.assertEquals(50, this.shape.getBottomRightX(), 0);
        Assert.assertEquals(60, this.shape.getBottomRightY(), 0);
    }
    
    @Test
    public void testUndo2(){
        ResizeEllipseCommand command1;
        ResizeEllipseCommand command2;
        ResizeEllipseCommand command3;
        
        command1 = new ResizeEllipseCommand(shape, -10, -35, 40, 50);
        command1.execute();
        
        command2 = new ResizeEllipseCommand(shape);
        command2.setNewCoordinates(20, 20, 20, 20);
        command2.execute();
        
        command3 = new ResizeEllipseCommand(shape);
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
