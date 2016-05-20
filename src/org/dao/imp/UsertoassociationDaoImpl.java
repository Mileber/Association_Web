package org.dao.imp;

import java.util.List;

import org.dao.BaseDAO;
import org.dao.UsertoactivityDao;
import org.dao.UsertoassociationDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.model.Association;
import org.model.User;
import org.model.Usertoactivity;
import org.model.Usertoassociation;

public class UsertoassociationDaoImpl extends BaseDAO implements UsertoassociationDao{

	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List selectAssociation(int userId, int pageNow, int pageSize) {
		Session session=null;
		Transaction tx=null;
		List list=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select u.name,e.associaId,a.name,e.status " +
					"from user as u,usertoassociation as e,association as a " +
					"where e.userId=? and e.userId=u.id and e.associaId=a.id");
			query.setParameter(0, userId);
			query.setFirstResult(pageSize*(pageNow-1));
			query.setMaxResults(pageSize);
			list=query.list();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public int selectAssociationSize(int userId) {
		Session session=null;
		Transaction tx=null;
		int size=0;
		try{
			session=getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from usertoassociation where userId=?");
			query.setParameter(0, userId);
			size=query.list().size();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return size;
	}

	@Override
	public void enrollAssociation(Usertoassociation usertoassociation,
			User user, Association association) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.save(usertoassociation);
			session.update(association);	//�޸Ļ��Ϣ����������+1
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public Usertoassociation selectByAssociationId(int id) {
		Session session=null;
		Transaction tx=null;
		Usertoassociation ua=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			ua=(Usertoassociation)session.get(ua.getClass(), id);
			//TO-DO:Ӧ��ΪList
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return ua;
	}

	@Override
	public Usertoassociation selectByUserIdandAssociationId(int userId, int associationId) {
		Session session=null;
		Transaction tx=null;
		Usertoassociation ua=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			ua=(Usertoassociation)session.get(ua.getClass(), userId);
			//TO-DO
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return ua;
	}

	@Override
	public void updateUsertoassociation(Usertoassociation usertoassociation) {
		try{
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.update(usertoassociation);
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
}
