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
		try{
			Activity activity=(Activity) this.selectActivity(id);
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.delete(activity);
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateActivity(Activity activity) {
		try{
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.update(activity);
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Activity selectActivity(int id) {
		Activity activity=null;
		try{
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Activity where id=?");
			query.setParameter(0, id);
			query.setMaxResults(1);
			activity=(Activity)query.uniqueResult();
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return activity;
	}

	@Override
	public List selectActivityByTime(int pageNow, int pageSize) {
		List list=null;
		try{
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from Activity");
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
		
		try{
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("from activity");
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
