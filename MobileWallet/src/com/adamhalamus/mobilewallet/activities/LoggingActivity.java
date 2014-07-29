package com.adamhalamus.mobilewallet.activities;

import com.adamhalamus.mobilewallet.R;
import com.adamhalamus.mobilewallet.fragments.LoggingFragment;
import com.adamhalamus.mobilewallet.fragments.RegistrationFragment;
import com.adamhalamus.mobilewallet.tools.LoggingValues;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class LoggingActivity extends ActionBarActivity implements LoggingCommunicator{
	
	LoggingFragment loggingFragment = new LoggingFragment();
	RegistrationFragment registrationFragment = new RegistrationFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logging);
		
		setDefaultFragment();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.logging, menu);
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

	private void setDefaultFragment(){
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.activity_main_layout, loggingFragment, "loggingFragment");
		fragmentTransaction.addToBackStack("loggingFragment");
		fragmentTransaction.commit();
	}
	
	@Override
	public void changeFragment(int value, String message) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		
		if(value == LoggingValues.LOGGING_INVALID){			
			showToast(message);
		} else if(value == LoggingValues.LOGGING_VALID){
			LoggingValues.setSharedPreferencesBoolValue("NetworkStatus", true, this);
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		} else if(value == LoggingValues.REGISTRATION){
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.activity_main_layout, registrationFragment, "registrationFragment");
			fragmentTransaction.addToBackStack("registrationFragment");
			fragmentTransaction.commit();
		}
		
	}
	
	private void showToast(String message){
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, message, duration);
		toast.show();
	}
}
