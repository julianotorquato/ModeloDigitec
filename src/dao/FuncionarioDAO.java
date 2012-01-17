package dao;

import java.util.List;

import dominio.Funcionario;

public interface FuncionarioDAO {

	public void salvarOuAtualizar(Funcionario funcionario);

	public void excluir(Funcionario funcionario);

	public Funcionario buscarPorCpf(String cpf);

	public List<Funcionario> listar();
}
