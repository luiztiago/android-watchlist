package com.luiztiago.android.imdb;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MoviesProvider extends ContentProvider {

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Uri uri, String whereClause, String[] whereArgs) {
		MoviesDB db = new MoviesDB(getContext());
		SQLiteDatabase sqlDB = db.getWritableDatabase(); 
		int ret = sqlDB.delete("movies", whereClause, whereArgs);
		sqlDB.close();
		return ret;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cursor query(Uri uri, String[] columns, String whereClause, String[] whereArgs,
			String orderBy) {
		
		MoviesDB db = new MoviesDB(getContext());
		SQLiteDatabase sqlDB = db.getWritableDatabase();
		
		Cursor cursor = sqlDB.query("movies", columns, whereClause, whereArgs, null, null, orderBy);
		
		sqlDB.close();
		
		return cursor;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
