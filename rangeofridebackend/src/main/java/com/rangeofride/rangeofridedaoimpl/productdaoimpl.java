package com.rangeofride.rangeofridedaoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rangeofride.dao.productdao;
import com.rangeofride.model.product;

@Repository
public class productdaoimpl implements productdao
{

	@Autowired
	SessionFactory sessionFactory;
	


	
	public boolean insert(product p) {
		
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(p);
			t.commit();
			s.close();
			return true;
		}
		
	    catch (Exception e) 
		
		{
			return false;
		}
	}


	public boolean update(product u) {
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
			System.out.println(id);
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			product p = s.get(product.class,id);
			s.delete(p);
			t.commit();
			s.close();
			return (true);
		} 
		catch (Exception e)
		
		{
			System.out.println(e.getMessage());
			return false;
		}
	}


	public List<product> showAll() {
		try
		{
			Session s=sessionFactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();		
			List<product> l= s.createQuery("from product").list();
			t.commit();
			s.close();
			return l;
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	
	public product showOne(int id) {
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			product k = s.get(product.class, id);
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


