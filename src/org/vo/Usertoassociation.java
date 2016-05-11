package org.vo;

/**
 * Usertoassociation entity. @author MyEclipse Persistence Tools
 */

public class Usertoassociation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Association association;
	private User user;
	private String status;

	// Constructors

	/** default constructor */
	public Usertoassociation() {
	}

	/** full constructor */
	public Usertoassociation(Association association, User user, String status) {
		this.association = association;
		this.user = user;
		this.status = status;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}