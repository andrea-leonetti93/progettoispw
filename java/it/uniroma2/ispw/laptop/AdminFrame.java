package it.uniroma2.ispw.laptop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.uniroma2.ispw.factory.BeautifulWidgetFactory;
import it.uniroma2.ispw.factory.WidgetFactory;

public class AdminFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String titolo = "Pannello amministratore di sistema";
	private VisualUtentiFrame visualUtentiFrame = null;
	private VisualOrdiniFrame visualOrdiniFrame = null;
	private VisualProdottiFrame visualProdottiFrame = null;
	private RegisterAdminFrame registerAdminFrame = null;
	//private LogFrame logFrame = null;
	
	private WidgetFactory widgetFactory = new BeautifulWidgetFactory();
	
	private JPanel panel = widgetFactory.createJPanel();
	private JButton btnVisualUtenti;
	private JButton btnVisualOrdini;
	private JButton btnVisualProdotti;
	private JButton btnRegistraAdmin;
	private JButton btnLog;
	
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
		
		btnVisualUtenti = widgetFactory.createJButton();
		btnVisualUtenti.setText("Visualizza utenti");
		btnVisualUtenti.setBounds(86, 12, 645, 25);
		panel.add(btnVisualUtenti);
		
		btnVisualOrdini = widgetFactory.createJButton();
		btnVisualOrdini.setText("Visualizza ordini");
		btnVisualOrdini.setBounds(86, 49, 645, 25);
		panel.add(btnVisualOrdini);
		
		btnVisualProdotti = widgetFactory.createJButton();
		btnVisualProdotti.setText("Visualizza prodotti");
		btnVisualProdotti.setBounds(86, 86, 645, 25);
		panel.add(btnVisualProdotti);
		
		btnRegistraAdmin = widgetFactory.createJButton();
		btnRegistraAdmin.setText("Registra nuovo amministratore");
		btnRegistraAdmin.setBounds(86, 123, 645, 25);
		panel.add(btnRegistraAdmin);
		
		btnLog = widgetFactory.createJButton();
		btnLog.setText("Visualizza log di sistema");
		btnLog.setBounds(86, 158, 645, 25);
		panel.add(btnLog);
		
	}
	
	
	private void addActionListener(){
		btnVisualUtenti.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				visualUtentiFrame = new VisualUtentiFrame();
				visualUtentiFrame.setVisible(true);
			    visualUtentiFrame.toFront();
			    visualUtentiFrame.repaint();
			}
		});
		
		btnVisualOrdini.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				visualOrdiniFrame = new VisualOrdiniFrame();
				visualOrdiniFrame.setVisible(true);
			    visualOrdiniFrame.toFront();
			    visualOrdiniFrame.repaint();
			}
		});
		
		btnVisualProdotti.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				visualProdottiFrame = new VisualProdottiFrame();
				visualProdottiFrame.setVisible(true);
			    visualProdottiFrame.toFront();
			    visualProdottiFrame.repaint();
			}
		});
		
		btnRegistraAdmin.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				registerAdminFrame = new RegisterAdminFrame();
				registerAdminFrame.setVisible(true);
			    registerAdminFrame.toFront();
			    registerAdminFrame.repaint();
			}
		});

		btnLog.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				//logFrame = new LogFrame();
				//logFrame.setVisible(true);
			    //logFrame.toFront();
			    //logFrame.repaint();
			}
		});
		
	}
	
	/*private void closeAdminFrame(){
		
		this.setVisible(false);
	}*/
	
	
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
