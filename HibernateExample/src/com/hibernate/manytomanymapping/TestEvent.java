package com.hibernate.manytomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Event.class);
		config.addAnnotatedClass(Delegate.class);
		config.configure("hibernate.cfg.xml");
//		create() 1st argument is for log files, 2nd argument do you want to run it on database?
//		it connects to the db and generates various tables
		new SchemaExport(config).create(true, true);
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	
		Delegate delegate = new Delegate();
		delegate.setDelegateName("Alex Rod");
		
		Delegate delegate2 = new Delegate();
		delegate2.setDelegateName("Linda Berry");
		
		Delegate delegate3 = new Delegate();
		delegate3.setDelegateName("John Doe");
		
		Delegate delegate4 = new Delegate();
		delegate4.setDelegateName("James Dean");
		
		Event java101 = new Event();
		java101.setEventName("Java - 101");
		
		Event cplus101 = new Event();
		cplus101.setEventName("C++ - 101");
		
		Event math101 = new Event();
		math101.setEventName("Math - 101");
		
		java101.getDelegates().add(delegate);
		java101.getDelegates().add(delegate2);
		java101.getDelegates().add(delegate3);
		
		cplus101.getDelegates().add(delegate2);
		cplus101.getDelegates().add(delegate3);
		
		math101.getDelegates().add(delegate4);
		
		session.save(delegate);
		session.save(delegate2);
		session.save(delegate3);
		session.save(delegate4);
		session.save(java101);
		session.save(cplus101);
		session.save(math101);
		
		session.getTransaction().commit();
	}

}
