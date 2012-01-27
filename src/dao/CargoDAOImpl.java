package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dominio.Cargo;

public class CargoDAOImpl implements CargoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Cargo cargo) {
		this.session.save(cargo);

	}

	@Override
	public void atualizar(Cargo cargo) {
		this.session.update(cargo);

	}

	@Override
	public void excluir(Cargo cargo) {
		this.session.delete(cargo);

	}

	@Override
	public Cargo buscaPorDescricao(String descricao) {
		String hql = "select c from Cargo c where cargo.descricao=:descricao";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("descricao", descricao);
		return (Cargo) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> buscaTodosCargos() {
		return this.session.createCriteria(Cargo.class).list();
	}

}
