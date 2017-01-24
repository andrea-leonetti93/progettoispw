package it.uniroma2.ispw.laptop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VisualCostoSpedFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static String titolo = "Pannello amministratore finanziario";
	//VisualUtentiFrame visualUtentiFrame = null;
	//VisualOrdiniFrame visualOrdiniFrame = null;
	//VisualProdottiFrame visualProdottiFrame = null;
	//RegisterAdminFrame registerAdminFrame = null;
	VisualUtentiFrame visualUtentiFrame = null;
	private JPanel panel = new JPanel();
	private static JLabel textSpedNormale;
	private static JTextField textSpedRapida;
	
	public VisualCostoSpedFrame(){
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
		
		textSpedNormale = new JLabel("Spedizione Normale");
		textSpedNormale.setBounds(10, 10, 80, 25);
		panel.add(textSpedNormale);

		
		
		System.out.println("ciao");
		System.out.println("ciao");
	}
	
	private void addActionListener(){
		
		
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
