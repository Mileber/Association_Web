package org.action;
import java.util.*;
import java.io.*;
import org.model.*;
import org.tool.*;

import com.opensymphony.xwork2.*;

import org.apache.struts2.*;
import org.dao.imp.*;
public class UserAction extends ActionSupport{
	private User user;
	private UserDaoImpl userDaoImpl;
	private int pageNow=1;
	private int pageSize=4;
	private Association association;
	private UsertoassociationDaoImpl usertoassociationDaoImpl;
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user=user;
	}
	public UserDaoImpl getUserDaoImpl(){
		return userDaoImpl;
	}
	public void setUserDaoImpl(UserDaoImpl userDaoImpl){
		this.userDaoImpl=userDaoImpl;
	}
	public Association getAssociation(){
		return association;
	}
	public void setAssociation(Association association){
		this.association=association;
	}
	
	//�鿴�Լ�������
	public String showUser() throws Exception{
		User u=userDaoImpl.checkUser(user.getName(),user.getPassword());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("user", u);
		return SUCCESS;
	}
	//update-���ڱ༭��������
	public String updateUser() throws Exception{
		User usr = userDaoImpl.checkUser(user.getName(),user.getPassword());
		if(usr==null){
			//this.setMessage("�û�������");
			return SUCCESS;
		}
		User u=new User();
		u.setName(user.getName());
		//u.setPassword(user.getPassword());//��ʱ���ṩ�޸�����
		u.setGender(user.getGender());
		u.setEmail(user.getEmail());
		u.setInfo(user.getInfo());
		u.setPhone(user.getPhone());
		u.setAvatar(user.getAvatar());
		userDaoImpl.updateUser(u);
		//this.setMessage("�޸ĳɹ�");
		return SUCCESS;
	}
	//add-�����û�ע��
	public String addUser() throws Exception{
		User usr = userDaoImpl.checkUser(user.getName(),user.getPassword());
		if(usr!=null){
			//this.setMessage("�û��Ѵ���");
			return SUCCESS;
		}
		User u=new User();
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setGender(user.getGender());
		u.setEmail(user.getEmail());
		u.setInfo(user.getInfo());
		u.setPhone(user.getPhone());
		u.setAvatar(user.getAvatar());
		userDaoImpl.addUser(u);
		//this.setMessage("��ӳɹ�");
		return SUCCESS;
	}
	////////////////////��Ҫ�޸�
	/*public String selectAllUser() throws Exception{
		List list=userDaoImpl.selectallUserByTime(pageNow, pageSize);
		Pager page=new Pager(pageNow,userDaoImpl.selectallUserSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}*/
	
}
