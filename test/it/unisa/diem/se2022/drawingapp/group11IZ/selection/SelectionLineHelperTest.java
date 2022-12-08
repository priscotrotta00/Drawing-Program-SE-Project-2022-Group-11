/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import java.lang.reflect.Field;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author utente
 */
public class SelectionLineHelperTest {
    private SelectionLineHelper helper;
    private MyLine line;
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
        
        this.line = new MyEnhancedLine();
        this.canvas.addShape(line);
        
        this.helper = new SelectionLineHelper(canvas, line);
    }
    
    @Test
    public void testCreateBoundingBoxEdge(){
        MyLine edge;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox();
        edge = (MyLine) this.helper.getBoundingBoxEdge();
        
        Assert.assertEquals(10, edge.myGetStartX(), 0);
        Assert.assertEquals(10, edge.myGetStartY(), 0);
        Assert.assertEquals(30, edge.myGetEndX(), 0);
        Assert.assertEquals(20, edge.myGetEndY(), 0);
    }
    
    @Test
    public void testCreateBoundingBoxEdgeMoveShape(){
        MyLine edge;
        MyLine preview;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox();
        edge = (MyLine) this.helper.getBoundingBoxEdge();
        preview = this.helper.getPreview();
        
        Assert.assertEquals(10, edge.myGetStartX(), 0);
        Assert.assertEquals(10, edge.myGetStartY(), 0);
        Assert.assertEquals(30, edge.myGetEndX(), 0);
        Assert.assertEquals(20, edge.myGetEndY(), 0);
        
        preview.modifyShape(50, 50, 80, 70);
        Assert.assertEquals(50, edge.myGetStartX(), 0);
        Assert.assertEquals(50, edge.myGetStartY(), 0);
        Assert.assertEquals(80, edge.myGetEndX(), 0);
        Assert.assertEquals(70, edge.myGetEndY(), 0);
        
        preview.modifyShape(-30, 40, -10, 50);
        Assert.assertEquals(-30, edge.myGetStartX(), 0);
        Assert.assertEquals(40, edge.myGetStartY(), 0);
        Assert.assertEquals(-10, edge.myGetEndX(), 0);
        Assert.assertEquals(50, edge.myGetEndY(), 0);
    }
    
    @Test
    public void testCreateBoundingBoxEdgeResizeShape(){
        MyLine edge;
        MyLine preview;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox();
        edge = (MyLine) this.helper.getBoundingBoxEdge();
        preview = this.helper.getPreview();
        
        Assert.assertEquals(10, edge.myGetStartX(), 0);
        Assert.assertEquals(10, edge.myGetStartY(), 0);
        Assert.assertEquals(30, edge.myGetEndX(), 0);
        Assert.assertEquals(20, edge.myGetEndY(), 0);
        
        preview.modifyShape(10, 50, 80, 30);
        Assert.assertEquals(10, edge.myGetStartX(), 0);
        Assert.assertEquals(50, edge.myGetStartY(), 0);
        Assert.assertEquals(80, edge.myGetEndX(), 0);
        Assert.assertEquals(30, edge.myGetEndY(), 0);
        
        preview.modifyShape(-10, -50, 45, -30);
        Assert.assertEquals(-10, edge.myGetStartX(), 0);
        Assert.assertEquals(-50, edge.myGetStartY(), 0);
        Assert.assertEquals(45, edge.myGetEndX(), 0);
        Assert.assertEquals(-30, edge.myGetEndY(), 0);
    }
    
    @Test
    public void testUpdateVertices(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        double widthVertex;
        double heightVertex;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox();
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(10 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex/2, vertex2.getTopLeftY(), 0);
        
    }
    
    @Test
    public void testUpdateVerticesMoveShape(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        double widthVertex;
        double heightVertex;
        MyLine preview;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox();
        preview = this.helper.getPreview();
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(10 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex/2, vertex2.getTopLeftY(), 0);
        
        preview.modifyShape(50, 50, 80, 70);
        Assert.assertEquals(50 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(80 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(70 - heightVertex/2, vertex2.getTopLeftY(), 0);
        
        preview.modifyShape(-30, 40, -10, 50);
        Assert.assertEquals(-30 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(40 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(-10 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex/2, vertex2.getTopLeftY(), 0);
    }
    
    @Test
    public void testUpdateVerticesResizeShape(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        double widthVertex;
        double heightVertex;
        MyLine preview;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox();
        preview = this.helper.getPreview();
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(10 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex/2, vertex2.getTopLeftY(), 0);
        
        preview.modifyShape(10, 50, 80, 30);
        Assert.assertEquals(10 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(80 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(30 - heightVertex/2, vertex2.getTopLeftY(), 0);
        
        preview.modifyShape(-10, -50, 45, -30);
        Assert.assertEquals(-10 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(-50 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(45 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(-30 - heightVertex/2, vertex2.getTopLeftY(), 0);
    }
    
    @Test
    public void testOnMouseDragVertex1Action(){
        MyLine preview;
        
        this.line.modifyShape(10, 10, 30, 40);
        this.helper.createBoundingBox();
        preview = this.helper.getPreview();
        
        this.helper.onMouseDragVertex1Action(0, 0);
        Assert.assertEquals(0, preview.myGetStartX(), 0);
        Assert.assertEquals(0, preview.myGetStartY(), 0);
        Assert.assertEquals(30, preview.myGetEndX(), 0);
        Assert.assertEquals(40, preview.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex1Action(50, 60);
        Assert.assertEquals(50, preview.myGetStartX(), 0);
        Assert.assertEquals(60, preview.myGetStartY(), 0);
        Assert.assertEquals(30, preview.myGetEndX(), 0);
        Assert.assertEquals(40, preview.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex1Action(-10, 40);
        Assert.assertEquals(-10, preview.myGetStartX(), 0);
        Assert.assertEquals(40, preview.myGetStartY(), 0);
        Assert.assertEquals(30, preview.myGetEndX(), 0);
        Assert.assertEquals(40, preview.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex1Action(-40, -70);
        Assert.assertEquals(-40, preview.myGetStartX(), 0);
        Assert.assertEquals(-70, preview.myGetStartY(), 0);
        Assert.assertEquals(30, preview.myGetEndX(), 0);
        Assert.assertEquals(40, preview.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex1Action(30, 40);
        Assert.assertEquals(30, preview.myGetStartX(), 0);
        Assert.assertEquals(40, preview.myGetStartY(), 0);
        Assert.assertEquals(30, preview.myGetEndX(), 0);
        Assert.assertEquals(40, preview.myGetEndY(), 0);
    }
    
    @Test
    public void testOnMouseDragVertex2Action(){
        MyLine preview;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox();
        preview = this.helper.getPreview();
        
        this.helper.onMouseDragVertex2Action(10, 50);
        Assert.assertEquals(10, preview.myGetStartX(), 0);
        Assert.assertEquals(10, preview.myGetStartY(), 0);
        Assert.assertEquals(10, preview.myGetEndX(), 0);
        Assert.assertEquals(50, preview.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex2Action(60, 90);
        Assert.assertEquals(10, preview.myGetStartX(), 0);
        Assert.assertEquals(10, preview.myGetStartY(), 0);
        Assert.assertEquals(60, preview.myGetEndX(), 0);
        Assert.assertEquals(90, preview.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex2Action(-100, -50);
        Assert.assertEquals(10, preview.myGetStartX(), 0);
        Assert.assertEquals(10, preview.myGetStartY(), 0);
        Assert.assertEquals(-100, preview.myGetEndX(), 0);
        Assert.assertEquals(-50, preview.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex2Action(10, 10);
        Assert.assertEquals(10, preview.myGetStartX(), 0);
        Assert.assertEquals(10, preview.myGetStartY(), 0);
        Assert.assertEquals(10, preview.myGetEndX(), 0);
        Assert.assertEquals(10, preview.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex2Action(40, -40);
        Assert.assertEquals(10, preview.myGetStartX(), 0);
        Assert.assertEquals(10, preview.myGetStartY(), 0);
        Assert.assertEquals(40, preview.myGetEndX(), 0);
        Assert.assertEquals(-40, preview.myGetEndY(), 0);
    }
}
