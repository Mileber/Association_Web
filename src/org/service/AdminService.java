package org.service;

import org.vo.Admin;

public interface AdminService {
	public Admin checkAdmin(String name,String password);
	public void addAdmin(Admin admin);
	public void deleteAdmin(int id);
	public void updateAdmin(Admin admin);
	public Admin selectAdmin(int id);
}
