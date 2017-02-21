package it.uniroma2.ispw.laptop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import it.uniroma2.ispw.controller.GestisciFinanza;
import it.uniroma2.ispw.factory.MagicWidgetFactory;
import it.uniroma2.ispw.factory.WidgetFactory;
import it.uniroma2.ispw.model.TipoProdotto;

public class VisualTipiProdottoFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static String titolo = "Pannello amministratore finanziario";

	private GestisciFinanza gf = GestisciFinanza.getInstance();
	
	private WidgetFactory widgetFactory = new MagicWidgetFactory();
	
	private static JLabel labelAggiungi;
	private static JLabel labelElimina;
	
	private static JLabel labelCategoria1;
	private static JLabel labelCategoria2;
	private static JLabel labelTipologia1;
	private static JLabel labelTipologia2;
	
	
	
	private static JTextField insCategoriaAdd;
	private static JTextField insTipologiaAdd;
	
	private static JTextField insCategoriaDel;
	private static JTextField insTipologiaDel;
	
	private JButton btnAdd;
	private JButton btnDel;
	
	private int row;

	
	
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel panel = widgetFactory.createJPanel();
	
	
	public VisualTipiProdottoFrame(){
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
		
		table = widgetFactory.createJTable();
		model = (DefaultTableModel) table.getModel();
		scrollPane = new JScrollPane(table);
		model.addColumn("idTipoProdotto");
		model.addColumn("Categoria");
		model.addColumn("Tipologia");
		scrollPane.setLocation(470, 30);
		scrollPane.setSize(300, 500);
		//scrollPane.sets
		panel.add(scrollPane);
		
		labelAggiungi = new JLabel("Aggiungi tipo prodotto");
		labelAggiungi.setBounds(10, 10, 170, 25);
		panel.add(labelAggiungi);
		
		
		labelElimina = new JLabel("Elimina tipo prodotto");
		labelElimina.setBounds(10, 300, 170, 25);
		panel.add(labelElimina);
		
		insCategoriaAdd = new JTextField(20);
		insCategoriaAdd.setBounds(100, 35, 200, 25);
		panel.add(insCategoriaAdd);
		
		insTipologiaAdd = new JTextField(20);
		insTipologiaAdd.setBounds(100, 75, 200, 25);
		panel.add(insTipologiaAdd);
		
		btnAdd = widgetFactory.createJButton();
		btnAdd.setText("Aggiungi");
		btnAdd.setBounds(10, 110, 200, 25);
		panel.add(btnAdd);
		
		
		insCategoriaDel = new JTextField(20);
		insCategoriaDel.setBounds(100, 325, 200, 25);
		panel.add(insCategoriaDel);
		
		insTipologiaDel = new JTextField(20);
		insTipologiaDel.setBounds(100, 365, 200, 25);
		panel.add(insTipologiaDel);
		
		btnDel = widgetFactory.createJButton();
		btnDel.setText("Elimina");
		btnDel.setBounds(10, 400, 200, 25);
		panel.add(btnDel);
		
		labelCategoria1 = new JLabel("Categoria:");
		labelCategoria1.setBounds(10, 35, 170, 15);
		panel.add(labelCategoria1);
		
		labelCategoria2 = new JLabel("Categoria:");
		labelCategoria2.setBounds(10, 325, 170, 15);
		panel.add(labelCategoria2);
		
		labelTipologia1 = new JLabel("Tipologia:");
		labelTipologia1.setBounds(10, 75, 170, 15);
		panel.add(labelTipologia1);
		
		labelTipologia2 = new JLabel("Tipologia:");
		labelTipologia2.setBounds(10, 365, 170, 15);
		panel.add(labelTipologia2);
		
		
		List<TipoProdotto> ltp = gf.visualizzaListaTipiProdotto();
		
		for(int i = 0;i<ltp.size();i++){
			model.insertRow(i, new Object[]{row});
			TipoProdotto tp = ltp.get(i);
			System.out.println(tp.getTipoProdId());
			System.out.println(tp.getCategoria());
			System.out.println(tp.getTipologia());
			model.setValueAt(tp.getTipoProdId(), i, 0);
			model.setValueAt(tp.getCategoria(), i, 1);
			model.setValueAt(tp.getTipologia(), i, 2);
		}
		
		
		
		
		

	}
	
	
	private void addActionListener(){
		
		btnAdd.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				String categoria = insCategoriaAdd.getText();
				String tipologia = insTipologiaAdd.getText();
				
				gf.aggiungiTipoProdotto(categoria, tipologia);
				
				int rowCount = model.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--){
					model.removeRow(i);
				}
				
				List<TipoProdotto> ltp = gf.visualizzaListaTipiProdotto();
				
				for(int i = 0;i<ltp.size();i++){
					model.insertRow(i, new Object[]{row});
					TipoProdotto tp = ltp.get(i);
					model.setValueAt(tp.getTipoProdId(), i, 0);
					model.setValueAt(tp.getCategoria(), i, 1);
					model.setValueAt(tp.getTipologia(), i, 2);
				}
			
			
				
				
			}
		});
		
		btnDel.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				String categoria = insCategoriaDel.getText();
				String tipologia = insTipologiaDel.getText();
				
				gf.eliminaTipoProdotto(categoria, tipologia);
				
				int rowCount = model.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--){
					model.removeRow(i);
				}
				
				List<TipoProdotto> ltp = gf.visualizzaListaTipiProdotto();
				
				for(int i = 0;i<ltp.size();i++){
					model.insertRow(i, new Object[]{row});
					TipoProdotto tp = ltp.get(i);
					model.setValueAt(tp.getTipoProdId(), i, 0);
					model.setValueAt(tp.getCategoria(), i, 1);
					model.setValueAt(tp.getTipologia(), i, 2);
				}
			
				
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
