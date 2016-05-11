package org.dao.impl;

import java.util.List;

import org.dao.BaseDAO;
import org.dao.UsertoactivityDao;
import org.dao.UsertoassociationDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.vo.Association;
import org.vo.User;
import org.vo.Usertoactivity;
import org.vo.Usertoassociation;

public class UsertoassociationDaoImpl extends BaseDAO implements UsertoassociationDao{

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
			session.update(association);	//修改活动信息，参与人数+1
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
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return ua;
	}

	
}
