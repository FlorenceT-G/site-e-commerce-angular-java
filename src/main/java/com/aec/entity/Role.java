package com.aec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int idRole;
	private String labelRole;
	@Column(name="descr")
	private String desc;
	
	public Role(int idRole) {
		super();
		this.idRole = idRole;
	}
	
	public Role() { super(); }

	public int getIdRole() {
		return idRole;
	}
	public String getLabelRole() {
		return labelRole;
	}
	public String getDesc() {
		return desc;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public void setLabelRole(String labelRole) {
		this.labelRole = labelRole;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}