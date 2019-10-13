package com.itheima.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Function;
import com.itheima.bos.service.IFunctionService;
import com.itheima.bos.web.action.base.BaseAction;

/**
 * 权限管理
 * @author 古炫天
 *
 */
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function> {
	@Autowired
	private IFunctionService service;
	
	/**
	 * 查询所有权限，返回json数据
	 */
	public String listajax() {
		List<Function> list = service.findAll();
		this.java2json(list, new String[] {"parentFunction","roles","children"});
		return NONE;
	}
	
	/**
	 * 添加权限
	 */
	public String add() {
		Function parentFunction = model.getParentFunction();
		if(parentFunction != null && parentFunction.getId().equals("")) {
			model.setParentFunction(null);
		}
		service.save(model);
		return LIST;
	}
}
