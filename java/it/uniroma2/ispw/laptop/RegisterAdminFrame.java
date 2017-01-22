package it.uniroma2.ispw.laptop;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import it.uniroma2.ispw.controller.GestioneSistema;

public class RegisterAdminFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String titolo = "Visualizza gli ordini";

	private GestioneSistema gs = new GestioneSistema();
	
	private JPanel panel = new JPanel();
	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel surnameLabel;
	private JTextField surnameText;
	private JLabel mailLabel;
	private JTextField mailText;
	private JLabel ruleLabel;
	private JButton btnRegister;
	private String userIDString;
	private String passwordString;
	private String nameString;
	private String surnameString;
	private String mailString;
	private Integer roleInt;
	private JComboBox<String> comboBoxRule;
	
	private int row;
	
	public RegisterAdminFrame(){
		super(titolo);
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(panel);
		placeComponents(panel);
		close();
		addActionListener();
		this.setVisible(true);
	}
	
	
	private void placeComponents(JPanel panel){
		panel.setLayout(null);

		// Etichetta Utente
		userLabel = new JLabel("Username");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		// Campo Username
		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		// Etichetta Password
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(278, 10, 80, 25);
		panel.add(passwordLabel);

		// Campo Password
		passwordText = new JPasswordField(20);
		passwordText.setBounds(360, 10, 160, 25);
		panel.add(passwordText);

		// Etichetta Nome
		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(10, 40, 80, 25);
		panel.add(nameLabel);

		// Campo Nome
		nameText = new JTextField(20);
		nameText.setBounds(100, 40, 160, 25);
		panel.add(nameText);
		
		// Etichetta Cognome
		surnameLabel = new JLabel("Cognome");
		surnameLabel.setBounds(278, 40, 80, 25);
		panel.add(surnameLabel);

		// Campo Cognome
		surnameText = new JTextField(20);
		surnameText.setBounds(360, 40, 160, 25);
		panel.add(surnameText);
		
		// Etichetta Mail
		mailLabel = new JLabel("Mail");
		mailLabel.setBounds(10, 72, 80, 25);
		panel.add(mailLabel);

		// Campo Mail
		mailText = new JTextField(50);
		mailText.setBounds(100, 72, 420, 25);
		panel.add(mailText);		
		
		// Etichetta Ruolo
		ruleLabel = new JLabel("Ruolo");
		ruleLabel.setBounds(10, 105, 80, 25);
		panel.add(ruleLabel);
		
		// Combo Box Utente/Amministratore
		comboBoxRule = new JComboBox<String>();
		comboBoxRule.setBounds(100, 105, 160, 24);
		panel.add(comboBoxRule);
		comboBoxRule.addItem("Amministratore");
		comboBoxRule.addItem("Utente");
		
		// Bottone Per Registrarsi
		btnRegister = new JButton("Registra");
		btnRegister.setBounds(360, 105, 160, 25);
		panel.add(btnRegister);
		
	}
	
	private void addActionListener(){}
	
	private void close(){
		
		this.addWindowListener(new java.awt.event.WindowAdapter(){
			
			public void windowClosing(WindowEvent windowEvent){
				Integer risposta = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler tornare al menu amministratore?", "Stai per chiudere ricerca ordini", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        if ( risposta == JOptionPane.YES_OPTION) {
		        	/* AdminFrame adminFrame = new AdminFrame();
				     adminFrame.setVisible(true);*/
		        }
			}
		});
	}
	
}
