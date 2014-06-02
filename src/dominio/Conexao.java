package dominio;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static void main(String[] args) {
		Conexao.conecta();
	}

	
	
	

	public static Connection conecta() {
		Connection conectaB = null;
		try {
			String url = "jdbc:mysql://localhost:3306/siet";
			String usuario = "root";
			String senha = "123456";
			Class.forName("com.mysql.jdbc.Driver");
			conectaB = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Banco acessado!");
		} catch (Exception ex) {
			System.out.println("Falha na conex�o  " + ex.getMessage());
		}
		return conectaB;

	}
}
