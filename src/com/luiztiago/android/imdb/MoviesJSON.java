package com.luiztiago.android.imdb;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MoviesJSON {
	public static String getJSONdata(URL url) {
		// TODO Auto-generated method stub
		String json = new String("");
		try {
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			conn.setDoInput(true);
			conn.setDoOutput(true);
			
			InputStream is = conn.getInputStream();
			
			byte[] buffer = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int readed;
			while ( ( readed = is.read(buffer)) > 0 ) {
				baos.write(buffer, 0, readed);
			}
			
			json = new String(baos.toByteArray());
			
//			for (Movie mov : objs.getMovies()) {
//				Log.i("MOVIES", mov.getTitle() + " - " + mov.getRating());
//			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return json;
	}
}
