package com.adamhalamus.mobilewallet.activities;

import com.adamhalamus.mobilewallet.R;
import com.adamhalamus.mobilewallet.fragments.MainInvalidLoggingFragment;
import com.adamhalamus.mobilewallet.fragments.MainLoggingFragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity implements MainLoggingCommunicator{
	
	final int LOGGING_VALID = 0;
	final int LOGGING_INVALID = 1;
	final int REGISTRATION = 2;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MainInvalidLoggingFragment invalidLoggingFragment = new MainInvalidLoggingFragment();
		MainLoggingFragment loggingFragment = new MainLoggingFragment();
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.activity_main_layout, loggingFragment, "loggingFragment");
		fragmentTransaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	
	@Override
	public void respond(int value) {
		if(value == LOGGING_INVALID){	
			System.out.println("trololo");
			FragmentManager fragmentManager = getSupportFragmentManager();
			MainInvalidLoggingFragment invalidLoggingFragment = new MainInvalidLoggingFragment();
			
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.activity_main_layout, invalidLoggingFragment, "invalidLoggingFragment");
			fragmentTransaction.commit();
		}
		
	}
}
