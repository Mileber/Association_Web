package org.service.impl;

import java.util.List;

import org.dao.UsertoassociationDao;
import org.service.UsertoassociationService;
import org.vo.Association;
import org.vo.User;
import org.vo.Usertoassociation;

public class UsertoassociationServiceImpl implements UsertoassociationService{
	private UsertoassociationDao usertoassociationDao;
	
	@Override
	public List selectAssociation(int userId, int pageNow, int pageSize) {
		return usertoassociationDao.selectAssociation(userId, pageNow, pageSize);
	}

	@Override
	public int selectAssociationSize(int userId) {
		return usertoassociationDao.selectAssociationSize(userId);
	}

	@Override
	public void enrollAssociation(Usertoassociation usertoassociation,
			User user, Association association) {
		usertoassociationDao.enrollAssociation(usertoassociation, user, association);
	}

	@Override
	public Usertoassociation selectByAssociationId(int id) {
		return usertoassociationDao.selectByAssociationId(id);
	}
	
	public UsertoassociationDao getUsertoassociationDao(){
		return usertoassociationDao;
	}
	
	public void setUsertoassociationDao(UsertoassociationDao usertoassociationDao){
		this.usertoassociationDao=usertoassociationDao;
	}

}
