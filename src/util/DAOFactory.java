package util;

import dao.CidadeDAO;
import dao.CidadeDAOImpl;
import dao.EstadoDAO;
import dao.EstadoDAOImpl;
import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;

public class DAOFactory {

	public static FuncionarioDAO criarFuncionarioDAO() {
		FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();
		funcionarioDAO.setSession(HibernateUtil.getSessionFactory()
				.getCurrentSession());

		return funcionarioDAO;
	}

	public static CidadeDAO criarCidadeDAO() {
		CidadeDAOImpl cidadeDAO = new CidadeDAOImpl();
		cidadeDAO.setSession(HibernateUtil.getSessionFactory()
				.getCurrentSession());

		return cidadeDAO;
	}

	public static EstadoDAO criarEstadoDAO() {
		EstadoDAOImpl estadoDAO = new EstadoDAOImpl();
		estadoDAO.setSession(HibernateUtil.getSessionFactory()
				.getCurrentSession());

		return estadoDAO;
	}
}
