package it.uniroma2.ispw.laptop;

import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.uniroma2.ispw.factory.BeautifulWidgetFactory;
import it.uniroma2.ispw.factory.WidgetFactory;
import it.uniroma2.ispw.model.LineaOrdine;
import it.uniroma2.ispw.model.Ordine;

public class VisualLineeOrdine extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WidgetFactory widgetFactory = new BeautifulWidgetFactory();

	
	private static String titolo = "Visualizza linee per ordine";

	
	private JPanel panel = widgetFactory.createJPanel();
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private int row;
	
	public VisualLineeOrdine(Ordine ordine){
		super(titolo);
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(panel);
		placeComponents(panel);
		riempiTabella(ordine);
		close();
		this.setVisible(true);
	}
	
	
	private void placeComponents(JPanel panel){
		panel.setLayout(null);
		
		table = widgetFactory.createJTable();
		model = (DefaultTableModel) table.getModel();
		scrollPane = new JScrollPane(table);
		model.addColumn("idLineaOrdine");
		model.addColumn("Nome prodotto");
		model.addColumn("Email venditore");
		model.addColumn("Prezzo linea");
		scrollPane.setLocation(10, 12);
		scrollPane.setSize(700, 400);		
		panel.add(scrollPane);
	}
	
	
	private void riempiTabella(Ordine ordine){
		int id;
		int prezzo;
		String nomeProd;
		String email;
		LineaOrdine lo;
		List<LineaOrdine> listaLineeOrdine = ordine.getLineeOrdine();
		for(int j=0; j<listaLineeOrdine.size(); j++){
			lo = listaLineeOrdine.get(j);
			model.insertRow(j, new Object[]{row});
			for(int i=0; i<model.getColumnCount(); i++){
				if(model.getColumnName(i).equals("idLineaOrdine")){
					id = lo.getIdLineaOrdine();
					model.setValueAt(id, j, i);
				}
				if(model.getColumnName(i).equals("Nome prodotto")){
					nomeProd = lo.getProdotto().getNome();
					model.setValueAt(nomeProd, j, i);
				}
				if(model.getColumnName(i).equals("Email venditore")){
					email = lo.getProdotto().getUtenteRegistrato().getEmail();
					model.setValueAt(email, j, i);
				}
				if(model.getColumnName(i).equals("Prezzo linea")){
					prezzo = lo.getPrezzoLinea();
					model.setValueAt(prezzo, j, i);
				}
			}	
		}
	}
	
	private void close(){
		
		this.addWindowListener(new java.awt.event.WindowAdapter(){
			
			public void windowClosing(WindowEvent windowEvent){
				Integer risposta = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler tornare indietro?", "Stai per chiudere linee ordine", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        if ( risposta == JOptionPane.YES_OPTION) {
		        	/* AdminFrame adminFrame = new AdminFrame();
				     adminFrame.setVisible(true);*/
		        }
			}
		});
	}
	
}
