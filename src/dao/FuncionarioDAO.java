package dao;

import java.util.List;

import dominio.Funcionario;

public interface FuncionarioDAO {

	public void salvar(Funcionario funcionario);

	public void atualizar(Funcionario funcionario);

	public void excluir(Funcionario funcionario);

	public Funcionario buscarPorCpf(String cpf);

	public List<Funcionario> listar();

	public Funcionario carregar(Integer codigo);
}
