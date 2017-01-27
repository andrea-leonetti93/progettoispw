package it.uniroma2.ispw.laptop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.uniroma2.ispw.factory.MagicWidgetFactory;
import it.uniroma2.ispw.factory.WidgetFactory;
import it.uniroma2.ispw.style.BeautifulJButton;

public class AdminFinanceFrame extends JFrame implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String titolo = "Pannello amministratore finanziario";
	//VisualUtentiFrame visualUtentiFrame = null;
	//VisualOrdiniFrame visualOrdiniFrame = null;
	//VisualProdottiFrame visualProdottiFrame = null;
	//RegisterAdminFrame registerAdminFrame = null;
	VisualCostoSpedFrame visualCostoSpedFrame = null;
	VisualTipiProdottoFrame visualTipiProdottoFrame = null;
	VisualUtentiFrame visualUtentiFrame = null;
	
	private WidgetFactory widgetFactory = new MagicWidgetFactory();
	
	private JPanel panel = widgetFactory.createJPanel();
	private JButton btnCostoSped;
	private JButton btnTipiProdotto;
	private JButton btnScontoEnte;
	private JButton btnTrattenutaSito;
	
	
	
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
		
		btnCostoSped = widgetFactory.createJButton();
		btnCostoSped.setText("Gestisci costo spedizione");
		btnCostoSped.setBounds(86, 12, 645, 25);
		panel.add(btnCostoSped);
		
		btnTipiProdotto = widgetFactory.createJButton();
		btnTipiProdotto.setText("Gestisci tipi prodotto");
		btnTipiProdotto.setBounds(86, 49, 645, 25);
		panel.add(btnTipiProdotto);
		
		btnScontoEnte = widgetFactory.createJButton();
		btnScontoEnte.setText("Gestisci sconto Ente");
		btnScontoEnte.setBounds(86, 86, 645, 25);
		panel.add(btnScontoEnte);
		
		btnTrattenutaSito = widgetFactory.createJButton();
		btnTrattenutaSito.setText("Gestisci trattenute sito");
		btnTrattenutaSito.setBounds(86, 123, 645, 25);
		panel.add(btnTrattenutaSito);
		
		
	}
	
	private void addActionListener(){
		
		btnCostoSped.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){;
				visualCostoSpedFrame = new VisualCostoSpedFrame();
				visualCostoSpedFrame.setVisible(true);
				visualCostoSpedFrame.toFront();
				visualCostoSpedFrame.repaint();
				//closeAdminFrame();
			
			}
		});
		
		btnTipiProdotto.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){;
				visualTipiProdottoFrame = new VisualTipiProdottoFrame();
				visualTipiProdottoFrame.setVisible(true);
				visualTipiProdottoFrame.toFront();
				visualTipiProdottoFrame.repaint();
			
			}
		});
		
		btnScontoEnte.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){;
				System.out.println("ciao");
			}
		});
		
		btnTrattenutaSito.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){;
				System.out.println("ciao");
			}
		});
		
	}
	
	private void closeAdminFrame(){
		
		this.dispose();
		//this.setVisible(false);
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

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
