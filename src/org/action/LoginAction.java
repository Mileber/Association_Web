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
		boolean validated=false;
		boolean validated1=false;
		Map session = ActionContext.getContext().getSession();
		User usr=null;
		Admin adm=null;
		usr=(User)session.get("user");
		adm=(Admin)session.get("admin");
		if(usr==null){
			usr=userDaoImpl.checkUser(user.getName(), user.getPassword());
			if(usr!=null){
				session.put("user", usr);
				validated=true;
				validated1=false;
			}else{
				adm=adminDaoImpl.checkAdmin(user.getName(), user.getPassword());
				if(adm!=null){
					session.put("admin", adm);
					validated=true;
					validated1=true;
				}
			}
		}
		else{
			validated=true;
		}
		if(validated==true&&validated1){
			return "admin";
		}
		else if(validated==true&&validated1==false){
			return "user";
		}
		else{
			return ERROR;
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
