package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

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
	
	/**
	 * 分页查询方法
	 */
	public String pageQuery() throws IOException {
		staffService.pageQuery(pageBean);
		this.java2json(pageBean, new String[] {"decidedzones","currentPage","detachedCriteria","pageSize"});
		return NONE;
	}
	
	 /**
	  * 取派员批量删除
	  */
	public String ids;
	@RequiresPermissions("staff-delete")//执行这个方法，需要当前用户具有staff-delete这个权限
	public String deleteBatch() {
		staffService.deleteBatch(ids);
		return LIST;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	/**
	 * 修改取派员信息
	 */
	@RequiresPermissions("staff-edit")
	public String edit() {
//		Subject subject = SecurityUtils.getSubject();
//		subject.checkPermission("staff-edit");
		
		//显查询数据库，根据id查询原始数据
		Staff staff = staffService.findById(model.getId());
		//使用页面提交的数据覆盖
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setDeltag(model.getDeltag());
		staff.setStation(model.getStation());
		staff.setStandard(model.getStandard());
		staffService.update(staff);
		return LIST;
	}
	
	/**
	 * 查询所有未删除的取派员，返回json
	 */
	public String listajax() {
		List<Staff> list = staffService.findListNotDelete();
		this.java2json(list, new String[] {"decidedzones"});
		return NONE;
	}
}
