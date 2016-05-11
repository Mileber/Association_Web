package org.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.engine.profile.Association;

/**
 * Activity entity. @author MyEclipse Persistence Tools
 */

public class Activity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Association association;
	private String name;
	private String class_;
	private String info;
	private String photo;
	private Timestamp time;
	private Set usertoactivities = new HashSet(0);

	// Constructors

	/** default constructor */
	public Activity() {
	}

	/** minimal constructor */
	public Activity(Association association, String name, String class_,
			String info, Timestamp time) {
		this.association = association;
		this.name = name;
		this.class_ = class_;
		this.info = info;
		this.time = time;
	}

	/** full constructor */
	public Activity(Association association, String name, String class_,
			String info, String photo, Timestamp time, Set usertoactivities) {
		this.association = association;
		this.name = name;
		this.class_ = class_;
		this.info = info;
		this.photo = photo;
		this.time = time;
		this.usertoactivities = usertoactivities;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Association getAssociation() {
		return this.association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Set getUsertoactivities() {
		return this.usertoactivities;
	}

	public void setUsertoactivities(Set usertoactivities) {
		this.usertoactivities = usertoactivities;
	}

}