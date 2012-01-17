package negocio;

import java.util.Date;
import java.util.List;

import util.DAOFactory;
import dao.FuncionarioDAO;
import dominio.Funcionario;

public class FuncionarioRN {

	private final FuncionarioDAO funcionarioDAO;

	public FuncionarioRN() {
		this.funcionarioDAO = DAOFactory.criarFuncionarioDAO();
	}

	public Funcionario buscarPorCpf(String cpf) {
		return this.funcionarioDAO.buscarPorCpf(cpf);
	}

	public void salvarOuAtualizar(Funcionario funcionario) {
		funcionario.setDataCadastro(new Date());
		this.funcionarioDAO.salvarOuAtualizar(funcionario);
	}

	public void excluir(Funcionario funcionario) {
		this.excluir(funcionario);
	}

	public List<Funcionario> listar() {
		return this.funcionarioDAO.listar();
	}

}
