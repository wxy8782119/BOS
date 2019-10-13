package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Function;

public interface IFunctionService {

	public List<Function> findAll();

	public void save(Function model);

}
