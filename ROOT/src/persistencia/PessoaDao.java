package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidade.Consolidador;
import entidade.Login;

public class PessoaDao extends Dao{
	
	public void gravar(String nome, Integer idade, String aniversario, String tribo, String batizado, String email, String telefone, String retiro, String quandoRetiro, String quantoTempoConsolidacao, String servos){
		abrirConexao();
		Consolidador p = new Consolidador();
		p.setNome(nome);
		p.setIdade(idade);
		p.setAniversario(aniversario);
		p.setTribo(tribo);
		p.setBatizado(batizado);
		p.setEmail(email);
		p.setTelefone(telefone);
		p.setRetiro(retiro);
		p.setQuandoRetiro(quandoRetiro);
		p.setQuantoTempoConsolidacao(quantoTempoConsolidacao);
		p.setServos(servos);		
		
		
		try {
			
			stmt = con.prepareStatement("insert into consolidar (nome, idade, aniversario, tribo, batizado, email, telefone, retiro, quandoretiro, quantotempoconsolidacao, servos) values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, p.getNome());
			stmt.setInt(2, p.getIdade());
			stmt.setString(3, p.getAniversario());
			stmt.setString(4, p.getTribo());
			stmt.setString(5, p.getBatizado());
			stmt.setString(6, p.getEmail());
			stmt.setString(7, p.getTelefone());
			stmt.setString(8, p.getRetiro());
			stmt.setString(9, p.getQuandoRetiro());
			stmt.setString(10, p.getQuantoTempoConsolidacao());
			stmt.setString(11, p.getServos());
			stmt.execute();
			stmt.close();
			
			System.out.println("Dados salvos com sucesso!!");
			
		} catch (Exception e) {
			
			System.out.println("Erro: "+ e.getMessage());
			e.printStackTrace();
		}
		
		fecharConexao();
		
	}


	public Consolidador findByCode(String cod) throws Exception{		
		abrirConexao();
			stmt = con.prepareStatement("select * from consolidar where id = ?");
			stmt.setString(1, cod);	
			rs = stmt.executeQuery();	
				Consolidador p = new Consolidador();
				
			if(rs.next()){
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setIdade(rs.getInt("idade"));
				p.setAniversario(rs.getString("aniversario"));
				p.setTribo(rs.getString("tribo"));
				p.setBatizado(rs.getString("batizado"));
				p.setEmail(rs.getString("email"));
				p.setTelefone(rs.getString("telefone"));
				p.setRetiro(rs.getString("retiro"));
				p.setQuandoRetiro(rs.getString("quandoretiro"));
				p.setQuantoTempoConsolidacao(rs.getString("quantotempoconsolidacao"));
				p.setServos(rs.getString("servos"));
				
			}
			stmt.close();
			fecharConexao();
			

		return p;
	

			
		/*stmt.setString(1, a);
		stmt.executeQuery();
		
		p.setId(rs.getInt("id"));
		p.setNome(rs.getString("nome"));
		p.setEndereco(rs.getString("endereco"));
		p.setStatus(rs.getString("status"));
		p.setEmpresa(rs.getString("empresa"));
		
		
		stmt.close();

		return p; fechar o coment√°rio ////////
		*/
}

	
	public List consultarTodos() throws Exception{
		
		List lista = new ArrayList();
		
		try {
			
			abrirConexao();
			stmt = con.prepareStatement("select * from consolidar");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Consolidador p = new Consolidador();
							
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome").toUpperCase());
				p.setIdade(rs.getInt("idade"));
				p.setAniversario(rs.getString("aniversario"));
				p.setTribo(rs.getString("tribo"));
				p.setBatizado(rs.getString("batizado"));
				p.setEmail(rs.getString("email"));
				p.setTelefone(rs.getString("telefone"));
				p.setRetiro(rs.getString("retiro"));
				p.setQuandoRetiro(rs.getString("quandoretiro"));
				p.setQuantoTempoConsolidacao(rs.getString("quantotempoconsolidacao"));
				p.setServos(rs.getString("servos"));
				lista.add(p);
				System.out.println(p);
			}
			
			stmt.close();
			fecharConexao();
			
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	public void alterar(Integer id, String nome, Integer idade, String aniversario, String tribo, String batizado, String email, String telefone, String retiro, String quandoretiro, String quantotempoconsolidacao, String servos){
		try {
			abrirConexao();
			
			stmt = con.prepareStatement("update consolidar set nome=?, idade=?, aniversario=?, tribo=?, batizado=?, email=?, telefone=?, retiro=?, quandoretiro=?, quantotempoconsolidacao=?, servos=?  where id=?");
			
			stmt.setString(1, nome);
			stmt.setInt(2, idade);
			stmt.setString(3, aniversario);
			stmt.setString(4, tribo);
			stmt.setString(5, batizado);
			stmt.setString(6, email );
			stmt.setString(7,  telefone);
			stmt.setString(8, retiro);
			stmt.setString(9, quandoretiro);
			stmt.setString(10, quantotempoconsolidacao);
			stmt.setString(11, servos);
			stmt.setInt(12, id);
				
			stmt.execute();
			stmt.close();
			fecharConexao();
			
			System.out.println("Alterado com sucesso!!");
			
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Login logar(String a, String b){
		Login login = null;
		
		try {
			
			abrirConexao();
			stmt = con.prepareStatement("select * from login where usuario= ? and senha= ?");
			stmt.setString(1, a);
			stmt.setString(2, b);
			rs = stmt.executeQuery();
			login = new Login();
			
			if(rs.next()){
				
					login.setId(rs.getInt("id"));
					login.setNome(rs.getString("usuario"));
					login.setSenha(rs.getString("senha"));
					login.setEmail(rs.getString("email"));
					login.setAdmin(rs.getString("admin"));
					
					
					stmt.close();
					fecharConexao();
					System.out.println("** PESSOADAO - LOGAR - IF **\n");
					System.out.println("Usu·rio "+login.getNome()+" acessado.");
					System.out.println(login);
					System.out.println("\n** PESSOADAO - LOGAR -IF **\n");
			}else {
				System.out.println("\n** PESSOADAO - LOGAR - ELSE**\n");
				System.out.println("N√O TROUXE NADA NO SELECT!!");
				System.out.println("\n** PESSOADAO - LOGAR - ELSE**\n");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		fecharConexao();
		return login;
	
	}

public String PesquisarNomeLogin(String a){
	try {
		
		abrirConexao();
		stmt = con.prepareStatement("select email from login where usuario= ?");
		stmt.setString(1, a);
		rs = stmt.executeQuery();
		String email = null;
		if(rs.next()){
			 email = rs.getString("email");
			System.out.println(email);
		}
		
		stmt = con.prepareStatement("select nome from consolidar where email= ?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		String nome = null;
		if(rs.next()){
			 nome = rs.getString("nome");
			System.out.println(nome);
		}
		
		stmt.close();
		fecharConexao();
		
		return nome;
		
	} catch (Exception e) {
		System.out.println("Erro em PesquisarNomeLogin");
		System.out.println("Erro: "+ e.getMessage());
		e.printStackTrace();
		return null;
	}
		
	}

	
	public void excluir(Integer x){
		try {
			abrirConexao();
			stmt = con.prepareStatement("delete from pessoa where id = ?");
			stmt.setInt(1, x);
			stmt.execute();
			stmt.close();
			fecharConexao();
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
			e.printStackTrace();
		}
		
	}
		
}
