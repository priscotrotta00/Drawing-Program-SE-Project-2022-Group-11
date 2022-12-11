package it.unisa.diem.se2022.drawingapp.group11IZ.export;

import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.export.exceptions.ExportException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * A class that represents a concrete visitor for the shapes. 
 * On each visit, the properties of the shape passed as a parameter are added to
 * a json object. The json object is added to the json array passed as 
 * parameter to the constructor too.
 * @author prisc
 */
public class JSONExportVisitor implements Visitor{

    private JSONArray jsonArray;

    /**
     * Create a new JSONExportVisitor object
     * @param jsonArray It represents the json array in which the json objects 
     * representing the figures contained in the drawing are saved
     */
    public JSONExportVisitor(JSONArray jsonArray) {
        if(jsonArray == null) throw new NullPointerException();
        this.jsonArray = jsonArray;
    }
    
    /**
     * Visit the MyRectangle object passed as parameter and populate the fields of a 
     * json object with its properties.
     * Then json object is added to the json array passed in the constructor.
     * @param myRectangle MyRectangle object you want to visit
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
        jsonRectangleObject.put("stroke-width", myRectangle.myGetStrokeWidth());
        jsonArray.add(jsonRectangleObject);
    }
    
    /**
     * Visit the MyEllipse object passed as parameter and populate the fields of a 
     * json object with its properties.
     * Then json object is added to the json array passed in the constructor.
     * @param myEllipse MyEllipse object you want to visit
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
        jsonEllipseObject.put("stroke-width", myEllipse.myGetStrokeWidth());
        jsonArray.add(jsonEllipseObject);
    }

    /**
     * Visit the MyLine object passed as parameter and populate the fields of a 
     * json object with its properties.
     * Then json object is added to the json array passed in the constructor.
     * @param myLine MyLine object you want to visit
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
        jsonLineObject.put("stroke-width", myLine.myGetStrokeWidth());
        jsonArray.add(jsonLineObject);
    }
    
}
