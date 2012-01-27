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

	public List<Cidade> getCidadePorEstado(Integer codigo) {
		return this.cidadeDAO.getCidadePorEstado(codigo);
	}

	public List<Cidade> buscaTodasCidades() {
		return this.cidadeDAO.buscaTodasCidades();
	}

	public Cidade recuperaCodigoCidade(Integer codigo) {
		return this.cidadeDAO.recuperaCodigoCidade(codigo);
	}
}
