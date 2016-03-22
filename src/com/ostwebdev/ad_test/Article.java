package com.ostwebdev.ad_test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class Article {
	public String mTitle = null;
	public String mAbstract = null;
	public String mURL = null;
	public String mThumbnailURL = null;
	
	public Article(String title, String url, String summary, String thumbnail_url) {
		mTitle = title;
		mAbstract = summary;
		mURL = url;
		Log.d("Debug", "Setting TURL: " + thumbnail_url);
		mThumbnailURL = thumbnail_url;
	}
	
	public String getTitle() {
		return mTitle;
	}
	
	public String getAbstract() {
		return mAbstract;
	}
	
	public Bitmap getThumbnail(Context context) {
		Bitmap bm = null;
		if (this.mThumbnailURL != null && this.mThumbnailURL != "")
		{
			URL url;
			try {
				Log.d("Debug", "Thumbnail URL: " + this.mThumbnailURL);
				url = new URL(this.mThumbnailURL);
				URLConnection conn = url.openConnection();
				conn.connect();
				InputStream is= conn.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				bm = BitmapFactory.decodeStream(bis);
				bis.close();
				is.close();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			Log.d("Debug", "Going with default");
			bm =  BitmapFactory.decodeResource(context.getResources(), R.drawable.icon);
		}
		Log.d("Debug", "Image width: " + bm.getWidth());
		Log.d("Debug", "Image Height: " + bm.getHeight());
		return bm;
	}
}
