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
import javafx.scene.layout.Pane;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author saram
 */
public class MoveForegroundShapeCommandTest {

    private Controller c;
    private Field drawField;
    private Field figuresField;
    private Field drawPaneField;
    private Pane pane;
    private Drawing draw;
    private List<MyShape> figures;
    private Field selectionField;
    private Selection selection;
    private MoveForegroundShapeCommand foregroundCommand;

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
    public void executeTest1() {
        //test move foreground a shape that is not in drawpane and figures, check if i have exception 
        MyEnhancedLine line = new MyEnhancedLine();
        this.foregroundCommand = new MoveForegroundShapeCommand(c, line);
        this.foregroundCommand.execute();
    }

    @Test(expected = ShapeNotFoundException.class)
    public void executeTest2() {
        //test move foreground a shape that is not in drawpane and figures, check if i have exception 
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        this.foregroundCommand = new MoveForegroundShapeCommand(c, ellipse);
        this.foregroundCommand.execute();
    }

    @Test(expected = ShapeNotFoundException.class)
    public void executeTest3() {
        //test move foreground a shape that is not in drawpane and figures, check if i have exception 
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        this.foregroundCommand = new MoveForegroundShapeCommand(c, rectangle);
        this.foregroundCommand.execute();
    }

    @Test
    public void executeTest4() {
        //move a shape in foreground, but the shape is already, I test if it is still in background
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
        //check if line is in last pos in draw and in drawpane
        assertTrue("error in addshape", draw.getShapeLayer(line) == 2);
        MyEnhancedLine lastPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in copy", lastPos.myGetEndX() == line.myGetEndX());
        assertTrue("Error in copy", lastPos.myGetEndY() == line.myGetEndY());
        assertTrue("Error in copy", lastPos.myGetStartY() == line.myGetStartY());
        assertTrue("Error in copy", lastPos.myGetStartX() == line.myGetStartX());
        assertTrue("Error in copy", lastPos.myGetFill() == line.myGetFill());
        assertTrue("Error in copy", lastPos.myGetStroke() == line.myGetStroke());
        assertTrue("Error in copy", lastPos.myGetStrokeWidth() == line.myGetStrokeWidth());

        this.foregroundCommand = new MoveForegroundShapeCommand(c, line);
        this.foregroundCommand.execute();
        //check if line is in last pos after foregroundCommand.execute
        assertTrue("error in foreground", draw.getShapeLayer(line) == 2);
        //check in drawPane
        lastPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in foreground", lastPos.myGetEndX() == line.myGetEndX());
        assertTrue("Error in foreground", lastPos.myGetEndY() == line.myGetEndY());
        assertTrue("Error in foreground", lastPos.myGetStartY() == line.myGetStartY());
        assertTrue("Error in foreground", lastPos.myGetStartX() == line.myGetStartX());
        assertTrue("Error in foreground", lastPos.myGetFill() == line.myGetFill());
        assertTrue("Error in foreground", lastPos.myGetStroke() == line.myGetStroke());
        assertTrue("Error in foreground", lastPos.myGetStrokeWidth() == line.myGetStrokeWidth());
    }

    @Test
    public void executeTest5() {
        //move a shape in foreground, but the shape is already, I test if it is still in background
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeL.execute();
        createShapeE.execute();
        createShapeR.execute();
        //check if rectangle is in last pos
        assertTrue("error in addshape", draw.getShapeLayer(rectangle) == 2);
        MyEnhancedRectangle lastPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in copy", lastPos.myGetX() == rectangle.myGetX());
        assertTrue("Error in copy", lastPos.myGetY() == rectangle.myGetY());
        assertTrue("Error in copy", lastPos.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in copy", lastPos.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in copy", lastPos.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in copy", lastPos.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in copy", lastPos.myGetStrokeWidth() == rectangle.myGetStrokeWidth());

        this.foregroundCommand = new MoveForegroundShapeCommand(c, rectangle);
        this.foregroundCommand.execute();
        //check if rectangle is in last pos after foregroundCommand.execute
        assertTrue("error in foreground", draw.getShapeLayer(rectangle) == 2);
        lastPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in foreground", lastPos.myGetX() == rectangle.myGetX());
        assertTrue("Error in foreground", lastPos.myGetY() == rectangle.myGetY());
        assertTrue("Error in foreground", lastPos.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in foreground", lastPos.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in foreground", lastPos.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in foreground", lastPos.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in foreground", lastPos.myGetStrokeWidth() == rectangle.myGetStrokeWidth());

    }

    @Test
    public void executeTest6() {
        //move a shape in background, but the shape is already, I test if it is still in background
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeL.execute();
        createShapeR.execute();
        createShapeE.execute();
        //check if ellipse is in last pos in draw and in drawpane
        assertTrue("error in addshape", draw.getShapeLayer(ellipse) == 2);
        MyEnhancedEllipse lastPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in copy", lastPos.myGetRadiusX() == ellipse.myGetRadiusX());
        assertTrue("Error in copy", lastPos.myGetRadiusY() == ellipse.myGetRadiusY());
        assertTrue("Error in copy", lastPos.myGetCenterX() == ellipse.myGetCenterX());
        assertTrue("Error in copy", lastPos.myGetCenterY() == ellipse.myGetCenterY());
        assertTrue("Error in copy", lastPos.myGetFill() == ellipse.myGetFill());
        assertTrue("Error in copy", lastPos.myGetStroke() == ellipse.myGetStroke());
        assertTrue("Error in copy", lastPos.myGetStrokeWidth() == ellipse.myGetStrokeWidth());
        this.foregroundCommand = new MoveForegroundShapeCommand(c, ellipse);
        this.foregroundCommand.execute();
        //check if ellipse is in last pos after foregroundCommand.execute
        assertTrue("error in foreground", draw.getShapeLayer(ellipse) == 2);
        //check in drawPane
        lastPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in foreground", lastPos.myGetRadiusX() == ellipse.myGetRadiusX());
        assertTrue("Error in foreground", lastPos.myGetRadiusY() == ellipse.myGetRadiusY());
        assertTrue("Error in foreground", lastPos.myGetCenterX() == ellipse.myGetCenterX());
        assertTrue("Error in foreground", lastPos.myGetCenterY() == ellipse.myGetCenterY());
        assertTrue("Error in foreground", lastPos.myGetFill() == ellipse.myGetFill());
        assertTrue("Error in foreground", lastPos.myGetStroke() == ellipse.myGetStroke());
        assertTrue("Error in foreground", lastPos.myGetStrokeWidth() == ellipse.myGetStrokeWidth());

    }

    @Test
    public void executeTest7() {
        //move a shape in foreground
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
        //move ellipse in foreground
        this.foregroundCommand = new MoveForegroundShapeCommand(c, ellipse);
        this.foregroundCommand.execute();
        assertTrue("error in foreground", draw.getShapeLayer(ellipse) == 2);
        //check in drawPane
        MyEnhancedEllipse lastPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in foreground", lastPos.myGetRadiusX() == ellipse.myGetRadiusX());
        assertTrue("Error in foreground", lastPos.myGetRadiusY() == ellipse.myGetRadiusY());
        assertTrue("Error in foreground", lastPos.myGetCenterX() == ellipse.myGetCenterX());
        assertTrue("Error in foreground", lastPos.myGetCenterY() == ellipse.myGetCenterY());
        assertTrue("Error in foreground", lastPos.myGetFill() == ellipse.myGetFill());
        assertTrue("Error in foreground", lastPos.myGetStroke() == ellipse.myGetStroke());
        assertTrue("Error in foreground", lastPos.myGetStrokeWidth() == ellipse.myGetStrokeWidth());
    }

    @Test
    public void executeTest8() {
        //move a shape in foreground
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeL.execute();
        createShapeR.execute();
        createShapeE.execute();
        //move rectangle in foreground
        this.foregroundCommand = new MoveForegroundShapeCommand(c, rectangle);
        this.foregroundCommand.execute();
        //check if rectangle is in last pos after foreroundCommand.execute
        assertTrue("error in foreground", draw.getShapeLayer(rectangle) == 2);
        MyEnhancedRectangle lastPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in foreground", lastPos.myGetX() == rectangle.myGetX());
        assertTrue("Error in foreground", lastPos.myGetY() == rectangle.myGetY());
        assertTrue("Error in foreground", lastPos.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in foreground", lastPos.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in foreground", lastPos.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in foreground", lastPos.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in foreground", lastPos.myGetStrokeWidth() == rectangle.myGetStrokeWidth());

    }

    @Test
    public void executeTest9() {
        //move a shape in foreground
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeR.execute();
        createShapeL.execute();
        createShapeE.execute();
        //move line in foreground
        this.foregroundCommand = new MoveForegroundShapeCommand(c, line);
        this.foregroundCommand.execute();
        assertTrue("error in foreground", draw.getShapeLayer(line) == 2);
        //check in pane
        MyEnhancedLine lastPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in foreground", lastPos.myGetEndX() == line.myGetEndX());
        assertTrue("Error in foreground", lastPos.myGetEndY() == line.myGetEndY());
        assertTrue("Error in foreground", lastPos.myGetStartY() == line.myGetStartY());
        assertTrue("Error in foreground", lastPos.myGetStartX() == line.myGetStartX());
        assertTrue("Error in foreground", lastPos.myGetFill() == line.myGetFill());
        assertTrue("Error in foreground", lastPos.myGetStroke() == line.myGetStroke());
        assertTrue("Error in foreground", lastPos.myGetStrokeWidth() == line.myGetStrokeWidth());

    }
    
    //test undo
    @Test
    public void undoTest1() {
        //move a shape in background
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeR.execute();
        createShapeL.execute();
        createShapeE.execute();
        //move line in background
        this.foregroundCommand = new MoveForegroundShapeCommand(c, line);
        this.foregroundCommand.execute();
        this.foregroundCommand.undo();
        //check if line is in pos 1 in draw 
        assertTrue("error in undo", draw.getShapeLayer(line) == 1);
        //check in pane
        MyEnhancedLine secondPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(1);
        assertTrue("Error in undo", secondPos.myGetEndX() == line.myGetEndX());
        assertTrue("Error in undo", secondPos.myGetEndY() == line.myGetEndY());
        assertTrue("Error in undo", secondPos.myGetStartY() == line.myGetStartY());
        assertTrue("Error in undo", secondPos.myGetStartX() == line.myGetStartX());
        assertTrue("Error in undo", secondPos.myGetFill() == line.myGetFill());
        assertTrue("Error in undo", secondPos.myGetStroke() == line.myGetStroke());
        assertTrue("Error in undo", secondPos.myGetStrokeWidth() == line.myGetStrokeWidth());
    }


    @Test
    public void undoTest2() {
        //move a shape in background
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeE.execute();
        createShapeL.execute();
        createShapeR.execute();
        //move line in background
        this.foregroundCommand = new MoveForegroundShapeCommand(c, ellipse);
        this.foregroundCommand.execute();
        this.foregroundCommand.undo();
        //check if ellipse is in pos 2 in draw 
        assertTrue("error in undo", draw.getShapeLayer(ellipse) == 0);
        //check in pane
        MyEnhancedEllipse lastPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in undo", lastPos.myGetRadiusX() == ellipse.myGetRadiusX());
        assertTrue("Error in undo", lastPos.myGetRadiusY() == ellipse.myGetRadiusY());
        assertTrue("Error in undo", lastPos.myGetCenterX() == ellipse.myGetCenterX());
        assertTrue("Error in undo", lastPos.myGetCenterY() == ellipse.myGetCenterY());
        assertTrue("Error in undo", lastPos.myGetFill() == ellipse.myGetFill());
        assertTrue("Error in undo", lastPos.myGetStroke() == ellipse.myGetStroke());
        assertTrue("Error in undo", lastPos.myGetStrokeWidth() == ellipse.myGetStrokeWidth());

    }
    
    @Test
    public void undoTest3() {
        //move a shape in background
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeL.execute();
        createShapeR.execute();
        createShapeE.execute();
        //move rectangle in background
        this.foregroundCommand = new MoveForegroundShapeCommand(c, rectangle);
        this.foregroundCommand.execute();
        this.foregroundCommand.undo();
        //check if rectangle is in first pos after backgroundCommand.execute
        assertTrue("error in undo", draw.getShapeLayer(rectangle) == 1);
        MyEnhancedRectangle firstPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(1);
        assertTrue("Error in undo", firstPos.myGetX() == rectangle.myGetX());
        assertTrue("Error in undo", firstPos.myGetY() == rectangle.myGetY());
        assertTrue("Error in undo", firstPos.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in undo", firstPos.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in undo", firstPos.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in undo", firstPos.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in undo", firstPos.myGetStrokeWidth() == rectangle.myGetStrokeWidth());

    }
    
    @Test
    public void undoTest4() {
        //move a shape in background
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeE.execute();
        createShapeL.execute();
        createShapeR.execute();
        //move rectangle in background
        this.foregroundCommand = new MoveForegroundShapeCommand(c, rectangle);
        this.foregroundCommand.execute();
        this.foregroundCommand.undo();
        //check if rectangle is in first pos after backgroundCommand.execute
        assertTrue("error in undo", draw.getShapeLayer(rectangle) == 2);
        MyEnhancedRectangle firstPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in undo", firstPos.myGetX() == rectangle.myGetX());
        assertTrue("Error in undo", firstPos.myGetY() == rectangle.myGetY());
        assertTrue("Error in undo", firstPos.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in undo", firstPos.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in undo", firstPos.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in undo", firstPos.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in undo", firstPos.myGetStrokeWidth() == rectangle.myGetStrokeWidth());

    }
    
    @Test
    public void undoTest5() {
        //move a shape in background
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeR.execute();
        createShapeL.execute();
        createShapeE.execute();
        //move line in background
        this.foregroundCommand = new MoveForegroundShapeCommand(c, ellipse);
        this.foregroundCommand.execute();
        this.foregroundCommand.undo();
        //check if ellipse is in pos 2 in draw 
        assertTrue("error in undo", draw.getShapeLayer(ellipse) == 2);
        //check in pane
        MyEnhancedEllipse lastPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in undo", lastPos.myGetRadiusX() == ellipse.myGetRadiusX());
        assertTrue("Error in undo", lastPos.myGetRadiusY() == ellipse.myGetRadiusY());
        assertTrue("Error in undo", lastPos.myGetCenterX() == ellipse.myGetCenterX());
        assertTrue("Error in undo", lastPos.myGetCenterY() == ellipse.myGetCenterY());
        assertTrue("Error in undo", lastPos.myGetFill() == ellipse.myGetFill());
        assertTrue("Error in undo", lastPos.myGetStroke() == ellipse.myGetStroke());
        assertTrue("Error in undo", lastPos.myGetStrokeWidth() == ellipse.myGetStrokeWidth());

    }
    
    @Test
    public void undoTest6() {
        //move a shape in background
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
        //move line in background
        this.foregroundCommand = new MoveForegroundShapeCommand(c, line);
        this.foregroundCommand.execute();
        this.foregroundCommand.undo();
        //check if line is in pos 1 in draw 
        assertTrue("error in undo", draw.getShapeLayer(line) == 2);
        //check in pane
        MyEnhancedLine secondPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in undo", secondPos.myGetEndX() == line.myGetEndX());
        assertTrue("Error in undo", secondPos.myGetEndY() == line.myGetEndY());
        assertTrue("Error in undo", secondPos.myGetStartY() == line.myGetStartY());
        assertTrue("Error in undo", secondPos.myGetStartX() == line.myGetStartX());
        assertTrue("Error in undo", secondPos.myGetFill() == line.myGetFill());
        assertTrue("Error in undo", secondPos.myGetStroke() == line.myGetStroke());
        assertTrue("Error in undo", secondPos.myGetStrokeWidth() == line.myGetStrokeWidth());
    }


}
