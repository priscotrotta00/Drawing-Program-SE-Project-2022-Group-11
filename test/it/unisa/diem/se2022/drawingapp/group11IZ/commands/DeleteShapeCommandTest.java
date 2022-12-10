/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ShapeNotFoundException;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author saram
 */
public class DeleteShapeCommandTest {

    private Canvas c;
    private Field figuresField;
    private Field drawPaneField;
    private Pane pane;
    private Drawing draw;
    private List<MyShape> figures;
    private Field selectionField;
    private Selection selection;

    private DeleteShapeCommand deleteCommand;
    
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

    //per ottenere i bottoni su cui fare controlli bind
    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.c = new Canvas();
        this.pane = new Pane();

        drawPaneField = Canvas.class.getDeclaredField("drawPane");
        figuresField = Drawing.class.getDeclaredField("figures");

        drawPaneField.setAccessible(true);
        figuresField.setAccessible(true);

        drawPaneField.set(c, pane);
        this.c.initialize(null, null);
        
        draw = this.c.getDraw();
        figures = (List<MyShape>) figuresField.get(draw);

    }

    @Test(expected = ShapeNotFoundException.class)
    public void executeTest6() throws NoSuchFieldException, IllegalAccessException, Exception {
        //test delete a shape that is not in drawpane and figures, so addShape in drawing throw exception. Check if i have this exception
        MyEnhancedLine line = new MyEnhancedLine();
        deleteCommand = new DeleteShapeCommand(c, line);
        deleteCommand.execute();
    }

    @Test(expected = ShapeNotFoundException.class)
    public void executeTest7() throws NoSuchFieldException, IllegalAccessException, Exception {
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        deleteCommand = new DeleteShapeCommand(c, rectangle);
        deleteCommand.execute();

    }

    @Test(expected = ShapeNotFoundException.class)
    public void executeTest8() throws NoSuchFieldException, IllegalAccessException, Exception {
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        deleteCommand = new DeleteShapeCommand(c, ellipse);
        deleteCommand.execute();

    }

    @Test
    public void executeTest9() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        //add element in figures and pane and after delete it

        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeE.execute();
        createShapeR.execute();
        createShapeL.execute();

        deleteCommand = new DeleteShapeCommand(c, ellipse);
        deleteCommand.execute();
        //check if ellipse is delete from figures
        Iterator<MyShape> iter=draw.iterator();
        assertNotEquals("Ellipse is not delete from figures", iter.next(),ellipse);
        //check if in pos0 i have rectangle and in pos1 i have line
        int layer1 = draw.getShapeLayer(rectangle);
        assertEquals("Error in remove", layer1, 0);
        layer1 = draw.getShapeLayer(line);
        assertEquals("Error in remove", layer1, 1);
        //check drawPane
        assertFalse("Error in removeShape", pane.getChildren().contains(ellipse));

        //test remove rectangle
        deleteCommand = new DeleteShapeCommand(c, rectangle);
        deleteCommand.execute();
        Iterator<MyShape> iter2=draw.iterator();
        //check if rectangle is delete from figures
        assertNotEquals("Rectangle is not delete from figures", iter2.next(),rectangle);
        assertFalse("Error in removeShape", pane.getChildren().contains(rectangle));

        //test remove line
        deleteCommand = new DeleteShapeCommand(c, line);
        deleteCommand.execute();
        //check if line is delete from figures
        Iterator<MyShape> iter3=draw.iterator();
        assertFalse("Line is not delete from figures",iter3.hasNext());
        assertFalse("Error in removeShape", pane.getChildren().contains(line));

    }

    @Test
    public void executeTest10() throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        selection = this.c.getSelection();

        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeE.execute();
        createShapeR.execute();
        createShapeL.execute();

        selection.select(ellipse);
        deleteCommand = new DeleteShapeCommand(c, selection.getSelectedItem());
        deleteCommand.execute();
        Iterator<MyShape> iter=draw.iterator();
        //check if ellipse is delete from figures
        assertNotEquals("Ellipse is not delete from figures", iter.next(),ellipse);
        //check if in pos0 i have rectangle and in pos1 i have line
        int layer1 = draw.getShapeLayer(rectangle);
        assertEquals("Error in remove", layer1, 0);
        layer1 = draw.getShapeLayer(line);
        assertEquals("Error in remove", layer1, 1);
        //check drawPane
        assertFalse("Error in removeShape", pane.getChildren().contains(ellipse));
    }

    @Test
    public void executeTest11() throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        selection = this.c.getSelection();

        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeE.execute();
        createShapeR.execute();
        createShapeL.execute();

        selection.select(line);
        deleteCommand = new DeleteShapeCommand(c, selection.getSelectedItem());
        deleteCommand.execute();
        Iterator<MyShape> iter=draw.iterator();
        assertEquals("Error in delete", iter.next(),ellipse);
        assertEquals("Error in delete", iter.next(),rectangle);
        //check if line is delete from figures
        assertFalse("Ellipse is not delete from figures", iter.hasNext());
        //check drawPane
        assertFalse("Error in removeShape", pane.getChildren().contains(line));

    }

    @Test
    public void executeTest12() throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        selection = this.c.getSelection();

        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeE.execute();
        createShapeR.execute();
        createShapeL.execute();

        selection.select(rectangle);
        deleteCommand = new DeleteShapeCommand(c, rectangle);
        deleteCommand.execute();
        //check if ellipse is delete from figures
        Iterator<MyShape> iter=draw.iterator();
        assertEquals("rectangle is not delete from figures", iter.next(),ellipse);
        assertEquals("rectangle is not delete from figures", iter.next(),line);
        assertFalse("rectangle is not delete from figures", iter.hasNext());
        
       // System.out.println(pane.getChildren());
        
        //check drawPane
        assertFalse("Error in removeShape", pane.getChildren().contains(rectangle));
        assertEquals("Error in removeShape", pane.getChildren().get(0),ellipse);
        assertEquals("Error in removeShape", pane.getChildren().get(1),line);
        
    }
    
    
    @Test 
    public void undoTest1() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        selection = this.c.getSelection();

        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeE.execute();
        createShapeR.execute();
        createShapeL.execute();
        selection.select(rectangle);
        deleteCommand = new DeleteShapeCommand(c, selection.getSelectedItem());
        deleteCommand.execute();
        
        deleteCommand.undo();
        //check if rectangle is in figures and in pane
        Iterator<MyShape> iter=draw.iterator();
        assertEquals("rectangle is not insert in figures", iter.next(),ellipse);
        assertEquals("rectangle is not insert in figures", iter.next(),rectangle);
        assertEquals("rectangle is not insert in figures", iter.next(),line);
        //check layer of ellipse
        assertTrue("error in undo",this.pane.getChildren().contains(ellipse));
        assertTrue("error in undo",this.pane.getChildren().indexOf(ellipse)==0);
        assertTrue("error in undo",this.pane.getChildren().indexOf(rectangle)==1);
        assertTrue("error in undo",this.pane.getChildren().indexOf(line)==2);
        
    }
    
    @Test(expected=ShapeNotFoundException.class)
    public void undoTest2(){
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        Command command1 = new CreateShapeCommand(c, ellipse);
        command1.execute();
        command1.undo();
        //check expection when you try to undo twice
        command1.undo();
    }
}
