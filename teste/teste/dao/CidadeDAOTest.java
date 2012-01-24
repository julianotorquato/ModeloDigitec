package teste.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import dao.EstadoDAOImpl;

public class CidadeDAOTest {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		SessionFactory sessionFactory;

		AnnotationConfiguration cfg = new AnnotationConfiguration()
				.configure("hibernate.cfg.xml");
		System.out.println("hibernate.cfg.xml Encontrado");
		sessionFactory = cfg.buildSessionFactory();

		EstadoDAOImpl estadoDO = new EstadoDAOImpl();

		System.out.println(estadoDO.buscaTodosEstados());

	}
}
