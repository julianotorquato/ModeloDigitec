package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import dominio.Funcionario;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Funcionario funcionario) {
		this.session.save(funcionario);
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		if (funcionario.getPermissao() == null
				|| funcionario.getPermissao().size() == 0) {
			Funcionario funcionarioPermissao = this.carregar(funcionario
					.getCodigo());
			funcionario.setPermissao(funcionarioPermissao.getPermissao());
			this.session.evict(funcionarioPermissao);
		}
		this.session.update(funcionario);

	}

	@Override
	public Funcionario carregar(Integer codigo) {
		return (Funcionario) this.session.get(Funcionario.class, codigo);
	}

	@Override
	public void excluir(Funcionario funcionario) {
		session.delete(funcionario);
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		String hql = "select f from Funcionario f where f.CPF_FUNCIONARIO=:CPF_FUNCIONARIO";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("CPF_FUNCIONARIO", cpf);
		return (Funcionario) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> listar() {
		return session.createCriteria(Funcionario.class).list();
	}

}
