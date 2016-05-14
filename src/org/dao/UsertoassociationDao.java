package org.dao;

import java.util.List;
import org.model.Association;
import org.model.User;
import org.model.Usertoassociation;

public interface UsertoassociationDao {
	public List selectAssociation(int userId,int pageNow,int pageSize);
	public int selectAssociationSize(int userId);
	public void enrollAssociation(Usertoassociation usertoassociation,User user,Association association);
	public Usertoassociation selectByAssociationId(int id);
}
