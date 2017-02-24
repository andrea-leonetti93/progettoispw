package it.uniroma2.ispw.test;

import java.io.Serializable;

public class AutomobileSerializabile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String modello;
	private String marca;
	private String colore;
	private int cilindrata;
	private int CV;
	
	public AutomobileSerializabile(String nome, String modello, String marca, String colore, int cilindrata, int CV){
		this.nome = nome;
		this.modello = modello;
		this.marca = marca;
		this.colore = colore;
		this.cilindrata = cilindrata;
		this.CV = CV;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	public int getCV() {
		return CV;
	}

	public void setCV(int cV) {
		CV = cV;
	}
	
}
