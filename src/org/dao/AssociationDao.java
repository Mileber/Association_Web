package org.dao;
import java.util.List;

import org.model.Association;

public interface AssociationDao {
	public void addAssociation(Association association);
	public void deleteAssociation(int id);
	public void updateAssociation(Association association);
	public Association selectAssociation(int id);
	public List selectallAssociation(int pageNow,int pageSize);
	public int selectallAssociationSize();
}
