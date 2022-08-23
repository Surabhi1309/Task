package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	
	@Column(name = "EmpId")
	private Integer empId;
	
	@Column(name = "EmpName")
	private String empName;


	@Column(name = "Password")
	private String password;

	//@OneToOne
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AssetId")
	private Asset asset;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, Integer empId, String password, Asset asset) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.password = password;
		this.asset = asset;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", password=" + password
				+ ", asset=" + asset + "]";
	}

}
