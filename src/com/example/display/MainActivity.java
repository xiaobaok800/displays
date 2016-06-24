package com.example.display;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private Button btLogin;
    private ViceDisplay mViceDisplay;//¸±ÆÁ
	private EditText etUser;
	private EditText etPsd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		InitView();
	}
	private void InitView(){
		etUser=(EditText)findViewById(R.id.et_user_name);
		etPsd=(EditText)findViewById(R.id.et_pass_word);
		btLogin=(Button)findViewById(R.id.bt_login);
		btLogin.setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			
			mViceDisplay = new ViceDisplay(MainActivity.this);
			mViceDisplay.Show();
		}
	};
}
