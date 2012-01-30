package negocio;

import java.util.Date;
import java.util.List;

import util.DAOFactory;
import dao.CargoDAO;
import dominio.Cargo;

public class CargoRN {

	private final CargoDAO cargoDAO;

	public CargoRN() {
		this.cargoDAO = DAOFactory.criarCargoDAO();
	}

	public void salvar(Cargo cargo) {
		cargo.setDataCadastro(new Date());
		this.cargoDAO.salvar(cargo);
	}

	public void atualizar(Cargo cargo) {
		this.cargoDAO.atualizar(cargo);
	}

	public void excluir(Cargo cargo) {
		this.cargoDAO.excluir(cargo);
	}

	public Cargo buscaPorDescricao(String descricao) {
		return this.cargoDAO.buscaPorDescricao(descricao);
	}

	public List<Cargo> buscaTodosCargos() {
		return this.cargoDAO.buscaTodosCargos();
	}

	public List<Cargo> listaDeCargoPorDescricao(String descricao) {
		return this.listaDeCargoPorDescricao(descricao);
	}
}
