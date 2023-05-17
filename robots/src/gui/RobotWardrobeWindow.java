package gui;

import controllers.TargetPositionController;
import gui.drawModels.RobotRepresentation;
import models.RobotModel;
import models.TargetModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class RobotWardrobeWindow extends JInternalFrame  {
    private ChangeListener mainColorController;
    private ChangeListener secondaryColorController;



    private RobotRepresentation m_modelView;
    private RobotRepresentationShow m_visualizer;

    private JColorChooser m_mainColorSelector;
    private JColorChooser m_secondaryColorSelector;
    private JTabbedPane color_choosers;

    public RobotWardrobeWindow(RobotRepresentation RobotView)
    {
        super("Игровое поле", true, true, true, true);
        mainColorController=new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                m_modelView.setPrimaryColor(m_mainColorSelector.getColor());
            }
        };
        secondaryColorController=new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                m_modelView.setSecondaryColor(m_secondaryColorSelector.getColor());
            }
        };


        m_modelView=RobotView;
        m_visualizer = new RobotRepresentationShow(m_modelView);
        m_mainColorSelector=new JColorChooser(m_modelView.getM_primaryColor());
        m_mainColorSelector.setPreviewPanel(new JPanel());
        m_mainColorSelector.getSelectionModel().addChangeListener(mainColorController);
        m_secondaryColorSelector=new JColorChooser(m_modelView.getM_secondaryColor());
        m_secondaryColorSelector.setPreviewPanel(new JPanel());
        m_secondaryColorSelector.getSelectionModel().addChangeListener(secondaryColorController);

        color_choosers=new JTabbedPane();

        color_choosers.add(m_mainColorSelector);

        color_choosers.add(m_secondaryColorSelector);
        color_choosers.setTitleAt(0,"Main color");
        color_choosers.setTitleAt(1,"Secondary color");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        panel.add(color_choosers,BorderLayout.PAGE_END);
        getContentPane().add(panel);
        pack();
    }


}
