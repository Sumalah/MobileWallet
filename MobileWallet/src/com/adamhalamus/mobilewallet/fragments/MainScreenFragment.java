package com.adamhalamus.mobilewallet.fragments;

import com.adamhalamus.mobilewallet.R;
import com.adamhalamus.mobilewallet.activities.LoggingActivity;
import com.adamhalamus.mobilewallet.activities.LoggingCommunicator;
import com.adamhalamus.mobilewallet.activities.MainActivity;
import com.adamhalamus.mobilewallet.tools.LoggingValues;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreenFragment extends Fragment{
	
	TextView networkStatusTextView;
	Button signInButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_main_screen, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		defineAllViewElements();
		changeNetworkStatusTextView();
		
		signInButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), LoggingActivity.class);
				startActivity(intent);
			}
		});
	}
	
	private void changeNetworkStatusTextView() {
		if(isUserConnected()){
			networkStatusTextView.setTextColor(getResources().getColor(R.color.networkStatusGreen));
			networkStatusTextView.setText("ONLINE");
		}
	}

	private void defineAllViewElements(){
		networkStatusTextView = (TextView) getActivity().findViewById(R.id.networkStatusTextView);
		signInButton = (Button) getActivity().findViewById(R.id.signInButton);
	}
	
	private boolean isUserConnected(){
		return LoggingValues.getSharedPreferencesValue("NetworkStatus", getActivity());
	}
}
