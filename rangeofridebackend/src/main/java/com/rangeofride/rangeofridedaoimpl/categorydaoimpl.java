package com.rangeofride.rangeofridedaoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rangeofride.dao.categorydao;
import com.rangeofride.model.category;

@Repository
public class categorydaoimpl implements categorydao

{
	@Autowired
	SessionFactory sessionFactory;
	


	public boolean insert(category o) {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(o);
			t.commit();
			s.close();
			return true;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	
	public boolean update(category u) {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.update(u);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			System.out.println(id);
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			category p = s.get(category.class,id);
			s.delete(p);
			t.commit();
			s.close();
			return (true);
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	
	public List<category> showAll() {
	
		try
		{
			Session s=sessionFactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();		
			List<category> l= s.createQuery("from category").list();
			t.commit();
			s.close();
			return l;
		}
		catch (Exception e) 
		{
			return null;
		}
	
	}


	
	public category showone(int id) {
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			category k = s.get(category.class, id);
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