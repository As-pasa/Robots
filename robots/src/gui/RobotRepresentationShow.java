package gui;

import gui.drawModels.RobotRepresentation;
import models.DummyRobotStateProvider;
import models.RobotModel;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class RobotRepresentationShow extends JPanel {

    private final java.util.Timer m_timer = initTimer();

    private static java.util.Timer initTimer() {
        java.util.Timer timer = new Timer("events generator", true);
        return timer;
    }


    private RobotRepresentation m_model;
    private DummyRobotStateProvider m_positionModel;


    public RobotRepresentationShow(RobotRepresentation model){
        m_model=model;
        m_positionModel=new DummyRobotStateProvider();
        m_timer.schedule(new TimerTask() {
            @Override
            public void run() {
                redraw();
            }
        }, 0, 10);
    }

    protected void onRedrawEvent(){
        EventQueue.invokeLater(this::repaint);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        m_model.draw(g2d,m_positionModel);

    }
    public void redraw(){
        onRedrawEvent();
    }
}
