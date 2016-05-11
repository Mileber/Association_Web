package org.service.impl;

import org.dao.AssociationDao;
import org.service.AssociationService;
import org.vo.Association;

public class AssociationServiceImpl implements AssociationService{
	private AssociationDao associationDao;

	@Override
	public void addAssociation(Association association) {
		associationDao.addAssociation(association);
	}

	@Override
	public void deleteAssociation(int id) {
		associationDao.deleteAssociation(id);
	}

	@Override
	public void updateAssociation(Association association) {
		associationDao.updateAssociation(association);
	}

	@Override
	public Association selectAssociation(int id) {
		return associationDao.selectAssociation(id);
	}
	
	public AssociationDao getAssociationDao() {
		return associationDao;
	}
	
	public void setAssociationDao(AssociationDao associationDao){
		this.associationDao=associationDao;
	}

}
