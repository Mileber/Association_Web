package org.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String gender;
	private String email;
	private String phone;
	private String password;
	private String avatar;
	private String info;
	private Set usertoassociations = new HashSet(0);
	private Set usertoactivities = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public User(String name, String gender, String email, String phone,
			String password, String avatar, String info,
			Set usertoassociations, Set usertoactivities) {
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.avatar = avatar;
		this.info = info;
		this.usertoassociations = usertoassociations;
		this.usertoactivities = usertoactivities;
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

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set getUsertoassociations() {
		return this.usertoassociations;
	}

	public void setUsertoassociations(Set usertoassociations) {
		this.usertoassociations = usertoassociations;
	}

	public Set getUsertoactivities() {
		return this.usertoactivities;
	}

	public void setUsertoactivities(Set usertoactivities) {
		this.usertoactivities = usertoactivities;
	}

}