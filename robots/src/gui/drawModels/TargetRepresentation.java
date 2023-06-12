package gui.drawModels;


import models.TargetModel;
import models.states.TargetStateReader;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static utils.MathUtils.*;

public class TargetRepresentation {


    private RepresentationTermOval m_body;

    public TargetRepresentation() {
        m_body = new RepresentationTermOval("body", 5, 5, Color.GREEN, 0, 0);
    }

    public TargetRepresentation(Color m_bodyColor) {
        m_body = new RepresentationTermOval("body", 5, 5, m_bodyColor, 0, 0);
    }


    public void draw(Graphics2D g, TargetModel model) {
        TargetStateReader targetCoord = model.getState();
        AffineTransform t = AffineTransform.getRotateInstance(0, 0, 0);
        g.setTransform(t);
        m_body.draw(g, round(targetCoord.getX()), round(targetCoord.getY()));
    }

}
