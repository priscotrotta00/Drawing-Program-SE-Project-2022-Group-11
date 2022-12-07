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
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author saram
 */
public class MoveBackgroundShapeCommandTest {

    private Controller c;
    private Field drawField;
    private Field figuresField;
    private Field drawPaneField;
    private Pane pane;
    private Drawing draw;
    private List<MyShape> figures;
    private Field selectionField;
    private Selection selection;
    private MoveBackgroundShapeCommand backgroundCommand;

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
        //test move background a shape that is not in drawpane and figures, check if i have exception 
        MyEnhancedLine line = new MyEnhancedLine();
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, line);
        this.backgroundCommand.execute();
    }

    @Test(expected = ShapeNotFoundException.class)
    public void executeTest2() {
        //test move background a shape that is not in drawpane and figures, check if i have exception 
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, ellipse);
        this.backgroundCommand.execute();
    }

    @Test(expected = ShapeNotFoundException.class)
    public void executeTest3() {
        //test move background a shape that is not in drawpane and figures, check if i have exception 
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, rectangle);
        this.backgroundCommand.execute();
    }

    @Test
    public void executeTest4() {
        //move a shape in background, but the shape is already, I test if it is still in background
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
        //check if ellipse is in first pos in draw and in drawpane
        assertTrue("error in addshape", draw.getShapeLayer(ellipse) == 0);
        MyEnhancedEllipse firstPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in copy", firstPos.myGetRadiusX() == ellipse.myGetRadiusX());
        assertTrue("Error in copy", firstPos.myGetRadiusY() == ellipse.myGetRadiusY());
        assertTrue("Error in copy", firstPos.myGetCenterX() == ellipse.myGetCenterX());
        assertTrue("Error in copy", firstPos.myGetCenterY() == ellipse.myGetCenterY());
        assertTrue("Error in copy", firstPos.myGetFill() == ellipse.myGetFill());
        assertTrue("Error in copy", firstPos.myGetStroke() == ellipse.myGetStroke());
        assertTrue("Error in copy", firstPos.myGetStrokeWidth() == ellipse.myGetStrokeWidth());
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, ellipse);
        this.backgroundCommand.execute();
        //check if ellipse is in first pos after backgroundCommand.execute
        assertTrue("error in background", draw.getShapeLayer(ellipse) == 0);
        //check in drawPane
        firstPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in background", firstPos.myGetRadiusX() == ellipse.myGetRadiusX());
        assertTrue("Error in background", firstPos.myGetRadiusY() == ellipse.myGetRadiusY());
        assertTrue("Error in background", firstPos.myGetCenterX() == ellipse.myGetCenterX());
        assertTrue("Error in background", firstPos.myGetCenterY() == ellipse.myGetCenterY());
        assertTrue("Error in background", firstPos.myGetFill() == ellipse.myGetFill());
        assertTrue("Error in background", firstPos.myGetStroke() == ellipse.myGetStroke());
        assertTrue("Error in background", firstPos.myGetStrokeWidth() == ellipse.myGetStrokeWidth());

    }

    @Test
    public void executeTest5() {
        //move a shape in background, but the shape is already, I test if it is still in background
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        MyEnhancedLine line = new MyEnhancedLine();
        //add in controller
        CreateShapeCommand createShapeE = new CreateShapeCommand(this.c, ellipse);
        CreateShapeCommand createShapeR = new CreateShapeCommand(this.c, rectangle);
        CreateShapeCommand createShapeL = new CreateShapeCommand(this.c, line);
        createShapeR.execute();
        createShapeE.execute();
        createShapeL.execute();
        //check if rectangle is in first pos
        assertTrue("error in addshape", draw.getShapeLayer(rectangle) == 0);
        MyEnhancedRectangle firstPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in copy", firstPos.myGetX() == rectangle.myGetX());
        assertTrue("Error in copy", firstPos.myGetY() == rectangle.myGetY());
        assertTrue("Error in copy", firstPos.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in copy", firstPos.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in copy", firstPos.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in copy", firstPos.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in copy", firstPos.myGetStrokeWidth() == rectangle.myGetStrokeWidth());

        this.backgroundCommand = new MoveBackgroundShapeCommand(c, rectangle);
        this.backgroundCommand.execute();
        //check if rectangle is in first pos after backgroundCommand.execute
        assertTrue("error in background", draw.getShapeLayer(rectangle) == 0);
        firstPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in background", firstPos.myGetX() == rectangle.myGetX());
        assertTrue("Error in background", firstPos.myGetY() == rectangle.myGetY());
        assertTrue("Error in background", firstPos.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in background", firstPos.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in background", firstPos.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in background", firstPos.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in background", firstPos.myGetStrokeWidth() == rectangle.myGetStrokeWidth());

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
        //check if line is in first pos
        assertTrue("error in addshape", draw.getShapeLayer(line) == 0);
        MyEnhancedLine firstPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in copy", firstPos.myGetEndX() == line.myGetEndX());
        assertTrue("Error in copy", firstPos.myGetEndY() == line.myGetEndY());
        assertTrue("Error in copy", firstPos.myGetStartY() == line.myGetStartY());
        assertTrue("Error in copy", firstPos.myGetStartX() == line.myGetStartX());
        assertTrue("Error in copy", firstPos.myGetFill() == line.myGetFill());
        assertTrue("Error in copy", firstPos.myGetStroke() == line.myGetStroke());
        assertTrue("Error in copy", firstPos.myGetStrokeWidth() == line.myGetStrokeWidth());

        this.backgroundCommand = new MoveBackgroundShapeCommand(c, line);
        this.backgroundCommand.execute();
        //check if line is in first pos after backgroundCommand.execute
        assertTrue("error in background", draw.getShapeLayer(line) == 0);
        //check in pane
        firstPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in background", firstPos.myGetEndX() == line.myGetEndX());
        assertTrue("Error in background", firstPos.myGetEndY() == line.myGetEndY());
        assertTrue("Error in background", firstPos.myGetStartY() == line.myGetStartY());
        assertTrue("Error in background", firstPos.myGetStartX() == line.myGetStartX());
        assertTrue("Error in background", firstPos.myGetFill() == line.myGetFill());
        assertTrue("Error in background", firstPos.myGetStroke() == line.myGetStroke());
        assertTrue("Error in background", firstPos.myGetStrokeWidth() == line.myGetStrokeWidth());

    }

    @Test
    public void executeTest7() {
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
        //move ellipse in background
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, ellipse);
        this.backgroundCommand.execute();
        assertTrue("error in background", draw.getShapeLayer(ellipse) == 0);
        //check in drawPane
        MyEnhancedEllipse firstPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in background", firstPos.myGetRadiusX() == ellipse.myGetRadiusX());
        assertTrue("Error in background", firstPos.myGetRadiusY() == ellipse.myGetRadiusY());
        assertTrue("Error in background", firstPos.myGetCenterX() == ellipse.myGetCenterX());
        assertTrue("Error in background", firstPos.myGetCenterY() == ellipse.myGetCenterY());
        assertTrue("Error in background", firstPos.myGetFill() == ellipse.myGetFill());
        assertTrue("Error in background", firstPos.myGetStroke() == ellipse.myGetStroke());
        assertTrue("Error in background", firstPos.myGetStrokeWidth() == ellipse.myGetStrokeWidth());
    }

    @Test
    public void executeTest8() {
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
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, rectangle);
        this.backgroundCommand.execute();
        //check if rectangle is in first pos after backgroundCommand.execute
        assertTrue("error in background", draw.getShapeLayer(rectangle) == 0);
        MyEnhancedRectangle firstPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in background", firstPos.myGetX() == rectangle.myGetX());
        assertTrue("Error in background", firstPos.myGetY() == rectangle.myGetY());
        assertTrue("Error in background", firstPos.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in background", firstPos.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in background", firstPos.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in background", firstPos.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in background", firstPos.myGetStrokeWidth() == rectangle.myGetStrokeWidth());

    }

    @Test
    public void executeTest9() {
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
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, line);
        this.backgroundCommand.execute();
        assertTrue("error in background", draw.getShapeLayer(line) == 0);
        //check in pane
        MyEnhancedLine firstPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in background", firstPos.myGetEndX() == line.myGetEndX());
        assertTrue("Error in background", firstPos.myGetEndY() == line.myGetEndY());
        assertTrue("Error in background", firstPos.myGetStartY() == line.myGetStartY());
        assertTrue("Error in background", firstPos.myGetStartX() == line.myGetStartX());
        assertTrue("Error in background", firstPos.myGetFill() == line.myGetFill());
        assertTrue("Error in background", firstPos.myGetStroke() == line.myGetStroke());
        assertTrue("Error in background", firstPos.myGetStrokeWidth() == line.myGetStrokeWidth());

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
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, line);
        this.backgroundCommand.execute();
        this.backgroundCommand.undo();
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
        createShapeR.execute();
        createShapeL.execute();
        createShapeE.execute();
        //move line in background
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, ellipse);
        this.backgroundCommand.execute();
        this.backgroundCommand.undo();
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
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, rectangle);
        this.backgroundCommand.execute();
        this.backgroundCommand.undo();
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
        createShapeR.execute();
        createShapeL.execute();
        createShapeE.execute();
        //move rectangle in background
        this.backgroundCommand = new MoveBackgroundShapeCommand(c, rectangle);
        this.backgroundCommand.execute();
        this.backgroundCommand.undo();
        //check if rectangle is in first pos after backgroundCommand.execute
        assertTrue("error in undo", draw.getShapeLayer(rectangle) == 0);
        MyEnhancedRectangle firstPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in undo", firstPos.myGetX() == rectangle.myGetX());
        assertTrue("Error in undo", firstPos.myGetY() == rectangle.myGetY());
        assertTrue("Error in undo", firstPos.myGetWidth() == rectangle.myGetHeight());
        assertTrue("Error in undo", firstPos.myGetHeight() == rectangle.myGetHeight());
        assertTrue("Error in undo", firstPos.myGetFill() == rectangle.myGetFill());
        assertTrue("Error in undo", firstPos.myGetStroke() == rectangle.myGetStroke());
        assertTrue("Error in undo", firstPos.myGetStrokeWidth() == rectangle.myGetStrokeWidth());

    }


}
