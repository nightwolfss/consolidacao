package teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.quartz.SchedulerException;

public class Teste {
	
	public static void main(String[] args) throws SchedulerException {
		String variavel = JOptionPane.showInputDialog("Vamos gravar essa Mensagem AQUI!!");
		/*String buffer="";
		*/
		String caminho = "C:\\Users\\Vitor\\Desktop\\teste.txt";
		String linha = " ";
		
		try {
			FileWriter arquivo = new FileWriter("C:\\Users\\Vitor\\Desktop\\teste.txt", true);
			BufferedWriter gravar = new BufferedWriter(arquivo);
			//PrintWriter gravar = new PrintWriter(arquivo);
			
			gravar.write(variavel + "\r\n");
			gravar.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao escrever arquivo." + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(caminho));
			try {
				while (linha != null) {
					linha = bf.readLine();
					System.out.println(linha);
					
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Não foi possível exibir a linha"+ e.getMessage());
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		/*
		EnviarEmail ee = new EnviarEmail();
		CampanhaDao cd = new CampanhaDao();
		
		String email = "boa.vidaplena.mais@gmail.com";
		String senha = "bruno2013";
		String assunto = new Date().toString();
		String mensagem = cd.findByCode(2).getTexto();;
		
		System.out.println("-----");
		ee.enviarGmail(email, senha, assunto, mensagem);
		
		System.out.println(new Date());
		*/
		
		/*
		JobDetail job = JobBuilder.newJob(Diariamente.class).build();
		Trigger t1 = TriggerBuilder.newTrigger().withIdentity("Contrigger")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build();

		Scheduler sc = StdSchedulerFactory.getDefaultScheduler(); //StdSchedulerFactory.getDefaultScheduler();
		sc.start();
		sc.scheduleJob(job, t1);
			*/
		
	}
	
	

}