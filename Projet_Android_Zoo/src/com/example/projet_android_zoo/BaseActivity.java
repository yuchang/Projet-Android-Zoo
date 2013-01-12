package com.example.projet_android_zoo;

import android.os.Bundle;
import android.app.Activity;

public class BaseActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		AppManager.getAppManager().addActivity(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		AppManager.getAppManager().finishActivity(this);
	}
	
}
