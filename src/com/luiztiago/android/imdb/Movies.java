package com.luiztiago.android.imdb;

import android.util.Log;

public class Movies {

	private String title;
	private String rating;
	private String imdburl;
	private String country;
	private String languages;
	private String genres;
	private String votes;
	private String usascreens;
	private String ukscreens;
	private String year;
	private String stv;
	private String series;

	public Movies(String t, String r, String imdb, String c, String l, String g, String v, String y) {
		// TODO Auto-generated constructor stub
		title = t;
		rating = r;
		imdburl = imdb;
		country = c;
		languages = l;
		genres = g;
		votes = v;
		year = y;
		Log.i("Luiz", "Title " + title);
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

	public void setUsascreens(String usascreens) {
		this.usascreens = usascreens;
	}

	public String getUsascreens() {
		return usascreens;
	}

	public void setUkscreens(String ukscreens) {
		this.ukscreens = ukscreens;
	}

	public String getUkscreens() {
		return ukscreens;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setStv(String stv) {
		this.stv = stv;
	}

	public String getStv() {
		return stv;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getSeries() {
		return series;
	}

}
