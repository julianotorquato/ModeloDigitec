package negocio;

import java.util.List;

import util.DAOFactory;
import dao.ContatoDAO;
import dominio.Contato;

public class ContatoRN {

	private final ContatoDAO contatoDAO;

	public ContatoRN() {
		this.contatoDAO = DAOFactory.criarContatoDAO();
	}

	public Contato buscarPorNome(String nome) {
		return this.contatoDAO.buscarPorNome(nome);
	}

	public void salvarOuAtualizar(Contato contato) {
		this.contatoDAO.salvarOuAtualizar(contato);
	}

	public void excluir(Contato contato) {
		this.contatoDAO.excluir(contato);
	}

	public List<Contato> Listar() {
		return this.contatoDAO.listar();
	}
}
