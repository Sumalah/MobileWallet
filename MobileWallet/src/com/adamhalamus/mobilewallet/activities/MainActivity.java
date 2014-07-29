package com.adamhalamus.mobilewallet.activities;

import com.adamhalamus.mobilewallet.R;
import com.adamhalamus.mobilewallet.R.id;
import com.adamhalamus.mobilewallet.R.layout;
import com.adamhalamus.mobilewallet.R.menu;
import com.adamhalamus.mobilewallet.fragments.MainScreenFragment;
import com.adamhalamus.mobilewallet.tools.LoggingValues;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemClickListener {
	
	MainScreenFragment mainScreenFragment = new MainScreenFragment();
	private DrawerLayout drawerLayout;
	private ListView listView;
	private String[] drawerMenuList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
		
		setDefaultFragment();
		defineAllViewElements();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
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
		fragmentTransaction.add(R.id.activity_main_screen, mainScreenFragment, "mainScreenFragment");
		fragmentTransaction.addToBackStack("mainScreenFragment");
		fragmentTransaction.commit();
	}
	
	private void defineAllViewElements(){
		drawerMenuList = getResources().getStringArray(R.array.menuList);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		listView = (ListView) findViewById(R.id.drawerList);
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drawerMenuList));
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(this, drawerMenuList[position], Toast.LENGTH_SHORT).show();
		setTitle(drawerMenuList[position]);
	}
	
	private void setTitle(String title){
		getSupportActionBar().setTitle(title);
	}
}
