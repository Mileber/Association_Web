package org.action;

import java.util.List;
import java.util.Map;

import org.dao.imp.UsertoactivityDaoImpl;
import org.dao.imp.UsertoassociationDaoImpl;
import org.model.*;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UsertoassociationAction extends ActionSupport{
	private int pageNow=1;
	private int pageSize=4;
	private Usertoassociation usertoassociation;
	private UsertoassociationDaoImpl usertoassociationDaoImpl;
	private List list;
	private User user;
	private Association association;
	
	public int getPageNow(){
		return pageNow;
	}
	public void setPageNow(int pageNow){
		this.pageNow=pageNow;
	}
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize=pageSize;
	}
	public void setUsertoassociation(Usertoassociation usertoassociation){
		this.usertoassociation=usertoassociation;
	}
	public Usertoassociation getUsertoassociation(){
		return usertoassociation;
	}
	public void setUsertoassociationDaoImpl(UsertoassociationDaoImpl usertoassociationDaoImpl){
		this.usertoassociationDaoImpl=usertoassociationDaoImpl;
	}
	public UsertoassociationDaoImpl getUsertoassociationDaoImpl(){
		return usertoassociationDaoImpl;
	}
	public String selectUsertoassociationByAssociationId() throws Exception{
		Usertoassociation ua = usertoassociationDaoImpl.selectByAssociationId(association.getId());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("usertoassociation", ua);
		return SUCCESS;
	}
	public String selectUsertoassociationByUserId() throws Exception{
		List list=usertoassociationDaoImpl.selectAssociation(user.getId(), pageNow, pageSize);
		Pager page=new Pager(pageNow,usertoassociationDaoImpl.selectAssociationSize(user.getId()));
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	//�û�����
	public String addUsertoassociation() throws Exception{
		Usertoassociation ua = usertoassociationDaoImpl.selectByAssociationId(association.getId());
		if(ua!=null){
			//this.setMessage("��Ѵ���");
			return SUCCESS;
		}
		Usertoassociation u=new Usertoassociation();
		u.setAssociation(association);
		u.setUser(user);
		u.setStatus("ENROLLED");
		//��ʱ��״̬���û��ѱ��������ǹ���Աδ����
		usertoassociationDaoImpl.enrollAssociation(u,user,association);
		//this.setMessage("��ӳɹ�");
		return SUCCESS;
	}
	
	public String agreeUsertoassociation() throws Exception{
		Usertoassociation ua = usertoassociationDaoImpl.selectByUserIdandAssociationId(user.getId(), association.getId());
		if(ua!=null){
			ua.setStatus("AGREED");		/*����Աͬ�ⱨ��*/
			return SUCCESS;
		}
		usertoassociationDaoImpl.updateUsertoassociation(ua);
		//this.setMessage("��ӳɹ�");
		return SUCCESS;
	}
	public String rejectUsertoassociation() throws Exception{
		Usertoassociation ua = usertoassociationDaoImpl.selectByUserIdandAssociationId(user.getId(), association.getId());
		if(ua!=null){
			ua.setStatus("REJECTED");		/*����Աͬ�ⱨ��*/
			return SUCCESS;
		}
		usertoassociationDaoImpl.updateUsertoassociation(ua);
		//this.setMessage("��ӳɹ�");
		return SUCCESS;
	}

}
