package it.uniroma2.ispw.laptop;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.uniroma2.ispw.controller.GestioneSistema;

public class LoginFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private LoginController controller = new LoginController(); 
	private GestioneSistema gs = GestioneSistema.getInstance();
	
	private final static String titolo = "Login";
	

	private final JPanel panel = new JPanel();
	
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private String userIDString;
	private String passwordString;
	

	public LoginFrame(){
		super(titolo);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		placeComponents(panel);
		centerFrame();
		addActionListener();
		
		this.setVisible(true);
	}
	
	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		
	}

	private void centerFrame(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
	private void addActionListener(){
		loginButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				updateFields();
				if(gs.effettuaLoginAdmin(userIDString, passwordString)){
					close();
				}else{
					String title = "Login fallito";
					String message = "Credenziali di accesso non valide!";
					JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	@SuppressWarnings("deprecation")
	private void updateFields(){
		userIDString = userText.getText();
		passwordString = passwordText.getText();
	}

	private void close(){
		
		this.setVisible(false);
	}
	
}
