package dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

public class UsuarioDAO {
	
	private  Connection con;
	
	public UsuarioDAO(){
		con = Conexao.conecta();
	}
	
//	public static void main(String[] args) {
//	Usuario usuario = new Usuario();
//	usuario.setLogin("log");
//	usuario.setSenha("123");
//	usuario.setNome("joo");
//	new UsuarioDAO().inserir(usuario);
//	}
	
	public void inserir(Usuario usuario){
		String sql = "insert into tb_usuario (nome, login, senha)" + "values(?,?,?)";
			
		
		try{
			
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1,usuario.getNome());
		stmt.setString(2,usuario.getLogin());
		stmt.setString(3,usuario.getSenha());
		
		stmt.execute();
		System.out.println("Usuario inserido com sucesso!");
		
		
			stmt.close();
		con.close();
		
				
	} catch (SQLException ex) {
		System.err.println("Falha ao inserir usuario!");
		throw new RuntimeException(ex);
	}
            

	}
	
	public List<Usuario> select(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM tb_usuario";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			while (res.next()){
				//criando o objeto pessoa
				Usuario usuario = new Usuario();
				usuario.setNome(res.getString("nome"));
				usuario.setLogin(res.getString("login"));
				usuario.setSenha(res.getString("senha"));
				
				usuarios.add(usuario);
			}
			
			stmt.close();
			con.close();
			
			return usuarios;
			
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		
		
		
	}

	public void update(Usuario usuario){
		String sql = "UPDATE usuario set nome=?, login=?, senha=? where login=?";
		try {
		
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			
			stmt.execute();
			stmt.close();
			con.close();
			
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		
		
		 
		
	}
	
	
	public void remover (Usuario usuario){
		String sql = "DELETE from tb_usuario where login=?";
		
		try {
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, usuario.getLogin());
			
			stmt.execute();
			System.out.println("Usuario excluido com sucesso!");
			stmt.close();
			con.close();
			
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	
}
