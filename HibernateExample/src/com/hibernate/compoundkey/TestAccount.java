package com.hibernate.compoundkey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfiguration config = new AnnotationConfiguration().addAnnotatedClass(Accounts.class)
				.configure("hibernate.cfg.xml");
//		create() 1st argument is for log files, 2nd argument do you want to run it on database?
//		it connects to the db and generates various tables
		new SchemaExport(config).create(true, true);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		CompoundKey key1 = new CompoundKey(100, 10001);
		Accounts savings = new Accounts();
		savings.setCompoundKey(key1);
		savings.setAccountBalance(8500);
		
		CompoundKey key2 = new CompoundKey(100, 20001);
		Accounts checking = new Accounts();
		checking.setCompoundKey(key2);
		checking.setAccountBalance(2500);
		
		session.save(savings);
		session.save(checking);
		
		session.getTransaction().commit();
	}

}
