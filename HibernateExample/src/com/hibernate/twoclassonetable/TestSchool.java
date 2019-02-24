package com.hibernate.twoclassonetable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestSchool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfiguration config = new AnnotationConfiguration().addAnnotatedClass(School.class)
				.configure("hibernate.cfg.xml");
//		create() 1st argument is for log files, 2nd argument do you want to run it on database?
//		it connects to the db and generates various tables
		new SchemaExport(config).create(true, true);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		SchoolDetail annsDetail = new SchoolDetail();
		annsDetail.setPublicSchool(false);
		annsDetail.setSchoolAddress("101 washington, DC");
		annsDetail.setStudentCount(300);
		
		School stanns = new School();
		stanns.setSchoolName("St. Anns School");
		stanns.setSchoolDetail(annsDetail);
		
		session.save(stanns);
		
		session.getTransaction().commit();
	}

}
