package com.iteam.app;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.os.Bundle;
import android.widget.Button;

public class LoginActivity extends Activity {
	
	Button sign_bt;
	Button login_bt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.longin);
        innitView();
	}
	private void innitView() {
		sign_bt = (Button)findViewById(R.id.sign_in_bt);
		login_bt = (Button)findViewById(R.id.login);
		sign_bt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(LoginActivity.this, SignInActivity.class);
				startActivity(intent);
			}
		});
		login_bt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(LoginActivity.this, Main_IteamActivity.class);
				startActivity(intent);
			}
		});
	}
	
}
