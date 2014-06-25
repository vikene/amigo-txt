/* ********************************Amigo-Txt*******************
 * activity2.java -- SmsSender for Amigo-Txt
 * Copyright (c) 2014 Vigneash sundar
 * 
 * 
 * this source is currently experimental !! 
 * 
 *    
 */


package in.vigneashsundar.page_navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.content.Intent;
import android.annotation.SuppressLint;
import android.widget.EditText;
import android.widget.Button;
import android.telephony.SmsManager;


public class activity2 extends Activity {

		@SuppressLint("NewApi")
	/** Called when the activity is first created. */
	String number;
	Button but;
	EditText text1;
	
		@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_2);
	    
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	    
	    but = (Button)findViewById(R.id.button1);
	    text1 = (EditText) findViewById(R.id.editText1);
	    
	     Intent intent = getIntent();
	    String yo = intent.getStringExtra("Message_extra");
	    String num = intent.getStringExtra("Number");
	    number = num;
	    setTitle(yo);
	    but.setOnClickListener(new OnClickListener(){
	    	@Override
	    	public void onClick(View arg0){
	    		sendSMS();
	    	}

		
	    });
	    Toast.makeText(getApplicationContext(), "All set ready!", Toast.LENGTH_LONG).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.menu_activity2, menu);
		return true;
	}
	
	public void sendSMS() {
		try{
			SmsManager smsman = SmsManager.getDefault();
			String tt = text1.getText().toString();
			smsman.sendTextMessage(number, null, tt, null, null);
			Toast.makeText(getApplicationContext(), "Message sent JAVA"+tt, Toast.LENGTH_LONG).show();
			
		}
		catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), "Sorry sir not sent", Toast.LENGTH_LONG).show();
			
		}
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
		case android.R.id.home:
			//NavUtils.navigateUpFromSameTask(this);
			onBackPressed();
			Toast.makeText(getApplicationContext(), "You have touched back buttun", Toast.LENGTH_LONG).show();
			return true;
			
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	

}
