package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

	protected Connection con;
	protected PreparedStatement stmt;
	protected ResultSet rs;

	protected Connection con2;
	protected PreparedStatement stmt2;
	protected ResultSet rs2;

	public void abrirConexao(){
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste?autoReconnect=true&useSSL=false","root","12345");
			System.out.println("Banco Conextado!!");
			
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void fecharConexao(){
		try {
			con.close();
			System.out.println("Conexão com o BD encerrada!!");
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public void abrirConexao2(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste?autoReconnect=true&useSSL=false","root","12345");
			System.out.println("Banco Conextado!!");
			
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void fecharConexao2(){
		try {
			con2.close();
			System.out.println("Conexão com o BD encerrada!!");
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public void enquete(String opcao, String sou) {
		try {
			abrirConexao();
			stmt = con.prepareStatement("insert into enquete (opcao, sou) values (?,?)");
			stmt.setString(1, opcao);
			stmt.setString(2, sou);
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public Integer contarDestinos() {
		Integer contador = 0;
		Integer a;
		abrirConexao();
		try {
			stmt = con.prepareStatement("select * from propaganda");
			rs = stmt.executeQuery();
			while (rs.next()) {
			contador = contador + 1;	
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
			e.printStackTrace();
		}
		return contador;
	}
	
	public Integer contarEmailsDisparo() {
		Integer contador = 0;
		abrirConexao();
		try {
			stmt = con.prepareStatement("select * from emails");
			rs = stmt.executeQuery();
			while (rs.next()) {
			contador = contador + 1;	
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
			e.printStackTrace();
		}
		return contador;
	}
	
	public String emailRemetente(Integer i) {
		String emailRemetente = null;
		
		abrirConexao();
		
		try {
			System.out.println("Valor do emailRemetente: "+ i);
			stmt = con.prepareStatement("select * from emails where id = ?");
			stmt.setInt(1, i);
			rs = stmt.executeQuery();
			if(rs.next()) {
			emailRemetente = rs.getString("email");
			System.out.println("emailRemente: " + emailRemetente);
			}
			
			stmt.close();
			return emailRemetente;
		} catch (SQLException e) {
			System.out.println("Erro emailRemetente: "+ e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	public String emailDestino(Integer i) {
		String email = "";
		abrirConexao();
		try {
			stmt = con.prepareStatement("select * from propaganda where id = ?");
			stmt.setInt(1, i);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
			email = rs.getString("email");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro emailDestino: "+ e.getMessage());
			e.printStackTrace();
		}
		return email;
	}
	
	public String nomeDestino(Integer i) {
		String nome = "";
		try {
			abrirConexao();
			stmt = con.prepareStatement("select * from propaganda where id = ?");
			stmt.setInt(1, i);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
			nome = rs.getString("nome");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro nomeDestino: "+ e.getMessage());
			e.printStackTrace();
		}
		return nome;
	}
}
