package com.luiztiago.android.imdb;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MoviesDB extends SQLiteOpenHelper {

	public MoviesDB(Context context) {
		super(context, "moviesDB", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(
				"CREATE TABLE movies ("+
				"_id integer primary key autoincrement,"+
				"title text not null, " +
				"rating text not null, " +
				"imdburl text not null, " +
				"country text not null, " +
				"languages text not null, " +
				"genres text not null, " +
				"votes text not null, " +
				"year text not null)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
	}

	public void save(Movies movie){
		if (movie.getId() == 0){
			insert(movie);
		} else {
			refresh(movie);
		}
	}

	private void refresh(Movies movie) {
		ContentValues cv = getContentValues(movie);
		
		SQLiteDatabase db = getWritableDatabase();
		db.update("movies", cv, "_id=?", 
				new String[]{String.valueOf(movie.getId())});
		db.close();
	}

	private void insert(Movies movie) {
		ContentValues cv = getContentValues(movie);
		
		SQLiteDatabase db = getWritableDatabase();
		db.insert("movies", null, cv);
		db.close();
	}

	public void remove(long id){
		SQLiteDatabase db = getReadableDatabase();
		db.delete("movies", "_id="+ id, null);
		db.close();
	}
	
	private ContentValues getContentValues(Movies movie) {
		ContentValues cv = new ContentValues();
		cv.put("title", movie.getTitle());
		cv.put("rating", movie.getRating());
		cv.put("imdburl", movie.getImdburl());
		cv.put("country", movie.getCountry());
		cv.put("languages", movie.getLanguages());
		cv.put("genres", movie.getGenres());
		cv.put("votes", movie.getVotes());
		cv.put("year", movie.getYear());
		return cv;
	}
	
	public List<Movies> list(){
		List<Movies> listagem = new ArrayList<Movies>();
		
		SQLiteDatabase db = getWritableDatabase();
		Cursor cursor = db.query("movies", null, null, null, null, null, "title");
		
		if (cursor.getCount() > 0){
			cursor.moveToFirst();
			
			long id;
			String title, rating, imdburl, country, languages, genres, votes, year;
			while (!cursor.isAfterLast()){
				id = cursor.getLong(0);
				
				title = cursor.getString(cursor.getColumnIndex("title"));
				rating = cursor.getString(cursor.getColumnIndex("rating"));
				imdburl = cursor.getString(cursor.getColumnIndex("imdburl"));
				country = cursor.getString(cursor.getColumnIndex("country"));
				languages = cursor.getString(cursor.getColumnIndex("languages"));
				genres = cursor.getString(cursor.getColumnIndex("genres"));
				votes = cursor.getString(cursor.getColumnIndex("votes"));
				year = cursor.getString(cursor.getColumnIndex("year"));
				
				Movies movie = new Movies(id, title, rating, imdburl, country, languages, genres, votes, year);
				listagem.add(movie);
				
				cursor.moveToNext();
			}
		}
		db.close();
		
		return listagem;
	}
}
