package com.example.welcome;

import android.os.Bundle;
 
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;


public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent=new Intent();
		intent.setClass(MainActivity.this,WelcomeActivity.class);
		//界面传递，从Main界面到Welcome界面
		startActivity(intent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
