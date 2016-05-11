package org.dao;
import org.vo.User;

public interface UserDao {
	public User checkUser(String name,String password);
	public void addUser(User user);
	public void deleteUser(String name,String password);
	public void updateUser(User user);
}
