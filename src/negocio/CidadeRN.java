package negocio;

import java.util.List;

import util.DAOFactory;
import dao.CidadeDAO;
import dominio.Cidade;
import dominio.Estado;

public class CidadeRN {

	private final CidadeDAO cidadeDAO;

	public CidadeRN() {
		this.cidadeDAO = DAOFactory.criarCidadeDAO();
	}

	public List<Cidade> buscarPorCidade(Estado estado) {
		return this.cidadeDAO.buscarCidadePorEstado(estado);
	}
}
