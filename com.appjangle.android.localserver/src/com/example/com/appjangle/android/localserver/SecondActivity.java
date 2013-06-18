package com.example.com.appjangle.android.localserver;

import com.appjangle.i110.data.game1.LoadStrategicQuandrantQuestion;
import com.appjangle.i110.data.game1.StrategicQuandrantQuestion;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextClock;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		TextView textView = (TextView) findViewById(R.id.secondActivityText);
		
		System.out.println(textView);
		
		StrategicQuandrantQuestion case1game1 = LoadStrategicQuandrantQuestion
				.getQuestionFromNode(Vision2Action.session, Vision2Action.session.node(getIntent().getStringExtra("uri") + "/c1"));

    	String result = "";
		result += "Loading data from "+getIntent().getStringExtra("uri")+"\n";
    	result += "Brand name: " + case1game1.getBrandName()+"\n";
    	
    	
    	System.out.println(result);
    	textView.setText(result);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
