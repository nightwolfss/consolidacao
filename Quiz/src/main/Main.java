package main;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import entidade.Competidor;
import entidade.Quiz;

public class Main {

	public static void main(String[] args) {

		String continuar = "s";
		ImageIcon fisio3 = new ImageIcon(Quiz.class.getResource("/fisio3.jpg"));
		String tudo="";
		
		new Quiz().apresentacaoQuiz();

		while (continuar.equalsIgnoreCase("s")) {
			Integer op = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\n\n1 - Jogar\n2 - Resultados\n3 - Sair"));
			switch (op) {

			case 1:
				while (continuar.equalsIgnoreCase("s")) {
					new Quiz().IniciarQuiz();
					continuar = JOptionPane.showInputDialog(null, "Tentar novamente?\n\nS - SIM\nN - N�O");
				}
				break;

			case 2:
				JOptionPane.showMessageDialog(null, new Quiz().resultado());
				
				/*op = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\n\n1 - Jogar\n2 - Resultados\n3 - Sair"));
				if(op == 3) {
					continuar = "x";
				}*/
				break;

			case 3:
				continuar = "x";
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!!");
				break;
			}
		}
		JOptionPane.showMessageDialog(null, new Quiz().resultado());
		JOptionPane.showMessageDialog(null, fisio3, "Obrigado", -1);
	}

}