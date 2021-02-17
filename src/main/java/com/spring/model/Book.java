package com.spring.model;

public class Book {
	private int id;
	private String title;
	private String urlImg;
	private String actor;
	private int numPage;
	private String releaseDate;

	public Book(int id, String title, String urlImg, String actor, int numPage, String releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.urlImg = urlImg;
		this.actor = actor;
		this.numPage = numPage;
		this.releaseDate = releaseDate;
	}
	
	public Book() {}

	public String getTitle() {
		return title;
	}


	public String getUrlImg() {
		return urlImg;
	}

	public String getActor() {
		return actor;
	}

	public int getNumPage() {
		return numPage;
	}

	public String getReleaseDate() {
		return releaseDate;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}
