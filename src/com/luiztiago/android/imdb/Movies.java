package com.luiztiago.android.imdb;

import java.io.Serializable;

import android.util.Log;

public class Movies implements Serializable {

	private long id;
	private String title;
	private String rating;
	private String imdburl;
	private String poster;
	private String plot;
	private String genres;
	private String votes;
	private String year;
	private long type;
	
	Movies(long id, String t, String r, String imdb, String p, String pl, String g, String v, String y, long ty) {
		this.setId(id);
		this.title = t;
		this.rating = r;
		this.imdburl = imdb;
		this.poster = p;
		this.plot = pl;
		this.genres = g;
		this.votes = v;
		this.year = y;
		this.type = ty;
	}
	
	public Movies(String t, String r, String imdb, String p, String pl, String g, String v, String y, long ty) {
		// TODO Auto-generated constructor stub
		this(0, t, r, imdb, p, pl, g, v, y, ty);
		
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
	
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
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
	
	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

}
