package gui;

import gui.drawModels.RepresentationTermOval;

import javax.swing.*;

public class TermSetupGui extends JPanel {
    private RepresentationTermOval m_term;

    public TermSetupGui(RepresentationTermOval m_term){
        this.m_term=m_term;
        var offsetXSelector=new JSlider(SwingConstants.HORIZONTAL,-10,10, 0);
        var offsetYSelector=new JSlider(SwingConstants.HORIZONTAL,-10,10, 0);
        var colorChooser = new JColorChooser(m_term.getColor());
        colorChooser.setPreviewPanel(new JPanel());
        colorChooser.getSelectionModel().addChangeListener(e -> m_term.setColor(colorChooser.getColor()));
        offsetXSelector.addChangeListener(e->m_term.setOffsetX(offsetXSelector.getValue()));
        offsetYSelector.addChangeListener(e->m_term.setOffsetY(offsetYSelector.getValue()));
        add(offsetXSelector);
        add(offsetYSelector);
        add(colorChooser);



    }
}
