/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.clipboard.Clipboard;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author scala
 */
public class CanvasTest {
    private Canvas canvas;
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
        
        this.canvas = new Canvas();
        this.pane = new Pane();
        
        drawPaneField = Canvas.class.getDeclaredField("drawPane");
        drawPaneField.setAccessible(true);
        drawPaneField.set(this.canvas, this.pane);
        this.canvas.initialize(null, null);
        
        this.draw = this.canvas.getDraw();
        this.selection = this.canvas.getSelection();
    }
    
    @Test
    public void testAddShape() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        //check if in DrawPane i have the shape
        MyEnhancedEllipse ellipse= new MyEnhancedEllipse();
        canvas.addShape(ellipse);
        //check if in DrawPane i have the ellipse
        assertTrue("Error in addShape",pane.getChildren().contains(ellipse));
    
        MyEnhancedRectangle rectangle= new MyEnhancedRectangle();
        canvas.addShape(rectangle);
        //check if in DrawPane i have the ellipse
        assertTrue("Error in addShape",pane.getChildren().contains(rectangle));
    
        MyEnhancedLine line= new MyEnhancedLine();
        canvas.addShape(line);
        //check if in DrawPane i have the ellipse
        assertTrue("Error in addShape",pane.getChildren().contains(line));
    }
    
    @Test
    public void testRemoveShape() throws IllegalArgumentException, IllegalAccessException, Exception{
        //add
        MyEnhancedEllipse ellipse= new MyEnhancedEllipse();
        canvas.addShape(ellipse);
        MyEnhancedRectangle rectangle= new MyEnhancedRectangle();
        canvas.addShape(rectangle);
        MyEnhancedLine line= new MyEnhancedLine();
        canvas.addShape(line);
        
        //remove
        canvas.removeShape(ellipse);
        assertFalse("Error in removeShape",pane.getChildren().contains(ellipse));
        canvas.removeShape(line);
        assertFalse("Error in removeShape",pane.getChildren().contains(line));
        canvas.removeShape(rectangle);
        assertFalse("Error in removeShape",pane.getChildren().contains(rectangle));
    }
    
    @Test (expected=Exception.class)
    public void testRemove3() throws NoSuchFieldException, IllegalAccessException{
        //try to delete an ellipse that is not in the list
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        canvas.removeShape(ellipse);        
    }
    
    @Test
    public void testGetDraw() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
        Field drawingField = Canvas.class.getDeclaredField("draw");
        
        drawingField.setAccessible(true);
        Drawing drawing = new Drawing();
        drawingField.set(canvas, drawing);
        
        Drawing d=canvas.getDraw();
        assertTrue("Error in getDraw",d==drawing);
    }
    
    @Test
    public void copyShapeTest() throws IllegalArgumentException, IllegalAccessException{
        
        MyEnhancedLine lineShape=new MyEnhancedLine();
        canvas.addShape(lineShape);
        selection.select(lineShape); //selection the shape
        assertTrue("Error in selection", selection.getSelectedValue());
        //copyShape
        canvas.copyShape(selection.getSelectedItem());
        //check if lineShape is in clipboard 
        Clipboard clipboard=canvas.getClipboard();
        assertTrue("Error insert in clipboard", clipboard.hasCopiedShape());
        //check if the selected shape is equal to lineShape
        assertTrue("Error insert in clipboard 0", selection.getSelectedItem().myGetId() == lineShape.myGetId());
        
        //check if the shape in clipboard is equal to lineshape
        
        MyEnhancedLine shapeClipboard=(MyEnhancedLine) clipboard.getNewCopy();
        
        assertTrue("error insert in clipboard 1", shapeClipboard.myGetFill()==lineShape.myGetFill());
        assertTrue("error insert in clipboard 2", shapeClipboard.myGetStroke()==lineShape.myGetStroke());
        assertTrue("error insert in clipboard 3", shapeClipboard.myGetEndX()==lineShape.myGetEndX());
        assertTrue("error insert in clipboard 4", shapeClipboard.myGetEndY()==lineShape.myGetEndY());
        assertTrue("error insert in clipboard 5", shapeClipboard.myGetStartX()==lineShape.myGetStartX());
        assertTrue("error insert in clipboard 6", shapeClipboard.myGetStartY()==lineShape.myGetStartY());
        assertTrue("Error insert in clipboard 7", shapeClipboard.myGetStrokeWidth()==lineShape.myGetStrokeWidth());   
        
    }
    
    @Test
    public void copyShapeTest2() throws IllegalArgumentException, IllegalAccessException{
        MyEnhancedRectangle rectangleShape =new MyEnhancedRectangle();
        canvas.addShape(rectangleShape);
        selection.select(rectangleShape); //selection the shape
        //copyShape
        canvas.copyShape(selection.getSelectedItem());
        //check if rectangleShape is in clipboard 
        Clipboard clipboard=canvas.getClipboard();
        assertTrue("Error insert in clipboard", clipboard.hasCopiedShape());
        //check if the selected shape is equal to rectangleShape
        assertTrue("Error insert in clipboard 0", selection.getSelectedItem().myGetId()==rectangleShape.myGetId());
        //check if the shape in clipboard is equal to rectangleshape
        MyEnhancedRectangle shapeClipboard=(MyEnhancedRectangle) clipboard.getNewCopy();
        
        assertTrue("error insert in clipboard 1", shapeClipboard.myGetFill()==rectangleShape.myGetFill());
        assertTrue("error insert in clipboard 2", shapeClipboard.myGetStroke()==rectangleShape.myGetStroke());
        assertTrue("error insert in clipboard 3", shapeClipboard.myGetWidth()==rectangleShape.myGetWidth());
        assertTrue("error insert in clipboard 4", shapeClipboard.myGetHeight()==rectangleShape.myGetHeight());
        assertTrue("error insert in clipboard 5", shapeClipboard.myGetX()==rectangleShape.myGetX());
        assertTrue("error insert in clipboard 6", shapeClipboard.myGetY()==rectangleShape.myGetY());
        assertTrue("Error insert in clipboard 7", shapeClipboard.myGetStrokeWidth()==rectangleShape.myGetStrokeWidth());   
        
    }
    
    @Test
    public void copyShapeTest3() throws IllegalArgumentException, IllegalAccessException{
        MyEnhancedEllipse ellipseShape =new MyEnhancedEllipse();
        canvas.addShape(ellipseShape);
        selection.select(ellipseShape); //selection the shape
        //copyShape
        canvas.copyShape(selection.getSelectedItem());
        //check if ellipseShape is in clipboard 
        Clipboard clipboard=canvas.getClipboard();
        assertTrue("Error insert in clipboard", clipboard.hasCopiedShape());
        //check if the selected shape is equal to ellipseShape
        assertTrue("Error insert in clipboard 0", selection.getSelectedItem().myGetId()==ellipseShape.myGetId());
        //check if the shape in clipboard is equal to ellipseshape
        MyEnhancedEllipse shapeClipboard=(MyEnhancedEllipse) clipboard.getNewCopy();
        
        assertTrue("error insert in clipboard 1", shapeClipboard.myGetFill()==ellipseShape.myGetFill());
        assertTrue("error insert in clipboard 2", shapeClipboard.myGetStroke()==ellipseShape.myGetStroke());
        assertTrue("error insert in clipboard 3", shapeClipboard.myGetRadiusX()==ellipseShape.myGetRadiusX());
        assertTrue("error insert in clipboard 4", shapeClipboard.myGetRadiusY()==ellipseShape.myGetRadiusY());
        assertTrue("error insert in clipboard 5", shapeClipboard.myGetCenterX()==ellipseShape.myGetCenterX());
        assertTrue("error insert in clipboard 6", shapeClipboard.myGetCenterY()==ellipseShape.myGetCenterY());
        assertTrue("Error insert in clipboard 7", shapeClipboard.myGetStrokeWidth()==ellipseShape.myGetStrokeWidth());   
        
    }
    
    @Test
    public void testAddPreviewNewShape() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
        MyShape preview;
        Field figuresField;
        List<MyShape> figures;
        
        figuresField = Drawing.class.getDeclaredField("figures");
        figuresField.setAccessible(true);
        figures = (List<MyShape>) figuresField.get(draw);
        
        preview = new MyEnhancedRectangle();
        this.canvas.addPreviewNewShape(preview);
        
        assertTrue(pane.getChildren().contains(preview.getView()));
        assertFalse(figures.contains(preview));
    }
    
    @Test
    public void testRemovePreviewNewShape() throws IllegalAccessException, NoSuchFieldException{
        MyShape preview;
        Field figuresField;
        List<MyShape> figures;
        
        figuresField = Drawing.class.getDeclaredField("figures");
        figuresField.setAccessible(true);
        figures = (List<MyShape>) figuresField.get(draw);
        
        preview = new MyEnhancedRectangle();
        this.canvas.addPreviewNewShape(preview);
        this.canvas.removePreviewNewShape(preview);
        
        assertFalse(pane.getChildren().contains(preview.getView()));
        assertFalse(figures.contains(preview));
    }
    
    @Test (expected = RuntimeException.class)
    public void testRemovePreviewNewShapeException() throws IllegalAccessException{
        MyShape preview = new MyEnhancedRectangle();
        this.canvas.removePreviewNewShape(preview);
    }
    
    @Test
    public void testSubstituteShapeWithPreview1() throws IllegalAccessException, NoSuchFieldException{
        MyShape shape;
        Field figuresField;
        List<MyShape> figures;
        
        figuresField = Drawing.class.getDeclaredField("figures");
        figuresField.setAccessible(true);
        figures = (List<MyShape>) figuresField.get(draw);
        
        shape = new MyEnhancedRectangle();
        this.canvas.addShape(shape);
        
        MyShape preview = this.canvas.substituteShapeWithPreview(shape);
        
        assertTrue(figures.contains(shape));
        assertFalse(pane.getChildren().contains(shape.getView()));
        
        //assertEquals(shape, preview);
        
        assertFalse(figures.contains(preview));
        assertTrue(pane.getChildren().contains(preview.getView()));
    }
    
    @Test (expected = ShapeNotFoundException.class)
    public void testSubstituteShapeWithPreview2() throws IllegalAccessException{
        MyShape shape = new MyEnhancedRectangle();
        MyShape preview = this.canvas.substituteShapeWithPreview(shape);
    }
    
    @Test
    public void testSubstitutePreviewWithOriginalShape1() throws IllegalAccessException, NoSuchFieldException {
        MyShape shape;
        Field figuresField;
        List<MyShape> figures;
        
        figuresField = Drawing.class.getDeclaredField("figures");
        figuresField.setAccessible(true);
        figures = (List<MyShape>) figuresField.get(draw);
        
        shape = new MyEnhancedRectangle();
        this.canvas.addShape(shape);
        
        MyShape preview = this.canvas.substituteShapeWithPreview(shape);
        this.canvas.substitutePreviewWithOriginalShape(shape);
        
        assertTrue(figures.contains(shape));
        assertTrue(pane.getChildren().contains(shape.getView()));
        
        assertFalse(figures.contains(preview));
        assertFalse(pane.getChildren().contains(preview.getView()));
    }
    
    @Test(expected = Exception.class)
    public void testSubstitutePreviewWithOriginalShape2() throws IllegalAccessException{
        MyShape shape = new MyEnhancedRectangle();
        this.canvas.substitutePreviewWithOriginalShape(shape);
    }
    
    @Test
    public void testMoveToLayer(){
        MyEnhancedRectangle r = new MyEnhancedRectangle();
        this.canvas.addShape(r);
        MyEnhancedLine l = new MyEnhancedLine();
        this.canvas.addShape(l);
        MyEnhancedEllipse e = new MyEnhancedEllipse();
        this.canvas.addShape(e);
        this.canvas.moveToLayer(e,0,true);
        //check in draw
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(e)==0);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(r)==1);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(l)==2);
        //check in drawpane
        MyEnhancedEllipse firstPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in moveToLayer", firstPos.myGetRadiusX() == e.myGetRadiusX());
        assertTrue("Error in moveToLayer", firstPos.myGetRadiusY() == e.myGetRadiusY());
        assertTrue("Error in moveToLayer", firstPos.myGetCenterX() == e.myGetCenterX());
        assertTrue("Error in moveToLayer", firstPos.myGetCenterY() == e.myGetCenterY());
        assertTrue("Error in moveToLayer", firstPos.myGetFill() == e.myGetFill());
        assertTrue("Error in moveToLayer", firstPos.myGetStroke() == e.myGetStroke());
        assertTrue("Error in moveToLayer", firstPos.myGetStrokeWidth() == e.myGetStrokeWidth()); 
        
        MyEnhancedLine lastPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in moveToLayer", lastPos.myGetEndX() == l.myGetEndX());
        assertTrue("Error in moveToLayer", lastPos.myGetEndY() == l.myGetEndY());
        assertTrue("Error in moveToLayer", lastPos.myGetStartY() == l.myGetStartY());
        assertTrue("Error in moveToLayer", lastPos.myGetStartX() == l.myGetStartX());
        assertTrue("Error in moveToLayer", lastPos.myGetFill() == l.myGetFill());
        assertTrue("Error in moveToLayer", lastPos.myGetStroke() == l.myGetStroke());
        assertTrue("Error in moveToLayer", lastPos.myGetStrokeWidth() == l.myGetStrokeWidth());
    
        MyEnhancedRectangle secondPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(1);
        assertTrue("Error in moveToLayer", secondPos.myGetX() == r.myGetX());
        assertTrue("Error in moveToLayer", secondPos.myGetY() == r.myGetY());
        assertTrue("Error in moveToLayer", secondPos.myGetWidth() == r.myGetHeight());
        assertTrue("Error in moveToLayer", secondPos.myGetHeight() == r.myGetHeight());
        assertTrue("Error in moveToLayer", secondPos.myGetFill() == r.myGetFill());
        assertTrue("Error in moveToLayer", secondPos.myGetStroke() == r.myGetStroke());
        assertTrue("Error in moveToLayer", secondPos.myGetStrokeWidth() == r.myGetStrokeWidth());

    }
    
    @Test
    public void testMoveToLayer1(){
        MyEnhancedRectangle r = new MyEnhancedRectangle();
        this.canvas.addShape(r);
        MyEnhancedLine l = new MyEnhancedLine();
        this.canvas.addShape(l);
        MyEnhancedEllipse e = new MyEnhancedEllipse();
        this.canvas.addShape(e);
        this.canvas.moveToLayer(l,2,true);
        //check in draw
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(e)==1);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(r)==0);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(l)==2);
        //check in drawpane
        MyEnhancedLine lastPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in moveToLayer", lastPos.myGetEndX() == l.myGetEndX());
        assertTrue("Error in moveToLayer", lastPos.myGetEndY() == l.myGetEndY());
        assertTrue("Error in moveToLayer", lastPos.myGetStartY() == l.myGetStartY());
        assertTrue("Error in moveToLayer", lastPos.myGetStartX() == l.myGetStartX());
        assertTrue("Error in moveToLayer", lastPos.myGetFill() == l.myGetFill());
        assertTrue("Error in moveToLayer", lastPos.myGetStroke() == l.myGetStroke());
        assertTrue("Error in moveToLayer", lastPos.myGetStrokeWidth() == l.myGetStrokeWidth());

        MyEnhancedRectangle firstPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in moveToLayer", firstPos.myGetX() == r.myGetX());
        assertTrue("Error in moveToLayer", firstPos.myGetY() == r.myGetY());
        assertTrue("Error in moveToLayer", firstPos.myGetWidth() == r.myGetHeight());
        assertTrue("Error in moveToLayer", firstPos.myGetHeight() == r.myGetHeight());
        assertTrue("Error in moveToLayer", firstPos.myGetFill() == r.myGetFill());
        assertTrue("Error in moveToLayer", firstPos.myGetStroke() == r.myGetStroke());
        assertTrue("Error in moveToLayer", firstPos.myGetStrokeWidth() == r.myGetStrokeWidth());

        MyEnhancedEllipse secondPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(1);
        assertTrue("Error in moveToLayer", secondPos.myGetRadiusX() == e.myGetRadiusX());
        assertTrue("Error in moveToLayer", secondPos.myGetRadiusY() == e.myGetRadiusY());
        assertTrue("Error in moveToLayer", secondPos.myGetCenterX() == e.myGetCenterX());
        assertTrue("Error in moveToLayer", secondPos.myGetCenterY() == e.myGetCenterY());
        assertTrue("Error in moveToLayer", secondPos.myGetFill() == e.myGetFill());
        assertTrue("Error in moveToLayer", secondPos.myGetStroke() == e.myGetStroke());
        assertTrue("Error in moveToLayer", secondPos.myGetStrokeWidth() == e.myGetStrokeWidth()); 
        
        
    }
    
    @Test
    public void testMoveToLayer2(){
        MyEnhancedRectangle r = new MyEnhancedRectangle();
        this.canvas.addShape(r);
        MyEnhancedLine l = new MyEnhancedLine();
        this.canvas.addShape(l);
        MyEnhancedEllipse e = new MyEnhancedEllipse();
        this.canvas.addShape(e);
        this.canvas.moveToLayer(r,2,true);
        //check in draw
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(e)==1);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(r)==2);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(l)==0);
        //check in drawpane
        MyEnhancedLine firstPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in moveToLayer", firstPos.myGetEndX() == l.myGetEndX());
        assertTrue("Error in moveToLayer", firstPos.myGetEndY() == l.myGetEndY());
        assertTrue("Error in moveToLayer", firstPos.myGetStartY() == l.myGetStartY());
        assertTrue("Error in moveToLayer", firstPos.myGetStartX() == l.myGetStartX());
        assertTrue("Error in moveToLayer", firstPos.myGetFill() == l.myGetFill());
        assertTrue("Error in moveToLayer", firstPos.myGetStroke() == l.myGetStroke());
        assertTrue("Error in moveToLayer", firstPos.myGetStrokeWidth() == l.myGetStrokeWidth());

        MyEnhancedRectangle lastPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in moveToLayer", lastPos.myGetX() == r.myGetX());
        assertTrue("Error in moveToLayer", lastPos.myGetY() == r.myGetY());
        assertTrue("Error in moveToLayer", lastPos.myGetWidth() == r.myGetHeight());
        assertTrue("Error in moveToLayer", lastPos.myGetHeight() == r.myGetHeight());
        assertTrue("Error in moveToLayer", lastPos.myGetFill() == r.myGetFill());
        assertTrue("Error in moveToLayer", lastPos.myGetStroke() == r.myGetStroke());
        assertTrue("Error in moveToLayer", lastPos.myGetStrokeWidth() == r.myGetStrokeWidth());

        MyEnhancedEllipse secondPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(1);
        assertTrue("Error in moveToLayer", secondPos.myGetRadiusX() == e.myGetRadiusX());
        assertTrue("Error in moveToLayer", secondPos.myGetRadiusY() == e.myGetRadiusY());
        assertTrue("Error in moveToLayer", secondPos.myGetCenterX() == e.myGetCenterX());
        assertTrue("Error in moveToLayer", secondPos.myGetCenterY() == e.myGetCenterY());
        assertTrue("Error in moveToLayer", secondPos.myGetFill() == e.myGetFill());
        assertTrue("Error in moveToLayer", secondPos.myGetStroke() == e.myGetStroke());
        assertTrue("Error in moveToLayer", secondPos.myGetStrokeWidth() == e.myGetStrokeWidth()); 
        
        
    }
    
    
    
    @Test
    public void testMoveToLayer3(){
        MyEnhancedRectangle r = new MyEnhancedRectangle();
        MyEnhancedLine l = new MyEnhancedLine();
        this.canvas.addShape(l);
        MyEnhancedEllipse e = new MyEnhancedEllipse();
        this.canvas.addShape(e);
        this.canvas.moveToLayer(r,2,false);
        //check in draw
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(e)==1);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(r)==2);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(l)==0);
        //check in drawpane
        MyEnhancedLine firstPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in moveToLayer", firstPos.myGetEndX() == l.myGetEndX());
        assertTrue("Error in moveToLayer", firstPos.myGetEndY() == l.myGetEndY());
        assertTrue("Error in moveToLayer", firstPos.myGetStartY() == l.myGetStartY());
        assertTrue("Error in moveToLayer", firstPos.myGetStartX() == l.myGetStartX());
        assertTrue("Error in moveToLayer", firstPos.myGetFill() == l.myGetFill());
        assertTrue("Error in moveToLayer", firstPos.myGetStroke() == l.myGetStroke());
        assertTrue("Error in moveToLayer", firstPos.myGetStrokeWidth() == l.myGetStrokeWidth());

        MyEnhancedRectangle lastPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in moveToLayer", lastPos.myGetX() == r.myGetX());
        assertTrue("Error in moveToLayer", lastPos.myGetY() == r.myGetY());
        assertTrue("Error in moveToLayer", lastPos.myGetWidth() == r.myGetHeight());
        assertTrue("Error in moveToLayer", lastPos.myGetHeight() == r.myGetHeight());
        assertTrue("Error in moveToLayer", lastPos.myGetFill() == r.myGetFill());
        assertTrue("Error in moveToLayer", lastPos.myGetStroke() == r.myGetStroke());
        assertTrue("Error in moveToLayer", lastPos.myGetStrokeWidth() == r.myGetStrokeWidth());

        MyEnhancedEllipse secondPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(1);
        assertTrue("Error in moveToLayer", secondPos.myGetRadiusX() == e.myGetRadiusX());
        assertTrue("Error in moveToLayer", secondPos.myGetRadiusY() == e.myGetRadiusY());
        assertTrue("Error in moveToLayer", secondPos.myGetCenterX() == e.myGetCenterX());
        assertTrue("Error in moveToLayer", secondPos.myGetCenterY() == e.myGetCenterY());
        assertTrue("Error in moveToLayer", secondPos.myGetFill() == e.myGetFill());
        assertTrue("Error in moveToLayer", secondPos.myGetStroke() == e.myGetStroke());
        assertTrue("Error in moveToLayer", secondPos.myGetStrokeWidth() == e.myGetStrokeWidth()); 
        
        
    }
    
    @Test
    public void testMoveToLayer4(){
        MyEnhancedRectangle r = new MyEnhancedRectangle();
        this.canvas.addShape(r);
        MyEnhancedLine l = new MyEnhancedLine();
        MyEnhancedEllipse e = new MyEnhancedEllipse();
        this.canvas.addShape(e);
        this.canvas.moveToLayer(l,2,false);
        //check in draw
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(e)==1);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(r)==0);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(l)==2);
        //check in drawpane
        MyEnhancedLine lastPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in moveToLayer", lastPos.myGetEndX() == l.myGetEndX());
        assertTrue("Error in moveToLayer", lastPos.myGetEndY() == l.myGetEndY());
        assertTrue("Error in moveToLayer", lastPos.myGetStartY() == l.myGetStartY());
        assertTrue("Error in moveToLayer", lastPos.myGetStartX() == l.myGetStartX());
        assertTrue("Error in moveToLayer", lastPos.myGetFill() == l.myGetFill());
        assertTrue("Error in moveToLayer", lastPos.myGetStroke() == l.myGetStroke());
        assertTrue("Error in moveToLayer", lastPos.myGetStrokeWidth() == l.myGetStrokeWidth());

        MyEnhancedRectangle firstPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in moveToLayer", firstPos.myGetX() == r.myGetX());
        assertTrue("Error in moveToLayer", firstPos.myGetY() == r.myGetY());
        assertTrue("Error in moveToLayer", firstPos.myGetWidth() == r.myGetHeight());
        assertTrue("Error in moveToLayer", firstPos.myGetHeight() == r.myGetHeight());
        assertTrue("Error in moveToLayer", firstPos.myGetFill() == r.myGetFill());
        assertTrue("Error in moveToLayer", firstPos.myGetStroke() == r.myGetStroke());
        assertTrue("Error in moveToLayer", firstPos.myGetStrokeWidth() == r.myGetStrokeWidth());

        MyEnhancedEllipse secondPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(1);
        assertTrue("Error in moveToLayer", secondPos.myGetRadiusX() == e.myGetRadiusX());
        assertTrue("Error in moveToLayer", secondPos.myGetRadiusY() == e.myGetRadiusY());
        assertTrue("Error in moveToLayer", secondPos.myGetCenterX() == e.myGetCenterX());
        assertTrue("Error in moveToLayer", secondPos.myGetCenterY() == e.myGetCenterY());
        assertTrue("Error in moveToLayer", secondPos.myGetFill() == e.myGetFill());
        assertTrue("Error in moveToLayer", secondPos.myGetStroke() == e.myGetStroke());
        assertTrue("Error in moveToLayer", secondPos.myGetStrokeWidth() == e.myGetStrokeWidth()); 
        
        
    }
    
    @Test
    public void testMoveToLayer5(){
        MyEnhancedRectangle r = new MyEnhancedRectangle();
        this.canvas.addShape(r);
        MyEnhancedLine l = new MyEnhancedLine();
        this.canvas.addShape(l);
        MyEnhancedEllipse e = new MyEnhancedEllipse();
        this.canvas.moveToLayer(e,0,false);
        //check in draw
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(e)==0);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(r)==1);
        assertTrue("error in moveToLayer of draw",this.canvas.getDraw().getShapeLayer(l)==2);
        //check in drawpane
        MyEnhancedEllipse firstPos = (MyEnhancedEllipse) (MyShape) this.pane.getChildren().get(0);
        assertTrue("Error in moveToLayer", firstPos.myGetRadiusX() == e.myGetRadiusX());
        assertTrue("Error in moveToLayer", firstPos.myGetRadiusY() == e.myGetRadiusY());
        assertTrue("Error in moveToLayer", firstPos.myGetCenterX() == e.myGetCenterX());
        assertTrue("Error in moveToLayer", firstPos.myGetCenterY() == e.myGetCenterY());
        assertTrue("Error in moveToLayer", firstPos.myGetFill() == e.myGetFill());
        assertTrue("Error in moveToLayer", firstPos.myGetStroke() == e.myGetStroke());
        assertTrue("Error in moveToLayer", firstPos.myGetStrokeWidth() == e.myGetStrokeWidth()); 
        
        MyEnhancedLine lastPos = (MyEnhancedLine) (MyShape) this.pane.getChildren().get(2);
        assertTrue("Error in moveToLayer", lastPos.myGetEndX() == l.myGetEndX());
        assertTrue("Error in moveToLayer", lastPos.myGetEndY() == l.myGetEndY());
        assertTrue("Error in moveToLayer", lastPos.myGetStartY() == l.myGetStartY());
        assertTrue("Error in moveToLayer", lastPos.myGetStartX() == l.myGetStartX());
        assertTrue("Error in moveToLayer", lastPos.myGetFill() == l.myGetFill());
        assertTrue("Error in moveToLayer", lastPos.myGetStroke() == l.myGetStroke());
        assertTrue("Error in moveToLayer", lastPos.myGetStrokeWidth() == l.myGetStrokeWidth());
    
        MyEnhancedRectangle secondPos = (MyEnhancedRectangle) (MyShape) this.pane.getChildren().get(1);
        assertTrue("Error in moveToLayer", secondPos.myGetX() == r.myGetX());
        assertTrue("Error in moveToLayer", secondPos.myGetY() == r.myGetY());
        assertTrue("Error in moveToLayer", secondPos.myGetWidth() == r.myGetHeight());
        assertTrue("Error in moveToLayer", secondPos.myGetHeight() == r.myGetHeight());
        assertTrue("Error in moveToLayer", secondPos.myGetFill() == r.myGetFill());
        assertTrue("Error in moveToLayer", secondPos.myGetStroke() == r.myGetStroke());
        assertTrue("Error in moveToLayer", secondPos.myGetStrokeWidth() == r.myGetStrokeWidth());

    }
    
    
    
    @Test (expected = NullPointerException.class)   //Check that the initializeNewDrawing method throws a NullPointerException 
                                                    //if invoked on a null Drawing object
    public void testInitializeNewNullDrawing(){
        Drawing drawing = null;
        this.canvas.initializeNewDrawing(drawing);
    }
    
    @Test
    public void testInitializeNewEmptyDrawing(){    //Check that the initializeNewDrawing method
        MyEnhancedEllipse ellipse= new MyEnhancedEllipse();
        canvas.addShape(ellipse);
        MyEnhancedRectangle rectangle= new MyEnhancedRectangle();
        canvas.addShape(rectangle);
        MyEnhancedLine line= new MyEnhancedLine();
        canvas.addShape(line);
        
        Drawing drawing = new Drawing();
        this.canvas.initializeNewDrawing(drawing);
        assertFalse(pane.getChildren().contains(rectangle));
        assertFalse(pane.getChildren().contains(ellipse));
        assertFalse(pane.getChildren().contains(line));
        assertTrue(pane.getChildren().isEmpty());
    }
    
    @Test
    public void testInitializeNewDrawing(){
        MyEnhancedEllipse ellipse= new MyEnhancedEllipse();
        canvas.addShape(ellipse);
        MyEnhancedRectangle rectangle= new MyEnhancedRectangle();
        canvas.addShape(rectangle);
        MyEnhancedLine line= new MyEnhancedLine();
        canvas.addShape(line);
        
        Drawing drawing = new Drawing();
        MyEnhancedEllipse ellipse2 = new MyEnhancedEllipse();
        drawing.addShape(ellipse2);
        MyEnhancedRectangle rectangle2 = new MyEnhancedRectangle();
        drawing.addShape(rectangle2);
        MyEnhancedLine line2 = new MyEnhancedLine();
        drawing.addShape(line2);
        
        this.canvas.initializeNewDrawing(drawing);
        assertTrue(pane.getChildren().contains(rectangle2));
        assertFalse(pane.getChildren().contains(rectangle));
        assertTrue(pane.getChildren().contains(ellipse2));
        assertFalse(pane.getChildren().contains(ellipse));
        assertTrue(pane.getChildren().contains(line2));
        assertFalse(pane.getChildren().contains(line));
    }
    
    @Test
    public void testChangeShapeStrokeColor1(){
        MyEnhancedRectangle shape;
        Color color;
        
        shape = new MyEnhancedRectangle();
        color = Color.CORAL;
        this.canvas.changeShapeStrokeColor(shape, color);
        
        assertEquals(color, shape.myGetStroke());
    }
    
    @Test
    public void testChangeShapeStrokeColor2(){
        MyEnhancedRectangle shape;
        MyShape preview;
        Color color;
        
        shape = new MyEnhancedRectangle();
        color = Color.CORAL;
        
        this.canvas.addShape(shape);
        preview = this.canvas.substituteShapeWithPreview(shape);
        this.canvas.changeShapeStrokeColor(shape, color);
        
        assertEquals(color, shape.myGetStroke());
        assertEquals(color, preview.myGetStroke());
    }
    
    @Test
    public void testChangeShapeFillColor1(){
        MyEnhancedRectangle shape;
        Color color;
        
        shape = new MyEnhancedRectangle();
        color = Color.CORAL;
        this.canvas.changeShapeFillColor(shape, color);
        
        assertEquals(color, shape.myGetFill());
    }
    
    @Test
    public void testChangeShapeFillColor2(){
        MyEnhancedRectangle shape;
        MyShape preview;
        Color color;
        
        shape = new MyEnhancedRectangle();
        color = Color.CORAL;
        
        this.canvas.addShape(shape);
        preview = this.canvas.substituteShapeWithPreview(shape);
        this.canvas.changeShapeFillColor(shape, color);
        
        assertEquals(color, shape.myGetFill());
        assertEquals(color, preview.myGetFill());
    }
}
