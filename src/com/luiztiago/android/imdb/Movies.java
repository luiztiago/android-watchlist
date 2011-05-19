package com.luiztiago.android.imdb;

import java.io.Serializable;

import android.util.Log;

public class Movies implements Serializable {

	private long id;
	private String title;
	private String rating;
	private String imdburl;
	private String country;
	private String languages;
	private String genres;
	private String votes;
	private String year;
	
	Movies(long id, String t, String r, String imdb, String c, String l, String g, String v, String y) {
		this.setId(id);
		this.title = t;
		this.rating = r;
		this.imdburl = imdb;
		this.country = c;
		this.languages = l;
		this.genres = g;
		this.votes = v;
		this.year = y;
	}
	
	public Movies(String t, String r, String imdb, String c, String l, String g, String v, String y) {
		// TODO Auto-generated constructor stub
		this(0, t, r, imdb, c, l, g, v, y);
		
//		title = t;
//		rating = r;
//		imdburl = imdb;
//		country = c;
//		languages = l;
//		genres = g;
//		votes = v;
//		year = y;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRating() {
		return rating + "/10";
//		return Float.parseFloat(rating);
	}

	public void setImdburl(String imdburl) {
		this.imdburl = imdburl;
	}

	public String getImdburl() {
		return imdburl;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getLanguages() {
		return languages;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getGenres() {
		return genres;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}

	public String getVotes() {
		return votes;
	}

		public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

}
