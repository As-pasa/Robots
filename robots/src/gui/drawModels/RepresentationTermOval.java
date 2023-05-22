package gui.drawModels;

import java.awt.*;

import static utils.DrawUtils.drawOval;
import static utils.DrawUtils.fillOval;

public class RepresentationTermOval {

    private String m_name;
    private Color m_color;
    private int m_diam1=30;
    private int m_diam2=10;
    private Color m_edgeColor=Color.BLACK;

    public RepresentationTermOval(String m_name, int m_diam1, int m_diam2, Color color) {
        this.m_name = m_name;
        this.m_diam1 = m_diam1;
        this.m_diam2 = m_diam2;
        this.m_color=color;
    }

    public String getName(){
        return m_name;
    };

    public Color getColor(){
        return m_color;
    }

    public void draw(Graphics2D g,int x,int y){
        g.setColor(m_color);
        fillOval(g, x, y, m_diam1, m_diam2);
        g.setColor(m_edgeColor);
        drawOval(g, x, y, m_diam1, m_diam2);

    };
    public void setColor(Color color){
        m_color=color;
    }
}
