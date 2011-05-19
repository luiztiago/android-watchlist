package com.luiztiago.android.imdb;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieActivity extends SearchActivity implements OnClickListener {
	
	private ImageView imageMovie;
	public Movies movie;
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movie);
		
		String imageLocation = null;
		Bitmap bm;
		URL url;
		//Movies movie = SearchActivity.movie;
		
		movie = null;
		if (getIntent().getSerializableExtra("movie") != null){
			movie = (Movies)getIntent().getSerializableExtra("movie");
			
			TextView fieldTitle = (TextView)findViewById(R.id.fieldTitle);
			fieldTitle.setText(movie.getTitle());
			
			TextView fieldRating = (TextView)findViewById(R.id.fieldRating);
			fieldRating.setText(movie.getRating());
			
			TextView fieldGenres = (TextView)findViewById(R.id.fieldGenres);
			fieldGenres.setText(movie.getGenres());
			
			TextView fieldImdb = (TextView)findViewById(R.id.fieldImdb);
			fieldImdb.setText(movie.getImdburl());
		}
		
		
//		Log.i("Luiz", movie.getTitle());
//		
//		TextView fieldTitle = (TextView)findViewById(R.id.fieldTitle);
//		fieldTitle.setText(movie.getTitle());
//		
//		TextView fieldRating = (TextView)findViewById(R.id.fieldRating);
//		fieldRating.setText(movie.getRating());
//		
//		TextView fieldGenres = (TextView)findViewById(R.id.fieldGenres);
//		fieldGenres.setText(movie.getGenres());
//		
//		TextView fieldImdb = (TextView)findViewById(R.id.fieldImdb);
//		fieldImdb.setText(movie.getImdburl());
		
		//RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar1);
		//ratingBar.setRating(movie.getRating());
		//System.out.println(ratingBar.getRating());
		//System.out.println(ratingBar.getNumStars());
		//ratingBar.setNumStars(5);
		
		//Uri imageURI = new Uri("http://developer.android.com/images/dialog_buttons.png");
		
//		try {
//			url = new URL("http://api.movieposterdb.com/json?api_key=demo&secret=b3b39cbcb1ee&width=100&title="+movie.getTitle());
//			String json = MoviesJSON.getJSONdata(url);
//			Log.i("L",url.toString());
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			
//			url = new URL("http://api.movieposterdb.com/json?api_key=demo&secret=b3b39cbcb1ee&width=100&title="+movie.getTitle());
//			String json = MoviesJSON.getJSONdata(url);
//			Log.i("L",url.toString());
//			
//			JSONObject obj = new JSONObject( json );
//			JSONArray posters = obj.getJSONArray("posters");
//			
//			
//			int len = posters.length();
//			for(int i = 0; i < len; ++i) {
//			    JSONObject posterObj = posters.getJSONObject(i);
//			    imageLocation = posterObj.getString("image_location");
//			    Log.i("L",imageLocation.toString());
//			}
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(imageLocation != null) {
//			bm = getImageBitmap(imageLocation);
//			
//			//movieName = (EditText)findViewById(R.id.movieName);
//			imageMovie = (ImageView)findViewById(R.id.imageMovie);
//			imageMovie.setImageBitmap(bm);
//		
//		}else{
//			bm = getImageBitmap("http://developer.android.com/images/dialog_buttons.png");
//		}
		//setImageURI("http://developer.android.com/images/dialog_buttons.png");
		
		//final LoaderImageView image = new LoaderImageView(this, "http://developer.android.com/images/dialog_buttons.png");
		
		//movieName.setText(movie.getTitle());
		//movieName.setText("Testeeeeee");
		
		bm = getImageBitmap("http://api.movieposterdb.com/cache/normal/69/800369/800369_100.jpg");
		imageMovie = (ImageView)findViewById(R.id.imageMovie);
		imageMovie.setImageBitmap(bm);
		
	}
	
	private Bitmap getImageBitmap(String url) { 
        Bitmap bm = null; 
        try { 
            URL aURL = new URL(url); 
            URLConnection conn = aURL.openConnection(); 
            conn.connect(); 
            InputStream is = conn.getInputStream(); 
            BufferedInputStream bis = new BufferedInputStream(is); 
            bm = BitmapFactory.decodeStream(bis); 
            bis.close(); 
            is.close(); 
       } catch (IOException e) { 
           Log.i("Error", "Error getting bitmap"); 
       } 
       return bm; 
    }

	public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(0, 1, 0, "Mark to watch");
    	menu.add(1, 2, 0, "Mark as watched");
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
    	
    	if (item.getItemId() == 1) {
    		
    		MoviesDB db = new MoviesDB(this);
    		System.out.println(movie);
			db.save(movie);
			Toast.makeText(self, "Adicionado com sucesso",
					Toast.LENGTH_SHORT).show();
    		
//    		AlertDialog.Builder builder = new AlertDialog.Builder(this)
//    			.setTitle("Titulo")
//    			.setMessage("Mensagem")
//    			.setPositiveButton("OK", (android.content.DialogInterface.OnClickListener) this)
//    			.setNegativeButton("Cancelar", (android.content.DialogInterface.OnClickListener) this);
//    		builder.create().show();
    	}else if (item.getItemId() == 2){
    		// Trator FAKE
    	}
    	
    	return super.onMenuItemSelected(featureId, item);
    }

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		if (which == DialogInterface.BUTTON_POSITIVE) {
			Toast.makeText(this, "Bot‹o 1", Toast.LENGTH_SHORT).show();
		} else if (which == DialogInterface.BUTTON_NEUTRAL) {
			Toast.makeText(this, "Bot‹o 3", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "Bot‹o 2", Toast.LENGTH_SHORT).show();
		}
	}

//	private void onClick(DialogInterface dialog, int which) {
//		if (which == DialogInterface.BUTTON_POSITIVE) {
//			Toast.makeText(this, "Bot‹o 1", Toast.LENGTH_SHORT).show();
//		}else if(which == DialogInterface.BUTTON_NEUTRAL) {
//			Toast.makeText(this, "Bot‹o 3", Toast.LENGTH_SHORT).show();
//		}else{
//			Toast.makeText(this, "Bot‹o 2", Toast.LENGTH_SHORT).show();
//		}
//
//	}
	
}