/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.Import;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.Import.exceptions.ImportException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import java.util.Iterator;
import javafx.scene.paint.Color;
import org.json.simple.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author prisc
 */
public class JSONImportVisitorTest {
    
    @Test (expected=NullPointerException.class)
    public void testNullJSONObject() {
        JSONObject jsonObject = null;
        Drawing draw = new Drawing();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonObject, draw);
    }
    
    @Test (expected=NullPointerException.class)
    public void testNullDraw() {
        JSONObject jsonObject = new JSONObject();
        Drawing draw = null;
        JSONImportVisitor visitor = new JSONImportVisitor(jsonObject, draw);
    }
    
    @Test (expected=ImportException.class)  //Visit a JSON object that doesn't contains any key "type" -> It's not a shape
    public void testRectangleVisitEmptyJSONObject() {
        JSONObject jsonObject = new JSONObject();
        MyRectangle myRectangle = new MyEnhancedRectangle();
        Drawing draw = new Drawing();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonObject, draw);
        visitor.visitRectangle(myRectangle);
    }
    
    @Test (expected=ImportException.class)  //Visit a JSON object that contains a wrong "type" key
    public void testRectangleVisitWrongJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "line");
        MyRectangle myRectangle = new MyEnhancedRectangle();
        Drawing draw = new Drawing();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonObject, draw);
        visitor.visitRectangle(myRectangle);
    }
    
    @Test
    public void testVisitStandardRectangle() {
        JSONObject jsonRectangleObject = new JSONObject();
        MyRectangle myRectangle = new MyEnhancedRectangle();
        jsonRectangleObject.put("type", "rectangle");
        jsonRectangleObject.put("fill", myRectangle.myGetFill().toString());
        jsonRectangleObject.put("stroke", null);
        jsonRectangleObject.put("height", myRectangle.myGetHeight());
        jsonRectangleObject.put("width", myRectangle.myGetWidth());
        jsonRectangleObject.put("x", myRectangle.myGetX());
        jsonRectangleObject.put("y", myRectangle.myGetY());
        Drawing draw = new Drawing();
        MyRectangle myTestRectangle = new MyEnhancedRectangle();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonRectangleObject, draw);
        visitor.visitRectangle(myTestRectangle);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a standard rectangle", myRectangle.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitStandardRectangle2() {
        JSONObject jsonRectangleObject = new JSONObject();
        MyRectangle myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(null);
        jsonRectangleObject.put("type", "rectangle");
        jsonRectangleObject.put("fill", null);
        jsonRectangleObject.put("stroke", null);
        jsonRectangleObject.put("height", myRectangle.myGetHeight());
        jsonRectangleObject.put("width", myRectangle.myGetWidth());
        jsonRectangleObject.put("x", myRectangle.myGetX());
        jsonRectangleObject.put("y", myRectangle.myGetY());
        Drawing draw = new Drawing();
        MyRectangle myTestRectangle = new MyEnhancedRectangle();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonRectangleObject, draw);
        visitor.visitRectangle(myTestRectangle);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a standard rectangle",myRectangle.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitRectangle() {
        JSONObject jsonRectangleObject = new JSONObject();
        MyRectangle myRectangle = new MyEnhancedRectangle();        
        myRectangle.mySetFill(Color.AQUAMARINE);
        myRectangle.mySetStroke(Color.BLUE);
        myRectangle.mySetHeight(15.0);
        myRectangle.mySetWidth(50.0);
        myRectangle.mySetX(20.0);
        myRectangle.mySetY(20.0);
        jsonRectangleObject.put("type", "rectangle");
        jsonRectangleObject.put("fill", myRectangle.myGetFill().toString());
        jsonRectangleObject.put("stroke", myRectangle.myGetStroke().toString());
        jsonRectangleObject.put("height", myRectangle.myGetHeight());
        jsonRectangleObject.put("width", myRectangle.myGetWidth());
        jsonRectangleObject.put("x", myRectangle.myGetX());
        jsonRectangleObject.put("y", myRectangle.myGetY());
        Drawing draw = new Drawing();
        MyRectangle myTestRectangle = new MyEnhancedRectangle();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonRectangleObject, draw);
        visitor.visitRectangle(myTestRectangle);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a rectangle",myRectangle.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitRectangle2() {
        JSONObject jsonRectangleObject = new JSONObject();
        MyRectangle myRectangle = new MyEnhancedRectangle();        
        myRectangle.mySetFill(null);
        myRectangle.mySetStroke(null);
        myRectangle.mySetHeight(15.0);
        myRectangle.mySetWidth(50.0);
        myRectangle.mySetX(20.0);
        myRectangle.mySetY(20.0);
        jsonRectangleObject.put("type", "rectangle");
        jsonRectangleObject.put("fill", null);
        jsonRectangleObject.put("stroke", null);
        jsonRectangleObject.put("height", myRectangle.myGetHeight());
        jsonRectangleObject.put("width", myRectangle.myGetWidth());
        jsonRectangleObject.put("x", myRectangle.myGetX());
        jsonRectangleObject.put("y", myRectangle.myGetY());
        Drawing draw = new Drawing();
        MyRectangle myTestRectangle = new MyEnhancedRectangle();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonRectangleObject, draw);
        visitor.visitRectangle(myTestRectangle);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a rectangle",myRectangle.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitNegativeRectangle() {
        JSONObject jsonRectangleObject = new JSONObject();
        MyRectangle myRectangle = new MyEnhancedRectangle();        
        myRectangle.mySetFill(Color.AQUAMARINE);
        myRectangle.mySetStroke(Color.BLUE);
        myRectangle.mySetHeight(-15.0);
        myRectangle.mySetWidth(-50.0);
        myRectangle.mySetX(-20.0);
        myRectangle.mySetY(-20.0);
        jsonRectangleObject.put("type", "rectangle");
        jsonRectangleObject.put("fill", myRectangle.myGetFill().toString());
        jsonRectangleObject.put("stroke", myRectangle.myGetStroke().toString());
        jsonRectangleObject.put("height", myRectangle.myGetHeight());
        jsonRectangleObject.put("width", myRectangle.myGetWidth());
        jsonRectangleObject.put("x", myRectangle.myGetX());
        jsonRectangleObject.put("y", myRectangle.myGetY());
        Drawing draw = new Drawing();
        MyRectangle myTestRectangle = new MyEnhancedRectangle();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonRectangleObject, draw);
        visitor.visitRectangle(myTestRectangle);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a rectangle with negative coordinates",myRectangle.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitNegativeRectangle2() {
        JSONObject jsonRectangleObject = new JSONObject();
        MyRectangle myRectangle = new MyEnhancedRectangle();        
        myRectangle.mySetFill(null);
        myRectangle.mySetStroke(null);
        myRectangle.mySetHeight(-15.0);
        myRectangle.mySetWidth(-50.0);
        myRectangle.mySetX(-20.0);
        myRectangle.mySetY(-20.0);
        jsonRectangleObject.put("type", "rectangle");
        jsonRectangleObject.put("fill", null);
        jsonRectangleObject.put("stroke", null);
        jsonRectangleObject.put("height", myRectangle.myGetHeight());
        jsonRectangleObject.put("width", myRectangle.myGetWidth());
        jsonRectangleObject.put("x", myRectangle.myGetX());
        jsonRectangleObject.put("y", myRectangle.myGetY());
        Drawing draw = new Drawing();
        MyRectangle myTestRectangle = new MyEnhancedRectangle();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonRectangleObject, draw);
        visitor.visitRectangle(myTestRectangle);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a rectangle with negative coordinates",myRectangle.toString(), itr.next().toString());
    }

    @Test (expected=ImportException.class)  //Visit a JSON object that doesn't contains any key "type" -> It's not a shape
    public void testEllipseVisitEmptyJSONObject() {
        JSONObject jsonObject = new JSONObject();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        Drawing draw = new Drawing();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonObject, draw);
        visitor.visitEllipse(myEllipse);
    }
    
    @Test (expected=ImportException.class)  //Visit a JSON object that contains a wrong "type" key
    public void testEllipseVisitWrongJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "line");
        MyEllipse myEllipse = new MyEnhancedEllipse();
        Drawing draw = new Drawing();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonObject, draw);
        visitor.visitEllipse(myEllipse);
    }
    
    @Test
    public void testVisitStandardEllipse() {
        JSONObject jsonEllipseObject = new JSONObject();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        jsonEllipseObject.put("type", "ellipse");
        jsonEllipseObject.put("fill", myEllipse.myGetFill().toString());
        jsonEllipseObject.put("stroke", null);
        jsonEllipseObject.put("centerX", myEllipse.myGetCenterX());
        jsonEllipseObject.put("centerY", myEllipse.myGetCenterY());
        jsonEllipseObject.put("radiusX", myEllipse.myGetRadiusX());
        jsonEllipseObject.put("radiusY", myEllipse.myGetRadiusY());
        Drawing draw = new Drawing();
        MyEllipse myTestEllipse = new MyEnhancedEllipse();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonEllipseObject, draw);
        visitor.visitEllipse(myTestEllipse);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a standard ellipse",myEllipse.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitStandardEllipse2() {
        JSONObject jsonEllipseObject = new JSONObject();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        myEllipse.mySetFill(null);
        jsonEllipseObject.put("type", "ellipse");
        jsonEllipseObject.put("fill", null);
        jsonEllipseObject.put("stroke", null);
        jsonEllipseObject.put("centerX", myEllipse.myGetCenterX());
        jsonEllipseObject.put("centerY", myEllipse.myGetCenterY());
        jsonEllipseObject.put("radiusX", myEllipse.myGetRadiusX());
        jsonEllipseObject.put("radiusY", myEllipse.myGetRadiusY());
        Drawing draw = new Drawing();
        MyEllipse myTestEllipse = new MyEnhancedEllipse();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonEllipseObject, draw);
        visitor.visitEllipse(myTestEllipse);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a standard ellipse",myEllipse.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitEllipse() {
        JSONObject jsonEllipseObject = new JSONObject();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        myEllipse.mySetCenterX(50.0);
        myEllipse.mySetCenterY(50.0);
        myEllipse.mySetRadiusX(100.0);
        myEllipse.mySetRadiusY(50.0);
        myEllipse.mySetStroke(Color.BLACK);
        myEllipse.mySetFill(Color.WHITE);
        jsonEllipseObject.put("type", "ellipse");
        jsonEllipseObject.put("fill", myEllipse.myGetFill().toString());
        jsonEllipseObject.put("stroke", myEllipse.myGetStroke().toString());
        jsonEllipseObject.put("centerX", myEllipse.myGetCenterX());
        jsonEllipseObject.put("centerY", myEllipse.myGetCenterY());
        jsonEllipseObject.put("radiusX", myEllipse.myGetRadiusX());
        jsonEllipseObject.put("radiusY", myEllipse.myGetRadiusY());
        Drawing draw = new Drawing();
        MyEllipse myTestEllipse = new MyEnhancedEllipse();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonEllipseObject, draw);
        visitor.visitEllipse(myTestEllipse);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit an ellipse",myEllipse.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitEllipse2() {
        JSONObject jsonEllipseObject = new JSONObject();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        myEllipse.mySetCenterX(50.0);
        myEllipse.mySetCenterY(50.0);
        myEllipse.mySetRadiusX(100.0);
        myEllipse.mySetRadiusY(50.0);
        myEllipse.mySetStroke(null);
        myEllipse.mySetFill(null);
        jsonEllipseObject.put("type", "ellipse");
        jsonEllipseObject.put("fill", null);
        jsonEllipseObject.put("stroke", null);
        jsonEllipseObject.put("centerX", myEllipse.myGetCenterX());
        jsonEllipseObject.put("centerY", myEllipse.myGetCenterY());
        jsonEllipseObject.put("radiusX", myEllipse.myGetRadiusX());
        jsonEllipseObject.put("radiusY", myEllipse.myGetRadiusY());
        Drawing draw = new Drawing();
        MyEllipse myTestEllipse = new MyEnhancedEllipse();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonEllipseObject, draw);
        visitor.visitEllipse(myTestEllipse);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit an ellipse",myEllipse.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitNegativeEllipse() {
        JSONObject jsonEllipseObject = new JSONObject();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        myEllipse.mySetCenterX(-50.0);
        myEllipse.mySetCenterY(-50.0);
        myEllipse.mySetRadiusX(-100.0);
        myEllipse.mySetRadiusY(-50.0);
        myEllipse.mySetStroke(Color.BLACK);
        myEllipse.mySetFill(Color.WHITE);
        jsonEllipseObject.put("type", "ellipse");
        jsonEllipseObject.put("fill", myEllipse.myGetFill().toString());
        jsonEllipseObject.put("stroke", myEllipse.myGetStroke().toString());
        jsonEllipseObject.put("centerX", myEllipse.myGetCenterX());
        jsonEllipseObject.put("centerY", myEllipse.myGetCenterY());
        jsonEllipseObject.put("radiusX", myEllipse.myGetRadiusX());
        jsonEllipseObject.put("radiusY", myEllipse.myGetRadiusY());
        Drawing draw = new Drawing();
        MyEllipse myTestEllipse = new MyEnhancedEllipse();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonEllipseObject, draw);
        visitor.visitEllipse(myTestEllipse);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit an ellipse with negative coordinates",myEllipse.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitNegativeEllipse2() {
        JSONObject jsonEllipseObject = new JSONObject();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        myEllipse.mySetCenterX(-50.0);
        myEllipse.mySetCenterY(-50.0);
        myEllipse.mySetRadiusX(-100.0);
        myEllipse.mySetRadiusY(-50.0);
        myEllipse.mySetStroke(null);
        myEllipse.mySetFill(null);
        jsonEllipseObject.put("type", "ellipse");
        jsonEllipseObject.put("fill", null);
        jsonEllipseObject.put("stroke", null);
        jsonEllipseObject.put("centerX", myEllipse.myGetCenterX());
        jsonEllipseObject.put("centerY", myEllipse.myGetCenterY());
        jsonEllipseObject.put("radiusX", myEllipse.myGetRadiusX());
        jsonEllipseObject.put("radiusY", myEllipse.myGetRadiusY());
        Drawing draw = new Drawing();
        MyEllipse myTestEllipse = new MyEnhancedEllipse();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonEllipseObject, draw);
        visitor.visitEllipse(myTestEllipse);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit an ellipse with negative coordinates",myEllipse.toString(), itr.next().toString());
    }
    
    @Test (expected=ImportException.class)  //Visit a JSON object that doesn't contains any key "type" -> It's not a shape
    public void testLineVisitEmptyJSONObject() {
        JSONObject jsonObject = new JSONObject();
        MyLine myLine = new MyEnhancedLine();
        Drawing draw = new Drawing();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonObject, draw);
        visitor.visitLine(myLine);
    }
    
    @Test (expected=ImportException.class)  //Visit a JSON object that contains a wrong "type" key
    public void testLineVisitWrongJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "rectangle");
        MyLine myLine = new MyEnhancedLine();
        Drawing draw = new Drawing();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonObject, draw);
        visitor.visitLine(myLine);
    }
    
    @Test
    public void testVisitStandardLine() {
        JSONObject jsonLineObject = new JSONObject();
        MyLine myLine = new MyEnhancedLine();
        jsonLineObject.put("type", "line");
        jsonLineObject.put("fill", null);
        jsonLineObject.put("stroke", myLine.myGetStroke().toString());
        jsonLineObject.put("endX", myLine.myGetEndX());
        jsonLineObject.put("endY", myLine.myGetEndY());
        jsonLineObject.put("startX", myLine.myGetStartX());
        jsonLineObject.put("startY", myLine.myGetStartY());  
        Drawing draw = new Drawing();
        MyLine myTestLine = new MyEnhancedLine();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonLineObject, draw);
        visitor.visitLine(myTestLine);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a standard line",myLine.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitStandardLine2() {
        JSONObject jsonLineObject = new JSONObject();
        MyLine myLine = new MyEnhancedLine();
        myLine.mySetStroke(null);
        jsonLineObject.put("type", "line");
        jsonLineObject.put("fill", null);
        jsonLineObject.put("stroke", null);
        jsonLineObject.put("endX", myLine.myGetEndX());
        jsonLineObject.put("endY", myLine.myGetEndY());
        jsonLineObject.put("startX", myLine.myGetStartX());
        jsonLineObject.put("startY", myLine.myGetStartY());  
        Drawing draw = new Drawing();
        MyLine myTestLine = new MyEnhancedLine();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonLineObject, draw);
        visitor.visitLine(myTestLine);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a standard line",myLine.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitLine() {
        JSONObject jsonLineObject = new JSONObject();
        MyLine myLine = new MyEnhancedLine();
        myLine.mySetEndX(50.0);
        myLine.mySetEndY(50.0);
        myLine.mySetStartX(25.0);
        myLine.mySetStartY(25.0);
        myLine.mySetFill(Color.WHITE);
        myLine.mySetStroke(Color.BLACK);
        jsonLineObject.put("type", "line");
        jsonLineObject.put("fill", myLine.myGetFill().toString());
        jsonLineObject.put("stroke", myLine.myGetStroke().toString());
        jsonLineObject.put("endX", myLine.myGetEndX());
        jsonLineObject.put("endY", myLine.myGetEndY());
        jsonLineObject.put("startX", myLine.myGetStartX());
        jsonLineObject.put("startY", myLine.myGetStartY());  
        Drawing draw = new Drawing();
        MyLine myTestLine = new MyEnhancedLine();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonLineObject, draw);
        visitor.visitLine(myTestLine);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a line",myLine.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitLine2() {
        JSONObject jsonLineObject = new JSONObject();
        MyLine myLine = new MyEnhancedLine();
        myLine.mySetEndX(50.0);
        myLine.mySetEndY(50.0);
        myLine.mySetStartX(25.0);
        myLine.mySetStartY(25.0);
        myLine.mySetFill(null);
        myLine.mySetStroke(null);
        jsonLineObject.put("type", "line");
        jsonLineObject.put("fill", null);
        jsonLineObject.put("stroke", null);
        jsonLineObject.put("endX", myLine.myGetEndX());
        jsonLineObject.put("endY", myLine.myGetEndY());
        jsonLineObject.put("startX", myLine.myGetStartX());
        jsonLineObject.put("startY", myLine.myGetStartY());  
        Drawing draw = new Drawing();
        MyLine myTestLine = new MyEnhancedLine();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonLineObject, draw);
        visitor.visitLine(myTestLine);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a line",myLine.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitNegativeLine() {
        JSONObject jsonLineObject = new JSONObject();
        MyLine myLine = new MyEnhancedLine();
        myLine.mySetEndX(-50.0);
        myLine.mySetEndY(-50.0);
        myLine.mySetStartX(-25.0);
        myLine.mySetStartY(-25.0);
        myLine.mySetFill(Color.WHITE);
        myLine.mySetStroke(Color.BLACK);
        jsonLineObject.put("type", "line");
        jsonLineObject.put("fill", myLine.myGetFill().toString());
        jsonLineObject.put("stroke", myLine.myGetStroke().toString());
        jsonLineObject.put("endX", myLine.myGetEndX());
        jsonLineObject.put("endY", myLine.myGetEndY());
        jsonLineObject.put("startX", myLine.myGetStartX());
        jsonLineObject.put("startY", myLine.myGetStartY());  
        Drawing draw = new Drawing();
        MyLine myTestLine = new MyEnhancedLine();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonLineObject, draw);
        visitor.visitLine(myTestLine);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a line with negative coordinates",myLine.toString(), itr.next().toString());
    }
    
    @Test
    public void testVisitNegativeLine2() {
        JSONObject jsonLineObject = new JSONObject();
        MyLine myLine = new MyEnhancedLine();
        myLine.mySetEndX(-50.0);
        myLine.mySetEndY(-50.0);
        myLine.mySetStartX(-25.0);
        myLine.mySetStartY(-25.0);
        myLine.mySetFill(null);
        myLine.mySetStroke(null);
        jsonLineObject.put("type", "line");
        jsonLineObject.put("fill", null);
        jsonLineObject.put("stroke", null);
        jsonLineObject.put("endX", myLine.myGetEndX());
        jsonLineObject.put("endY", myLine.myGetEndY());
        jsonLineObject.put("startX", myLine.myGetStartX());
        jsonLineObject.put("startY", myLine.myGetStartY());  
        Drawing draw = new Drawing();
        MyLine myTestLine = new MyEnhancedLine();
        JSONImportVisitor visitor = new JSONImportVisitor(jsonLineObject, draw);
        visitor.visitLine(myTestLine);
        Iterator<MyShape> itr = draw.iterator();
        assertEquals("Test failed when you want to visit a line with negative coordinates",myLine.toString(), itr.next().toString());
    }
}
