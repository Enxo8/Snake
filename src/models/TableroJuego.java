package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import views.MySnakeFrame;

public class TableroJuego extends JPanel {
	private MySnakeFrame snakeFrame;

    //comportamiento para "enganchar" el tablero con el frame controlador.
    public void setSnakeFrame(MySnakeFrame sf) {
    	snakeFrame = sf;
    }
    
    
	public void paint(Graphics g) {
		super.paint(g);
		if (snakeFrame != null) { //pintamos si tenemos serpiente
		    Graphics2D g2d = (Graphics2D) g;
		    
		    //configuramos los gráficos para que pinte figuras suaves...
		    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		    
		    //le decimos al controlador que nos de la serpiente para pintarla...
		    snakeFrame.getSerpiente().pintarse(g2d);
		}
	}
}
