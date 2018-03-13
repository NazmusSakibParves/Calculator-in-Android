package parves.Calculator.version3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class historyActivity extends Activity {

	public static final String PREFS_NAME = "mydata";
	public static final String Default = "N/A";
/** Called when the activity is first created. */	
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.historyactivity);


TextView view = (TextView)findViewById(R.id.textView1);


          SharedPreferences sharedpreferences = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);  
          String value = sharedpreferences.getString("result", Default);	    

       if(value.equals(Default)){
	        Toast.makeText(historyActivity.this, "No Data Found",Toast.LENGTH_LONG).show();
             }
       else{
	      Toast.makeText(historyActivity.this, "Data Loaded Successfuly",Toast.LENGTH_LONG).show();
	      view.setText(value);
         }

/*
try{
	String message;
	FileInputStream fileinputstream = openFileInput("history_file");
	InputStreamReader inputstreamreader = new InputStreamReader(fileinputstream);
	BufferedReader bufferreader = new BufferedReader(inputstreamreader);
	StringBuffer stringbuffer = new StringBuffer();
	while((message=bufferreader.readLine())!=null){
		stringbuffer.append(message +"\n");
		view.setText(stringbuffer.toString());
		view.setVisibility(View.VISIBLE);
	}
	
	
} catch(FileNotFoundException e){
	e.printStackTrace();
}
catch(IOException e){
	e.printStackTrace();
	
}*/


   }



}
