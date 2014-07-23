package com.adamhalamus.mobilewallet.fragments;

import com.adamhalamus.mobilewallet.R;
import com.adamhalamus.mobilewallet.activities.MainLoggingCommunicator;
import com.adamhalamus.mobilewallet.tools.LoggingValues;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainLoggingFragment extends Fragment{
	
	MainLoggingCommunicator comm;
	
	Button loggingButton;
	Button registerButton;
	EditText loginEditText;
	EditText passwordEditText;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_main_logging, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		comm = (MainLoggingCommunicator) getActivity();
		defineAllViewElements();
		
		loggingButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int fragmentChangeValue;
				String message = null;
				
				if(!fieldsEmpty()){
					if(areLoggingParamsValid()){
						fragmentChangeValue = LoggingValues.LOGGING_VALID;
					} else {
						fragmentChangeValue = LoggingValues.LOGGING_INVALID;
						message = "Wrong User/Password";
					}
				} else {
					fragmentChangeValue = LoggingValues.LOGGING_INVALID;
					message = "Please fill all fields";
				}

				comm.changeFragment(fragmentChangeValue, message);
			}
		});
		
		registerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				comm.changeFragment(LoggingValues.REGISTRATION, null);
			}
		});
		
	}

	
	private void defineAllViewElements(){
		loggingButton = (Button) getActivity().findViewById(R.id.loggingButton);
		registerButton = (Button) getActivity().findViewById(R.id.registerButton);
		loginEditText = (EditText) getActivity().findViewById(R.id.loggingLoginEditText);
		passwordEditText = (EditText) getActivity().findViewById(R.id.loggingPasswordEditText);
	}
	
	private boolean areLoggingParamsValid(){
		//poki co na pale sztywne wartosci
		if (loginEditText.getText().toString().equals("adam") 
			&& passwordEditText.getText().toString().equals("pass")){
			return true;
		} else {
			return false;
		}
	}
	
	private boolean fieldsEmpty(){
		if (loginEditText.getText().toString().equals("") 
				|| passwordEditText.getText().toString().equals("")){
				return true;
		} else {
			return false;
		}
	}
}
