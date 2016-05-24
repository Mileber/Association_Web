package org.dao.imp;
import org.dao.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Admin;
import org.model.User;

public class AdminDaoImpl extends BaseDAO implements AdminDao{

	@Override
	public void addAdmin(Admin admin) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.save(admin);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void deleteAdmin(int id) {
		Session session=null;
		Transaction tx=null;
		try{
			Admin admin=(Admin) this.selectAdmin(id);
			session=getSession();
			tx=session.beginTransaction();
			session.delete(admin);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void updateAdmin(Admin admin) {
		Session session=null;
		Transaction tx=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			session.update(admin);
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public Admin selectAdmin(int id) {
		Session session=null;
		Transaction tx=null;
		Admin admin=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from Admin where id='"+id+"'");
			query.setMaxResults(1);
			admin=(Admin)query.uniqueResult();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return admin;
	}

	@Override
	public Admin checkAdmin(String name, String password) {
		Session session=null;
		Transaction tx=null;
		Admin admin=null;
		try{
			session=getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from Admin where name='" + name + "' and password='" + password + "'");
			query.setMaxResults(1);
			admin=(Admin)query.uniqueResult();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}
		return admin;
	}
	

}
