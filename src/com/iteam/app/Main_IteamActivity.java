package com.iteam.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Main_IteamActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_iteam);
        innitView();
	}

	private void innitView() {
		// TODO Auto-generated method stub
		
	}
}
