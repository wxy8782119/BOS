package com.itheima.bos.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IStaffDao;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffDao staffDao;
	public void save(Staff model) {
		staffDao.save(model);
	}
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}
	
	/**
	 * 取派员批量删除
	 * 逻辑删除，将deltag改为1
	 */
	public void deleteBatch(String ids) {
		if(StringUtils.isNotBlank(ids)) {
			String[] staffIds = ids.split(",");
			for(String id : staffIds) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
	}
}
