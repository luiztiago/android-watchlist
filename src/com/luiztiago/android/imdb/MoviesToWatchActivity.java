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

public class MoviesToWatchActivity extends ListActivity {
	
	final Activity self = this;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.listmovies);
		
		MoviesDB db = new MoviesDB(this);

		final List<Movies> movies = db.list();

		if(movies.size() > 0) {
			ArrayAdapter<Movies> adapter = new ArrayAdapter<Movies>(this,
					android.R.layout.simple_list_item_1, movies) {
				@Override
				public long getItemId(int position) {
					return movies.get(position).getId();
				}
			};
			setListAdapter(adapter);
		}else{
			ArrayList<String> noResults = new ArrayList<String>();
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, noResults);
			noResults.add("Nenhum resultado encontrado");
			setListAdapter(adapter);
		}

		registerForContextMenu(getListView());

	}
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		Movies movie = (Movies)l.getAdapter().getItem(position);
		
		Intent it = new Intent(self, MovieActivity.class);
		it.putExtra("movie", movie);
		startActivity(it);
	}

}
