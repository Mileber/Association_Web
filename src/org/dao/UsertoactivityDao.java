package org.dao;

import java.util.List;

import org.vo.Activity;
import org.vo.User;
import org.vo.Usertoactivity;

public interface UsertoactivityDao {
	//��ҳ��ѯָ���û��Ļ
	public List selectActivity(int userId,int pageNow,int pageSize);
	//��ѯָ���û�����������
	public int selectActivitySize(int userId);
	//�����
	public void enrollActivity(Usertoactivity usertoactivity, Activity activity, User user);
	//���ݻ��Ų�ѯ�������
	public Usertoactivity selectByActivityId(int id);
}
