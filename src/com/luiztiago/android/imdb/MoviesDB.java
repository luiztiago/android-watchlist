package com.luiztiago.android.imdb;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MoviesDB extends SQLiteOpenHelper {

	public MoviesDB(Context context) {
		super(context, "moviesDB", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(
				"CREATE TABLE moviesImdb ("+
				"_id integer primary key autoincrement,"+
				"title text not null, " +
				"rating text not null, " +
				"imdburl text not null, " +
				"poster text not null, " +
				"plot text not null, " +
				"genres text not null, " +
				"year text not null, " +
				"votes text not null, " +
				"type int(2) null)");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	public void save(Movies movie){
		final Activity self = new Activity();
		if (movie.getId() == 0){
			
			if(!hasMovie(movie.getTitle())){
				insert(movie);
			}else{
				Toast.makeText(self, "J‡ existe este filme cadastrado",
						Toast.LENGTH_SHORT).show();
			}
			
		} else {
			refresh(movie);
		}
	}

	private void refresh(Movies movie) {
		ContentValues cv = getContentValues(movie);
		
		SQLiteDatabase db = getWritableDatabase();
		db.update("moviesImdb", cv, "_id=?", 
				new String[]{String.valueOf(movie.getId())});
		db.close();
	}

	private void insert(Movies movie) {
		ContentValues cv = getContentValues(movie);
		
		SQLiteDatabase db = getWritableDatabase();
		db.insert("moviesImdb", null, cv);
		db.close();
	}

	public void remove(long id){
		SQLiteDatabase db = getReadableDatabase();
		db.delete("moviesImdb", "_id="+ id, null);
		db.close();
	}
	
	private ContentValues getContentValues(Movies movie) {
		ContentValues cv = new ContentValues();
		cv.put("title", movie.getTitle());
		cv.put("rating", movie.getRating());
		cv.put("imdburl", movie.getImdburl());
		cv.put("poster", movie.getPoster());
		cv.put("plot", movie.getPlot());
		cv.put("genres", movie.getGenres());
		cv.put("votes", movie.getVotes());
		cv.put("year", movie.getYear());
		cv.put("type", movie.getType());
		return cv;
	}
	
	public List<String> listMovies(long filterType){
		
		List<String> listagem = new ArrayList<String>();
		
		SQLiteDatabase db = getWritableDatabase();
		Cursor cursor = db.query("moviesImdb", null, "type = "+filterType, null, null, null, "title");
		
		if (cursor.getCount() > 0){
			cursor.moveToFirst();
			
			long id;
			String title, rating, imdburl, poster, plot, genres, votes, year;
			long type;
			while (!cursor.isAfterLast()){
				id = cursor.getLong(0);
				
				title = cursor.getString(cursor.getColumnIndex("title"));
				rating = cursor.getString(cursor.getColumnIndex("rating"));
				imdburl = cursor.getString(cursor.getColumnIndex("imdburl"));
				poster = cursor.getString(cursor.getColumnIndex("poster"));
				plot = cursor.getString(cursor.getColumnIndex("plot"));
				genres = cursor.getString(cursor.getColumnIndex("genres"));
				votes = cursor.getString(cursor.getColumnIndex("votes"));
				year = cursor.getString(cursor.getColumnIndex("year"));
				type = cursor.getLong(cursor.getColumnIndex("type"));
				
				Movies movie = new Movies(id, title, rating, imdburl, poster, plot, genres, votes, year, type);
				listagem.add(movie.getTitle());
				
				cursor.moveToNext();
			}
		}
		db.close();
		
		return listagem;
	}
	
	public List<Movies> list(long filterType){
		List<Movies> objList = new ArrayList<Movies>();
		
		SQLiteDatabase db = getWritableDatabase();
		Cursor cursor = db.query("moviesImdb", null, "type = "+filterType, null, null, null, "title");
		
		if (cursor.getCount() > 0){
			cursor.moveToFirst();
			
			long id;
			String title, rating, imdburl, poster, plot, genres, votes, year;
			long type;
			while (!cursor.isAfterLast()){
				id = cursor.getLong(0);
				
				title = cursor.getString(cursor.getColumnIndex("title"));
				rating = cursor.getString(cursor.getColumnIndex("rating"));
				imdburl = cursor.getString(cursor.getColumnIndex("imdburl"));
				poster = cursor.getString(cursor.getColumnIndex("poster"));
				plot = cursor.getString(cursor.getColumnIndex("plot"));
				genres = cursor.getString(cursor.getColumnIndex("genres"));
				votes = cursor.getString(cursor.getColumnIndex("votes"));
				year = cursor.getString(cursor.getColumnIndex("year"));
				type = cursor.getLong(cursor.getColumnIndex("type"));
				
				Movies movie = new Movies(id, title, rating, imdburl, poster, plot, genres, votes, year, type);
				objList.add(movie);
				
				cursor.moveToNext();
			}
		}
		db.close();
		
		return objList;
	}
	
	public boolean hasMovie(String title){
		
		SQLiteDatabase db = getWritableDatabase();
		Cursor cursor = db.query("moviesImdb", null, "title = \""+title+"\"", null, null, null, "title");
		boolean hasMovie;
		
		if (cursor.getCount() > 0){
			hasMovie = true;
		}else{
			hasMovie = false;
		}
		
		return hasMovie;
	}

}
