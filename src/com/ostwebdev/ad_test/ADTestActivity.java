

package com.ostwebdev.ad_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.app.Activity;
import android.app.ListActivity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class ADTestActivity extends TabActivity {
    static final String[] COUNTRIES = new String[] {
    	"A", "B", "C"
    };
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
		Log.d("Debug", "Started onCreate");
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        Log.d("Debug", "Init intent");
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, ArticleListActivity.class);

        Log.d("Debug", "Spec setup");
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("artists").setIndicator("Articles",
        		res.getDrawable(R.drawable.ic_tab_artists))
                .setContent(intent);
        Log.d("Debug", "Adding article tab");
        tabHost.addTab(spec);
        tabHost.setCurrentTab(1);
	}
}