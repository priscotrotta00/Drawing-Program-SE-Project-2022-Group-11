/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.AddedDuplicateException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ShapeNotFoundException;
import java.lang.reflect.Field;
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
    private Controller c;
    private Field drawPaneField;
    private Field drawingField;
    private Field figuresDrawingField;
    private Pane pane;
    private Drawing draw;
    private List<MyShape> figures;
    
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
        c = new Controller();
        pane = new Pane();
        draw = new Drawing();
        
        drawPaneField = Controller.class.getDeclaredField("drawPane");
        drawingField = Controller.class.getDeclaredField("draw");
        figuresDrawingField = Drawing.class.getDeclaredField("figures");
        
        drawPaneField.setAccessible(true);
        drawingField.setAccessible(true);
        figuresDrawingField.setAccessible(true);
        
        drawPaneField.set(c, pane);
        drawingField.set(c, draw);
        figures = (List<MyShape>) figuresDrawingField.get(draw);
    }
    
    @Test
    public void testExecute1() {
        MyShape shape = new MyEnhancedRectangle();
        Command command = new CreateShapeCommand(c, shape);
        command.execute();
        
        Assert.assertTrue("Verify shape is inserted in pane", pane.getChildrenUnmodifiable().contains((Shape) shape));
        Assert.assertTrue("Verify shape is inserted in drawing", figures.contains(shape));
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
        Assert.assertTrue("Ellipse is not in figures", figures.contains(ellipse));
        Assert.assertTrue("Verify Ellipse is in Pane", pane.getChildrenUnmodifiable().contains(ellipse));
        
        //test add rectangle
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        new CreateShapeCommand(c, rectangle).execute();
        //check if rectangle is in figures. If rectangle is in figures, add went well, else throws exception.
        Assert.assertTrue("Rectangle is not in figures", figures.contains(rectangle));
        Assert.assertTrue("Verify Rectangle is in Pane", pane.getChildrenUnmodifiable().contains(rectangle));
        
        //test add line
        MyEnhancedLine line=new MyEnhancedLine();
        new CreateShapeCommand(c, line).execute();
        //check if line is in figures. If line is in figures, add went well, else throws exception.
        Assert.assertTrue("Line is not in figures", figures.contains(line));
        Assert.assertTrue("Verify Line is in Pane", pane.getChildrenUnmodifiable().contains(line));
    }
        
    @Test
    public void testUndo1(){
        MyShape shape = new MyEnhancedRectangle();
        Command command = new CreateShapeCommand(c, shape);
        command.execute();
        command.undo();
        
        Assert.assertFalse("Verify shape is not in pane anymore", pane.getChildrenUnmodifiable().contains((Shape) shape));
        Assert.assertFalse("Verify shape is not in drawing anymore", figures.contains(shape));
    }
    
    @Test
    public void testUndo2(){
        //test add ellipse
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        Command command1 = new CreateShapeCommand(c, ellipse);
        command1.execute();
        //check if ellipse is in figures. If ellipse is in figures, add went well, else throws exception.
        Assert.assertTrue("Ellipse is not in figures", figures.contains(ellipse));
        Assert.assertTrue("Verify Ellipse is in Pane", pane.getChildrenUnmodifiable().contains(ellipse));
        
        //test add rectangle
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        Command command2 = new CreateShapeCommand(c, rectangle);
        command2.execute();
        //check if rectangle is in figures. If rectangle is in figures, add went well, else throws exception.
        Assert.assertTrue("Rectangle is not in figures", figures.contains(rectangle));
        Assert.assertTrue("Verify Rectangle is in Pane", pane.getChildrenUnmodifiable().contains(rectangle));
        
        //test add line
        MyEnhancedLine line=new MyEnhancedLine();
        Command command3 = new CreateShapeCommand(c, line);
        command3.execute();
        //check if line is in figures. If line is in figures, add went well, else throws exception.
        Assert.assertTrue("Line is not in figures", figures.contains(line));
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
