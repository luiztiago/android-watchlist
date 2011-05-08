package com.luiztiago.android.imdb;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class SearchActivity extends DefaultActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.search);

		final Activity self = this;

		Button btnSearch = (Button) findViewById(R.id.buttonSearch);
		btnSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText fieldSearch = (EditText) findViewById(R.id.fieldSearch);
				Toast.makeText(self, "Searching movies with: " + fieldSearch.getText(),
						Toast.LENGTH_LONG).show();
				
				//String response = null;
				//movies movie = new Gson().fromJson(response, movies.class);

				String movie = getJson();
				
				Toast.makeText(self, (String)movie, Toast.LENGTH_LONG).show();
				
				//EditText textMovies = (EditText)findViewById(R.id.textMovies);
				//textMovies.setText((String)movie.toString());
				
				//Log.d("Luiz", movie.toString());
				
			}
		});
		
	}
	
	public static String getJson(){
		
		//List<movies> movies = null;
		movies movie = null;
		
		WebService webService = new WebService(
				"http://www.deanclatworthy.com/imdb/");
		//WebService webService = new WebService("http://www.sumasoftware.com/alerts/GetAlerts.php");

		Map<String, String> params = new HashMap<String, String>();
		//params.put("param", "");
		
		params.put("q", "Thor");
		params.put("year", "");
		params.put("type", "json");

		// Get JSON response from server the "" are where the method name would
		// normally go if needed example
		// webService.webGet("getMoreAllerts", params);
		String response = webService.webGet("", params);

		try {
			// Parse Response into our object
			//Type collectionType = new TypeToken<List<movies>>() {}.getType();
			//movies = new Gson().fromJson(response, collectionType);
			
			movie = new Gson().fromJson(response, movies.class);

		} catch (Exception e) {
			Log.d("Error: ", e.getMessage());
		}
		
		return movie.toString();
	}
	
	public class movies {
		 
//	    public String title;
//	    public String imdburl;
//	    public String country;
//	    public String languages;
//	    public String genres;
//	    public String rating;
//	    public String votes;
//	    public String year;
//	 
//	    @Override
//	    public String toString()
//	    {
//	        return "Title: " + title + " | IMDB: " + imdburl + " | Rating: " + rating;
//	    }
		
		public int alertid;
	    public String alerttext;
	    public String alertdate;
	 
	    @Override
	    public String toString()
	    {
	        return "Alert ID: "+alertid+ " Alert Text: "+alerttext+ " Alert Date: "+alertdate;
	 
	    }
		
	}

}
