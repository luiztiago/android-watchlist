package com.luiztiago.android.imdb;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WatchedMoviesActivity extends ListActivity {
	final Activity self = this;
	public List<Movies> movies;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.listmovies);
		
		getMovies();

	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		
		getMovies();
	}
	
	public void getMovies() {
		
		MoviesDB db = new MoviesDB(this);

		//final List<Movies> movies = db.list();
		movies = db.list(2);
		final List<String> listMovies = db.listMovies(2);
		
		if(movies.size() > 0) {
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, listMovies) {
//				public long getItemId(int position) {
//					return movies.get(position).getId();
//				}
			};
			setListAdapter(adapter);
		}else{
			ArrayList<String> noResults = new ArrayList<String>();
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, noResults);
			noResults.add("No results");
			setListAdapter(adapter);
		}

		registerForContextMenu(getListView());
		
	}
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		//Movies movie = (Movies)l.getAdapter().getItem(position);
		Movies movie = movies.get(position); 
		
		Intent it = new Intent(self, MovieActivity.class);
		it.putExtra("movie", movie);
		startActivity(it);
	}
}
