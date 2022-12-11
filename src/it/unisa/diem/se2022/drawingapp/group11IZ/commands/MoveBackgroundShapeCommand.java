package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;

/**
 *
 * @author saram
 */
public class MoveBackgroundShapeCommand implements Command {

    private final Canvas canvas;
    private final MyShape shape;
    private final int layerShape;
    
    /**
     * constructor of MoveBackgroundShape
     * @param canvas
     * @param shape 
     */
    public MoveBackgroundShapeCommand(Canvas canvas, MyShape shape) {
        this.canvas=canvas;
        this.shape=shape;
        this.layerShape=this.canvas.getDraw().getShapeLayer(shape);
        
    }
    /**
     * Execute the MoveBackground
     */
    @Override
    public void execute() {
        this.canvas.moveShapeToBackground(shape);
    }

    /**
     * Undo of operation MoveBackground
     */
    @Override
    public void undo() {
        this.canvas.moveToLayer(shape,this.layerShape);
          }
    
}
