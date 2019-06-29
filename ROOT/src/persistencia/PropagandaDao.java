package persistencia;

public class PropagandaDao extends Dao{
	
	public String gravarEmail(String nome, String sobrenome, String email) {
		abrirConexao();
		String retorno = null;
		
		try {
			stmt = con.prepareStatement("select * from propaganda where email = ?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("Email já cadastrado!!");
				retorno = "Email já cadastrado!!";
			}else {
				try {
					
					stmt = con.prepareStatement("insert into propaganda (nome, sobrenome, email, numpropaganda) values (?,?,?,1)");
					stmt.setString(1, nome);
					stmt.setString(2, sobrenome);
					stmt.setString(3, email);
					
					stmt.execute();
					stmt.close();
					
					retorno = "Cadastrado com sucesso!!";
					
				} catch (Exception e) {
					System.out.println("Erro ao salvar email: "+ e.getMessage());
					e.printStackTrace();			
				}
			}
			
			} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
		
	}
	
	
}
