package it.uniroma2.ispw.style;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class MagicJButton extends JButton{
	
	//Font defaultFont = new Font("Gill Sans MT",Font.BOLD,14);
    Color textColor = Color.decode("#120A8F");
    Color backgroundColor = Color.decode("#7FFFD4");
   // Color hoverColor = Color.decode("#00aced");
    
    public MagicJButton(){
    	super();
    	this.setForeground(textColor);
    	this.setBackground(backgroundColor);
    	//this.setFont(defaultFont);
  
 
    }

}
