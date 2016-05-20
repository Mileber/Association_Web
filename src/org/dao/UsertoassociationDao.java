package org.dao;

import java.util.List;
import org.model.Association;
import org.model.User;
import org.model.Usertoactivity;
import org.model.Usertoassociation;

public interface UsertoassociationDao {
	//��ҳ��ѯָ���û�������
	public List selectAssociation(int userId,int pageNow,int pageSize);
	//��ѯָ���û���������������
	public int selectAssociationSize(int userId);
	//��������
	public void enrollAssociation(Usertoassociation usertoassociation,User user,Association association);
	//�������ű�Ų�ѯ�������
	public Usertoassociation selectByAssociationId(int id);
	//�����û���ź����ű�Ų�ѯ�������
	public Usertoassociation selectByUserIdandAssociationId(int userId, int associationId);
	//�����û��������ű�
	public void updateUsertoassociation(Usertoassociation usertoassociation);
}
