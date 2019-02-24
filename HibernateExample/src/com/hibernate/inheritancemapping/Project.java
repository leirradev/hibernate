package com.hibernate.inheritancemapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//three types of inheritance: single table(default), joined(doesnt repeat the data), table per class
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Project {

	private int projectId;
	private String projectName;
	
	@Id
	@GeneratedValue
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
