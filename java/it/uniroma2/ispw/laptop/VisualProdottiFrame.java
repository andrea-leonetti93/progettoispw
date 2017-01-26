package it.uniroma2.ispw.laptop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.uniroma2.ispw.controller.GestioneSistema;
import it.uniroma2.ispw.factory.BeautifulWidgetFactory;
import it.uniroma2.ispw.factory.WidgetFactory;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.TipoProdotto;

public class VisualProdottiFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WidgetFactory widgetFactory = new BeautifulWidgetFactory();
	
	private static String titolo = "Visualizza prodotti";
	private GestioneSistema gs = new GestioneSistema();
	private JPanel panel = widgetFactory.createJPanel();
	private JButton btnTuttiProdotti;
	private JButton btnRiceProdotti;
	private JLabel labelCategoria;
	private JLabel labelTipologia;
	private JComboBox<String> boxCategoria;
	private JComboBox<String> boxTipologia;
	private DefaultComboBoxModel<String> nomiCategorie = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> nomiTipologie = new DefaultComboBoxModel<String>();
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private int row;
	
	private List<TipoProdotto> tipiProdotti = null;
	private List<String> categorie = new ArrayList<String>();
	private List<String> tipologie = new ArrayList<String>();
	private List<Prodotto> listaProdotti;
	
	public VisualProdottiFrame(){
		super(titolo);
		
		this.setSize(900, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(panel);
		placeComponents(panel);
		riempiComboBox();
		close();
		addActionListener();
		this.setVisible(true);
	}

	private void placeComponents(JPanel panel){
		panel.setLayout(null);
		
		labelCategoria = new JLabel("Categoria");
		labelCategoria.setBounds(42, 12, 80, 25);
		panel.add(labelCategoria);
		
		boxCategoria = new JComboBox<String>(nomiCategorie);
		boxCategoria.setBounds(42, 49, 625, 25);
		panel.add(boxCategoria);
		
		labelTipologia = new JLabel("Tipologia");
		labelTipologia.setBounds(42, 86, 80, 25);
		panel.add(labelTipologia);
		
		boxTipologia = new JComboBox<String>(nomiTipologie);
		boxTipologia.setBounds(42, 123, 625, 25);
		panel.add(boxTipologia);
		
		btnRiceProdotti = widgetFactory.createJButton();
		btnRiceProdotti.setText("Avvia ricerca prodotti");
		btnRiceProdotti.setBounds(42, 158, 625, 25);
		panel.add(btnRiceProdotti);
		
		btnTuttiProdotti = widgetFactory.createJButton();
		btnTuttiProdotti.setText("Avvia ricerca tutti i prodotti");
		btnTuttiProdotti.setBounds(42, 200, 625, 25);
		panel.add(btnTuttiProdotti);
		
		table =  widgetFactory.createJTable();
		model = (DefaultTableModel) table.getModel();
		scrollPane = new JScrollPane(table);
		model.addColumn("idProdotto");
		model.addColumn("prezzo");
		model.addColumn("Email venditore");
		model.addColumn("Categoria");
		model.addColumn("Tipologia");
		scrollPane.setLocation(42, 250);
		scrollPane.setSize(700, 300);		
		panel.add(scrollPane);
	}
	
	
	private void addActionListener(){
		
		 boxCategoria.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nomiTipologie.removeAllElements();
				tipologie.clear();
				String item = (String) boxCategoria.getSelectedItem();

				for(int i=0; i<tipiProdotti.size(); i++){
	        		if(item.equals(tipiProdotti.get(i).getCategoria())){
	        			tipologie.add(tipiProdotti.get(i).getTipologia());	
	        		}
	        	}
	        	// spinnerTipologia = new JSpinner(modelT);
	        	 //modelT.setValue(tipologie);
	        	for(int j=0; j<tipologie.size(); j++){ 
	        		nomiTipologie.addElement(tipologie.get(j)); 
	        	}
			}
	      });
		 
		btnRiceProdotti.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rowCount = model.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--){
					model.removeRow(i);
				}
				String cat = (String) boxCategoria.getSelectedItem();
				String tip = (String) boxTipologia.getSelectedItem();
				System.out.println(cat + tip);
				listaProdotti = gs.visualizzaProdotti(cat, tip);
				riempiTabella(listaProdotti);
			}
		});
		 
		btnTuttiProdotti.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rowCount = model.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--){
					model.removeRow(i);
				}
				listaProdotti = gs.visualizzaProdotti();
				riempiTabella(listaProdotti);
			}
		});
	}
	
	
	private void riempiComboBox(){

		tipiProdotti = gs.visualizzaTipoProdotti();
		for(int i=0; i<tipiProdotti.size(); i++){
			categorie.add(tipiProdotti.get(i).getCategoria());
			tipologie.add(tipiProdotti.get(i).getTipologia());
		}
		Set<String> se = new HashSet<String>(categorie);
		categorie.clear();
		categorie = new ArrayList<String>(se);
		for(int j=0; j<categorie.size(); j++){
			nomiCategorie.addElement(categorie.get(j));
		}
		nomiTipologie.addElement("Scegli categoria");
	}
	
	private void riempiTabella(List<Prodotto> listaProdotti){
		Prodotto p;
		int id;
		int prezzo;
		String email = "";
		String cate = "";
		String tipo = "";
		for(int j=0; j<listaProdotti.size(); j++){
			p = listaProdotti.get(j);
			model.insertRow(j, new Object[]{row});
			for(int i=0; i<model.getColumnCount(); i++){
				if(model.getColumnName(i).equals("idProdotto")){
					id = p.getId();
					model.setValueAt(id, j, i);
				}
				if(model.getColumnName(i).equals("prezzo")){
					prezzo = p.getPrezzo();
					model.setValueAt(prezzo, j, i);
				}
				if(model.getColumnName(i).equals("Email venditore")){
					email = p.getUtenteRegistrato().getEmail();
					model.setValueAt(email, j, i);
				}
				if(model.getColumnName(i).equals("Categoria")){
					cate = p.getCategoria();
					model.setValueAt(cate, j, i);
				}
				if(model.getColumnName(i).equals("Tipologia")){
					tipo = p.getTipologia();
					model.setValueAt(tipo, j, i);
				}
			}
		}
	}
	
	private void close(){
		
		this.addWindowListener(new java.awt.event.WindowAdapter(){
			
			public void windowClosing(WindowEvent windowEvent){
				Integer risposta = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler tornare al menu amministratore?", "Stai per chiudere cerca prodotti", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        if ( risposta == JOptionPane.YES_OPTION) {
		        	/* AdminFrame adminFrame = new AdminFrame();
				     adminFrame.setVisible(true);*/
		        }
			}
		});
	}
	
}
