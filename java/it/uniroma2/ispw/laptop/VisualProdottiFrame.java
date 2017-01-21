package it.uniroma2.ispw.laptop;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.uniroma2.ispw.controller.GestioneSistema;

public class VisualProdottiFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String titolo = "Visualizza prodotti";
	private GestioneSistema gs = new GestioneSistema();
	private JPanel panel = new JPanel();
	private JButton btnTuttiProdotti;
	private JButton btnRiceProdotti;
	private JLabel labelCategoria;
	private JLabel labelTipologia;
	private JMenu menuCategoria;
	private JMenu menuTipologia;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private int row;
	
	public VisualProdottiFrame(){
		super(titolo);
		
		this.setSize(900, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(panel);
		placeComponents(panel);
		close();
		addActionListener();
		this.setVisible(true);
	}

	private void placeComponents(JPanel panel){
		panel.setLayout(null);
		
		labelCategoria = new JLabel("Categoria");
		labelCategoria.setBounds(42, 12, 80, 25);
		panel.add(labelCategoria);
		
		menuCategoria = new JMenu();
		menuCategoria.setBounds(42, 49, 625, 25);
		panel.add(menuCategoria);
		
		labelTipologia = new JLabel("Tipologia");
		labelTipologia.setBounds(42, 86, 80, 25);
		panel.add(labelTipologia);
		
		menuTipologia = new JMenu();
		menuTipologia.setBounds(42, 123, 625, 25);
		panel.add(menuTipologia);
		
		btnRiceProdotti = new JButton("Avvia ricerca prodotti");
		btnRiceProdotti.setBounds(42, 158, 625, 25);
		panel.add(btnRiceProdotti);
		
		btnTuttiProdotti = new JButton("Avvia ricerca tutti i prodotti");
		btnTuttiProdotti.setBounds(42, 185, 625, 25);
		panel.add(btnTuttiProdotti);
		
		table = new JTable(0, 0);
		model = (DefaultTableModel) table.getModel();
		scrollPane = new JScrollPane(table);
		model.addColumn("idProdotto");
		model.addColumn("prezzo");
		model.addColumn("Email venditore");
		model.addColumn("Categoria");
		model.addColumn("Tipologia");
		scrollPane.setLocation(42, 200);
		scrollPane.setSize(700, 350);		
		panel.add(scrollPane);
	}
	
	
	private void addActionListener(){
		
	}
	
	private void riempiTabella(){
		
	}
	
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
