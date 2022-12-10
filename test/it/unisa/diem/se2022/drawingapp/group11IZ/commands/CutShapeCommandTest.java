/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.clipboard.Clipboard;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import java.lang.reflect.Field;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author daddy
 */
public class CutShapeCommandTest {
    private Canvas canvas;
    private MyEnhancedRectangle myRectangle;
    private MyEnhancedLine myLine;
    private MyEnhancedEllipse myEllipse;
    private Clipboard clipboard;

    private CutShapeCommand cutCommand;
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
        Field clipboardField;
        
        this.canvas = new Canvas();
        this.pane = new Pane();
        
        drawPaneField = Canvas.class.getDeclaredField("drawPane");
        clipboardField = Canvas.class.getDeclaredField("clipboard");
        drawPaneField.setAccessible(true);
        clipboardField.setAccessible(true);
        drawPaneField.set(this.canvas, this.pane);
        this.canvas.initialize(null, null);
        clipboard = (Clipboard) clipboardField.get(canvas);
        
        this.draw = this.canvas.getDraw();
        this.selection = this.canvas.getSelection();
    
        myRectangle = new MyEnhancedRectangle();
        myEllipse = new MyEnhancedEllipse();
        myLine = new MyEnhancedLine();
        canvas.addShape(myRectangle);
        canvas.addShape(myLine);
        canvas.addShape(myEllipse);
        
        selection = this.canvas.getSelection();
        selection.select((MyEnhancedRectangle)myRectangle);
        
        cutCommand = new CutShapeCommand(selection.getSelectedItem(), canvas);
        
    }
    
    @Test
    public void executeTest(){
        cutCommand.execute();
        MyEnhancedRectangle copy = (MyEnhancedRectangle)clipboard.getNewCopy();
        
        Assert.assertFalse("If cutted shape is not in the drawing", pane.getChildren().contains((Node)myRectangle));
        Assert.assertTrue("If clipboard contains shape", 
                    copy.myGetX() == myRectangle.myGetX() &&
                            copy.myGetY() == myRectangle.myGetY() &&
                            copy.myGetWidth() == myRectangle.myGetWidth() &&
                            copy.myGetLayoutX() == myRectangle.myGetLayoutX() &&
                            copy.myGetLayoutY() == myRectangle.myGetLayoutY()
                );
        
    }
    
    @Test
    public void undoText(){
        cutCommand.execute();
        cutCommand.undo();
        
        MyEnhancedRectangle copy = (MyEnhancedRectangle)clipboard.getNewCopy();
        Assert.assertTrue("If previous cutted shape is again in the drawing", pane.getChildren().contains((Node)myRectangle));
        Assert.assertTrue("If clipboard does contains the restored cutted shape", 
                copy.myGetX() == myRectangle.myGetX() &&
                            copy.myGetY() == myRectangle.myGetY() &&
                            copy.myGetWidth() == myRectangle.myGetWidth() &&
                            copy.myGetLayoutX() == myRectangle.myGetLayoutX() &&
                            copy.myGetLayoutY() == myRectangle.myGetLayoutY()
        );
        
    }
}
