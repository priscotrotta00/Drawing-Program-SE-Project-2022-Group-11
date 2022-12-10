/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author prisc
 */
public class PasteShapeCommandTest {
    
    private Canvas c;
    private Pane pane;
    private Selection selection;
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
        Field drawPaneField;
        
        this.c = new Canvas();
        this.pane = new Pane();
        
        drawPaneField = Canvas.class.getDeclaredField("drawPane");
        drawPaneField.setAccessible(true);
        drawPaneField.set(this.c, this.pane);
        this.c.initialize(null, null);
        
        this.draw = this.c.getDraw();
        this.selection = this.c.getSelection();
        
    }
    
    
    @Test (expected = NullPointerException.class)
    public void testNullController(){
        this.c = null;
        MyRectangle myRectangle = new MyEnhancedRectangle();
        PasteShapeCommand psc = new PasteShapeCommand(this.c, myRectangle);
    }
    
    @Test (expected = NullPointerException.class)
    public void testNullShape(){
        MyRectangle myRectangle = null;
        PasteShapeCommand psc = new PasteShapeCommand(this.c, myRectangle);
    }
    
    @Test
    public void testPasteShape() {
        MyRectangle myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        myRectangle.mySetStroke(Color.BLACK);
        myRectangle.mySetLayoutX(50.0);
        myRectangle.mySetLayoutY(50.0);
        myRectangle.mySetHeight(30.0);
        myRectangle.mySetWidth(70.0);
        
        PasteShapeCommand psc = new PasteShapeCommand(this.c, myRectangle);
        psc.execute();
        Iterator<MyShape> iter = draw.iterator();
        MyShape myShape;
        myShape = iter.next();
        
        assertEquals("Error in the paste of the rectangle", myShape.toString(), myRectangle.toString());
        
        MyEllipse myEllipse = new MyEnhancedEllipse();
        
        PasteShapeCommand psc2 = new PasteShapeCommand(this.c, myEllipse);
        psc2.execute();
        iter = draw.iterator();
        iter.next();
        myShape = iter.next();;
        
        assertEquals("Error in the paste of the ellipse", myShape.toString(), myEllipse.toString());
        
        MyLine myLine = new MyEnhancedLine();
        
        PasteShapeCommand psc3 = new PasteShapeCommand(this.c, myLine);
        psc3.execute();
        
        iter = draw.iterator();
        iter.next();
        iter.next();
        myShape = iter.next();;
        
        assertEquals("Error in the paste of the line", myShape.toString(), myLine.toString());
    }
    
    @Test
    public void testUndoPasteShape() {
        MyRectangle myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        myRectangle.mySetStroke(Color.BLACK);
        myRectangle.mySetLayoutX(50.0);
        myRectangle.mySetLayoutY(50.0);
        myRectangle.mySetHeight(30.0);
        myRectangle.mySetWidth(70.0);
        
        PasteShapeCommand psc = new PasteShapeCommand(this.c, myRectangle);
        psc.execute();
        Iterator<MyShape> iter = draw.iterator();
        MyShape myShape = iter.next();
        assertEquals("Error in the paste of the shape", myShape.toString(), myRectangle.toString());
        
        psc.undo();
        assertTrue("Error in the undo paste of the shape", iter.hasNext());
    }
    
}
