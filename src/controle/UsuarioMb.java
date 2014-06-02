package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Usuario;
import dominio.UsuarioDAO;


@ManagedBean
@SessionScoped
public class UsuarioMb {
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public String salvar(){
		usuarioDAO.inserir(usuario);
		return "cadUsuarios";
		}
	

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public UsuarioMb(){
		usuario = new Usuario();
		usuarios = new ArrayList<Usuario>();
	}
		
		
	}
		
		    

    