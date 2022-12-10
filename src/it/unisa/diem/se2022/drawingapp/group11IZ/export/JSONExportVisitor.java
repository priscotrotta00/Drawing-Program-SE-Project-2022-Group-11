/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.export;

import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.export.exceptions.ExportException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author prisc
 */
public class JSONExportVisitor implements Visitor{

    private JSONArray jsonArray;

    public JSONExportVisitor(JSONArray jsonArray) {
        if(jsonArray == null) throw new NullPointerException();
        this.jsonArray = jsonArray;
    }
    
    /**
     * Visit a rectangle and put his properties in a JSON Array
     * @param myRectangle is the myRectangle object you want to visit
     */
    
    @Override
    public void visitRectangle(MyRectangle myRectangle) {
        if(myRectangle == null) throw new ExportException();
        JSONObject jsonRectangleObject = new JSONObject();
        jsonRectangleObject.put("type", "rectangle");
        jsonRectangleObject.put("fill", myRectangle.myGetFill() == null ? null : myRectangle.myGetFill().toString());
        jsonRectangleObject.put("stroke", myRectangle.myGetStroke() == null ? null : myRectangle.myGetStroke().toString());
        jsonRectangleObject.put("height", myRectangle.myGetHeight());
        jsonRectangleObject.put("width", myRectangle.myGetWidth());
        jsonRectangleObject.put("x", myRectangle.myGetX());
        jsonRectangleObject.put("y", myRectangle.myGetY());
        jsonArray.add(jsonRectangleObject);
    }

    /**
     * Visit an ellipse and put her properties in a JSON Array
     * @param myEllipse is the myEllipse object you want to visit
     */
    
    @Override
    public void visitEllipse(MyEllipse myEllipse) {
        if(myEllipse == null) throw new ExportException();
        JSONObject jsonEllipseObject = new JSONObject();
        jsonEllipseObject.put("type", "ellipse");
        jsonEllipseObject.put("fill", myEllipse.myGetFill() == null ? null : myEllipse.myGetFill().toString());
        jsonEllipseObject.put("stroke", myEllipse.myGetStroke() == null ? null : myEllipse.myGetStroke().toString());
        jsonEllipseObject.put("centerX", myEllipse.myGetCenterX());
        jsonEllipseObject.put("centerY", myEllipse.myGetCenterY());
        jsonEllipseObject.put("radiusX", myEllipse.myGetRadiusX());
        jsonEllipseObject.put("radiusY", myEllipse.myGetRadiusY());
        jsonArray.add(jsonEllipseObject);
    }

    /**
     * Visit a line and put her properties in a JSON Array
     * @param myLine is the myLine object you want to visit
     */
    
    @Override
    public void visitLine(MyLine myLine) {
        if(myLine == null) throw new ExportException();
        JSONObject jsonLineObject = new JSONObject();
        jsonLineObject.put("type", "line");
        jsonLineObject.put("fill", myLine.myGetFill() == null ? null: myLine.myGetFill().toString());
        jsonLineObject.put("stroke", myLine.myGetStroke() == null ? null : myLine.myGetStroke().toString());
        jsonLineObject.put("endX", myLine.myGetEndX());
        jsonLineObject.put("endY", myLine.myGetEndY());
        jsonLineObject.put("startX", myLine.myGetStartX());
        jsonLineObject.put("startY", myLine.myGetStartY());        
        jsonArray.add(jsonLineObject);
    }
    
}
