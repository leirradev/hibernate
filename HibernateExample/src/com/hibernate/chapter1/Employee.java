package com.hibernate.chapter1;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//java bean rules: should be private datatype and has getters & setters; has no-arg constructor; serializable
//difference between jpa annotation and hibernate annotation; 
//hibernate annotation - if changed to different orm, annotations needs to change everything
//jpa annotation (javax.persistence) - sun java standard; if changed to different orm, annotations doesnt need to be change
@Entity
@Table(name="EmployeeInfo")
public class Employee {
//primary @Id should set at the top of object or getter
//@Id represents unique primary key
	private int empId;
	private String empName;

	private String empPassword, empEmailAddress;
	private boolean isPermanent;
	private Calendar empJoinDate;
	private Date empLoginTime;
	
	@Id
	@TableGenerator(name="empid", table="emppktb", pkColumnName="empkey", pkColumnValue="empvalue"
	, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="empid")
	@Column(name="EmployeeID")
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	// @transient annotation doesnt persist the object in the database
	@Transient
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	
	@Column(nullable=false)
	public String getEmpEmailAddress() {
		return empEmailAddress;
	}
	public void setEmpEmailAddress(String empEmailAddress) {
		this.empEmailAddress = empEmailAddress;
	}
	
	@Basic
	public boolean isPermanent() {
		return isPermanent;
	}
	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}
	
	@Temporal(TemporalType.DATE)
	public Calendar getEmpJoinDate() {
		return empJoinDate;
	}
	public void setEmpJoinDate(Calendar empJoinDate) {
		this.empJoinDate = empJoinDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEmpLoginTime() {
		return empLoginTime;
	}
	public void setEmpLoginTime(Date empLoginTime) {
		this.empLoginTime = empLoginTime;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
