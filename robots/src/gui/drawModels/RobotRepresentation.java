package gui.drawModels;

import models.RobotModel;
import models.RobotStateProvider;
import models.states.RobotStateReader;

import static utils.DrawUtils.*;
import static utils.MathUtils.*;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class RobotRepresentation {

    private RepresentationTermOval m_body;
    private RepresentationTermOval m_eye;

    public RobotRepresentation() {
        m_body = new RepresentationTermOval("Body", 30, 10, Color.MAGENTA);
        m_eye = new RepresentationTermOval("Eye", 5, 5, Color.WHITE);

    }


    public ArrayList<RepresentationTermOval> getTerms() {
        var ans = new ArrayList<RepresentationTermOval>();
        ans.add(m_body);
        ans.add(m_eye);
        return ans;
    }


    public RobotRepresentation(Color m_bodyColor, Color m_eyeColor) {
        m_body = new RepresentationTermOval("Body", 30, 10, m_bodyColor);
        m_eye = new RepresentationTermOval("Eye", 5, 5, m_eyeColor);
    }


    public void draw(Graphics2D g, RobotStateProvider model) {
        RobotStateReader state = model.getState();
        int robotCenterX = round(state.getX());
        int robotCenterY = round(state.getY());
        AffineTransform t = AffineTransform.getRotateInstance(state.getDir(), robotCenterX, robotCenterY);
        g.setTransform(t);
        m_body.draw(g, robotCenterX, robotCenterY);
        m_eye.draw(g, robotCenterX + 10, robotCenterY);

    }


}
