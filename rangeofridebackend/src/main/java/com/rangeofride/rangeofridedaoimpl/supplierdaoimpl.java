package com.rangeofride.rangeofridedaoimpl;


import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rangeofride.dao.supplierdao;
import com.rangeofride.model.supplier;
@Entity
@Repository
public class supplierdaoimpl implements supplierdao
{


	@Autowired
	SessionFactory sessionFactory;
	

	
	public boolean insert(supplier n) {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(n);
			t.commit();
			s.close();
			return true;
		}
		
	    catch (Exception e) 
		
		{
			return false;
		}
	}

	
	public boolean update(supplier u) {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.update(u);
			t.commit();
			s.close();
			return true;
		}
		
		catch (Exception e)
		
		{
			return false;
		}
		
	}

	
	public boolean delete(int id) {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			supplier p = s.get(supplier.class,id);
			s.delete(p);
			t.commit();
			s.close();
			return (true);
		} 
		
		catch (Exception e)
		
		{
			return false;
		}
	}

	
	public List<supplier> showAll() {
		try
		{
			
			Session s=sessionFactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();		
			List<supplier> l= s.createQuery("from supplier").list();
			t.commit();
			s.close();
			return l;
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	
	public supplier showOne(int id) {
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			supplier k = s.get(supplier.class, id);
			t.commit();
			s.close();
			return k;
		} 
		
		catch (Exception e)
		
		
		{
			return null;
		}
	}
}