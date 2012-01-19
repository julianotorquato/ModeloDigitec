package util;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;

public class DAOFactory {

	public static FuncionarioDAO criarFuncionarioDAO() {
		FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();
		funcionarioDAO.setSession(HibernateUtil.getSessionFactory()
				.getCurrentSession());

		return funcionarioDAO;
	}

}
