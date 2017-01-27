package it.uniroma2.ispw.style;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class BeautifulJButton extends JButton{
	
	//Font defaultFont = new Font("Gill Sans MT",Font.BOLD,14);
    Color textColor = Color.decode("#B20000");
    Color backgroundColor = Color.decode("#DA70D6");
    //Color hoverColor = Color.decode("#00aced");
    
    public BeautifulJButton(){
    	//.setText(...);
    	super();
    	this.setForeground(textColor);
        this.setBackground(backgroundColor);
        //this.setFont(defaultFont);
    	
    	 
 
    }

}
