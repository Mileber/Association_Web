package org.dao.imp;
import java.util.List;

import org.dao.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.model.Activity;

public class ActivityDaoImpl extends BaseDAO implements ActivityDao{
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addActivity(Activity activity) {
		
		try{
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(activity);
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteActivity(int id) {
		Session session=null;
		Transaction tx=null;
		try{
			Activity activity=(Activity) this.selectActivity(id);
			session=getSession();
			tx=session.beginTransaction();
			session.delete(activity);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void updateActivity(Activity activity) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.update(activity);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public Activity selectActivity(int id) {
		Session session=null;
		Transaction tx=null;
		Activity activity=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from activity where id=?");
			query.setParameter(0, id);
			query.setMaxResults(1);
			activity=(Activity)query.uniqueResult();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return activity;
	}

	@Override
	public List selectActivityByTime(int pageNow, int pageSize) {
		List list=null;
		try{
			Session session = getSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from activity");
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
	public int selectActivitySize() {
		Session session=null;
		Transaction tx=null;
		int size=0;
		try{
			session=getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from activity");
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

}
