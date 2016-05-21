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
	//显示所有的社团
	public String selectallAssociation() throws Exception{
		List list=associationDaoImpl.selectallAssociation(pageNow, pageSize);
		Pager page=new Pager(pageNow,associationDaoImpl.selectallAssociationSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	
	//搜索某个社团///////////////////////////////////////未完成
	public String searchAssociation() throws Exception{
		Association ac = associationDaoImpl.selectAssociation(association.getId());
		if(ac==null){
			//this.setMessage("输入的社团不存在");
			return SUCCESS;
		}
		
		return SUCCESS;
	}
	
	//添加社团///////////////////////////////////////
	public String addAssociation() throws Exception{
		Association ac = associationDaoImpl.selectAssociation(association.getId());
		if(ac!=null){
			//this.setMessage("社团已存在");
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
		//this.setMessage("添加成功");
		return SUCCESS;
	}
	
	//更新社团资料///////////////////////////////////////
	public String updateAssociation() throws Exception{
		Association ac = associationDaoImpl.selectAssociation(association.getId());
		if(ac==null){
			//this.setMessage("社团不存在");
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
		//this.setMessage("修改成功");
		return SUCCESS;
	}
	
	//删除社团////////////////////////////////////////////
	public String delelteAssociation() throws Exception{
		Association ac = associationDaoImpl.selectAssociation(association.getId());
		if(ac==null){
			//this.setMessage("社团不存在");
			return SUCCESS;
		}
		associationDaoImpl.deleteAssociation(association.getId());
		//this.setMessage("删除成功");
		return SUCCESS;
	}
	
	//更新社团点赞///////////////////////////////////////////
	public String updateLikeAssociation() throws Exception{
		Association ac = associationDaoImpl.selectAssociation(association.getId());
		if(ac==null){
			//this.setMessage("社团不存在");
			return SUCCESS;
		}
		Association a=new Association();
		a.setFavor(association.getFavor());
		return SUCCESS;
		}

}
