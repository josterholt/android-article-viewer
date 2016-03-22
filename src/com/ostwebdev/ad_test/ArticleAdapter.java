package com.ostwebdev.ad_test;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

class ArticleAdapterView extends LinearLayout {        
    public ArticleAdapterView(Context context, final Article article ) {
        super( context );
   		
        LinearLayout ll = new LinearLayout(context);
        ll.setClickable(true);
        
        ll.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        ll.setOrientation(VERTICAL);
        
        LinearLayout.LayoutParams titleParams = 
            new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        //titleParams.setMargins(1, 1, 1, 1);

        TextView titleControl = new TextView( context );
        titleControl.setText( article.getTitle() );
        titleControl.setTextSize(14f);
        titleControl.setTextColor(Color.WHITE);
        ll.addView( titleControl, titleParams);       

        LinearLayout.LayoutParams summaryParams = 
            new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        //summaryParams.setMargins(1, 1, 1, 1);

        TextView summaryControl = new TextView(context);
        summaryControl.setText( article.getAbstract() );
        summaryControl.setTextSize( 14f );
        summaryControl.setTextColor(Color.WHITE);
        ll.addView(summaryControl, summaryParams);

        LinearLayout.LayoutParams thumbnailParams = 
                new LinearLayout.LayoutParams(120, LayoutParams.WRAP_CONTENT);
            thumbnailParams.setMargins(4, 4, 4, 0);

    		ImageView thumbnailControl = new ImageView( context );
    		thumbnailControl.setImageBitmap(article.getThumbnail(context) );
    		thumbnailControl.setClickable(true);
    		addView( thumbnailControl, thumbnailParams );

        ll.setOnClickListener(new OnClickListener() {
		      @Override
	    	  public void onClick(View view) {
		    	  /*
	    		  Intent intent = new Intent(view.getContext(), ADTestActivity.class);
	    		  view.getContext().startActivity(intent);
	    		  */
		    	  Log.d("Debug", "Click");
		    	  Log.d("Debug", article.getTitle());
	    	  }
	       });
        //Add text fields to main layout
        addView(ll);
    }
    
}

public class ArticleAdapter extends BaseAdapter {
	private Context context;
    private List<Article> articleList;

    public ArticleAdapter(Context context, List<Article> articleList ) { 
        this.context = context;
        this.articleList = articleList;
    }

    public int getCount() {                        
        return articleList.size();
    }

    public Object getItem(int position) {     
        return articleList.get(position);
    }

    public long getItemId(int position) {  
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) { 
        Article article = articleList.get(position);
        return new ArticleAdapterView(this.context, article);
    }
    
}
