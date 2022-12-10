/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.AddedDuplicateException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ShapeNotFoundException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Assert;

/**
 * 
 * @author Felice Scala
 */
public class CreateShapeCommandTest {
    private Canvas c;
    private Field drawPaneField;
    private Field drawingField;
    private Pane pane;
    private Drawing draw;
    
    public static class AsNonApp extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            //NOOP
        }
        
    }
    
    @BeforeClass
    public static void initJFX() {
        Thread t = new Thread("JavaFX Init Thread") {
            @Override
            public void run() {
                Application.launch(AsNonApp.class, new String[0]);
            }
        };
        t.setDaemon(true);
        t.start();
    }
    
    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException{
        c = new Canvas();
        pane = new Pane();
        
        drawPaneField = Canvas.class.getDeclaredField("drawPane");
        
        drawPaneField.setAccessible(true);
        
        drawPaneField.set(c, pane);
        this.c.initialize(null, null);
        draw = this.c.getDraw();
    }
    
    @Test
    public void testExecute1() {
        MyShape shape = new MyEnhancedRectangle();
        Command command = new CreateShapeCommand(c, shape);
        command.execute();
        Iterator<MyShape> iter = draw.iterator();
        Assert.assertTrue("Verify shape is inserted in pane", pane.getChildrenUnmodifiable().contains((Shape) shape));
        Assert.assertTrue("Verify shape is inserted in drawing", iter.next() == shape);
    }
    
    @Test (expected=AddedDuplicateException.class)
    public void testExecute2() {
        MyEnhancedLine line=new MyEnhancedLine();
        new CreateShapeCommand(c, line).execute();
        //insert line again, so an exception will be thrown
        new CreateShapeCommand(c, line).execute();
    }
    
    @Test
    public void testExecute3(){
        //test add ellipse
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        new CreateShapeCommand(c, ellipse).execute();
        //check if ellipse is in figures. If ellipse is in figures, add went well, else throws exception.
        Iterator<MyShape> iter = draw.iterator();
        Assert.assertTrue("Ellipse is not in figures", iter.next() == ellipse);
        Assert.assertTrue("Verify Ellipse is in Pane", pane.getChildrenUnmodifiable().contains(ellipse));
        
        //test add rectangle
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        new CreateShapeCommand(c, rectangle).execute();
        iter = draw.iterator();
        iter.next();
        //check if rectangle is in figures. If rectangle is in figures, add went well, else throws exception.
        Assert.assertTrue("Rectangle is not in figures", iter.next() == rectangle);
        Assert.assertTrue("Verify Rectangle is in Pane", pane.getChildrenUnmodifiable().contains(rectangle));
        
        //test add line
        MyEnhancedLine line=new MyEnhancedLine();
        new CreateShapeCommand(c, line).execute();
        iter = draw.iterator();
        iter.next();
        iter.next();
        //check if line is in figures. If line is in figures, add went well, else throws exception.
        Assert.assertTrue("Line is not in figures", iter.next() == line);
        Assert.assertTrue("Verify Line is in Pane", pane.getChildrenUnmodifiable().contains(line));
    }
        
    @Test
    public void testUndo1(){
        MyShape shape = new MyEnhancedRectangle();
        Command command = new CreateShapeCommand(c, shape);
        command.execute();
        command.undo();
        Iterator<MyShape> iter = draw.iterator();
        Assert.assertFalse("Verify shape is not in pane anymore", pane.getChildrenUnmodifiable().contains((Shape) shape));
        Assert.assertFalse("Verify shape is not in drawing anymore", iter.hasNext());
    }
    
    @Test
    public void testUndo2(){
        //test add ellipse
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        Command command1 = new CreateShapeCommand(c, ellipse);
        command1.execute();
        Iterator<MyShape> iter = draw.iterator();
        //check if ellipse is in figures. If ellipse is in figures, add went well, else throws exception.
        Assert.assertTrue("Ellipse is not in figures", iter.next() == ellipse);
        Assert.assertTrue("Verify Ellipse is in Pane", pane.getChildrenUnmodifiable().contains(ellipse));
        
        //test add rectangle
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        Command command2 = new CreateShapeCommand(c, rectangle);
        command2.execute();
        iter = draw.iterator();
        iter.next();
        //check if rectangle is in figures. If rectangle is in figures, add went well, else throws exception.
        Assert.assertTrue("Rectangle is not in figures", iter.next() == rectangle);
        Assert.assertTrue("Verify Rectangle is in Pane", pane.getChildrenUnmodifiable().contains(rectangle));
        
        //test add line
        MyEnhancedLine line=new MyEnhancedLine();
        Command command3 = new CreateShapeCommand(c, line);
        command3.execute();
        iter = draw.iterator();
        iter.next();
        iter.next();
        //check if line is in figures. If line is in figures, add went well, else throws exception.
        Assert.assertTrue("Line is not in figures", iter.next() == line);
        Assert.assertTrue("Verify Line is in Pane", pane.getChildrenUnmodifiable().contains(line));
    }
    
    @Test(expected=ShapeNotFoundException.class)
    public void testUndo3(){
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        Command command1 = new CreateShapeCommand(c, ellipse);
        command1.execute();
        command1.undo();
        //check expection when you try to undo twice
        command1.undo();
    }
}
