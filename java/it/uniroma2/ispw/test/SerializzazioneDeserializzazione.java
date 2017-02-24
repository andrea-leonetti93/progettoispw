package it.uniroma2.ispw.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringReader;

/*
 Schema classico da seguire in lettura 
  
  open(Stream);
  while(more information ?){
  	read(Stream);
  }
  close(Stream);
  
  
  e in scrittura
  
  open(Stream);
  while(more information ?){
  	write(Stream)
  }
  close(Stream);
  
  Flussi di byte:
  	- Specializzare classe astratta InputStream
  	- Specializzare classe astratta OutputStream
  	
  Flussi di caratteri:
  	- Specializzare classe astratta Reader;
  	- Specializzare classe astratta Writer
  	
  	
  Per la serializzazione e deserializzazione vengono utilizzate le seguenti classi:
  
  	-ObjectInputStream
  	-ObjectOutputStream
  	
  */




public class SerializzazioneDeserializzazione {


	public void letturaCharFile(){
		BufferedReader bf = null;
		String s = new String();
		String s1 = new String();
		try{
			bf = new BufferedReader(new FileReader("file.txt"));
			while((s = bf.readLine()) != null){
				s1 += s + "\n";
			}
			bf.close();
			System.out.println("letto fa file :" + s1);
		}catch(IOException e){}

	}

	
	public void scritturaCharFile(){
		
		String s = new String();
		String s2 = "Stringa da scrivere!";
		BufferedReader bf = new BufferedReader(new StringReader(s2));
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("file.txt")));
			int lineCount = 1; //vedere quante righe leggiamo
			while((s = bf.readLine()) != null){
				lineCount++;
				out.println(lineCount + ": " + s);
			}
			out.close();
		}catch(IOException e){}
		System.out.println("scritto su file");
	}
	
	////////////
	
	public void scriviAutoFile() throws IOException{
		
		FileOutputStream out = new FileOutputStream("file.txt");
		ObjectOutputStream obs = new ObjectOutputStream(out);
		AutomobileSerializabile auto = new AutomobileSerializabile("punto", "quarta serie", "fiat", "nero", 1200, 75);
		obs.writeObject(auto);
	}
	
	public void leggiAutoFile(){
		

		try {
			FileInputStream in = new FileInputStream("file.txt");
			ObjectInputStream obs = new ObjectInputStream(in);
			AutomobileSerializabile auto = null;
			auto = (AutomobileSerializabile) obs.readObject();
			System.out.println("Auto: " + auto.getNome());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
