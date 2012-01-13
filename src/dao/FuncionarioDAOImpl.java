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
		session.save(funcionario);
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		session.update(funcionario);

	}

	@Override
	public void excluir(Funcionario funcionario) {
		session.delete(funcionario);
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		String hql = "select f from Funcionario where f.cpf:=cpf";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("cpf", cpf);
		return (Funcionario) consulta.uniqueResult();
	}

	@Override
	public List<Funcionario> listar() {
		return session.createCriteria(Funcionario.class).list();
	}

}
