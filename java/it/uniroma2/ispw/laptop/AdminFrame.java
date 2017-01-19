package it.uniroma2.ispw.laptop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String titolo = "Pannello amministratore di sistema";
	//VisualUtentiFrame visualUtentiFrame = null;
	//VisualOrdiniFrame visualOrdiniFrame = null;
	//VisualProdottiFrame visualProdottiFrame = null;
	//RegisterAdminFrame registerAdminFrame = null;
	
	private JPanel panel = new JPanel();
	private JButton btnVisualUtenti;
	private JButton btnVisualOrdini;
	private JButton btnVisualProdotti;
	private JButton btnRegistraAdmin;
	
	public AdminFrame(){
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
		
		btnVisualUtenti = new JButton("Visualizza utenti");
		btnVisualUtenti.setBounds(86, 12, 645, 25);
		panel.add(btnVisualUtenti);
		
		btnVisualOrdini = new JButton("Visualizza ordini");
		btnVisualOrdini.setBounds(86, 12, 645, 25);
		panel.add(btnVisualOrdini);
		
		btnVisualProdotti = new JButton("Visualizza prodotti");
		btnVisualProdotti.setBounds(86, 12, 645, 25);
		panel.add(btnVisualProdotti);
		
		btnRegistraAdmin = new JButton("Registra nuovo amministratore");
		btnRegistraAdmin.setBounds(86, 12, 645, 25);
		panel.add(btnRegistraAdmin);
		
	}
	
	
	private void addActionListener(){
		btnVisualUtenti.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				//visualUtentiFrame = new visualUtentiFrame();
			}
		});
		
		btnVisualOrdini.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				//visualOrdiniFrame = new visualOrdiniFrame();
			}
		});
		
		btnVisualProdotti.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				//isualProdottiFrame = new visualProdottiFrame();
			}
		});
		
		btnRegistraAdmin.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				//registerAdminFrame = new RegisterAdminFrame();
			}
		});
		
	}
	
	
	private void close(){
		
		this.addWindowListener(new java.awt.event.WindowAdapter(){
			
			public void windowClosing(WindowEvent windowEvent){
				Integer risposta = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler chiudere l'applicazione?", "Stai per chiudere l'applicazione", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        if ( risposta == JOptionPane.YES_OPTION) {
		        	 LoginFrame loginFrame = new LoginFrame();
				     loginFrame.setVisible(true);
		        }
			}
		});
	}
}
