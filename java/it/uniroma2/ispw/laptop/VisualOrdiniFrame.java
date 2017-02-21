package it.uniroma2.ispw.laptop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import it.uniroma2.ispw.controller.GestioneSistema;
import it.uniroma2.ispw.factory.BeautifulWidgetFactory;
import it.uniroma2.ispw.factory.WidgetFactory;
import it.uniroma2.ispw.laptopBean.OrdineLaptopBean;
import it.uniroma2.ispw.model.Ordine;
import it.uniroma2.ispw.model.PagamentoCarta;
import it.uniroma2.ispw.model.SpedizioneNormale;

public class VisualOrdiniFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String titolo = "Visualizza gli ordini";
	
	private WidgetFactory widgetFactory = new BeautifulWidgetFactory();

	private OrdineLaptopBean olb = new OrdineLaptopBean();
	private List<OrdineLaptopBean> listaOrdiniB;
	
	private JPanel panel = widgetFactory.createJPanel();
	private JButton btnOrdini;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JLabel textLabel;
	private int row;
	
	public VisualOrdiniFrame(){
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
		
		btnOrdini = widgetFactory.createJButton();
		btnOrdini.setText("Visualizza ordini consumatori");
		btnOrdini.setBounds(86, 12, 645, 25);
		panel.add(btnOrdini);
		
		textLabel = new JLabel("Selezionare una riga per avere informazioni sull'ordine!");
		textLabel.setBounds(86, 49, 685, 25);
		panel.add(textLabel);
		
		table = widgetFactory.createJTable();
		model = (DefaultTableModel) table.getModel();
		scrollPane = new JScrollPane(table);
		model.addColumn("idOrdine");
		model.addColumn("prezzo");
		model.addColumn("Email consumatore");
		model.addColumn("Tipo spedizione");
		model.addColumn("Metodo pagamento");
		scrollPane.setLocation(42, 86);
		scrollPane.setSize(700, 400);		
		panel.add(scrollPane);
	}
	
	private void addActionListener(){
		
		btnOrdini.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				int rowCount = model.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--){
					model.removeRow(i);
				}
				riempiTabella();
			}
		});
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				//int i = (Integer) table.getValueAt(table.getSelectedRow(), 0);
				int i = (Integer) table.getSelectedRow();
				OrdineLaptopBean orb = listaOrdiniB.get(i);
				visualLineeOrdine = new VisualLineeOrdine(or);
				visualLineeOrdine.setVisible(true);
			    visualLineeOrdine.toFront();
			    visualLineeOrdine.repaint();
			}
		});
		
	}
	
	private void riempiTabella(){
		OrdineLaptopBean orb;
		String sped = "";
		String pag = "";
		String elem = "";
		int id = 0, prezzo = 0;
		listaOrdiniB = olb.ottieniListaOrdini();
		//listaOrdini = gs.visualizzaOrdini();
		for(int j=0; j<listaOrdiniB.size(); j++){
			orb = listaOrdiniB.get(j);
			model.insertRow(j, new Object[]{row});
			
			for(int i=0; i<model.getColumnCount(); i++){
				if(model.getColumnName(i).equals("idOrdine")){
					id = orb.getIdOrdine();
					model.setValueAt(id, j, i);
				}
				if(model.getColumnName(i).equals("prezzo")){
					prezzo = orb.getPrezzo();
					model.setValueAt(prezzo, j, i);
				}
				if(model.getColumnName(i).equals("Email consumatore")){
					elem = orb.getEmailUtente();
					model.setValueAt(elem, j, i);
				}
				if(model.getColumnName(i).equals("Tipo spedizione")){
					sped = orb.getTipoSped();
					model.setValueAt(sped, j, i);
				}
				if(model.getColumnName(i).equals("Metodo pagamento")){
					pag = orb.getMetodoPag();
					model.setValueAt(pag, j, i);
				}
			}
		}
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
