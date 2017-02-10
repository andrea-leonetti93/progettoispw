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

import it.uniroma2.ispw.controller.GestisciFinanza;
import it.uniroma2.ispw.factory.BeautifulWidgetFactory;
import it.uniroma2.ispw.factory.MagicWidgetFactory;
import it.uniroma2.ispw.factory.WidgetFactory;
import it.uniroma2.ispw.model.PrezzoSpedizione;

public class VisualCostoSpedFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static String titolo = "Pannello amministratore finanziario";
	//VisualUtentiFrame visualUtentiFrame = null;
	//VisualOrdiniFrame visualOrdiniFrame = null;
	//VisualProdottiFrame visualProdottiFrame = null;
	//RegisterAdminFrame registerAdminFrame = null;
	VisualUtentiFrame visualUtentiFrame = null;
	
	
	private WidgetFactory widgetFactory = new MagicWidgetFactory();
	
	private JPanel panel = widgetFactory.createJPanel();
	
	private static JLabel textSpedNormale;
	private static JTextField insSpedNormale;
	
	private static JLabel textSpedRapida;
	private static JTextField insSpedRapida;
	
	private JButton btnSalva;
	
	int inputSpedNormale;
	int inputSpedRapida;
	
	private int row;
	
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
		
		textSpedNormale = new JLabel("Costo Spedizione Normale");
		textSpedNormale.setBounds(10, 10, 200, 25);
		panel.add(textSpedNormale);
		
		insSpedNormale = new JTextField(20);
		insSpedNormale.setBounds(15, 40, 200, 25);
		panel.add(insSpedNormale);
		
		textSpedRapida = new JLabel("Costo Spedizione Rapida");
		textSpedRapida.setBounds(10, 80, 200, 25);
		panel.add(textSpedRapida);
		
		insSpedRapida = new JTextField(20);
		insSpedRapida.setBounds(15, 110, 200, 25);
		panel.add(insSpedRapida);
		
		btnSalva = widgetFactory.createJButton();
		btnSalva.setText("Salva");
		btnSalva.setBounds(15, 165, 200, 25);
		panel.add(btnSalva);
		
		//qui devo caricare dal database i due prezzi
		
		GestisciFinanza gf = GestisciFinanza.getInstance();
		
		PrezzoSpedizione psNormale = gf.prendiPrezzoSpedizione("Normale");
		PrezzoSpedizione psRapida = gf.prendiPrezzoSpedizione("Rapida");
		
		
		if (psNormale!=null) inputSpedNormale = psNormale.getCostoConsegna(); 
		else inputSpedNormale = 2; //default
		
		if (psRapida != null) inputSpedRapida = psRapida.getCostoConsegna(); 
		else inputSpedRapida = 4; //default

		insSpedNormale.setText(String.valueOf(inputSpedNormale));
		insSpedRapida.setText(String.valueOf(inputSpedRapida));
		
		

	}
	
	private void addActionListener(){
		
		btnSalva.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				inputSpedNormale = Integer.parseInt(insSpedNormale.getText());
				inputSpedRapida = Integer.parseInt(insSpedRapida.getText());
				GestisciFinanza gf = GestisciFinanza.getInstance();
				
				
				PrezzoSpedizione psN = new PrezzoSpedizione("Normale",inputSpedNormale);
				PrezzoSpedizione psR = new PrezzoSpedizione("Rapida", inputSpedRapida);
				
				gf.aggiungiOModificaPrezzoSpedizione(psN);
				gf.aggiungiOModificaPrezzoSpedizione(psR);
				
				insSpedNormale.setText(String.valueOf(inputSpedNormale));
				insSpedRapida.setText(String.valueOf(inputSpedRapida));
				
			}
		});
		
		
	}
	
	private void close(){
		
		this.addWindowListener(new java.awt.event.WindowAdapter(){
			
			public void windowClosing(WindowEvent windowEvent){
				
			}
		});
	}
	

}
