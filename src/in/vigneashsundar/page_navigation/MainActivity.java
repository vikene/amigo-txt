/* ********************************Amigo-Txt*******************
 * MainActivity.java -- Main thread for Amigo-Txt
 * Copyright (c) 2014 Vigneash sundar
 * 
 *    
 */



package in.vigneashsundar.page_navigation;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class MainActivity extends Activity {

		ListView oob;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 final ArrayList<String> arraylist = new ArrayList();
		arraylist.add(new String("Tom"));
		arraylist.add(new String("Harry"));
		arraylist.add(new String("XXX"));
		arraylist.add(new String("YYYY"));
		arraylist.add(new String("zzzzz"));
		
		
		final ArrayList<String> numarraylist = new ArrayList();
		numarraylist.add(new String("54532321"));
		numarraylist.add(new String("546562"));
		numarraylist.add(new String("645645"));
		numarraylist.add(new String("6546545"));
		numarraylist.add(new String("645454"));
	
		ArrayAdapter arrayadap = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arraylist);
		oob = (ListView)findViewById(R.id.listview1);
		oob.setAdapter(arrayadap);
		
		oob.setOnItemClickListener(new OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3){
				Intent intent = new Intent(getApplicationContext(),in.vigneashsundar.page_navigation.activity2.class);
				String mes = arraylist.get(arg2);
				String num = numarraylist.get(arg2);
				intent.putExtra("Message_extra",mes );
				intent.putExtra("Number", num);
				startActivity(intent);
				
			}
		});
		
		
		
	}
	
	public void activity2(View view)
	{
		Intent intent = new Intent(this,in.vigneashsundar.page_navigation.activity2.class);
		intent.putExtra("Message_extra", "yo yo");
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
