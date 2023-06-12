package gui;

import gui.drawModels.RobotRepresentation;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

public class RobotWardrobeWindow extends JInternalFrame {

    private RobotRepresentation m_modelView;
    private RobotRepresentationShow m_visualizer;


    private JTabbedPane m_ColorChoosersTab;

    public RobotWardrobeWindow(RobotRepresentation RobotView) {
        super("Кастомизация робота", true, true, true, true);

        m_modelView = RobotView;
        m_ColorChoosersTab = new JTabbedPane();
        m_visualizer = new RobotRepresentationShow(m_modelView);


        var terms = m_modelView.getTerms();
        int counter = 0;
        for (var term : terms) {
           m_ColorChoosersTab.add(new TermSetupGui(term));
           m_ColorChoosersTab.setTitleAt(counter,term.getName());
           counter++;
        }


        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        panel.add(m_ColorChoosersTab, BorderLayout.PAGE_END);
        getContentPane().add(panel);
        pack();
    }


}
