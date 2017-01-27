package it.uniroma2.ispw.style;

import java.awt.Color;

import javax.swing.JTable;

public class BeautifulJTable extends JTable {
	
	Color backColor = Color.decode("#FF9966");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeautifulJTable(){
		super();
		this.setBackground(backColor);
		
	}

}
