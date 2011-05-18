package com.luiztiago.android.imdb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class Utils {
	public static boolean isNetworkAvailable(Context context) { 
		
		//@LuizTiago
		//Got in: http://groups.google.com/group/android-developers/browse_thread/thread/65cdc456b93ad2d9
		
        ConnectivityManager connectivity = (ConnectivityManager) context 
                .getSystemService(Context.CONNECTIVITY_SERVICE); 
        if (connectivity == null) { 
            Log.w("AndroidIMDB", "couldn't get connectivity manager"); 
        } else { 
            NetworkInfo[] info = connectivity.getAllNetworkInfo(); 
            if (info != null) { 
                for (int i = 0; i < info.length; i++) { 
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) { 
                        return true; 
                    } 
                } 
            } 
        } 
        return false; 
    } 
}
