package it.uniroma2.ispw.laptop;

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
	
	private JPanel panel = new JPanel();
	private JButton btnBoh1;
	private JButton btnBoh2;
	
	public AdminFinanceFrame(){
		super(titolo);
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(panel);
		placeComponents(panel);
		close();
		//addActionListener();
		this.setVisible(true);
	}
	
	private void placeComponents(JPanel panel){
		panel.setLayout(null);
		
		btnBoh1 = new JButton("Boh1");
		btnBoh1.setBounds(86, 12, 645, 25);
		panel.add(btnBoh1);
		
		btnBoh2 = new JButton("Boh2");
		btnBoh2.setBounds(86, 12, 645, 25);
		panel.add(btnBoh2);
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
