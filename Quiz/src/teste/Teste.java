package teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) throws IOException {
		
		//String texto = "Vitor: 140";
		/*ArrayList<Competidor> texto = new ArrayList<Competidor>();
		
		Competidor c1 = new Competidor("Vitor", 20);
		Competidor c2 = new Competidor("Andre", 44);
		Competidor c3 = new Competidor("Lincol", 35);
		Competidor c4 = new Competidor("Dominic", 57);
		Competidor c5 = new Competidor("Mario", 60);
		
		texto.add(c1);
		texto.add(c2);
		texto.add(c3);
		texto.add(c4);
		texto.add(c5);
		*/
		
		/*
		String caminho = "resultados.txt";
		String linha2="";
		
		Competidor comp = new Competidor();
		ArrayList<Competidor> co = new ArrayList<Competidor>();
		
		try {
			FileReader arquivo = new FileReader(caminho);
			BufferedReader ler = new BufferedReader(arquivo);
			String linha = "";
			try {
				
				while (linha != null) {
					linha = ler.readLine();
					if (linha != null) {
						linha2 = linha2 + linha + "\n";
						comp.setNome(linha.substring(0, linha.length()-3));
						comp.setPontos(Integer.parseInt(linha.substring(linha.length()-3).trim()));
						co.add(comp);
				}
					
					
					//JOptionPane.showMessageDialog(null, co);
			} 
				
			} catch (Exception e) {
				// TODO: handle exception
			}
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ainda n�o temos nenhum resultado!!");
		}
		*/
		
		/*ArrayList<Competidor> co = new ArrayList<Competidor>();
		int var = 1;
		while (var == 1) {
			Competidor c = new Competidor();
			c.setNome(JOptionPane.showInputDialog(null, "Nome: "));
			c.setPontos(Integer.parseInt(JOptionPane.showInputDialog("Pontos: ")));
			co.add(c);
			
			var = Integer.parseInt(JOptionPane.showInputDialog(null, "Var: "));
			
		}
		
		Collections.sort(co);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(co.get(i));
		}*/
		
		
		/*
		String nome = texto.substring(0, texto.length()-3);
		Integer pontos = Integer.parseInt(texto.substring(texto.length()-3).trim());
		
		
		System.out.println(nome);
		System.out.println(pontos);
		*/
		String nome = JOptionPane.showInputDialog("Digite o nome: ");
		try {
			FileReader fr = new FileReader("resultados.txt");
			BufferedReader bfr = new BufferedReader(fr);
			ArrayList<String> lista = new ArrayList<String>();
			String linha="";
			String linha2="";
			
			while (linha != null) {
				linha2 = linha + bfr.readLine();
				System.out.println(linha2);
							
			}
			
			System.out.println(linha2);
			
			if(lista.contains(nome)) {
				JOptionPane.showMessageDialog(null, nome + " j� existe na lista.");
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
