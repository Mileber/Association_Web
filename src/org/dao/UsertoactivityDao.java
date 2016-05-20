package org.dao;

import java.util.List;

import org.model.Activity;
import org.model.User;
import org.model.Usertoactivity;

public interface UsertoactivityDao {
	//��ҳ��ѯָ���û��Ļ
	public List selectActivity(int userId,int pageNow,int pageSize);
	//��ѯָ���û�����������
	public int selectActivitySize(int userId);
	//�����
	public void enrollActivity(Usertoactivity usertoactivity, Activity activity, User user);
	//���ݻ��Ų�ѯ�������
	public Usertoactivity selectByActivityId(int id);
	//�����û���źͻ��Ų�ѯ�������
	public Usertoactivity selectByUserIdandActivityId(int userId, int activityId);
	//�����û��������
	public void updateUsertoactivity(Usertoactivity usertoactivity);
}
