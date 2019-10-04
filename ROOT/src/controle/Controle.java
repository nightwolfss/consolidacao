package controle;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidade.Campanha;
import entidade.EnviarEmail;
import persistencia.CampanhaDao;
import persistencia.Dao;
import persistencia.PropagandaDao;

@WebServlet("/Controle")

public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session;

	private List lista5;
	
	
	public List getLista5() {
		try {
		lista5 = new CampanhaDao().consultarCampanhas();
		
	} catch (Exception e) {

		System.out.print("Erro: "+ e.getMessage());
	}
	return lista5;
}

	public void setLista5(List lista5) {
	
	this.lista5 = lista5;
	
	}
	
	Integer diaCampanha = 1;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String var = request.getParameter("cmd");
		
		if(var.equalsIgnoreCase("index")) {
			response.sendRedirect("index.jsp");
		}
		
		if(var.equalsIgnoreCase("email")) {
			enviarEmail(request, response);
		}
		if(var.equalsIgnoreCase("cademail")) {
			cadeMail(request, response);
			
		}
		if(var.equalsIgnoreCase("campanhaGravar")) {
			gravarCampanha(request, response);
			
		}
		if(var.equalsIgnoreCase("campanhaUpdate")) {
			atualizarCampanha(request, response);
			
		}
		if(var.equals("enviarcampanhas")) {
			enviarPropaganda(request, response);
		}
		if(var.equals("login")) {
			redirecionar(request, response);
		}
		
	}
	

		
	protected void enviarEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnviarEmail ee = new EnviarEmail();
		
		String destino =  request.getParameter("destino");
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		Integer qtd =  Integer.parseInt(request.getParameter("quantidade"));
		
		Dao d = new Dao();
		
		//Os emails serão enviados. O metodo retorna uma variável que conta quantos emails foram disparados.
        for(int i=1; i<=qtd; i++) {
		ee.enviarHotmail(titulo, destino, texto, i);
        }		
		//request.setAttribute("mensagemUsuario", "Foram disparados "+ contador +" email(s).");
		
		request.getRequestDispatcher("email.jsp").forward(request, response);
		
	}
	
	protected void cadeMail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PropagandaDao prod = new PropagandaDao();
		EnviarEmail ee = new EnviarEmail();
		Dao d = new Dao();
		CampanhaDao cd = new CampanhaDao();
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");;
		String email = request.getParameter("email");
		String mensagem= cd.findByCode(diaCampanha).getTexto();;
		
		try {
			String retorno = prod.gravarEmail(nome, sobrenome, email);			
			request.setAttribute("mensagem", retorno +"<br>"+ new Date().toString().substring(11, 19));
			//request.getRequestDispatcher("campanhas_cadastro_de_email.jsp").forward(request, response);
			
			System.out.println("O valor de RETORNO: "+ retorno);
			
			if(retorno == "Email já cadastrado!!") {
				request.getRequestDispatcher("campanhas_cadastro_de_email.jsp").forward(request, response);
			}
						
			else {
				ee.enviarUmGmail(nome, email, mensagem);
				request.getRequestDispatcher("campanhas_cadastro_de_email.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			//request.setAttribute("mensagem", retorno +"<br>"+ new Date().toString().substring(11, 19));
			request.setAttribute("mensagem", "Erro!!");
		}
		
	}
	
	protected void gravarCampanha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CampanhaDao cd = new CampanhaDao();
		Campanha c = new Campanha();
		
		c.setNome(request.getParameter("nome"));
		c.setTexto(request.getParameter("texto"));
		
	
		try {
			cd.gravarCampanha(c.getNome(), c.getTexto());
			request.setAttribute("mensagem", "Campanha Salva com sucesso!!");
			request.getRequestDispatcher("campanhas.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro ao gravar Campanha!!");
			request.getRequestDispatcher("campanhas.jsp").forward(request, response);
		}
		
	}
	
	protected void atualizarCampanha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CampanhaDao cd = new CampanhaDao();
		Campanha c = new Campanha();
		
		c.setId(Integer.parseInt(request.getParameter("id")));
		c.setNome(request.getParameter("nome"));
		c.setTexto(request.getParameter("texto"));
		
	
		try {
			cd.atualizarCampanha(c.getNome(), c.getTexto(), c.getId());
			
			request.setAttribute("mensagem", "Campanha Salva com sucesso!!");
			request.getRequestDispatcher("campanhas.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro ao gravar Campanha!!");
			request.getRequestDispatcher("campanhas.jsp").forward(request, response);
		}
		
	}
	
	protected void enviarPropaganda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		CampanhaDao cd = new CampanhaDao();
		Dao d = new Dao();
		EnviarEmail ee = new EnviarEmail();
		
		String email = "vitorrubm@gmail.com";
		String senha = "Jesuseamor";
		String assunto = "®";
		String mensagem = null;	
		
		ee.enviarGmail(email, senha, assunto, mensagem);			
		
		System.out.println(new Date());
		
	}	
	
	protected void enviarUmaPropaganda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CampanhaDao cd = new CampanhaDao();
		EnviarEmail ee = new EnviarEmail();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String mensagem = cd.findByCode(diaCampanha).getTexto();
		
		ee.enviarUmGmail(nome, email, mensagem);
		
	}
	protected void redirecionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	String nome = request.getParameter("nome");
	session.setAttribute("nome", nome);
	response.sendRedirect("campanhas.jsp");
	//request.getRequestDispatcher("campanhas.jsp").forward(request, response);
	}

}