package com.hibernate.oneclasstwotable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfiguration config = new AnnotationConfiguration().addAnnotatedClass(Customer.class)
				.configure("hibernate.cfg.xml");
//		create() 1st argument is for log files, 2nd argument do you want to run it on database?
//		it connects to the db and generates various tables
		new SchemaExport(config).create(true, true);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Customer alex = new Customer();
		alex.setCustomerName("Alex Rod");
		alex.setCustomerAddress("101 washington st., DC");
		alex.setCreditScore(780);
		alex.setRewardPoints(12000);
		
		session.save(alex);
		session.getTransaction().commit();
	}

}
