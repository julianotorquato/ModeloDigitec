package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import dominio.Cidade;
import dominio.Estado;

public class CidadeDAOImpl implements CidadeDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> buscarCidadePorEstado(Estado estado) {
		String hql = "from Cidade c where c.estado.FK_ID_ESTADO =:ID_ESTADO";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("ID_ESTADO", estado.getSigla());

		return consulta.list();
	}

}
