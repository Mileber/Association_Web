package org.dao.imp;
import org.dao.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.User;

public class UserDaoImpl extends BaseDAO implements UserDao{
	public User checkUser(String name,String password){
		Session session=null;
		Transaction tx=null;
		User user=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from user where name=? and password=?");
			query.setParameter(0, name);
			query.setParameter(1, password);
			query.setMaxResults(1);
			user=(User)query.uniqueResult();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void deleteUser(String name, String password) {
		Session session=null;
		Transaction tx=null;
		try{
			User user=(User) this.checkUser(name, password);
			session=getSession();
			tx=session.beginTransaction();
			session.delete(user);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void updateUser(User user) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.update(user);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}
