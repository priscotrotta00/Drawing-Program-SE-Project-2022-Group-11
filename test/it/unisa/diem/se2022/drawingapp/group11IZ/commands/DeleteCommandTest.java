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
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ShapeNotFoundException;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import java.lang.reflect.Field;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author saram
 */
public class DeleteCommandTest {

    //TEST 1-2-3 VANNO IN CONTROLLERTEST
    private Controller c;
    private Field drawField;
    private Field figuresField;
    private Field drawPaneField;
    private Pane pane;
    private Drawing draw;
    private List<MyShape> figures;
    private Field selectionField;
    private Selection selection;

    private DeleteCommand deleteCommand;

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

    @Test(expected = ShapeNotFoundException.class)
    public void executeTest6() throws NoSuchFieldException, IllegalAccessException, Exception {
        //test delete a shape that is not in drawpane and figures, so addShape in drawing throw exception. Check if i have this exception
        System.out.println("executeTest4");
        MyEnhancedLine line = new MyEnhancedLine();
        deleteCommand = new DeleteCommand(c, line);
        deleteCommand.execute();
    }

    @Test(expected = ShapeNotFoundException.class)
    public void executeTest7() throws NoSuchFieldException, IllegalAccessException, Exception {
        System.out.println("executeTest5");
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        deleteCommand = new DeleteCommand(c, rectangle);
        deleteCommand.execute();

    }

    @Test(expected = ShapeNotFoundException.class)
    public void executeTest8() throws NoSuchFieldException, IllegalAccessException, Exception {
        System.out.println("executeTest6");
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        deleteCommand = new DeleteCommand(c, ellipse);
        deleteCommand.execute();

    }

    @Test
    public void executeTest9() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        //add element in figures and pane and after delete it
        System.out.println("remove");

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

        deleteCommand = new DeleteCommand(c, ellipse);
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
        deleteCommand = new DeleteCommand(c, rectangle);
        deleteCommand.execute();
        //check if rectangle is delete from figures
        assertFalse("Rectangle is not delete from figures", figures.contains(rectangle));
        assertFalse("Error in removeShape", pane.getChildren().contains(rectangle));

        //test remove line
        deleteCommand = new DeleteCommand(c, line);
        deleteCommand.execute();
        //check if line is delete from figures
        assertFalse("Line is not delete from figures", figures.contains(line));
        assertFalse("Error in removeShape", pane.getChildren().contains(line));

    }

    @Test
    public void executeTest10() throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        selection = Selection.getInstance();
        selectionField = Controller.class.getDeclaredField("selection");
        selectionField.setAccessible(true);
        selectionField.set(c, selection);

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
        deleteCommand = new DeleteCommand(c, selection.getSelectedItem());
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
        selection = Selection.getInstance();
        selectionField = Controller.class.getDeclaredField("selection");
        selectionField.setAccessible(true);
        selectionField.set(c, selection);

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
        deleteCommand = new DeleteCommand(c, selection.getSelectedItem());
        deleteCommand.execute();
        //check if ellipse is delete from figures
        assertFalse("Ellipse is not delete from figures", figures.contains(line));
        //check drawPane
        assertFalse("Error in removeShape", pane.getChildren().contains(line));
        selection.unSelect();

    }

    @Test
    public void executeTest12() throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        selection = Selection.getInstance();
        selectionField = Controller.class.getDeclaredField("selection");
        selectionField.setAccessible(true);
        selectionField.set(c, selection);

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
        deleteCommand = new DeleteCommand(c, selection.getSelectedItem());
        deleteCommand.execute();
        //check if ellipse is delete from figures
        assertFalse("Ellipse is not delete from figures", figures.contains(rectangle));
        //check drawPane
        assertFalse("Error in removeShape", pane.getChildren().contains(rectangle));
        selection.unSelect();

    }
    
    
    @Test 
    public void undoTest1() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        selection = Selection.getInstance();
        selectionField = Controller.class.getDeclaredField("selection");
        selectionField.setAccessible(true);
        selectionField.set(c, selection);

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
        deleteCommand = new DeleteCommand(c, selection.getSelectedItem());
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
