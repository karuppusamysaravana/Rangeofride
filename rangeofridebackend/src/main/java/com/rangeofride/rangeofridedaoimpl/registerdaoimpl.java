package com.rangeofride.rangeofridedaoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rangeofride.dao.registerdao;
import com.rangeofride.model.Register;
import com.rangeofride.model.product;

@Repository
public class registerdaoimpl implements registerdao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean insert(Register d) {

		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(d);
			t.commit();
			s.close();
			return (true);
		} catch (Exception e) {
			return false;
		}

	}

	public List<Register> showAll() {
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			List<Register> l = s.createQuery("from Register").list();
			t.commit();
			s.close();
			return l;
		} catch (Exception e) {
			return null;
		}
	}

}
