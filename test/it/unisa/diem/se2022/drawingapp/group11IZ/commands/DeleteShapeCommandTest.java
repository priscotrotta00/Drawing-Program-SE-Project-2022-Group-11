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
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ShapeNotFoundException;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import java.lang.reflect.Field;
import java.util.List;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    private Field drawField;
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
        assertFalse("Ellipse is not delete from figures", figures.contains(ellipse));
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
        //check if rectangle is delete from figures
        assertFalse("Rectangle is not delete from figures", figures.contains(rectangle));
        assertFalse("Error in removeShape", pane.getChildren().contains(rectangle));

        //test remove line
        deleteCommand = new DeleteShapeCommand(c, line);
        deleteCommand.execute();
        //check if line is delete from figures
        assertFalse("Line is not delete from figures", figures.contains(line));
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
        //check if ellipse is delete from figures
        assertFalse("Ellipse is not delete from figures", figures.contains(ellipse));
        //check if in pos0 i have rectangle and in pos1 i have line
        int layer1 = draw.getShapeLayer(rectangle);
        assertEquals("Error in remove", layer1, 0);
        layer1 = draw.getShapeLayer(line);
        assertEquals("Error in remove", layer1, 1);
        //check drawPane
        assertFalse("Error in removeShape", pane.getChildren().contains(ellipse));
        selection.unSelect();

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
        //check if ellipse is delete from figures
        assertFalse("Ellipse is not delete from figures", figures.contains(line));
        //check drawPane
        assertFalse("Error in removeShape", pane.getChildren().contains(line));
        selection.unSelect();

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
        deleteCommand = new DeleteShapeCommand(c, selection.getSelectedItem());
        deleteCommand.execute();
        //check if ellipse is delete from figures
        assertFalse("Ellipse is not delete from figures", figures.contains(rectangle));
        //check drawPane
        assertFalse("Error in removeShape", pane.getChildren().contains(rectangle));
        selection.unSelect();

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
        selection.unSelect();
        
        deleteCommand.undo();
        //check if ellipse is in figures and in pane
        assertTrue("Ellipse is not insert in figures", figures.contains(ellipse));
        assertTrue("Error in addShape", pane.getChildren().contains(ellipse));
        //check layer of ellipse
        int layer=draw.getShapeLayer(ellipse);
        assertEquals("Error in add", layer, 0);
        
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
