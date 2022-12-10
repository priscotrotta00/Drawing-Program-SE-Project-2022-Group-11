/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.clipboard.Clipboard;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import java.lang.reflect.Field;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author daddy
 */
public class CommandInvokerTest {
    private CommandInvoker commandInvoker;
    private Canvas canvas;
    
    private Pane pane;
    private Drawing draw;
    private List<MyShape> figures;
    private Clipboard clipboard;
    private Selection selection;
    
    private Field figuresDrawingField;
    private Field drawPaneField;
    private Field drawingField;
    private Field clipboardField;
    
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
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        canvas = new Canvas();
        pane = new Pane();
        
        drawPaneField = Canvas.class.getDeclaredField("drawPane");
        drawingField = Canvas.class.getDeclaredField("draw");
        figuresDrawingField = Drawing.class.getDeclaredField("figures");
        clipboardField = Canvas.class.getDeclaredField("clipboard");

        drawPaneField.setAccessible(true);
        drawingField.setAccessible(true);
        figuresDrawingField.setAccessible(true);
        clipboardField.setAccessible(true);

        drawPaneField.set(canvas, pane);
        canvas.initialize(null, null);
        
        commandInvoker = canvas.getCommandInvoker();
        clipboard = (Clipboard) clipboardField.get(canvas);
        draw = canvas.getDraw();
        figures = (List<MyShape>) figuresDrawingField.get(draw);
    
    }
    
    @Test
    public void invokerChangeColorCommandTest(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        
        ChangeColorCommand cccFill = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        
        commandInvoker.execute(cccFill);
        
        Assert.assertEquals("Command invoker executed change of color", myRectangle.myGetFill().toString(), Color.BLUEVIOLET.toString());
        
        commandInvoker.undoLast();
        
        Assert.assertEquals("Command invoker executed change of color", myRectangle.myGetFill().toString(), Color.RED.toString());
        
        myRectangle.mySetStroke(Color.RED);
        ChangeColorCommand cccStroke = new ChangeStrokeColorCommand(myRectangle, Color.BLUEVIOLET);
        
        commandInvoker.execute(cccStroke);
        
        Assert.assertEquals("Command invoker executed change of color", myRectangle.myGetStroke().toString(), Color.BLUEVIOLET.toString());
        
        commandInvoker.undoLast();
        
        Assert.assertEquals("Command invoker executed change of color", myRectangle.myGetStroke().toString(), Color.RED.toString());
        
    }
    
    @Test
    public void invokerCreateShapeCommandTest(){
        MyShape shape = new MyEnhancedRectangle();
        Command command = new CreateShapeCommand(canvas, shape);
        commandInvoker.execute(command);
        
        Assert.assertTrue("Verify shape is inserted in pane", pane.getChildrenUnmodifiable().contains((Shape) shape));
        Assert.assertTrue("Verify shape is inserted in drawing", figures.contains(shape));
    
        commandInvoker.undoLast();
        
        Assert.assertFalse("Verify shape is not in pane anymore", pane.getChildrenUnmodifiable().contains((Shape) shape));
        Assert.assertFalse("Verify shape is not in drawing anymore", figures.contains(shape));
    }
    
    @Test
    public void invokerCutShapeCommandTest(){
        MyEnhancedRectangle myRectangle = new MyEnhancedRectangle();
        MyEnhancedLine myLine = new MyEnhancedLine();
        MyEnhancedEllipse myEllipse = new MyEnhancedEllipse();
        
        canvas.addShape(myRectangle);
        canvas.addShape(myLine);
        canvas.addShape(myEllipse);
        
        selection = canvas.getSelection();
        selection.select((MyEnhancedRectangle)myRectangle);
        
        CutShapeCommand cutCommand = new CutShapeCommand(selection.getSelectedItem(), canvas);
        
        commandInvoker.execute(cutCommand);
        
        MyEnhancedRectangle copy = (MyEnhancedRectangle)clipboard.getNewCopy();
        
            
        Assert.assertFalse("If cutted shape is not in the drawing", pane.getChildren().contains((Node)myRectangle));
        Assert.assertTrue("If clipboard contains shape", 
                    copy.myGetX() == myRectangle.myGetX() &&
                            copy.myGetY() == myRectangle.myGetY() &&
                            copy.myGetWidth() == myRectangle.myGetWidth() &&
                            copy.myGetLayoutX() == myRectangle.myGetLayoutX() &&
                            copy.myGetLayoutY() == myRectangle.myGetLayoutY()
                );
        
        commandInvoker.undoLast();
        
        MyEnhancedRectangle copy2 = (MyEnhancedRectangle)clipboard.getNewCopy();
        Assert.assertTrue("If previous cutted shape is again in the drawing", pane.getChildren().contains((Node)myRectangle));
        Assert.assertTrue("If clipboard does contains the restored cutted shape", 
                copy2.myGetX() == myRectangle.myGetX() &&
                            copy2.myGetY() == myRectangle.myGetY() &&
                            copy2.myGetWidth() == myRectangle.myGetWidth() &&
                            copy2.myGetLayoutX() == myRectangle.myGetLayoutX() &&
                            copy2.myGetLayoutY() == myRectangle.myGetLayoutY()
        );
        
    }
    
    @Test
    public void invokerDeleteShapeCommandTest(){
        MyEnhancedLine line = new MyEnhancedLine();
        canvas.addShape(line);
        
        selection = canvas.getSelection();
        selection.select(line);
        
        DeleteShapeCommand deleteCommand = new DeleteShapeCommand(canvas, selection.getSelectedItem());
        commandInvoker.execute(deleteCommand);
        
        Assert.assertFalse("Ellipse is not delete from figures", figures.contains(line));
        
        Assert.assertFalse("Error in removeShape", pane.getChildren().contains(line));
        
        commandInvoker.undoLast();
        Assert.assertTrue("Line is not insert in figures", figures.contains(line));
        
        int layer=draw.getShapeLayer(line);
        assertEquals("Error in add", layer, 0);
        
    }
    
    @Test
    public void invokerMoveShapeCommandTest() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        double x = 50.0;
        double y = 50.0;
        MyEnhancedRectangle myEnhancedRectangle = new MyEnhancedRectangle();
        
        myEnhancedRectangle.mySetX(10);
        myEnhancedRectangle.mySetY(10);
        myEnhancedRectangle.mySetWidth(20);
        myEnhancedRectangle.mySetHeight(10);
        
        Field oldXField = MoveShapeCommand.class.getDeclaredField("oldX");
        Field oldYField = MoveShapeCommand.class.getDeclaredField("oldY");
        Field newXField = MoveShapeCommand.class.getDeclaredField("newX");
        Field newYField = MoveShapeCommand.class.getDeclaredField("newY");
        
        oldXField.setAccessible(true);
        oldYField.setAccessible(true);
        newXField.setAccessible(true);
        newYField.setAccessible(true);
        
        MoveShapeCommand msc = new MoveShapeCommand(myEnhancedRectangle);
        
        msc.setNewCoordinates(x, y);
        
        double diffX = myEnhancedRectangle.myGetLayoutBounds().getMaxX() - myEnhancedRectangle.myGetLayoutBounds().getMinX();
        double diffY = myEnhancedRectangle.myGetLayoutBounds().getMaxY() - myEnhancedRectangle.myGetLayoutBounds().getMinY();

        Assert.assertEquals("If oldX is equal to selectedShape minX coordinate", oldXField.get(msc), myEnhancedRectangle.myGetLayoutBounds().getMinX() + diffX / 2);
        Assert.assertEquals("If oldY is equal to selectedShape minY coordinate", oldYField.get(msc), myEnhancedRectangle.myGetLayoutBounds().getMinY() + diffY / 2);
        
        commandInvoker.execute(msc);
        
        Assert.assertTrue("If correctly moved", x == (myEnhancedRectangle.myGetLayoutBounds().getMinX() + diffX / 2));
        Assert.assertTrue("If correctly moved", y == (myEnhancedRectangle.myGetLayoutBounds().getMinY() + diffY / 2));
    
        commandInvoker.undoLast();
        
        Assert.assertFalse("If correctly done the undo", x == (myEnhancedRectangle.myGetLayoutBounds().getMinX() + diffX / 2));
        Assert.assertFalse("If correctly done the undo", y == (myEnhancedRectangle.myGetLayoutBounds().getMinY() + diffY / 2));
        
        Assert.assertTrue("If coordinates are correct", ((double)oldXField.get(msc)) == (myEnhancedRectangle.myGetLayoutBounds().getMinX() + diffX / 2));
        Assert.assertTrue("If coordinates are correct", ((double)oldYField.get(msc)) == (myEnhancedRectangle.myGetLayoutBounds().getMinY() + diffY / 2));
    
    }
    
    @Test
    public void invokerPasteShapeCommand(){
        MyRectangle myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        myRectangle.mySetStroke(Color.BLACK);
        myRectangle.mySetLayoutX(50.0);
        myRectangle.mySetLayoutY(50.0);
        myRectangle.mySetHeight(30.0);
        myRectangle.mySetWidth(70.0);
        
        PasteShapeCommand psc = new PasteShapeCommand(canvas, myRectangle);
        //psc.execute();
        commandInvoker.execute(psc);
        
        MyShape myShape;
        myShape = figures.get(0);
        
        Assert.assertEquals("Error in the paste of the rectangle", myShape.toString(), myRectangle.toString());
        //psc.undo();
        commandInvoker.undoLast();
        Assert.assertTrue("Error in the undo paste of the shape", figures.isEmpty());
    
    }
    
    @Test
    public void invokerResizeShapeCommand(){
        MyRectangle shape = new MyEnhancedRectangle();
        
        ResizeShapeCommand command = new ResizeRectangleCommand(shape, 10, 10, 30, 20);
        commandInvoker.execute(command);
        
        Assert.assertEquals(10, shape.getTopLeftX(), 0);
        Assert.assertEquals(10, shape.getTopLeftY(), 0);
        Assert.assertEquals(30, shape.getBottomRightX(), 0);
        Assert.assertEquals(20, shape.getBottomRightY(), 0);
        
        command = new ResizeRectangleCommand(shape, 10, 40, 80, 70);
        commandInvoker.execute(command);
        commandInvoker.undoLast();
        
        Assert.assertEquals(10, shape.getTopLeftX(), 0);
        Assert.assertEquals(10, shape.getTopLeftY(), 0);
        Assert.assertEquals(30, shape.getBottomRightX(), 0);
        Assert.assertEquals(20, shape.getBottomRightY(), 0);
    
    }
    
    @Test
    public void clearStacktest(){
        MyShape myRectangle = new MyEnhancedRectangle();
        Command command = new CreateShapeCommand(canvas, myRectangle);
        commandInvoker.execute(command);
        myRectangle.mySetFill(Color.RED);
        
        ChangeColorCommand cccFill = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        
        commandInvoker.execute(cccFill);
        myRectangle.mySetStroke(Color.RED);
        ChangeColorCommand cccStroke = new ChangeStrokeColorCommand(myRectangle, Color.BLUEVIOLET);
        
        commandInvoker.execute(cccStroke);
        
        Assert.assertFalse("If stack is not empty", commandInvoker.stackIsEmptyProperty().get());
        
        commandInvoker.clearStack();
        
        Assert.assertTrue("If stack is empty", commandInvoker.stackIsEmptyProperty().get());
        
    }
}
