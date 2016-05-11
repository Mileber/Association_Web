package org.service.impl;

import org.dao.AdminDao;
import org.service.AdminService;
import org.vo.Admin;

public class AdminServiceImpl implements AdminService{
	private AdminDao adminDao;

	@Override
	public Admin checkAdmin(String name, String password) {
		return adminDao.checkAdmin(name, password);
	}

	@Override
	public void addAdmin(Admin admin) {
		adminDao.addAdmin(admin);
	}

	@Override
	public void deleteAdmin(int id) {
		adminDao.deleteAdmin(id);
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
	}

	@Override
	public Admin selectAdmin(int id) {
		return adminDao.selectAdmin(id);
	}
	
	public AdminDao getAdminDao(){
		return adminDao;
	}
	
	public void setAdminDao(AdminDao adminDao){
		this.adminDao=adminDao;
	}

}
