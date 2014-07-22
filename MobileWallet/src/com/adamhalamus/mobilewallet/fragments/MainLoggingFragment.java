package com.adamhalamus.mobilewallet.fragments;

import com.adamhalamus.mobilewallet.R;
import com.adamhalamus.mobilewallet.activities.MainLoggingCommunicator;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainLoggingFragment extends Fragment{
	
	MainLoggingCommunicator comm;
	
	Button button;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_main_logging, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		comm = (MainLoggingCommunicator) getActivity();
		button = (Button) getActivity().findViewById(R.id.testButton);
		
		setLogginButtonListener(button);
		
	}

	private void setLogginButtonListener(Button button) {
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				comm.respond(1);
			}
		});
	}
	

}
