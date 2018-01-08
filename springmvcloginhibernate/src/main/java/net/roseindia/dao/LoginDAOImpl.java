package net.roseindia.dao;

/*
@Author: Deepak Kumar
Check more tutorials at http://www.roseindia.net
*/
import net.roseindia.model.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import java.util.List;

@Repository("loginDAO")
@Transactional
public class LoginDAOImpl implements LoginDAO {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public boolean checkLogin(String userName, String userPassword) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		// Query using Hibernate Query Language
		// String SQL_QUERY =" from Users as o where o.userName=? and
		// o.userPassword=?";
		String SQL_QUERY = " from Registrations as o where o.userName=? and o.userPassword=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userName);
		query.setParameter(1, userPassword);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}

		session.close();
		return userFound;
	}

	public List<Registrations> isAdmin(String userName) {
		System.out.println("In isAdmin method");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		String SQL_QUERY = " from Registrations as o where o.userName=? and o.role=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userName);
		query.setParameter(1, "Admin");
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}
		List<Registrations> list1 = null;
		if (userFound) {
			String SQL_QUERY1 = " from Registrations as o where o.role=?";
			Query query1 = session.createQuery(SQL_QUERY1);
			query1.setParameter(0, "Employee");
			list1 = (List<Registrations>) query1.list();
			for (Registrations model : list1) {
				System.out.println("uname : " + model.getUserName());
			}

		}
		session.close();
		return list1;

	}

}