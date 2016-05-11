package org.service;

import java.util.List;
import org.vo.Association;
import org.vo.User;
import org.vo.Usertoassociation;

public interface UsertoassociationService {
	public List selectAssociation(int userId,int pageNow,int pageSize);
	public int selectAssociationSize(int userId);
	public void enrollAssociation(Usertoassociation usertoassociation,User user,Association association);
	public Usertoassociation selectByAssociationId(int id);
}
