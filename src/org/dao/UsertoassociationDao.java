package org.dao;

import java.util.List;
import org.model.Association;
import org.model.User;
import org.model.Usertoactivity;
import org.model.Usertoassociation;

public interface UsertoassociationDao {
	//分页查询指定用户的社团
	public List selectAssociation(int userId,int pageNow,int pageSize);
	//查询指定用户所参与社团总数
	public int selectAssociationSize(int userId);
	//报名社团
	public void enrollAssociation(Usertoassociation usertoassociation,User user,Association association);
	//根据社团编号查询报名情况
	public Usertoassociation selectByAssociationId(int id);
	//根据用户编号和社团编号查询报名情况
	public Usertoassociation selectByUserIdandAssociationId(int userId, int associationId);
	//更新用户报名社团表
	public void updateUsertoassociation(Usertoassociation usertoassociation);
}
