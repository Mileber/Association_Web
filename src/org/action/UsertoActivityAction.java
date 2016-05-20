package org.action;

import java.util.List;
import java.util.Map;

import org.dao.imp.UsertoactivityDaoImpl;
import org.model.Activity;
import org.model.User;
import org.model.Usertoactivity;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UsertoActivityAction extends ActionSupport{
	private int pageNow=1;
	private int pageSize=4;
	private Usertoactivity usertoactivity;
	private UsertoactivityDaoImpl usertoactivityDaoImpl;
	private List list;
	private User user;
	private Activity activity;
	
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
	public void setUsertoactivity(Usertoactivity usertoactivity){
		this.usertoactivity=usertoactivity;
	}
	public Usertoactivity getUsertoactivity(){
		return usertoactivity;
	}
	public void setUsertoactivityDaoImpl(UsertoactivityDaoImpl usertoactivityDaoImpl){
		this.usertoactivityDaoImpl=usertoactivityDaoImpl;
	}
	public UsertoactivityDaoImpl getUsertoactivityDaoImpl(){
		return usertoactivityDaoImpl;
	}
	public String selectUsertoactivityByActivityId() throws Exception{
		Usertoactivity ua = usertoactivityDaoImpl.selectByActivityId(activity.getId());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("usertoactivity", ua);
		return SUCCESS;
	}
	public String selectUsertoactivityByUserId() throws Exception{
		List list=usertoactivityDaoImpl.selectActivity(user.getId(), pageNow, pageSize);
		Pager page=new Pager(pageNow,usertoactivityDaoImpl.selectActivitySize(user.getId()));
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	//用户报名
	public String addUsertoactivity() throws Exception{
		Usertoactivity ua = usertoactivityDaoImpl.selectByActivityId(activity.getId());
		if(ua!=null){
			//this.setMessage("活动已存在");
			return SUCCESS;
		}
		Usertoactivity u=new Usertoactivity();
		u.setActivity(activity);
		u.setUser(user);
		u.setStatus("ENROLLED");
		//此时的状态是用户已报名，但是管理员未处理
		usertoactivityDaoImpl.enrollActivity(u,activity,user);
		//this.setMessage("添加成功");
		return SUCCESS;
	}
	
	public String agreeUsertoactivity() throws Exception{
		Usertoactivity ua = usertoactivityDaoImpl.selectByUserIdandActivityId(user.getId(), activity.getId());
		if(ua!=null){
			ua.setStatus("AGREED");		/*管理员同意报名*/
			return SUCCESS;
		}
		usertoactivityDaoImpl.updateUsertoactivity(ua);
		//this.setMessage("添加成功");
		return SUCCESS;
	}
	public String rejectUsertoactivity() throws Exception{
		Usertoactivity ua = usertoactivityDaoImpl.selectByUserIdandActivityId(user.getId(), activity.getId());
		if(ua!=null){
			ua.setStatus("REJECTED");		/*管理员同意报名*/
			return SUCCESS;
		}
		usertoactivityDaoImpl.updateUsertoactivity(ua);
		//this.setMessage("添加成功");
		return SUCCESS;
	}
}
