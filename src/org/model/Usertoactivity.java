package org.model;

/**
 * Usertoactivity entity. @author MyEclipse Persistence Tools
 */

public class Usertoactivity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Activity activity;
	private User user;
	private String status;

	// Constructors

	/** default constructor */
	public Usertoactivity() {
	}

	/** full constructor */
	public Usertoactivity(Activity activity, User user, String status) {
		this.activity = activity;
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

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
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