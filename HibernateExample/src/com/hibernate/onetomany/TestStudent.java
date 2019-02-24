package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestStudent {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(College.class);
		config.addAnnotatedClass(Student.class);
		config.configure("hibernate.cfg.xml");
//		create() 1st argument is for log files, 2nd argument do you want to run it on database?
//		it connects to the db and generates various tables
		new SchemaExport(config).create(true, true);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		College college1 = new College();
		college1.setCollegeName("NewYork College");
		
		Student s1 = new Student();
		s1.setStudentName("Alex Rod");
		
		Student s2 = new Student();
		s2.setStudentName("Linda Berry");
		
		s1.setCollege(college1);
		s2.setCollege(college1);
		
		session.save(college1);
		session.save(s1);
		session.save(s2);
		
		session.getTransaction().commit();
	}

}
