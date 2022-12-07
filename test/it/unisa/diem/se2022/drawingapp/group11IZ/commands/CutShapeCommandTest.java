/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.clipboard.Clipboard;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import java.lang.reflect.Field;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author daddy
 */
public class CutShapeCommandTest {
    private Controller c;
    private Field drawField;
    private Field drawPaneField;
    private Pane pane;
    private Drawing draw;
    private Field selectionField;
    private Field clipboardField;
    private Selection selection;
    private MyEnhancedRectangle myRectangle;
    private MyEnhancedLine myLine;
    private MyEnhancedEllipse myEllipse;
    private Clipboard clipboard;

    private CutShapeCommand cutCommand;
    
    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.c = new Controller();
        this.pane = new Pane();
        this.draw = new Drawing();
        this.clipboard = new Clipboard();

        drawPaneField = Controller.class.getDeclaredField("drawPane");
        drawField = Controller.class.getDeclaredField("draw");
        clipboardField = Controller.class.getDeclaredField("clipboard");

        drawPaneField.setAccessible(true);
        drawField.setAccessible(true);
        clipboardField.setAccessible(true);

        drawPaneField.set(this.c, this.pane);
        drawField.set(this.c, this.draw);
        clipboardField.set(this.c, this.clipboard);
        
        myRectangle = new MyEnhancedRectangle();
        myLine = new MyEnhancedLine();
        myEllipse = new MyEnhancedEllipse();
        
        c.addShape(myRectangle);
        c.addShape(myLine);
        c.addShape(myEllipse);
        
        //clipboard = new Clipboard();
        //cutCommand = new CutShapeCommand(c, clipboard);
        
        selection = Selection.getInstance();
        
        selection.select((MyEnhancedRectangle)myRectangle);
        
        cutCommand = new CutShapeCommand(selection.getSelectedItem(), c);
        
    }
    
    @Test
    public void executeTest(){
        
        cutCommand.execute();
        //System.out.println(clipboard.getNewCopy());
        //System.out.println(myRectangle);
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
