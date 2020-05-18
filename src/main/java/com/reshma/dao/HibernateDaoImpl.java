package com.reshma.dao;


import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reshma.bean.Circle;

@Transactional
@Repository
public class HibernateDaoImpl  {
	
	@Autowired
	private SessionFactory sessionFactory;

	public int getCircleCount() {
		String hql = "select count(*) from Circle";
		Query query = getSession().createQuery(hql);
		return Integer.parseInt(query.uniqueResult().toString());
	}
	
	public Circle saveCircle(Circle c) {
		 getSession().save(c);
		 return c;
		 
	}
	
	public void deleteCirle(int id) {
		Query query = getSession().createQuery("delete from Circle where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession()
	
	{	
		return sessionFactory.getCurrentSession();
	}

	

}
