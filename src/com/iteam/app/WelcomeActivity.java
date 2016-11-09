package com.iteam.app;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
//import android.support.v7.appcompat.*;
//import com.iteam.*;

public class WelcomeActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome);
        final Intent intent = new Intent(this, Login.class); // 要转向的Activity
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
               startActivity(intent); // 启动新的Activity
               //MyNowActivity.this.finish();
            }
        };
        timer.schedule(task, 1000 * 1.5); // 8秒后执行
	}
}
