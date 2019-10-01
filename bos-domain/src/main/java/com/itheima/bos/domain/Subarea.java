package com.itheima.bos.domain;
// Generated 2019-9-26 15:05:59 by Hibernate Tools 4.3.5.Final

/**
 * 分区
 * @author 古炫天
 *
 */
public class Subarea implements java.io.Serializable {

	private String id;
	private Decidedzone decidedzone;
	private Region region;//分区对应的区域
	private String addresskey;
	private String startnum;
	private String endnum;
	private Character single;
	private String position;

	public Subarea() {
	}

	public Subarea(String id) {
		this.id = id;
	}

	public Subarea(String id, Decidedzone decidedzone, Region region, String addresskey, String startnum, String endnum,
			Character single, String position) {
		this.id = id;
		this.decidedzone = decidedzone;
		this.region = region;
		this.addresskey = addresskey;
		this.startnum = startnum;
		this.endnum = endnum;
		this.single = single;
		this.position = position;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Decidedzone getDecidedzone() {
		return decidedzone;
	}

	public void setDecidedzone(Decidedzone decidedzone) {
		this.decidedzone = decidedzone;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getAddresskey() {
		return this.addresskey;
	}

	public void setAddresskey(String addresskey) {
		this.addresskey = addresskey;
	}

	public String getStartnum() {
		return this.startnum;
	}

	public void setStartnum(String startnum) {
		this.startnum = startnum;
	}

	public String getEndnum() {
		return this.endnum;
	}

	public void setEndnum(String endnum) {
		this.endnum = endnum;
	}

	public Character getSingle() {
		return this.single;
	}

	public void setSingle(Character single) {
		this.single = single;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
