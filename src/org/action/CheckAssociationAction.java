package org.action;

import java.io.*;
import java.util.*;

import org.tool.Pager;
import org.dao.imp.*;
import org.model.*;
import com.opensymphony.xwork2.*;

public class CheckAssociationAction extends ActionSupport{
	private int pageNow=1;
	private int pageSize=4;
	private List list;
	private Association association;
	private AssociationDaoImpl associationDaoImpl;
	
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
	public Association getAssociation(){
		return association;
	}
	public void setAssociation(Association association){
		this.association=association;
	}
	public AssociationDaoImpl getAssociationDaoImpl(){
		return associationDaoImpl;
	}
	public void setAssociationDaoImpl(AssociationDaoImpl associationDaoImpl){
		this.associationDaoImpl=associationDaoImpl;
	}
	//��ʾ���е�����
	public String selectallAssociation() throws Exception{
		List list=associationDaoImpl.selectallAssociation(pageNow, pageSize);
		Pager page=new Pager(pageNow,associationDaoImpl.selectallAssociationSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	
	//����ĳ������///////////////////////////////////////δ���
	public String searchAssociation() throws Exception{
		Association ac = associationDaoImpl.selectAssociation(association.getId());
		if(ac==null){
			//this.setMessage("��������Ų�����");
			return SUCCESS;
		}
		
		return SUCCESS;
	}
	
	//�������///////////////////////////////////////
	public String addAssociation() throws Exception{
		Association ac = associationDaoImpl.selectAssociation(association.getId());
		if(ac!=null){
			//this.setMessage("�����Ѵ���");
			return SUCCESS;
		}
		Association a=new Association();
		a.setName(association.getName());
		a.setNumber(association.getNumber());
		a.setClass_(association.getClass_());
		a.setLeader(association.getLeader());
		a.setInfo(association.getInfo());
		a.setFavor(association.getFavor());
		a.setLogo(association.getLogo());
		associationDaoImpl.addAssociation(a);
		//this.setMessage("��ӳɹ�");
		return SUCCESS;
	}
	
	//������������///////////////////////////////////////
	public String updateAssociation() throws Exception{
		Association ac = associationDaoImpl.selectAssociation(association.getId());
		if(ac==null){
			//this.setMessage("���Ų�����");
			return SUCCESS;
		}
		Association a=new Association();
		a.setName(association.getName());
		a.setNumber(association.getNumber());
		a.setClass_(association.getClass_());
		a.setLeader(association.getLeader());
		a.setInfo(association.getInfo());
		a.setFavor(association.getFavor());
		a.setLogo(association.getLogo());
		associationDaoImpl.updateAssociation(a);
		//this.setMessage("�޸ĳɹ�");
		return SUCCESS;
	}
	
	//ɾ������////////////////////////////////////////////
	public String delelteAssociation() throws Exception{
		Association ac = associationDaoImpl.selectAssociation(association.getId());
		if(ac==null){
			//this.setMessage("���Ų�����");
			return SUCCESS;
		}
		associationDaoImpl.deleteAssociation(association.getId());
		//this.setMessage("ɾ���ɹ�");
		return SUCCESS;
	}
	
	//�������ŵ���///////////////////////////////////////////
	public String updateLikeAssociation() throws Exception{
		Association ac = associationDaoImpl.selectAssociation(association.getId());
		if(ac==null){
			//this.setMessage("���Ų�����");
			return SUCCESS;
		}
		Association a=new Association();
		a.setFavor(association.getFavor());
		return SUCCESS;
		}

}
