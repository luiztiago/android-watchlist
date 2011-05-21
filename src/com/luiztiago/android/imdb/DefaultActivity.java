package com.luiztiago.android.imdb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class DefaultActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Activity self = this;
        // SEARCH BUTTON
        findViewById(R.id.searchButton).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(self, SearchActivity.class);
				startActivity(it);
			}
		});
        
     // MOVIES TO WATCH BUTTON
        findViewById(R.id.moviesToWatchButton).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(self, MoviesToWatchActivity.class);
				startActivity(it);
			}
		});
        
        // WATCHED MOVIES BUTTON
        findViewById(R.id.watchedMoviesButton).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(self, WatchedMoviesActivity.class);
				startActivity(it);
			}
		});
        
    }
}