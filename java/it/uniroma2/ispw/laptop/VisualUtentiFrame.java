package it.uniroma2.ispw.laptop;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.uniroma2.ispw.controller.GestioneSistema;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;

public class VisualUtentiFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String titolo = "Visualizza utenti del sistema";
	private GestioneSistema gs = new GestioneSistema();
	
	//private static String[] header = {"UseriID", "Email", "Nome", "Cognome", "Tipo", "Indirizzo", "Numero"};
	
	private JPanel panel = new JPanel();
	private DefaultTableModel model;
	private JButton btnTutti;
	private JButton btnVenditori;
	private JButton btnConsumatori;
	// Create a table with 10 rows and 5 columns
    private JTable table;

    // Make the table vertically scrollable
    private JScrollPane scrollPane;
//	private JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
	private int row;
	
	
	public VisualUtentiFrame(){
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
		
		btnConsumatori = new JButton("Visualizza i consumatori");
		btnConsumatori.setBounds(86, 12, 320, 25);
		panel.add(btnConsumatori);
		
		btnVenditori = new JButton("Visualizza i venditori");
		btnVenditori.setBounds(420, 12, 320, 25);
		panel.add(btnVenditori);
		
		btnTutti = new JButton("Visualizza tutti gli utenti");
		btnTutti.setBounds(86, 49, 645, 25);
		panel.add(btnTutti);
		
/*		Dimension d = new Dimension(600, table.getRowHeight());
		table.add(scrollBar);
		table.setLocation(10, 86);
		table.setAutoscrolls(true);
		table.setPreferredScrollableViewportSize(d);
		panel.add(table);*/
		table = new JTable(0, 0);
		model = (DefaultTableModel) table.getModel();
		scrollPane = new JScrollPane(table);
		model.addColumn("UserID");
		model.addColumn("Nome");
		model.addColumn("Cognome");
		model.addColumn("Email");
		model.addColumn("Tipo");
		model.addColumn("Indirizzo");
		model.addColumn("Telefono");
		scrollPane.setLocation(42, 86);
		scrollPane.setSize(700, 400);		
		panel.add(scrollPane);
	}
	
	
	private void addActionListener(){
		
		btnTutti.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				int rowCount = model.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--){
					model.removeRow(i);
				}
				String tipo = "tutti";
				riempiTabella(tipo);
			}
		});
		
		btnConsumatori.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				int rowCount = model.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--){
					model.removeRow(i);
				}
				String tipo = "consumatore";
				riempiTabella(tipo);
			}
		});
		
		btnVenditori.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				int rowCount = model.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--){
					model.removeRow(i);
				}
				String tipo = "venditore";
				riempiTabella(tipo);
			}
		});
	}

	
	private void riempiTabella(String tipo){
		UtenteRegistrato ur;
		String type = "";
		String elem = "";
		if(tipo.equals("tutti")){
			try
			{
			List<UtenteRegistrato> listaUtenti = gs.visualizzaUtenti();
			for(int j=0; j<listaUtenti.size(); j++){
				ur = listaUtenti.get(j);
				model.insertRow(j, new Object[]{row});
				if(ur instanceof Venditore){
					type = "venditore";
				}else{
					type = "consumatore";
				}
				for(int i=0; i<model.getColumnCount(); i++){
					if(model.getColumnName(i).equals("UserID")){
						elem = ur.getUserid();
						model.setValueAt(elem, j, i);
					}
					if(model.getColumnName(i).equals("Nome")){
						elem = ur.getNome();
						model.setValueAt(elem, j, i);
					}
					if(model.getColumnName(i).equals("Cognome")){
						elem = ur.getCognome();
						model.setValueAt(elem, j, i);
					}
					if(model.getColumnName(i).equals("Email")){
						elem = ur.getEmail();
						model.setValueAt(elem, j, i);
					}
					if(model.getColumnName(i).equals("Tipo")){
						model.setValueAt(type, j, i);
					}
					if(model.getColumnName(i).equals("Indirizzo")){
						elem = ur.getResidenza();
						model.setValueAt(elem, j, i);
					}
					if(model.getColumnName(i).equals("Telefono")){
						elem = ur.getTelefono();
						model.setValueAt(elem, j, i);
					}
				}
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			try
			{
			List<UtenteRegistrato> listaUtenti = gs.visualizzaUtenti();
			for(int j=0; j<listaUtenti.size(); j++){
				ur = listaUtenti.get(j);
				if(ur instanceof Venditore){
					type = "venditore";
				}else{
					type = "consumatore";
				}
				if(tipo.equals(type)){
					model.insertRow(j, new Object[]{row});
					for(int i=0; i<model.getColumnCount(); i++){
						if(model.getColumnName(i).equals("UserID")){
							elem = ur.getUserid();
							model.setValueAt(elem, j, i);
						}
						if(model.getColumnName(i).equals("Nome")){
							elem = ur.getNome();
							model.setValueAt(elem, j, i);
						}
						if(model.getColumnName(i).equals("Cognome")){
							elem = ur.getCognome();
							model.setValueAt(elem, j, i);
						}
						if(model.getColumnName(i).equals("Email")){
							elem = ur.getEmail();
							model.setValueAt(elem, j, i);
						}
						if(model.getColumnName(i).equals("Tipo")){
							model.setValueAt(type, j, i);
						}
						if(model.getColumnName(i).equals("Indirizzo")){
							elem = ur.getResidenza();
							model.setValueAt(elem, j, i);
						}
						if(model.getColumnName(i).equals("Telefono")){
							elem = ur.getTelefono();
							model.setValueAt(elem, j, i);
						}
					}
				}
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
/*	
	private void addRow(){
		String type;
		List<UtenteRegistrato> listaUtenti = gs.visualizzaUtenti();
		for(UtenteRegistrato ur: listaUtenti){
			if(ur instanceof Venditore){
				type = "venditore";
			}else{
				type = "consumatore";
			}
			table.add(new String[]{
					ur.getUserid(),
					ur.getEmail(),
					ur.getNome(),
					ur.getCognome(),
					type,
					ur.getResidenza(),
					ur.getTelefono()
			});
		}
	}*/
	
	private void close(){
		
		this.addWindowListener(new java.awt.event.WindowAdapter(){
			
			public void windowClosing(WindowEvent windowEvent){
				Integer risposta = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler tornare al menu amministratore?", "Stai per chiudere la ricerca utenti", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        if ( risposta == JOptionPane.YES_OPTION) {
		        	/* AdminFrame adminFrame = new AdminFrame();
				     adminFrame.setVisible(true);*/
		        }
			}
		});
	}
}
