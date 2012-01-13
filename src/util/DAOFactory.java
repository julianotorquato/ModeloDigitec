package util;

import dao.ContatoDAO;
import dao.ContatoDAOImpl;
import dao.EventoDAO;
import dao.EventoDAOImpl;

public class DAOFactory {
	public static ContatoDAO criarContatoDAO() {
		ContatoDAOImpl contatoDAO = new ContatoDAOImpl();
		contatoDAO.setSession(HibernateUtil.getSessionFactory()
				.getCurrentSession());
		return contatoDAO;
	}

	public static EventoDAO criarEventoDAO() {
		EventoDAOImpl eventoDAO = new EventoDAOImpl();
		eventoDAO.setSession(HibernateUtil.getSessionFactory()
				.getCurrentSession());

		return eventoDAO;
	}
}
