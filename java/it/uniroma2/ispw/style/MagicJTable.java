package it.uniroma2.ispw.style;

import java.awt.Color;

import javax.swing.JTable;

public class MagicJTable extends JTable {
	
	Color backColor = Color.decode("#96DED1");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MagicJTable(){
		super();
		this.setBackground(backColor);
		
		
	}


}
