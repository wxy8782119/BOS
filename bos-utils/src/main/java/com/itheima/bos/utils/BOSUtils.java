package com.itheima.bos.utils;
/**
 * BOS项目的工具类
 * @author 古炫天
 *
 */

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.bos.domain.User;

public class BOSUtils {
	//获取session对象
	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	//获取登录用户对象
	public static User getLoginUser() {
		return (User) getSession().getAttribute("loginUser");
	}
}
