package org.dao;
import org.model.Association;

public interface AssociationDao {
	public void addAssociation(Association association);
	public void deleteAssociation(int id);
	public void updateAssociation(Association association);
	public Association selectAssociation(int id);
}
