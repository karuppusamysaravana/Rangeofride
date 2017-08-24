package com.rangeofride.dao;

import java.util.List;

import org.hibernate.sql.Delete;
import org.springframework.stereotype.Service;

import com.rangeofride.model.category;

@Service
public interface categorydao
{
	boolean insert(category o);
	boolean update(category u);
	boolean delete(int id);
	List<category>showAll();
	category showone(int id);	
	
}
