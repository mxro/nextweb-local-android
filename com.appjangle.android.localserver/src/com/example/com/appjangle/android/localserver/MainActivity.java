package com.example.com.appjangle.android.localserver;

import io.nextweb.Node;
import io.nextweb.jre.Nextweb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appjangle.i110.data.GameData;
import com.appjangle.i110.data.game1.LoadStrategicQuandrantQuestion;
import com.appjangle.i110.data.game1.StrategicQuandrantQuestion;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
            	Vision2Action.server = Nextweb.startServer(23211);
            	Vision2Action.session = Nextweb.createSession();
            	
            	Node db = Vision2Action.session.seed("local").get();
            	
            	GameData.writeCaseData(Vision2Action.session, db);

            	TextView textView = (TextView) findViewById(R.id.textView1);
            	
            
            	StrategicQuandrantQuestion case1game1 = LoadStrategicQuandrantQuestion
        				.getQuestionFromNode(Vision2Action.session, Vision2Action.session.node(db.uri() + "/c1"));

            	String result = "";
        		result += "Loading data from "+db.uri()+"\n";
            	result += "Brand name: " + case1game1.getBrandName()+"\n";
        		result += "Brand image: " + case1game1.getBrandImageLink();
        		System.out.println("Brand vision: " + case1game1.getBrandVision());
        		System.out.println("Correct strategy: "
        				+ case1game1.getCorrectStrategy());
        		System.out.println("Strategy justification:");
        		System.out.println(" Competitive scope: "
        				+ case1game1.getCorrectCompetiveScope());
        		System.out.println(" Cost strategy: "
        				+ case1game1.getCorrectCostStrategy());
        		System.out.println(" Therefore, the correct strategy is: "
        				+ case1game1.getCorrectStrategy());
        		
        		textView.setText(result);
        		
        		 Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        		    
        		 intent.putExtra("uri", db.uri());
        		 
        		    startActivity(intent);
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
