package com.itheima.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.web.action.base.BaseAction;

/**
 * 取派员管理
 * @author 古炫天
 *
 */
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Autowired
	private IStaffService staffService;
	
	/**
	 * 添加取派员
	 */
	public String add() {
		staffService.save(model);
		return LIST;
	}
}
