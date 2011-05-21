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
	
	public Movies movie;
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movie);
		
		movie = null;
		
		// RECEBE O OBJETO MOVIE
		if (getIntent().getSerializableExtra("movie") != null){
			movie = (Movies)getIntent().getSerializableExtra("movie");
			
			// SETA O TITULO DO FILME
			TextView fieldTitle = (TextView)findViewById(R.id.fieldTitle);
			if(movie.getYear() != null && movie.getYear() != "null"){
				fieldTitle.setText(movie.getTitle() + " (" + movie.getYear() + ")");
			}else{
				fieldTitle.setText(movie.getTitle());
			}
			
			// SETA O RATING DO FILME
			TextView fieldRating = (TextView)findViewById(R.id.fieldRating);
			fieldRating.setText(movie.getRating());
			
			// SETA O GENRE DO FILME
			TextView fieldGenres = (TextView)findViewById(R.id.fieldGenres);
			fieldGenres.setText(movie.getGenres());
			
			// SETA O IMDB LINK DO FILME
			TextView fieldImdb = (TextView)findViewById(R.id.fieldImdb);
			fieldImdb.setText(movie.getImdburl());
			
			// SETA O PLOT DO FILME
			TextView fieldPlot = (TextView)findViewById(R.id.fieldPlot);
			fieldPlot.setText(movie.getPlot());
			
			// SETA A IMAGEM DO FILME
			ImageView imageMovie = (ImageView)findViewById(R.id.imageMovie);
			Bitmap bm = getImageBitmap(movie.getPoster());
			imageMovie.setImageBitmap(bm);
		}
		
		
	}
	
	private Bitmap getImageBitmap(String url) { 
		// RETORNA O IMAGEBITMAP ATRAVES DA URL
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
		// MENU PARA MARCAR COMO ASSISTIDO E A ASSISTIR
		menu.add(0, 1, 0, "Mark to watch");
    	menu.add(1, 2, 0, "Mark as watched");
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
    	
    	// CLIQUE DOS BOTOES PARA MARCACAO
    	if (item.getItemId() == 1) {
    		
    		MoviesDB db = new MoviesDB(this);
    		System.out.println(movie);
    		movie.setType(1);
    		db.save(movie);
    		Toast.makeText(self, "Marked successfuly",
					Toast.LENGTH_SHORT).show();
    		
    	}else if (item.getItemId() == 2){
    	
    		MoviesDB db = new MoviesDB(this);
    		System.out.println(movie);
    		movie.setType(2);
			db.save(movie);
			Toast.makeText(self, "Marked successfuly",
					Toast.LENGTH_SHORT).show();
			
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
	
}