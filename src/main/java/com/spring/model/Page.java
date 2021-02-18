package com.spring.model;

public class Page {
	private int idChap;
	private String urlImg;
	public int getIdChap() {
		return idChap;
	}
	public void setIdChap(int idChap) {
		this.idChap = idChap;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	public Page(int idChap, String urlImg) {
		super();
		this.idChap = idChap;
		this.urlImg = urlImg;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
