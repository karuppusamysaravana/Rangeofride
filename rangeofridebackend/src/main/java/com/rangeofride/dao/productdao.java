package com.rangeofride.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rangeofride.model.product;

@Service
public interface productdao {
	boolean insert(product p);
	boolean update(product u);
	boolean delete(int id);
	List<product> showAll();
	product showOne(int id);
	}
