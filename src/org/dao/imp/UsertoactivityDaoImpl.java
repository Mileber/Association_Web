package org.dao.imp;
import java.util.List;

import org.dao.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.model.Activity;
import org.model.User;
import org.model.Usertoactivity;

public class UsertoactivityDaoImpl extends BaseDAO implements UsertoactivityDao{
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List selectActivity(int userId, int pageNow, int pageSize) {
		Session session=null;
		Transaction tx=null;
		List list=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select u.name,e.activityId,a.name,e.status " +
					"from user as u,usertoactivity as e,activity as a " +
					"where e.userId=? and e.userId=u.id and e.activityId=a.id");
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
	public int selectActivitySize(int userId) {
		Session session=null;
		Transaction tx=null;
		int size=0;
		try{
			session=getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from usertoactivity where userId=?");
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
	public void enrollActivity(Usertoactivity usertoactivity,
			Activity activity, User user) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.save(usertoactivity);
			session.update(activity);	//修改活动信息，参与人数+1
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public Usertoactivity selectByActivityId(int id) {
		//TO-DO:应该是List
		Session session=null;
		Transaction tx=null;
		Usertoactivity ua=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			ua=(Usertoactivity)session.get(ua.getClass(), id);
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
	public Usertoactivity selectByUserIdandActivityId(int userId, int activityId) {
		Session session=null;
		Transaction tx=null;
		Usertoactivity ua=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			ua=(Usertoactivity)session.get(ua.getClass(), userId);
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
	public void updateUsertoactivity(Usertoactivity usertoactivity) {
		try{
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.update(usertoactivity);
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
