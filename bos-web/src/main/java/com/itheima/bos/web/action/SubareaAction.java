package com.itheima.bos.web.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Region;
import com.itheima.bos.domain.Subarea;
import com.itheima.bos.service.ISubareaService;
import com.itheima.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	@Resource
	private ISubareaService subareaService;
	/**
	 * 添加分区
	 */
	public String add() {
		subareaService.save(model);
		return LIST;
	}
	
	/**
	 * 分页查询
	 */
	public String pageQuery() {
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		//动态添加过滤条件
		String addresskey = model.getAddresskey();
		if(StringUtils.isNotBlank(addresskey)) {
			//添加过滤条件，根据地址关键字模糊查询
			dc.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
		}
		Region region = model.getRegion();
		if(region != null) {
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			dc.createAlias("region", "r");
			if(StringUtils.isNotBlank(province)) {
				//添加过滤条件，根据省份模糊查询------多表关联查询，使用别名方式实现
				//参数一：分区对象中关联的区域对象属性名称
				//参数二：别名，可以任意
				dc.add(Restrictions.like("r.province", "%"+province+"%"));
			}
			if(StringUtils.isNotBlank(city)) {
				//添加过滤条件，根据市模糊查询------多表关联查询，使用别名方式实现
				//参数一：分区对象中关联的区域对象属性名称
				//参数二：别名，可以任意
				dc.add(Restrictions.like("r.city", "%"+city+"%"));
			}
			if(StringUtils.isNotBlank(district)) {
				//添加过滤条件，根据区模糊查询------多表关联查询，使用别名方式实现
				//参数一：分区对象中关联的区域对象属性名称
				//参数二：别名，可以任意
				dc.add(Restrictions.like("r.district", "%"+district+"%"));
			}
		}
		subareaService.pageQuery(pageBean);
		this.java2json(pageBean, new String[] {"currentPage","detachedCriteria","pageSize","decidedzone","subareas"});
		return NONE;
	}
}
