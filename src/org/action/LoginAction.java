package org.action;
import java.util.*;

import org.tool.Pager;
import org.dao.imp.*;
import org.model.*;

import com.opensymphony.xwork2.*;
public class LoginAction extends ActionSupport{
	private User user;
	private Admin admin;
	protected UserDaoImpl userDaoImpl;
	protected AdminDaoImpl adminDaoImpl;
	public String execute() throws Exception{
		User usr = userDaoImpl.checkUser(user.getName(), user.getPassword());
		if(usr!=null){
			Map session = ActionContext.getContext().getSession();
			session.put("user", usr);
			return "user";
		}else{
			/*
			Admin adm = adminDaoImpl.checkAdmin(admin.getName(), admin.getPassword());
			if(adm!=null){
			Map session = ActionContext.getContext().getSession();
			session.put("admin", adm);
			return "admin";
			}else{*/
				return ERROR;
			//}
		}
	}
	
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user=user;
	}
	public Admin getAdmin(){
		return admin;
	}
	public void setAdmin(Admin admin){
		this.admin=admin;
	}
	public AdminDaoImpl getAdminDaoImpl(){
		return adminDaoImpl;
	}
	public void setAdminDapImpl(AdminDaoImpl adminDaoImpl){
		this.adminDaoImpl=adminDaoImpl;
	}
	public UserDaoImpl getUserDaoImpl(){
		return userDaoImpl;
	}
	public void setUserDaoImpl(UserDaoImpl userDaoImpl){
		this.userDaoImpl=userDaoImpl;
	}
}
