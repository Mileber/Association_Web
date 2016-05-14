package org.dao.imp;
import org.dao.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Association;

public class AssociationDaoImpl extends BaseDAO implements AssociationDao{

	@Override
	public void addAssociation(Association association) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.save(association);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void deleteAssociation(int id) {
		Session session=null;
		Transaction tx=null;
		try{
			Association association=(Association) this.selectAssociation(id);
			session=getSession();
			tx=session.beginTransaction();
			session.delete(association);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void updateAssociation(Association association) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.update(association);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public Association selectAssociation(int id) {
		Session session=null;
		Transaction tx=null;
		Association association=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from Association where id=?");
			query.setParameter(0, id);
			query.setMaxResults(1);
			association=(Association)query.uniqueResult();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return association;
	}
	
}
