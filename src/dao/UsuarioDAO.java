package dao;

import java.util.List;

import dominio.Usuario;

public interface UsuarioDAO {
	public void salvar(Usuario usuario);

	public void atualizar(Usuario usuario);

	public void excluir(Usuario usuario);

	public Usuario buscarPorLogin(String login);

	public Usuario carregar(Integer codigo);

	public List<Usuario> listar();

}
