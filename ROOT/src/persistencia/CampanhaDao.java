package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidade.Campanha;

public class CampanhaDao extends Dao{
	
	public void gravarCampanha(String nome, String texto) {
		abrirConexao();
		
		try {
			
			stmt = con.prepareStatement("insert into campanhas (nome, texto) values (?,?)");
			stmt.setString(1, nome);
			stmt.setString(2, texto);
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao salvar Campanha: "+ e.getMessage());
			e.printStackTrace();			
		}
		
	}
	
	public void atualizarCampanha(String nome, String texto, Integer id) {
		abrirConexao();
		
		try {
			
			stmt = con.prepareStatement("update campanhas set nome=? , texto=? where id = ?");
			stmt.setString(1, nome);
			stmt.setString(2, texto);
			stmt.setInt(3, id);
			stmt.execute();
			stmt.close();
			System.out.println("Atualizado com sucesso!!");
			fecharConexao();
		
		} catch (Exception e) {
			System.out.println("Erro ao atualizar Campanha: "+ e.getMessage());
			e.printStackTrace();
			fecharConexao();
		}
		
	}
	
	public List consultarCampanhas() {
		List lista = new ArrayList();
		
		try {
			
			abrirConexao();
			stmt = con.prepareStatement("select * from campanhas");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Campanha c = new Campanha();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setTexto(rs.getString("texto"));
			
				lista.add(c);
				System.out.println(c);
			}
			
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}

	public Campanha findByCode(Integer a){
		Campanha c = new Campanha();
		try {
			abrirConexao();
			stmt = con.prepareStatement("select * from campanhas where id= ?");
			stmt.setInt(1, a);
			rs = stmt.executeQuery();
			if(rs.next()){
				 c.setId(rs.getInt("id"));
				 c.setNome(rs.getString("nome"));
				 c.setTexto(rs.getString("texto"));
			}
			
			stmt.close();
			fecharConexao();
			
			return c;
			
		} catch (Exception e) {
			System.out.println("Erro em findByCode - CampanhaDao");
			System.out.println("Erro: "+ e.getMessage());
			e.printStackTrace();
			return null;
		}
			
		}


}
