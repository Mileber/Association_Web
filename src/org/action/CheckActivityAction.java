package org.action;

import java.io.*;
import java.util.*;
import org.tool.Pager;
import org.dao.imp.*;
import org.model.*;
import com.opensymphony.xwork2.*;

public class CheckActivityAction extends ActionSupport{
	private int pageNow=1;
	private int pageSize=4;
	private Activity activity;
	private File photoFile;
	private List list;
	
	private ActivityDaoImpl activityDaoImpl;
	
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
	public Activity getActivity(){
		return activity;
	}
	public void setActivity(Activity activity){
		this.activity=activity;
	}
	public File getPhotoFile(){
		return photoFile;
	}
	public void setPhotoFile(File photoFile){
		this.photoFile=photoFile;
	}
	/*public List getList(){
		return 
	}*/
	public ActivityDaoImpl getActivityDaoImpl(){
		return activityDaoImpl;
	}
	public void setActivityDaoImpl(ActivityDaoImpl activityDaoImpl){
		this.activityDaoImpl=activityDaoImpl;
	}
	public String selectAllActivityByTime() throws Exception{
		List list=activityDaoImpl.selectActivityByTime(pageNow, pageSize);
		Pager page=new Pager(pageNow,activityDaoImpl.selectActivitySize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	
	public String addActivity() throws Exception{
		List list=activityDaoImpl.selectActivityByTime(this.getPageNow(), this.getPageSize());
		Pager page=new Pager(pageNow,activityDaoImpl.selectActivitySize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}

}
