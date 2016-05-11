package org.action;

import java.util.*;
import org.tool.Pager;
import org.service.*;
import org.vo.*;
import com.opensymphony.xwork2.*;

public class CheckActivityAction extends ActionSupport{
	private int pageNow=1;
	private int pageSize=4;
	private Activity activity;
	private ActivityService activityService;
	
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
	public ActivityService getActivityService(){
		return activityService;
	}
	public void setActivityService(ActivityService activityService){
		this.activityService=activityService;
	}
	public String selectAllActivityByTime() throws Exception{
		List list=activityService.selectActivityByTime(this.getPageNow(), this.getPageSize());
		Pager page=new Pager(pageNow,activityService.selectActivitySize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}

}
