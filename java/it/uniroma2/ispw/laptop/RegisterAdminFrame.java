package it.uniroma2.ispw.laptop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.uniroma2.ispw.controller.GestioneSistema;
import it.uniroma2.ispw.factory.BeautifulWidgetFactory;
import it.uniroma2.ispw.factory.WidgetFactory;
import it.uniroma2.ispw.model.Amministratore;
import it.uniroma2.ispw.model.AmministrazioneDiSistema;
import it.uniroma2.ispw.model.AmministrazioneFinanziaria;
import it.uniroma2.ispw.model.RuoloAmministrazione;

public class RegisterAdminFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String titolo = "Aggiungi nuovo amministratore";

	private GestioneSistema gs = GestioneSistema.getInstance();
	
	
	private WidgetFactory widgetFactory = new BeautifulWidgetFactory();
	
	private JPanel panel = widgetFactory.createJPanel();
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
	private String passwordString;
	private String nameString;
	private String surnameString;
	private String mailString;
	private String role;
	private JComboBox<String> comboBoxRule;
	
	
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
	
		// Etichetta Nome
		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(10, 10, 80, 25);
		panel.add(nameLabel);
		
		// Campo Nome
		nameText = new JTextField(20);
		nameText.setBounds(100, 10, 160, 25);
		panel.add(nameText);

		// Etichetta Cognome
		surnameLabel = new JLabel("Cognome");
		surnameLabel.setBounds(278, 10, 80, 25);
		panel.add(surnameLabel);

		// Campo Cognome
		surnameText = new JTextField(20);
		surnameText.setBounds(360, 10, 160, 25);
		panel.add(surnameText);
		
		// Etichetta Mail
		mailLabel = new JLabel("Mail");
		mailLabel.setBounds(10, 40, 80, 25);
		panel.add(mailLabel);

		// Campo Mail
		mailText = new JTextField(50);
		mailText.setBounds(100, 40, 420, 25);
		panel.add(mailText);	
		
		// Etichetta Password
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 72, 80, 25);
		panel.add(passwordLabel);

		// Campo Password
		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 72, 160, 25);
		panel.add(passwordText);		
		
		// Etichetta Ruolo
		ruleLabel = new JLabel("Ruolo");
		ruleLabel.setBounds(10, 105, 80, 25);
		panel.add(ruleLabel);
		
		// Combo Box Utente/Amministratore
		comboBoxRule = new JComboBox<String>();
		comboBoxRule.setBounds(100, 105, 200, 24);
		panel.add(comboBoxRule);
		comboBoxRule.addItem("Amministratore di sistema");
		comboBoxRule.addItem("Amministratore finanziario");
		
		// Bottone Per Registrarsi
		btnRegister = widgetFactory.createJButton();
		btnRegister.setText("Registra");
		btnRegister.setBounds(360, 105, 160, 25);
		panel.add(btnRegister);
		
	}
	
	private void addActionListener(){
		
		btnRegister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RuoloAmministrazione rolAdmin;
				nameString = nameText.getText();
				surnameString = surnameText.getText();
				mailString = mailText.getText();
				passwordString = passwordText.getText();
				role = (String)comboBoxRule.getSelectedItem();
				Amministratore admin = new Amministratore(nameString, surnameString, mailString, passwordString);
				if(role.equals("Amministratore di sistema")){
					rolAdmin = new AmministrazioneDiSistema();
				}else{
					rolAdmin = new AmministrazioneFinanziaria();
				}
				if(gs.aggiungiAmministratore(admin, rolAdmin)){
					JOptionPane.showMessageDialog(null, "L'amministratore è stato registrato con successo", "Opreazione completata", JOptionPane.INFORMATION_MESSAGE);
				}else{
				JOptionPane.showMessageDialog(null, "L'amministratore non è stato registrato a causa di un errore. Riprovare", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}
	
	private void close(){
		
		this.addWindowListener(new java.awt.event.WindowAdapter(){
			
			public void windowClosing(WindowEvent windowEvent){
				Integer risposta = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler tornare al menu amministratore?", "Stai per chiudere registra amministratore", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        if ( risposta == JOptionPane.YES_OPTION) {
		        	/* AdminFrame adminFrame = new AdminFrame();
				     adminFrame.setVisible(true);*/
		        }
			}
		});
	}
	
}
