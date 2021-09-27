package com.jjang051.controller;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	//nextpage jsp 처리(view)
	private String nextPage;
	//model은 request.setAttriubute()의 역할을한
	private Map<String,Object> model=new HashMap<String,Object>();
	public ModelAndView() {
		
		// TODO Auto-generated constructor stub
	}
	public ModelAndView(String nextPage) {
		
		this.nextPage = nextPage;
	}
	public ModelAndView(String nextPage,String key,Object object) {
		setNextPage(nextPage);
		addObject(key, object);
	}
	/**
	 * @return the model
	 */
	public Map<String, Object> getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	/**
	 * @return the nextPage
	 */
	public String getNextPage() {
		return nextPage;
	}
	/**
	 * @param nextPage the nextPage to set
	 */
	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}
	
	public void addObject(String key ,Object object) {
		model.put(key, object);
	}
	

	
}
