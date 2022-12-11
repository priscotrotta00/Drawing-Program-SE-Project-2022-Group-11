package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 *
 * @author saram
 */
public class DeleteShapeCommand implements Command {
    private final Canvas canvas;
    private final MyShape shape;
    private final int layerShape;
    
    /**
     * constructor of Delete Command
     * @param canvas
     * @param shape 
     */
    public DeleteShapeCommand(Canvas canvas, MyShape shape) {
        this.canvas = canvas;
        this.shape=shape;
        this.layerShape=this.canvas.getDraw().getShapeLayer(shape);
        
    }
    /**
     * Execute the command and remove the previously passed shape in the drawing
     */
    @Override
    public void execute() {
        this.canvas.removeShape(shape);
        
    }

    /**
     * Undo the Remove shape action, so the previously passed shape will be added
     * in the drawing
     */
    @Override
    public void undo() {
        this.canvas.moveToLayer(shape, layerShape,false);
    }
    
}
