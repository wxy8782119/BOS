package com.itheima.bos.domain;

import java.util.HashSet;
import java.util.Set;

// Generated 2019-9-26 15:05:59 by Hibernate Tools 4.3.5.Final

/**
 * 定区
 * @author 古炫天
 *
 */
public class Decidedzone implements java.io.Serializable {

	private String id;
	private String name;
	private Staff staff;
	private Set subareas = new HashSet(0);

	public Decidedzone() {
	}

	public Decidedzone(String id) {
		this.id = id;
	}

	public Decidedzone(String id, String name, Staff staff, Set subareas) {
		this.id = id;
		this.name = name;
		this.staff = staff;
		this.subareas = subareas;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Set getSubareas() {
		return subareas;
	}

	public void setSubareas(Set subareas) {
		this.subareas = subareas;
	}
	
}
