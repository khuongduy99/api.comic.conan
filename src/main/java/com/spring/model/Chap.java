package com.spring.model;

public class Chap {
	private int id;
	private int idBook;
	private String title;
    private String alias;
    private String urlChap;
    
	public Chap(int id, int idBook, String title, String alias, String urlChap) {
		super();
		this.id = id;
		this.idBook = idBook;
		this.title = title;
		this.alias = alias;
		this.urlChap = urlChap;
	}
	public Chap() {
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getUrlChap() {
		return urlChap;
	}
	public void setUrlChap(String urlChap) {
		this.urlChap = urlChap;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Chap [idBook=" + idBook + ", title=" + title + ", alias=" + alias + ", urlChap=" + urlChap + "]";
	}
	
	
}
