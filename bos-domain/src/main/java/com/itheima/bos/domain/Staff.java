package com.itheima.bos.domain;

import java.util.HashSet;
import java.util.Set;

// Generated 2019-9-26 15:05:59 by Hibernate Tools 4.3.5.Final

/**
 * 取派员
 * @author 古炫天
 *
 */
public class Staff implements java.io.Serializable {

	private String id;
	private String name;
	private String telephone;
	private Character haspda='0';//是否有PDA，1：有，0：无
	private Character deltag='0';//删除标识位，1：已删除，0：未删除
	private String station;
	private String standard;
	private Set decidedzones = new HashSet(0);

	public Staff() {
	}

	public Staff(String id) {
		this.id = id;
	}

	public Staff(String id, String name, String telephone, Character haspda, Character deltag, String station,
			String standard, Set decidedzones) {
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.haspda = haspda;
		this.deltag = deltag;
		this.station = station;
		this.standard = standard;
		this.decidedzones = decidedzones;
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

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Character getHaspda() {
		return this.haspda;
	}

	public void setHaspda(Character haspda) {
		this.haspda = haspda;
	}

	public Character getDeltag() {
		return this.deltag;
	}

	public void setDeltag(Character deltag) {
		this.deltag = deltag;
	}

	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Set getDecidedzones() {
		return decidedzones;
	}

	public void setDecidedzones(Set decidedzones) {
		this.decidedzones = decidedzones;
	}

}
