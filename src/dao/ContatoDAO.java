package dao;

import java.util.List;

import dominio.Contato;

public interface ContatoDAO {

	public void salvarOuAtualizar(Contato contato);

	public void excluir(Contato contato);

	public Contato buscarPorNome(String nome);

	public List<Contato> listar();
}
