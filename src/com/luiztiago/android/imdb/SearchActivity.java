package com.luiztiago.android.imdb;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends DefaultActivity {

	final Activity self = this;
	
	Movies movie;
	EditText fieldSearch;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.search);
		
		fieldSearch = (EditText) findViewById(R.id.fieldSearch);
		fieldSearch.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// If the event is a key-down event on the "enter" button
				if ((event.getAction() == KeyEvent.ACTION_DOWN)
						&& (keyCode == KeyEvent.KEYCODE_ENTER)) {
					// Perform action on key press
					//Toast.makeText(self, fieldSearch.getText(),
					//		Toast.LENGTH_SHORT).show();
					
					searchMovie();
					
					return true;
				}
				return false;
			}
		});
		
		Button btnSearch = (Button) findViewById(R.id.buttonSearch);
		btnSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				searchMovie();
			}
		});

	}
	
	public void searchMovie(){
		//fieldSearch = (EditText) findViewById(R.id.fieldSearch);
		if (Utils.isNetworkAvailable(self)) {
			String search = fieldSearch.getText().toString();
			Toast.makeText(self, "Searching movies with: " + search,
					Toast.LENGTH_LONG).show();

			runJSONParser(search);
		} else {
			Toast.makeText(self, "You're without internet connection",
					Toast.LENGTH_LONG).show();
		}
	}

	public InputStream getJSONData(String url) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		URI uri;
		InputStream data = null;
		try {
			uri = new URI(url);
			HttpGet method = new HttpGet(uri);
			HttpResponse response = httpClient.execute(method);
			data = response.getEntity().getContent();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	/*
	 * private String getJSONdata(URL url) { // TODO Auto-generated method stub
	 * String json = new String(""); try { HttpURLConnection conn =
	 * (HttpURLConnection)url.openConnection();
	 * 
	 * conn.setDoInput(true); conn.setDoOutput(true);
	 * 
	 * InputStream is = conn.getInputStream();
	 * 
	 * byte[] buffer = new byte[1024]; ByteArrayOutputStream baos = new
	 * ByteArrayOutputStream(); int readed; while ( ( readed = is.read(buffer))
	 * > 0 ) { baos.write(buffer, 0, readed); }
	 * 
	 * json = new String(baos.toByteArray());
	 * 
	 * // for (Movie mov : objs.getMovies()) { // Log.i("MOVIES", mov.getTitle()
	 * + " - " + mov.getRating()); // }
	 * 
	 * } catch (Exception ex) { ex.printStackTrace(); }
	 * 
	 * return json; }
	 */

	public void runJSONParser(String search) {
		try {
			// URL url = new
			// URL("http://www.deanclatworthy.com/imdb/?year=&submit=Submit&type=json&q="+search);
			// HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//
			// conn.setDoInput(true);
			// conn.setDoOutput(true);
			//
			// InputStream is = conn.getInputStream();
			//
			// byte[] buffer = new byte[1024];
			// ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// int readed;
			// while ( ( readed = is.read(buffer)) > 0 ) {
			// baos.write(buffer, 0, readed);
			// }
			//
			// String json = new String(baos.toByteArray());

			URL url = new URL(
					"http://www.deanclatworthy.com/imdb/?year=&submit=Submit&type=json&q="
							+ search);
			String json = MoviesJSON.getJSONdata(url);
			Log.i("Luiz", json.toString());

			JSONObject obj = new JSONObject(json);
			String title = obj.getString("title");
			String rating = obj.getString("rating");
			String imdburl = obj.getString("imdburl");
			String country = obj.getString("country");
			String languages = obj.getString("languages");
			String genres = obj.getString("genres");
			String votes = obj.getString("votes");
			String year = obj.getString("year");

			movie = new Movies(title, rating, imdburl, country, languages,
					genres, votes, year);
			Log.i("Luiz", title);
			Log.i("Luiz", "Rating: " + movie.getRating());

			Intent it = new Intent(self, MovieActivity.class);
			it.putExtra("movie", movie);
			startActivity(it);

		} catch (Exception ex) {
			Toast.makeText(self, "WebService without response.",
					Toast.LENGTH_LONG).show();
			ex.printStackTrace();
		}
	}

}
