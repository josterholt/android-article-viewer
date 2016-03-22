package com.ostwebdev.ad_test;

import android.content.ComponentName;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.util.Log;

public class notifier extends BroadcastReceiver {
	@Override
    public void onReceive(Context context, Intent intent) {
		/*
		Intent startupIntent = new Intent(context, ADTestActivity.class);
		startupIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(startupIntent);
		*/
		/*
    	if( "android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
    		ComponentName comp = new ComponentName(context.getPackageName(), ADNotifierService.class.getName());
    		ComponentName service = context.startService(new Intent().setComponent(comp));
    		if (null == service) {
    			Log.e("Foo", "Could not start service " + comp.toString());
    		}
    	} else {
    		Log.e("Foo", "Received unexpected intent" + intent.toString());
    	}
    	*/
		Log.e("Foo", "Starting service...");
		Intent serviceIntent = new Intent(context, ADNotifierService.class);
		//serviceIntent.setAction("com.ostwebdev.ad_test.ADNotifierService");
		context.startService(serviceIntent);
		
    }
}
