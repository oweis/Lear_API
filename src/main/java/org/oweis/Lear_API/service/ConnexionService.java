package org.oweis.Lear_API.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnexionService {
	static SessionFactory sessionFactory;
	static Session session;
	static Boolean open = false;
	
	public ConnexionService() {	}
	
	public static void openConnexion(){
		 sessionFactory = new Configuration().configure().buildSessionFactory();
		 session = sessionFactory.openSession();
		 session.beginTransaction();
		 open = true;
	}

}
