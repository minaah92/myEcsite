package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	public String execute() {
		String result=SUCCESS;
//		if(session.get("adminFlg")!=null) {
//			result="admin";
//
//			return result;
//		}
		return result;
	}

	public Map<String,Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}
