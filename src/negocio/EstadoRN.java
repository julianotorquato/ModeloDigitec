package negocio;

import java.util.List;

import util.DAOFactory;
import dao.EstadoDAO;
import dominio.Estado;

public class EstadoRN {

	private final EstadoDAO estadoDAO;

	public EstadoRN() {
		this.estadoDAO = DAOFactory.criarEstadoDAO();
	}

	public List<Estado> buscaTodosEstados() {
		return this.estadoDAO.buscaTodosEstados();
	}
}
