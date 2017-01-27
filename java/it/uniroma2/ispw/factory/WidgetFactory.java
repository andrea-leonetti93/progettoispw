package it.uniroma2.ispw.factory;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public abstract class WidgetFactory {
	
	public abstract JButton createJButton();
	public abstract JPanel createJPanel();
	public abstract JTable createJTable();
	
	

}
