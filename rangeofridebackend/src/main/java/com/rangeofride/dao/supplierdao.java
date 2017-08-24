package com.rangeofride.dao;

import java.util.List;

import javax.persistence.Entity;

import com.rangeofride.model.supplier;

@Entity
public interface supplierdao
{
	boolean insert(supplier n);
	boolean update(supplier u);
	boolean delete(int id);
	List<supplier> showAll();
    supplier showOne(int id);

}
