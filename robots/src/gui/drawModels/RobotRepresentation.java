package gui.drawModels;
import models.RobotModel;
import models.states.RobotStateReader;

import static utils.DrawUtils.*;
import static utils.MathUtils.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class RobotRepresentation{

    public void setPrimaryColor(Color m_bodyColor) {
        this.m_primaryColor = m_bodyColor;
    }

    public void setEdgeColor(Color m_edgeColor) {
        this.m_edgeColor = m_edgeColor;
    }

    public void setSecondaryColor(Color m_eyeColor) {
        this.m_secondaryColor = m_eyeColor;
    }

    private Color m_primaryColor;
    private Color m_edgeColor;
    private Color m_secondaryColor;

    public RobotRepresentation() {
        m_primaryColor=Color.MAGENTA;
        m_edgeColor=Color.BLACK;
        m_secondaryColor=Color.WHITE;
    }

    public RobotRepresentation(Color m_bodyColor, Color m_edgeColor, Color m_eyeColor) {
        this.m_primaryColor = m_bodyColor;
        this.m_edgeColor = m_edgeColor;
        this.m_secondaryColor = m_eyeColor;
    }


    public void draw(Graphics2D g, RobotModel model) {
        RobotStateReader state=model.getState();
        int robotCenterX = round(state.getX());
        int robotCenterY = round(state.getY());
        AffineTransform t = AffineTransform.getRotateInstance(state.getDir(), robotCenterX, robotCenterY);
        g.setTransform(t);
        g.setColor(m_primaryColor);
        fillOval(g, robotCenterX, robotCenterY, 30, 10);
        g.setColor(m_edgeColor);
        drawOval(g, robotCenterX, robotCenterY, 30, 10);
        g.setColor(m_secondaryColor);
        fillOval(g, robotCenterX  + 10, robotCenterY, 5, 5);
        g.setColor(m_edgeColor);
        drawOval(g, robotCenterX  + 10, robotCenterY, 5, 5);
    }



}
