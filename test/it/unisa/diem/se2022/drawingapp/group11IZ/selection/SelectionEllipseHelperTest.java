/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import java.lang.reflect.Field;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 *
 * @author utente
 */
public class SelectionEllipseHelperTest {
    private SelectionEllipseHelper helper;
    private MyEllipse ellipse;
    private Canvas canvas;
    
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
        Pane pane;
        
        this.canvas = new Canvas();
        pane = new Pane();
        drawPaneField = Canvas.class.getDeclaredField("drawPane");
        drawPaneField.setAccessible(true);
        drawPaneField.set(this.canvas, pane);
        this.canvas.initialize(null, null);
        
        this.ellipse = new MyEnhancedEllipse();
        this.canvas.addShape(ellipse);
        
        this.helper = new SelectionEllipseHelper(canvas, ellipse);
    }
    
    @Test
    public void testCreateBoundingBoxEdge(){
        MyEllipse edge;
        
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        edge = (MyEllipse) this.helper.getBoundingBoxEdge();
        
        Assert.assertEquals(10, edge.getTopLeftX(), 0);
        Assert.assertEquals(10, edge.getTopLeftY(), 0);
        Assert.assertEquals(30, edge.getBottomRightX(), 0);
        Assert.assertEquals(50, edge.getBottomRightY(), 0);
        Assert.assertEquals(10, edge.myGetRadiusX(), 0);
        Assert.assertEquals(20, edge.myGetRadiusY(), 0);
        Assert.assertEquals(20, edge.myGetCenterX(), 0);
        Assert.assertEquals(30, edge.myGetCenterY(), 0);
    }
    
    @Test
    public void testCreateBoundingBoxEdgeMoveShape(){
        MyEllipse edge;
        MyEllipse preview;
        
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        edge = (MyEllipse) this.helper.getBoundingBoxEdge();
        preview = this.helper.getPreview();
        
        Assert.assertEquals(10, edge.getTopLeftX(), 0);
        Assert.assertEquals(10, edge.getTopLeftY(), 0);
        Assert.assertEquals(30, edge.getBottomRightX(), 0);
        Assert.assertEquals(50, edge.getBottomRightY(), 0);
        Assert.assertEquals(10, edge.myGetRadiusX(), 0);
        Assert.assertEquals(20, edge.myGetRadiusY(), 0);
        Assert.assertEquals(20, edge.myGetCenterX(), 0);
        Assert.assertEquals(30, edge.myGetCenterY(), 0);
        
        preview.modifyShape(40, 60, 60, 100);
        Assert.assertEquals(40, edge.getTopLeftX(), 0);
        Assert.assertEquals(60, edge.getTopLeftY(), 0);
        Assert.assertEquals(60, edge.getBottomRightX(), 0);
        Assert.assertEquals(100, edge.getBottomRightY(), 0);
        Assert.assertEquals(10, edge.myGetRadiusX(), 0);
        Assert.assertEquals(20, edge.myGetRadiusY(), 0);
        Assert.assertEquals(50, edge.myGetCenterX(), 0);
        Assert.assertEquals(80, edge.myGetCenterY(), 0);
        
        preview.modifyShape(-10, -10, 10, 30);
        Assert.assertEquals(-10, edge.getTopLeftX(), 0);
        Assert.assertEquals(-10, edge.getTopLeftY(), 0);
        Assert.assertEquals(10, edge.getBottomRightX(), 0);
        Assert.assertEquals(30, edge.getBottomRightY(), 0);
        Assert.assertEquals(10, edge.myGetRadiusX(), 0);
        Assert.assertEquals(20, edge.myGetRadiusY(), 0);
        Assert.assertEquals(0, edge.myGetCenterX(), 0);
        Assert.assertEquals(10, edge.myGetCenterY(), 0);
    }
    
    @Test
    public void testCreateBoundingBoxEdgeResizeShape(){
        MyEllipse edge;
        MyEllipse preview;
        
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        edge = (MyEllipse) this.helper.getBoundingBoxEdge();
        preview = this.helper.getPreview();
        
        Assert.assertEquals(10, edge.getTopLeftX(), 0);
        Assert.assertEquals(10, edge.getTopLeftY(), 0);
        Assert.assertEquals(30, edge.getBottomRightX(), 0);
        Assert.assertEquals(50, edge.getBottomRightY(), 0);
        Assert.assertEquals(10, edge.myGetRadiusX(), 0);
        Assert.assertEquals(20, edge.myGetRadiusY(), 0);
        Assert.assertEquals(20, edge.myGetCenterX(), 0);
        Assert.assertEquals(30, edge.myGetCenterY(), 0);
        
        preview.modifyShape(-10, -10, 10, 10);
        Assert.assertEquals(-10, edge.getTopLeftX(), 0);
        Assert.assertEquals(-10, edge.getTopLeftY(), 0);
        Assert.assertEquals(10, edge.getBottomRightX(), 0);
        Assert.assertEquals(10, edge.getBottomRightY(), 0);
        Assert.assertEquals(10, edge.myGetRadiusX(), 0);
        Assert.assertEquals(10, edge.myGetRadiusY(), 0);
        Assert.assertEquals(0, edge.myGetCenterX(), 0);
        Assert.assertEquals(0, edge.myGetCenterY(), 0);
        
        preview.modifyShape(40, 30, 60, 40);
        Assert.assertEquals(40, edge.getTopLeftX(), 0);
        Assert.assertEquals(30, edge.getTopLeftY(), 0);
        Assert.assertEquals(60, edge.getBottomRightX(), 0);
        Assert.assertEquals(40, edge.getBottomRightY(), 0);
        Assert.assertEquals(10, edge.myGetRadiusX(), 0);
        Assert.assertEquals(5, edge.myGetRadiusY(), 0);
        Assert.assertEquals(50, edge.myGetCenterX(), 0);
        Assert.assertEquals(35, edge.myGetCenterY(), 0);
    }
    
    @Test
    public void testUpdateVertices(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        MyRectangle vertex3;
        MyRectangle vertex4;
        double widthVertex;
        double heightVertex;
        
        this.ellipse.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox();
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        vertex3 = this.helper.getVertex3();
        vertex4 = this.helper.getVertex4();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(20 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(15 - heightVertex/2, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(20 - widthVertex/2, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(15 - heightVertex/2, vertex4.getTopLeftY(), 0);
    }
    
    @Test
    public void testUpdateVerticesMoveShape(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        MyRectangle vertex3;
        MyRectangle vertex4;
        double widthVertex;
        double heightVertex;
        MyEllipse preview;
        
        this.ellipse.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox();
        preview = this.helper.getPreview();
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        vertex3 = this.helper.getVertex3();
        vertex4 = this.helper.getVertex4();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(20 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(15 - heightVertex/2, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(20 - widthVertex/2, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(15 - heightVertex/2, vertex4.getTopLeftY(), 0);
        
        preview.modifyShape(40, 60, 60, 100);
        Assert.assertEquals(50 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(60, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(60 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(80 - heightVertex/2, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex/2, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(100 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(40, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(80 - heightVertex/2, vertex4.getTopLeftY(), 0);
        
        preview.modifyShape(-10, -10, 10, 30);
        Assert.assertEquals(0 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(-10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(10 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(10 - heightVertex/2, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(0 - widthVertex/2, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(30 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(-10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(10 - heightVertex/2, vertex4.getTopLeftY(), 0);
    }
    
    @Test
    public void testUpdateVerticesResizeShape(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        MyRectangle vertex3;
        MyRectangle vertex4;
        double widthVertex;
        double heightVertex;
        MyEllipse preview;
        
        this.ellipse.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox();
        preview = this.helper.getPreview();
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        vertex3 = this.helper.getVertex3();
        vertex4 = this.helper.getVertex4();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(20 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(15 - heightVertex/2, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(20 - widthVertex/2, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(15 - heightVertex/2, vertex4.getTopLeftY(), 0);
        
        preview.modifyShape(-10, -10, 10, 10);
        Assert.assertEquals(0 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(-10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(10 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(0 - heightVertex/2, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(0 - widthVertex/2, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(10 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(-10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(0 - heightVertex/2, vertex4.getTopLeftY(), 0);
        
        preview.modifyShape(40, 30, 60, 40);
        Assert.assertEquals(50 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(30, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(60 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(35 - heightVertex/2, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex/2, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(40 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(40, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(35 - heightVertex/2, vertex4.getTopLeftY(), 0);
    }
    
    @Test
    public void testOnMouseDragVertex1ConditionTrue(){
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(20, 30));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(20, -10));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(10, 40));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(10, 10));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(10, 0));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(25, 5));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(25, 10));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(25, 25));
        
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(15, 50));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(20, 50));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(25, 50));
        
    }
    
    @Test
    public void testOnMouseDragVertex1ConditionFalse(){
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        
        Assert.assertFalse(this.helper.onMouseDragVertex1Condition(0, 60));
        Assert.assertFalse(this.helper.onMouseDragVertex1Condition(20, 60));
        Assert.assertFalse(this.helper.onMouseDragVertex1Condition(50, 80));
    }
    
    @Test
    public void testOnMouseDragVertex1Action(){
        MyEllipse preview;
        
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        preview = this.helper.getPreview();
        
        this.helper.onMouseDragVertex1Action(20, 30);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(30, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(20, -10);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(-10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(10, 40);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(40, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(10, 10);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(10, 0);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(0, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(25, 5);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(5, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(25, 10);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(25, 5);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(5, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(25, 25);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(25, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(15, 50);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(50, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(20, 50);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(50, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(25, 50);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(50, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
    }
    
    @Test
    public void testOnMouseDragVertex2ConditionTrue(){
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(40, 30));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(40, 50));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(30, 40));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(20, 40));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(20, 30));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(20, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(30, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(40, 20));
        
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(10, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(10, 30));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(10, 40));
    }
    
    @Test
    public void testOnMouseDragVertex2ConditionFalse(){
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        
        Assert.assertFalse(this.helper.onMouseDragVertex2Condition(0, 20));
        Assert.assertFalse(this.helper.onMouseDragVertex2Condition(-10, 30));
        Assert.assertFalse(this.helper.onMouseDragVertex2Condition(-20, 50));
        
    }
    
    @Test
    public void testOnMouseDragVertex2Action(){
        MyEllipse preview;
        
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        preview = this.helper.getPreview();
        
        this.helper.onMouseDragVertex2Action(40, 30);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(40, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(40, 50);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(40, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(30, 40);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(20, 40);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(20, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(20, 30);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(20, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(20, 20);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(20, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(30, 20);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(40, 20);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(40, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(10, 20);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(10, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(10, 30);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(10, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(10, 40);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(10, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
    }
    
    @Test
    public void testOnMouseDragVertex3ConditionTrue(){
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(20, 30));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(30, 40));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(30, 50));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(30, 60));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(20, 60));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(10, 60));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(10, 50));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(10, 30));
        
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(15, 10));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(20, 10));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(25, 10));
    }
    
    @Test
    public void testOnMouseDragVertex3ConditionFalse(){
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        
        Assert.assertFalse(this.helper.onMouseDragVertex3Condition(0, -10));
        Assert.assertFalse(this.helper.onMouseDragVertex3Condition(10, -20));
        Assert.assertFalse(this.helper.onMouseDragVertex3Condition(50, 5));
    }
    
    @Test
    public void testOnMouseDragVertex3Action(){
        MyEllipse preview;
        
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        preview = this.helper.getPreview();
        
        this.helper.onMouseDragVertex3Action(20, 30);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(30, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(30, 40);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(40, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(30, 50);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(30, 60);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(60, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(20, 60);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(60, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(10, 60);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(60, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(10, 50);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(10, 30);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(30, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(15, 10);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(10, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(20, 10);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(10, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(25, 10);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(10, preview.getBottomRightY(), 0);
    }
    
    @Test
    public void testOnMouseDragVertex4ConditionTrue(){
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(10, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(20, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(20, 30));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(20, 40));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(10, 40));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(0, 40));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(0, 30));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(0, 20));
        
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(30, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(30, 30));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(30, 40));
        
    }
    
    @Test
    public void testOnMouseDragVertex4ConditionFalse(){
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        
        Assert.assertFalse(this.helper.onMouseDragVertex4Condition(40, 20));
        Assert.assertFalse(this.helper.onMouseDragVertex4Condition(40, 30));
        Assert.assertFalse(this.helper.onMouseDragVertex4Condition(40, 50));
    }
    
    @Test
    public void testOnMouseDragVertex4Action(){
        MyEllipse preview;
        
        this.ellipse.modifyShape(10, 10, 30, 50);
        this.helper.createBoundingBox();
        preview = this.helper.getPreview();
        
        this.helper.onMouseDragVertex4Action(10, 20);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(20, 20);
        Assert.assertEquals(20, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(20, 30);
        Assert.assertEquals(20, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(20, 40);
        Assert.assertEquals(20, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(10, 40);
        Assert.assertEquals(10, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(0, 40);
        Assert.assertEquals(0, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(0, 30);
        Assert.assertEquals(0, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(0, 20);
        Assert.assertEquals(0, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(30, 20);
        Assert.assertEquals(30, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(30, 30);
        Assert.assertEquals(30, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(30, 40);
        Assert.assertEquals(30, preview.getTopLeftX(), 0);
        Assert.assertEquals(10, preview.getTopLeftY(), 0);
        Assert.assertEquals(30, preview.getBottomRightX(), 0);
        Assert.assertEquals(50, preview.getBottomRightY(), 0);
    }
}
