package org.dao.imp;
import java.util.List;

import org.dao.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.model.Association;

public class AssociationDaoImpl extends BaseDAO implements AssociationDao{

	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
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
			Query query=session.createQuery("from Association where id='" + id + "'");
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

	@Override
	public List selectallAssociation(int pageNow, int pageSize) {
		List list=null;
		try{
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Association");
			query.setFirstResult(pageSize*(pageNow-1));
			query.setMaxResults(pageSize);
			list=query.list();
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int selectallAssociationSize() {
		try{
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Association");
			int size=query.list().size();
			tx.commit();
			session.close();
			return size;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
}
