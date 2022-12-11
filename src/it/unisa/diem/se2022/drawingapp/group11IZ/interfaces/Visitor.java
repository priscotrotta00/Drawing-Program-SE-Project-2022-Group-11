package it.unisa.diem.se2022.drawingapp.group11IZ.interfaces;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;

/**
 *
 * @author prisc
 */
public interface Visitor {
    public void visitRectangle(MyRectangle myRectangle);
    public void visitEllipse(MyEllipse myEllipse);
    public void visitLine(MyLine myLine);
}
