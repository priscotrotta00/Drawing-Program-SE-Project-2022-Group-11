/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import java.lang.reflect.Field;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author prisc
 */
public class PasteShapeCommandTest {
    
    private Controller c;
    private Field drawField;
    private Field figuresField;
    private Field drawPaneField;
    private Pane pane;
    private Drawing draw;
    private List<MyShape> figures;
    
    //per ottenere i bottoni su cui fare controlli bind
    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.c = new Controller();
        this.pane = new Pane();
        this.draw = new Drawing();

        drawPaneField = Controller.class.getDeclaredField("drawPane");
        drawField = Controller.class.getDeclaredField("draw");
        figuresField = Drawing.class.getDeclaredField("figures");

        drawPaneField.setAccessible(true);
        drawField.setAccessible(true);
        figuresField.setAccessible(true);

        drawPaneField.set(c, pane);
        drawField.set(c, draw);
        figures = (List<MyShape>) figuresField.get(draw);

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
        
        MyShape myShape;
        myShape = figures.get(0);
        
        assertEquals("Error in the paste of the rectangle", myShape.toString(), myRectangle.toString());
        
        MyEllipse myEllipse = new MyEnhancedEllipse();
        
        PasteShapeCommand psc2 = new PasteShapeCommand(this.c, myEllipse);
        psc2.execute();
        
        myShape = figures.get(1);
        
        assertEquals("Error in the paste of the ellipse", myShape.toString(), myEllipse.toString());
        
        MyLine myLine = new MyEnhancedLine();
        
        PasteShapeCommand psc3 = new PasteShapeCommand(this.c, myLine);
        psc3.execute();
        
        myShape = figures.get(2);
        
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
        
        MyShape myShape = figures.get(0);
        assertEquals("Error in the paste of the shape", myShape.toString(), myRectangle.toString());
        
        psc.undo();
        assertTrue("Error in the undo paste of the shape", figures.isEmpty());
    }
    
}
