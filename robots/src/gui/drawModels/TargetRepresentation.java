package gui.drawModels;


import models.TargetModel;
import models.states.TargetStateReader;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static utils.DrawUtils.*;
import static utils.MathUtils.*;

public class TargetRepresentation  {


    private Color m_bodyColor;
    private Color m_edgeColor;


    public TargetRepresentation() {
        m_bodyColor=Color.GREEN;
        m_edgeColor=Color.BLACK;
    }

    public TargetRepresentation(Color m_bodyColor, Color m_edgeColor) {
        this.m_bodyColor = m_bodyColor;
        this.m_edgeColor = m_edgeColor;
    }


    public void draw(Graphics2D g,TargetModel model) {
        TargetStateReader targetCoord=model.getState();
        AffineTransform t = AffineTransform.getRotateInstance(0, 0, 0);
        g.setTransform(t);
        g.setColor(m_bodyColor);
        fillOval(g, round(targetCoord.getX()) ,round(targetCoord.getY()) , 5, 5);
        g.setColor(m_edgeColor);
        drawOval(g, round(targetCoord.getX()) ,round(targetCoord.getY()),  5, 5);
    }

}
