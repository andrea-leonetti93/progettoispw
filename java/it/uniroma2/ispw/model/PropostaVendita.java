package it.uniroma2.ispw.model;

public class PropostaVendita {

	Venditore v;
	Prodotto p;
	int prezzoFinale; /* calcolato a runtime */
	
	public Venditore getV() {
		return v;
	}
	public void setV(Venditore v) {
		this.v = v;
	}
	public Prodotto getP() {
		return p;
	}
	public void setP(Prodotto p) {
		this.p = p;
	}
	public int getPrezzoFinale() {
		return prezzoFinale;
	}
	public void setPrezzoFinale(int prezzoFinale) {
		this.prezzoFinale = prezzoFinale;
	}
	
	
		
}
