package controle;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import entidade.EnviarEmail;
import persistencia.CampanhaDao;

public class Diariamente implements Job{
	
	int dia;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		String hora = new Date().toString().substring(11, 19);
		//System.out.println(hora);
		
		if(hora.equalsIgnoreCase("08:15:00")) {
		
		EnviarEmail ee = new EnviarEmail();
		CampanhaDao cd = new CampanhaDao();
		
		String email = "mais.vida.boaplena@gmail.com";
		String senha = "bruno2013";
		String assunto = new Date().toString();
		String mensagem = cd.findByCode(1).getTexto();;
		
		System.out.println("-----");
		ee.enviarGmail(email, senha, assunto, mensagem);
		
		System.out.println(new Date());
		
	}
	}
}
