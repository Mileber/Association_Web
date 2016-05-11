package org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Association entity. @author MyEclipse Persistence Tools
 */

public class Association implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer number;
	private String leader;
	private String class_;
	private String logo;
	private String info;
	private Integer favor;
	private Set activities = new HashSet(0);
	private Set admins = new HashSet(0);
	private Set usertoassociations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Association() {
	}

	/** minimal constructor */
	public Association(String name, Integer number, String leader,
			String class_, Integer favor) {
		this.name = name;
		this.number = number;
		this.leader = leader;
		this.class_ = class_;
		this.favor = favor;
	}

	/** full constructor */
	public Association(String name, Integer number, String leader,
			String class_, String logo, String info, Integer favor,
			Set activities, Set admins, Set usertoassociations) {
		this.name = name;
		this.number = number;
		this.leader = leader;
		this.class_ = class_;
		this.logo = logo;
		this.info = info;
		this.favor = favor;
		this.activities = activities;
		this.admins = admins;
		this.usertoassociations = usertoassociations;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getLeader() {
		return this.leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getFavor() {
		return this.favor;
	}

	public void setFavor(Integer favor) {
		this.favor = favor;
	}

	public Set getActivities() {
		return this.activities;
	}

	public void setActivities(Set activities) {
		this.activities = activities;
	}

	public Set getAdmins() {
		return this.admins;
	}

	public void setAdmins(Set admins) {
		this.admins = admins;
	}

	public Set getUsertoassociations() {
		return this.usertoassociations;
	}

	public void setUsertoassociations(Set usertoassociations) {
		this.usertoassociations = usertoassociations;
	}

}