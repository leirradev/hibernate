package com.hibernate.inheritancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.compoundkey.Accounts;

public class TestInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Accounts.class);
		config.addAnnotatedClass(Module.class);
		config.addAnnotatedClass(Task.class);
		config.configure("hibernate.cfg.xml");
//		create() 1st argument is for log files, 2nd argument do you want to run it on database?
//		it connects to the db and generates various tables
		new SchemaExport(config).create(true, true);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Project p = new Project();
		p.setProjectName("Hibernate Lessons");
		
		Module m = new Module();
		m.setProjectName("Spring Lessons");
		m.setModuleName("AOP");
		
		Task t = new Task();
 	    t.setProjectName("Java Lessons");
		t.setModuleName("Collections");
		t.setTaskName("ArrayList");
		
		session.save(p);
		session.save(m);
		session.save(t);
		
		session.getTransaction().commit();
	}

}
