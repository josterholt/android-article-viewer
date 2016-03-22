<?xml version="1.0" encoding="utf-8"?>
<LinearList xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="wrap_content" android:layout_height="wrap_content">
    <ImageView android:id="@+id/icon" 
        android:src="@drawable/icon"
        android:layout_width="120px"
        android:layout_height="wrap_content"
        android:layout_marginTop="4px"
        android:layout_marginRight="4px"
        android:layout_marginLeft="4px">
    </ImageView>
    <LinearLayout android:id="@+id/LinearLayout01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <TextView 
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:id="@android:id/title"
        android:textSize="30px"></TextView>
        <TextView 
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:id="@android:id/summary"
        android:textSize="15px"></TextView>
    </LinearLayout>        
</LinearList>