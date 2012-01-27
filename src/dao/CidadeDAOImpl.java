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
		String hql = "from Cidade c where c.estado.codigo=:codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", estado.getCodigo());
		return consulta.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> getCidadePorEstado(Integer codigo) {
		Query query = this.session.createQuery("select c from "
				+ Cidade.class.getName()
				+ " as c where c.estado.codigo=:codigo");
		query.setParameter("codigo", codigo);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> buscaTodasCidades() {
		return this.session.createCriteria(Cidade.class).list();
	}

	@Override
	public Cidade recuperaCodigoCidade(Integer codigo) {
		Query query = this.session
				.createQuery("select c from Cidade c where cidade.codigo=:codigo");
		query.setParameter("codigo", codigo);

		return (Cidade) query.uniqueResult();
	}

}
