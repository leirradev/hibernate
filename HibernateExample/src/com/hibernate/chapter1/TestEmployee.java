package com.hibernate.chapter1;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfiguration config = new AnnotationConfiguration().addAnnotatedClass(Employee.class)
				.configure("hibernate.cfg.xml");
//		create() 1st argument for log files, 2nd argument do you want to run it on database
//		it connects to the db and generates various tables
		new SchemaExport(config).create(true, true);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		{
			Employee emp = new Employee();
//		emp.setEmpId(100);
			emp.setEmpName("Alex Berry");
			emp.setEmpEmailAddress("alex@hibernate.com");
			emp.setEmpPassword("alexpass");
			emp.setPermanent(true);
			emp.setEmpJoinDate(new GregorianCalendar(2009, 05, 26));
			emp.setEmpLoginTime(Date.valueOf("2010-06-05"));
			session.save(emp);
		}
		{
			Employee emp2 = new Employee();
			emp2.setEmpName("Linda Chase");
			emp2.setEmpEmailAddress("linda@hibernate.com");
			emp2.setEmpPassword("lindapass");
			emp2.setPermanent(true);
			emp2.setEmpJoinDate(new GregorianCalendar(2008, 04, 20));
			emp2.setEmpLoginTime(new java.util.Date());
			session.save(emp2);
		}
		{
			Employee emp3 = new Employee();
			emp3.setEmpName("Bryan Go");
			emp3.setEmpEmailAddress("bryan@hibernate.com");
			emp3.setEmpPassword("bryanpass");
			emp3.setPermanent(true);
			emp3.setEmpJoinDate(new GregorianCalendar(2005, 04, 12));
			emp3.setEmpLoginTime(new java.util.Date());
			session.save(emp3);
		}
		{
			Employee emp4 = new Employee();
			emp4.setEmpName("Sara Brown");
			emp4.setEmpEmailAddress("Sara@hibernate.com");
			emp4.setEmpPassword("Sarapass");
			emp4.setPermanent(false);
			emp4.setEmpJoinDate(new GregorianCalendar(2005, 03, 12));
			emp4.setEmpLoginTime(Date.valueOf("2010-06-02"));
			session.save(emp4);
		}
		session.getTransaction().commit();
	}

}
