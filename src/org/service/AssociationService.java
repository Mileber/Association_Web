package org.service;

import org.vo.Association;

public interface AssociationService {
	public void addAssociation(Association association);
	public void deleteAssociation(int id);
	public void updateAssociation(Association association);
	public Association selectAssociation(int id);
}
