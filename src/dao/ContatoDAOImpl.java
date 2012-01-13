package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;

import dominio.Contato;

@Component
public class ContatoDAOImpl implements ContatoDAO {
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvarOuAtualizar(Contato contato) {
		session.saveOrUpdate(contato);

	}

	@Override
	public void excluir(Contato contato) {
		session.delete(contato);

	}

	@Override
	public Contato buscarPorNome(String nome) {
		String hql = "select c from Contato where c.nome =:nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome);
		return (Contato) consulta.uniqueResult();
	}

	@Override
	public List<Contato> listar() {
		return session.createCriteria(Contato.class).list();
	}

}
