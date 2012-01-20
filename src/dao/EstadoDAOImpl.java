package dao;

import java.util.List;

import org.hibernate.classic.Session;

import dominio.Estado;

public class EstadoDAOImpl implements EstadoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> buscaTodosEstados() {
		return this.session.createCriteria(Estado.class).list();
	}

}
