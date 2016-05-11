package org.service;
import org.vo.User;

public interface UserService {
	public User checkUser(String name,String password);
	public void addUser(User user);
	public void deleteUser(String name,String password);
	public void updateUser(User user);
}
