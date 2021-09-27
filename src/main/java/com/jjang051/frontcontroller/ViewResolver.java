package com.jjang051.frontcontroller;

public class ViewResolver {
	private String prefix;
	private String suffix;
	public ViewResolver() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}
	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getViewPage(String nextPage) {
		return prefix+nextPage+suffix;
	}
}
