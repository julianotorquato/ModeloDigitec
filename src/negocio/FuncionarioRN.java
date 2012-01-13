package negocio;

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

	public void salvar(Funcionario funcionario) {
		Integer codigo = funcionario.getCodigo();
		if (codigo == null || codigo == 0) {
			funcionario.getPermissao().add("ROLE_USUARIO");
			this.funcionarioDAO.salvar(funcionario);
		} else {
			this.funcionarioDAO.atualizar(funcionario);
		}
	}

	public void excluir(Funcionario funcionario) {
		this.excluir(funcionario);
	}

	public List<Funcionario> listar() {
		return this.funcionarioDAO.listar();
	}

}
