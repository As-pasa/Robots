package gui.drawModels;
import models.RobotModel;
import models.RobotStateProvider;
import models.states.RobotStateReader;

import static utils.DrawUtils.*;
import static utils.MathUtils.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class RobotRepresentation{





    private RepresentationTermOval m_body;
    private RepresentationTermOval m_eye;

    public RobotRepresentation() {
        m_body=new RepresentationTermOval("Body",30,10,Color.MAGENTA);
        m_eye=new RepresentationTermOval("Eye",5,5,Color.WHITE);

    }
    public void setPrimaryColor(Color m_bodyColor) {

        this.m_body.setColor(m_bodyColor);
    }



    public void setSecondaryColor(Color m_eyeColor) {
        this.m_eye.setColor(m_eyeColor);
    }

    public Color getM_primaryColor() {
        return m_body.getColor();
    }

    public Color getM_secondaryColor() {
        return m_eye.getColor();
    }

    public RobotRepresentation(Color m_bodyColor, Color m_edgeColor, Color m_eyeColor) {
        m_body=new RepresentationTermOval("Body",30,10,m_bodyColor);
        m_eye=new RepresentationTermOval("Eye",5,5,m_eyeColor);
    }


    public void draw(Graphics2D g, RobotStateProvider model) {
        RobotStateReader state=model.getState();
        int robotCenterX = round(state.getX());
        int robotCenterY = round(state.getY());
        AffineTransform t = AffineTransform.getRotateInstance(state.getDir(), robotCenterX, robotCenterY);
        g.setTransform(t);
        m_body.draw(g,robotCenterX,robotCenterY);
        m_eye.draw(g,robotCenterX  + 10, robotCenterY);

    }



}
