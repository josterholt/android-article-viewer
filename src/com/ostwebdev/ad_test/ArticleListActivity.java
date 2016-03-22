package com.ostwebdev.ad_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ArticleListActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Debug", "In ArticleListActivity");
        /*
        TextView textview = new TextView(this);
        textview.setText("This is the Article tab");
        setContentView(textview);
        */
        
	    ArrayList<Article> articleList = new ArrayList<Article>();
		   Log.d("Debug", "Getting articles");
		   articleList = queryRESTURL("http://www.ostwebdev.com/templates/android_json_test");
	       ArticleAdapter articleAdapter = new ArticleAdapter( 
					this,
					articleList ); 
	       setListAdapter( articleAdapter );
        
    }
    
	public ArrayList<Article> queryRESTURL(String url) {
		ArrayList<Article> listItems = new ArrayList<Article>();
		Log.d("Debug", "Getting data...");
        try {
        	Log.d("Debug", "URL: " + url);
            URL twitter = new URL(url);
            URLConnection tc = twitter.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    tc.getInputStream()));
 
            String line;
            String dataFeed = new String();
            while ((line = in.readLine()) != null) {
            	Log.d("Data", line);
            	dataFeed += line;
            }
            JSONArray ja = new JSONArray(dataFeed);
            Log.d("Debug", "Items returned: " + ja.length());
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = (JSONObject) ja.get(i);
                Log.d("Debug", jo.get("title").toString());
                Article article = new Article(jo.get("title").toString(), jo.get("url").toString(), jo.get("abstract").toString(), jo.get("thumbnail").toString());
                listItems.add(article);
            }
            
        }  catch (JSONException e) {
			Log.e("REST", "There was a JSON based error", e);
		} catch (IOException e) {
			Log.e("REST", "There was an IO Stream related error", e);
		}
		return listItems;
		
	}
}