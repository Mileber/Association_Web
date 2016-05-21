package org.action;
import java.util.*;
import java.io.*;
import org.model.*;
import org.tool.*;

import com.opensymphony.xwork2.*;

import org.apache.struts2.*;
import org.dao.imp.*;
public class AdminAction extends ActionSupport{
	private Admin admin;
	private AdminDaoImpl adminDaoImpl;
	private int pageNow=1;
	private int pageSize=4;
	private Association association;
	public Admin getAdmin(){
		return admin;
	}
	public void setAdmin(Admin admin){
		this.admin=admin;
	}
	public AdminDaoImpl getAdminDaoImpl(){
		return adminDaoImpl;
	}
	public void setAdminDaoImpl(AdminDaoImpl adminDaoImpl){
		this.adminDaoImpl=adminDaoImpl;
	}
	public Association getAssociation(){
		return association;
	}
	public void setAssociation(Association association){
		this.association=association;
	}
	//update
	public String updateAdmin() throws Exception{
		Admin adm = adminDaoImpl.checkAdmin(admin.getName(),admin.getPassword());
		if(adm==null){
			//this.setMessage("用户不存在");
			return SUCCESS;
		}
		Admin a=new Admin();
		a.setName(admin.getName());
		//a.setPassword(admin.getPassword());
		a.setEmail(admin.getEmail());
		a.setPhone(admin.getPhone());
		adminDaoImpl.updateAdmin(a);
		//this.setMessage("修改成功");
		return SUCCESS;
	}
	//add
	public String addAdmin() throws Exception{
		Admin adm = adminDaoImpl.checkAdmin(admin.getName(),admin.getPassword());
		if(adm!=null){
			//this.setMessage("用户已存在");
			return SUCCESS;
		}
		Admin a=new Admin();
		a.setName(admin.getName());
		a.setPassword(admin.getPassword());
		a.setEmail(admin.getEmail());
		a.setPhone(admin.getPhone());
		a.setAssociation(admin.getAssociation());
		adminDaoImpl.addAdmin(a);
		//this.setMessage("修改成功");
		return SUCCESS;
	}
	/*public String selectAllAdmin() throws Exception{
		List list=AdminDaoImpl.selectAdminByTime(pageNow, pageSize);
		Pager page=new Pager(pageNow,AdminDaoImpl.selectActivitySize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}*/
}
