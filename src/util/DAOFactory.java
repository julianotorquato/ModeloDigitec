package util;

import dao.ContatoDAO;
import dao.ContatoDAOImpl;
import dao.EventoDAO;
import dao.EventoDAOImpl;
import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;

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

	public static FuncionarioDAO criarFuncionarioDAO() {
		FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();
		funcionarioDAO.setSession(HibernateUtil.getSessionFactory()
				.getCurrentSession());

		return funcionarioDAO;
	}

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory()
				.getCurrentSession());

		return usuarioDAO;
	}
}
