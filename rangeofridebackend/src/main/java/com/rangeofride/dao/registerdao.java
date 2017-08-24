package com.rangeofride.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rangeofride.model.Register;
import com.rangeofride.model.product;

@Service
public interface registerdao {
boolean insert(Register d);
List<Register> showAll();

}
