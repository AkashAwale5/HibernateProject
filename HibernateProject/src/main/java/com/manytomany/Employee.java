package com.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	@Column(name = "Emp_Id")
	private int eid;

	@Column(name = "Emp_Name")
	private String name;

	// many to many mapping
	@ManyToMany(mappedBy = "employees")
//	@JoinTable(name="emp_learn", joinColumns = {@JoinColumn(name="eid")}, inverseJoinColumns = {@JoinColumn(name="pid")})
	List<Project> projects;

	
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
