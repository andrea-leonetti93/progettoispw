package it.uniroma2.ispw.style;

import java.awt.Color;

import javax.swing.JPanel;

public class MagicJPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MagicJPanel(){
		super();
		Color backgroundColor = Color.decode("#5F9EA0");
		this.setBackground(backgroundColor);
	}

}
