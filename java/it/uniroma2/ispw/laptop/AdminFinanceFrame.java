package it.uniroma2.ispw.laptop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminFinanceFrame extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String titolo = "Pannello amministratore finanziario";
	//VisualUtentiFrame visualUtentiFrame = null;
	//VisualOrdiniFrame visualOrdiniFrame = null;
	//VisualProdottiFrame visualProdottiFrame = null;
	//RegisterAdminFrame registerAdminFrame = null;
	VisualUtentiFrame visualUtentiFrame = null;
	private JPanel panel = new JPanel();
	private JButton btnBoh1;
	private JButton btnBoh2;
	private JButton btnBoh3;
	private JButton btnBoh4;
	
	public AdminFinanceFrame(){
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
		
		btnBoh1 = new JButton("Gestisci costo spedizione");
		btnBoh1.setBounds(86, 12, 645, 25);
		panel.add(btnBoh1);
		
		btnBoh2 = new JButton("Gestisci tipi prodotto");
		btnBoh2.setBounds(86, 49, 645, 25);
		panel.add(btnBoh2);
		
		btnBoh3 = new JButton("Gestisci sconto Ente");
		btnBoh3.setBounds(86, 86, 645, 25);
		panel.add(btnBoh3);
		
		btnBoh4 = new JButton("Gestisci trattenute sito");
		btnBoh4.setBounds(86, 123, 645, 25);
		panel.add(btnBoh4);
		
		System.out.println("ciao");
		System.out.println("ciao");
	}
	
	
	
	
	private void addActionListener(){
		btnBoh1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){;
				System.out.println("ciao");
			}
		});
		
	}
	
	private void closeAdminFrame(){
		
		this.setVisible(false);
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
