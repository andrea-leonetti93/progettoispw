package it.uniroma2.ispw.factory;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import it.uniroma2.ispw.style.MagicJButton;
import it.uniroma2.ispw.style.MagicJPanel;
import it.uniroma2.ispw.style.MagicJTable;

public class MagicWidgetFactory extends WidgetFactory {

	@Override
	public JButton createJButton() {
		return new MagicJButton();
	}

	@Override
	public JPanel createJPanel() {
		return new MagicJPanel();
	}

	@Override
	public JTable createJTable() {
		return new MagicJTable();
	}

}
