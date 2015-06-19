package com.example.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class MainActivity extends Activity
{
	EditText username,password;
	CheckBox cb;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		username=(EditText)findViewById(R.id.editText1);
		password=(EditText)findViewById(R.id.editText2);
		cb=(CheckBox)findViewById(R.id.checkBox1);
		
		//SharedPreferences sp = getSharedPreferences(name, mode)
		SharedPreferences sp = getSharedPreferences("MyPrefsFile",0);
		//et.setText(sp.getString(arg0, arg1))
		username.setText(sp.getString("user_key", ""));
		password.setText(sp.getString("pass_key", ""));
		cb.setChecked(sp.getBoolean("key_state", false));
		
		
		
		cb.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) 
			{
				// TODO Auto-generated method stub
				
				if (arg1==true) 
				{
				
						SharedPreferences sp = getSharedPreferences("MyPrefsFile",0);
						SharedPreferences.Editor ed= sp.edit();
						ed.putString("user_key", username.getText().toString());
						ed.putString("pass_key", password.getText().toString());
						ed.putBoolean("key_state", true);
						ed.commit();
						
						
				}
				
				if (arg1==false)
				{
					SharedPreferences sp = getSharedPreferences("MyPrefsFile",0);
					SharedPreferences.Editor ed= sp.edit();
					//ed.putString("e_key", et.getText().toString());
					ed.remove(sp.getString("user_key", username.getText().toString()));
					ed.remove(sp.getString("pass_key", password.getText().toString()));
					ed.putBoolean("key_state", false);
					ed.clear().commit();
					
				}
				
				
			}
		});
	}
	
	
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
