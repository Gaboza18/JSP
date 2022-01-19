package com.green.dto;

public class MovieVO {

	private int code;
	private String title;
	private int price;
	private String director;
	private String actor;
	private String poster;
	private String synopsis;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	@Override
	public String toString() {
		return "MovieVO [code=" + code + ", title=" + title + ", price=" + price + ", director=" + director + ", actor="
				+ actor + ", poster=" + poster + ", synopsis=" + synopsis + "]";
	}
}
