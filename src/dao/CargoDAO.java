package dao;

import java.util.List;

import dominio.Cargo;

public interface CargoDAO {

	public void salvar(Cargo cargo);

	public void atualizar(Cargo cargo);

	public void excluir(Cargo cargo);

	public Cargo buscaPorDescricao(String descricao);

	public List<Cargo> listaDeCargoPorDescricao(String descricao);

	public List<Cargo> buscaTodosCargos();
}
