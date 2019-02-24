package com.hibernate.onetoonemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);
		config.configure("hibernate.cfg.xml");
//		create() 1st argument is for log files, 2nd argument do you want to run it on database?
//		it connects to the db and generates various tables
		new SchemaExport(config).create(true, true);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		PersonDetail alexDetail = new PersonDetail();
		alexDetail.setZipCode("20815");
		alexDetail.setJob("Accountant");
		alexDetail.setIncome(67245.56);
		
		Person alex = new Person();
		alex.setPersonName("Alex Berry");
		
		alex.setpDetail(alexDetail);
		
		session.save(alex);
		
		session.getTransaction().commit();
	}

}
