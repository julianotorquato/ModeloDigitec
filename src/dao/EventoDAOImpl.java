package dao;

import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;

import dominio.Evento;

@Component
public class EventoDAOImpl implements EventoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvarOuAtualizar(Evento evento) {
		session.saveOrUpdate(evento);

	}

}
