package parves.Calculator.version3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorV3Activity extends Activity {
	 private Button one,two,three,four,five,six,seven,eight,nine,zero,decimal,equal,backspace,/*ms,*/mc,plus,minus,multiply,divide,clear,square,history,mp,mr,root;
	    private double num1,num2;
	    String optr;
		String value;
	    private int operator1 = 1;
	    private EditText res;
	    public static final String PREFS_NAME = "mydata";
	    public static final String Default ="N/A";
	    //ArrayList<Double> tempfigure = new ArrayList<Double>();
	    //double tempfigure1;
	    double memory1 = 0;
	    Vibrator vibration;
	    
	    //static final String STATE_SCORE = "currentScore";
	   // static final String STATE_LEVEL = "currentLevel";
	    int counter = 0;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	    }

		@Override
		protected void onResume() {
			super.onResume();
			counter++;
		}

		@Override
		protected void onStart() {
			super.onStart();
			one=(Button)findViewById(R.id.one);
			two=(Button)findViewById(R.id.two);
			three=(Button)findViewById(R.id.three);
			four=(Button)findViewById(R.id.four);
			five=(Button)findViewById(R.id.five);
			six=(Button)findViewById(R.id.six);
			seven=(Button)findViewById(R.id.seven);
			eight=(Button)findViewById(R.id.eight);
			nine=(Button)findViewById(R.id.nine);
			zero=(Button)findViewById(R.id.zero);
			equal=(Button)findViewById(R.id.equal);
			plus=(Button)findViewById(R.id.plus);
			minus=(Button)findViewById(R.id.minus);
			multiply=(Button)findViewById(R.id.multiply);
			divide=(Button)findViewById(R.id.divide);
			//ms=(Button)findViewById(R.id.ms);
			backspace=(Button)findViewById(R.id.backspace);
			mc=(Button)findViewById(R.id.mc);
			square=(Button)findViewById(R.id.square);
			decimal=(Button)findViewById(R.id.decimal);
			clear=(Button)findViewById(R.id.clear);
			mp=(Button)findViewById(R.id.mp);
			mr=(Button)findViewById(R.id.mr);
			root=(Button)findViewById(R.id.root);
				
			history=(Button)findViewById(R.id.history);
			//
			//mcr=(Button)findViewById(R.id.mcr);
			//
			
			res=(EditText)findViewById(R.id.editText1);
			res.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
			//res.setFocusable(false);
		    res.setClickable(false);
			
			
			vibration = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); 
			
			try{
				/*one.setOnClickListener((OnClickListener) this);
				two.setOnClickListener((OnClickListener) this);
				three.setOnClickListener((OnClickListener) this);
				four.setOnClickListener((OnClickListener) this);
				five.setOnClickListener((OnClickListener) this);
				six.setOnClickListener((OnClickListener) this);
				seven.setOnClickListener((OnClickListener) this);
				eight.setOnClickListener((OnClickListener) this);
				nine.setOnClickListener((OnClickListener) this);
				zero.setOnClickListener((OnClickListener) this);
				plus.setOnClickListener((OnClickListener) this);
				minus.setOnClickListener((OnClickListener) this);
				divide.setOnClickListener((OnClickListener) this);
				multiply.setOnClickListener((OnClickListener) this);
				equal.setOnClickListener((OnClickListener) this);
				square.setOnClickListener((OnClickListener) this);
				ms.setOnClickListener((OnClickListener) this);
				mc.setOnClickListener((OnClickListener) this);
				clear.setOnClickListener((OnClickListener) this);
				history.setOnClickListener((OnClickListener) this);
				decimal.setOnClickListener((OnClickListener) this);*/
				
				one.setOnClickListener(new OnClickListener() {
					
					public void onClick(View arg0) {
						Log.d("Check","Button 1 Click");
						Editable str = res.getText();
						if(num2 != 0){
							num2 = 0;
							res.setText("");
						}
						str = str.append(one.getText());
						res.setText(str);		
					}
				});
				
	           two.setOnClickListener(new OnClickListener() {
					
					public void onClick(View arg0) {
						Log.d("Check","Button 2 Click");
						Editable str = res.getText();
						if(num2 != 0){
							num2 = 0;
							res.setText("");
						}
						str = str.append(two.getText());
						res.setText(str);		
					}
				});

	        three.setOnClickListener(new OnClickListener() {
		
		    public void onClick(View arg0) {
			  Log.d("Check","Button 3 Click");
			  Editable str = res.getText();
			   if(num2 != 0){
				    num2 = 0;
				   res.setText("");
			}
			       str = str.append(three.getText());
			        res.setText(str);		
		} 
	});

	    four.setOnClickListener(new OnClickListener() {
		
		        public void onClick(View arg0) {
			    Log.d("Check","Button 4 Click");
			    Editable str = res.getText();
			       if(num2 != 0){
				     num2 = 0;
				     res.setText("");
			}
			   str = str.append(four.getText());
			   res.setText(str);		
		}
	});

	      five.setOnClickListener(new OnClickListener() {
		
		    public void onClick(View arg0) {
			    Log.d("Check","Button 5 Click");
			     Editable str = res.getText();
			      if(num2 != 0){
				     num2 = 0;
				    res.setText("");
			}
			   str = str.append(five.getText());
			    res.setText(str);		
		}
	});

	      six.setOnClickListener(new OnClickListener() {
		
		    public void onClick(View arg0) {
			    Log.d("Check","Button 6 Click");
			    Editable str = res.getText();
			       if(num2 != 0){
				       num2 = 0;
				       res.setText("");
			}
			    str = str.append(six.getText());
			    res.setText(str);		
		}
	});

	      	seven.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button 7 Click");
	      			Editable str = res.getText();
	      			if(num2 != 0){
	      				num2 = 0;
	      				res.setText("");
			}
	      			str = str.append(seven.getText());
	      			res.setText(str);		
		}
	});

	      	eight.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button 8 Click");
	      			Editable str = res.getText();
	      			if(num2 != 0){
	      				num2 = 0;
	      				res.setText("");
			}
	      			str = str.append(eight.getText());
	      			res.setText(str);		
		}
	});

	      	nine.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button 9 Click");
	      			Editable str = res.getText();
	      			if(num2 != 0){
	      				num2 = 0;
	      				res.setText("");
			}
	      			str = str.append(nine.getText());
	      			res.setText(str);		
		}
	});

	      	zero.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button 0 Click");
	      			Editable str = res.getText();
	      			if(num2 != 0){
	      				num2 = 0;
	      				res.setText("");
			}
	      			str = str.append(zero.getText());
	      			res.setText(str);		
		}
	});

	      	decimal.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button . Click");
	      			Editable str = res.getText();
	      			if(num2 != 0){
	      				num2 = 0;
	      				res.setText("");
			}
	      			str = str.append(decimal.getText());
	      			res.setText(str);		
		}
	});

	      	clear.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button clear Click");
	      	          num1 = 0;
	      	          num2 = 0;
	      	          res.setText("");
	      					
		}
	});

	      	plus.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button + Click");
	      			Editable str = res.getText();
	      			try{
	      				optr = "+";
	      				if(num1 == 0){
	      					num1 = Double.parseDouble(res.getText().toString());
	      					res.setText("");
	      				}
	      				
	      				else if(num2 != 0){
	      					num2 = 0;
	      					res.setText("");	
	      				}
	      				else{
	      					num2 = Double.parseDouble(res.getText().toString());
	      					res.setText("");
	      					num1 = num1+num2;
	      					res.setText("=" +Double.toString(num1));
	      				}
	      			}
	      				catch(Exception ex){
	      					//value+= "+";
	      					//res.setText(value);
	      					
	      				}
	      				
		}
	});

	      	minus.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button - Click");
	      			Editable str = res.getText();
	      			try{
	      				optr = "-";
	      				if(num1 == 0){
	      					num1 = Double.parseDouble(res.getText().toString());
	      					res.setText("");
	      				}
	      				
	      				else if(num2 != 0){
	      					num2 = 0;
	      					res.setText("");	
	      				}
	      				else{
	      					num2 = Double.parseDouble(res.getText().toString());
	      					res.setText("");
	      					num1 = num1-num2;
	      					res.setText("=" +Double.toString(num1));
	      				}
	      				}
	      				catch(Exception ex){
	      					//value+="-";
	      					//res.setText(value);
	      				}
	      		
		}
	});

	      	multiply.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button * Click");
	      			Editable str = res.getText();
	      			try{
	      				optr = "*";
	      				if(num1 == 0){
	      					num1 = Double.parseDouble(res.getText().toString());
	      					res.setText("");
	      				}
	      				
	      				else if(num2 != 0){
	      					num2 = 0;
	      					res.setText("");	
	      				}
	      				else{
	      					num2 = Double.parseDouble(res.getText().toString());
	      					res.setText("");
	      					num1 = num1*num2;
	      					res.setText("=" +Double.toString(num1));
	      				}
	      				}
	      				catch(Exception ex){
	      					//value+="*";
	      					//res.setText(value);
	      					
	      				}		
		}
	});

	      	divide.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button / Click");
	      			Editable str = res.getText();
	      			try{
	      				optr = "/";
	      				if(num1 == 0){
	      					num1 = Double.parseDouble(res.getText().toString());
	      					res.setText("");
	      				}
	      				
	      				else if(num2 != 0){
	      					num2 = 0;
	      					res.setText("");	
	      				}
	      				else{
	      					num2 = Double.parseDouble(res.getText().toString());
	      					res.setText("");
	      					num1 = num1/num2;
	      					res.setText("=" +Double.toString(num1));
	      				}
	      			}		
	      				catch(Exception ex){
	      					//value+="/";
	      					//res.setText(value);
	      				}			
		}
	});
	      	
	      	square.setOnClickListener(new OnClickListener() {
	      		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button ^2 Click");
	      			
	      			try{
	      				optr = "^2";
	      			
	      					num1 = Double.parseDouble(res.getText().toString());
	      					num1 = Math.pow(num1,2);
	      					res.setText("=" +Double.toString(num1));
	      			}		
	      				catch(Exception ex){
	      					
	      				}			
		}
	});

	      	equal.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button = Click");
	      			try{
	      				if(!optr.equals(null)){
	      					if(num2 != 0){
	      						if(optr.equals("+")){
	      							res.setText("");
	      							res.setText("=" +Double.toString(num1));
	      						}
	      						else if(optr.equals("-")){
	      							res.setText("");
	      							res.setText("=" +Double.toString(num1));
	      						}
	      						else if(optr.equals("*")){
	      							res.setText("");
	      							res.setText("=" +Double.toString(num1));
	      						}
	      						else if(optr.equals("/")){
	      							res.setText("");
	      							res.setText("=" +Double.toString(num1));
	      						}
	      						else if (optr.equals("^2")){
	      							res.setText("");
	      							res.setText("=" +Double.toString(num1));     						}
	      						
	      					}
	      					else if (optr.equals("^2")){
      							res.setText("");
      							res.setText("=" +Double.toString(num1));   
	      					}
	      					else if (optr.equals("M+")){
	      						memory1 = memory1 + num1;
	      					}
	      					else{
	      						operation(operator1);
	      					}
	      					
	      				}
	      			}
	      				catch(Exception ex){
	      				Toast.makeText(CalculatorV3Activity.this, "Math Error", 50).show();
	      				
	      				}	   
	      			SharedPreferences sharedpreferences = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
	    			SharedPreferences.Editor editor= sharedpreferences.edit();
	    			editor.putString("result",res.getText().toString() );
	    			
	    			editor.commit();
	    			Toast.makeText(CalculatorV3Activity.this,"Data saved...",20).show();
	      			
	      			/*String message = res.getText().toString();
	      			String file_name = "history_file.txt"; 
	      			try{
	      				FileOutputStream fileoutputstream = openFileOutput(file_name, MODE_PRIVATE);
	      				OutputStreamWriter osw = new OutputStreamWriter(fileoutputstream);
	      				//fileoutputstream.write(message.getBytes());
	      				//fileoutputstream.close();
	      				try{
	      					osw.write(message);
	      					osw.flush();
	      					osw.close();
	      					Toast.makeText(getBaseContext(), "Data save",Toast.LENGTH_LONG ).show();
	      				
	      			   } 
	      				catch (IOException e) {
						e.printStackTrace();
					}
	      		}
	      			catch(FileNotFoundException e){
	      				e.printStackTrace();
	      	}	*/
	  	}   			
	    		
	});

	      	backspace.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button backspace Click");
	      		  	     			
	      			 String str = res.getText().toString();
	      			 if(str.length()>=1){
	      				 str = str.substring(0, str.length()-1);
	      				 res.setText(str);
	      			     }else if (str.length()<=1){
	      			    	 res.setText("");
	      			     }
		}
	});
	      	
	     	/*ms.setOnClickListener(new OnClickListener() {
	    		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button ms Click");
	      			
	      			SharedPreferences sharedpreferences = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
	    			SharedPreferences.Editor editor= sharedpreferences.edit();
	    			editor.putString("result",res.getText().toString() );
	    			
	    			editor.commit();
	    			Toast.makeText(CalculatorV3Activity.this,"Data saved successfuly",20).show();
	    			//Toast.makeText(getBaseContext(),"Data saved successfuly",20).show();    	
	      			
	      			
	      	
		}
	});*/
	      	
	    mr.setOnClickListener(new OnClickListener() {
	    		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button MemoryRetrive Click");
	      			
	      			SharedPreferences sharedpreferences = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
	      			String memory_r=sharedpreferences.getString("result", "");
	    			res.setText(memory_r);
	      			      				      			   		      			
		}
	});
	    
	    mp.setOnClickListener(new OnClickListener() {
    		
      		public void onClick(View arg0) {
      			Log.d("Check","Button MemoryPlus Click");
      			
      			//SharedPreferences sharedpreferences = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
      			//String Astatus = sharedpreferences.getString("Authentication_Status", "");		
      			   //editor.apply();	
      			/*tempfigure.add(Double.parseDouble(res.getText().toString())); 
                memory1=memory1+tempfigure.get(0); 
                tempfigure1=0;
                tempfigure.removeAll(tempfigure); 
                res.setText("0"); 
                if (memory1 >0) { view.setText("Memory saved");}*/
      			
      			SharedPreferences sharedpreferences = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
    			SharedPreferences.Editor editor= sharedpreferences.edit();
    			
    			/*editor.putLong("result",(long)num1);   			
    		     editor.commit();  		
		         res.setText("" +Double.toString(num1));*/
    			
    			String savevalue = res.getText().toString();
    			if(savevalue.length()>0){
    			editor.putString("result",savevalue);
    			
    			editor.commit();
    			
            }
      	}
		
      			      				      			   		      			
	
});
	    root.setOnClickListener(new OnClickListener() {
    		
      		public void onClick(View arg0) {
      			Log.d("Check","Button MemoryMinus Click");
      			
      			try{
      				optr = "√";
      			
      					num1 = Double.parseDouble(res.getText().toString());
      					num1 = Math.sqrt(num1);
      					res.setText("=" +Double.toString(num1));
      			}		
      				catch(Exception ex){
      					
      				}			
	}
      			      			   		      			
	
});

	      	mc.setOnClickListener(new OnClickListener() {
		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button mc Click");
	      			
	      			SharedPreferences sharedpreferences = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
	    			
	      			/*String value = sharedpreferences.getString("result", Default);
	      			if(value != Default){
	      				String view = sharedpreferences.getString("result", "");
	      			}*/
	      			
	      			sharedpreferences.edit().clear().commit();
	      			
	      		
	      			Toast.makeText(CalculatorV3Activity.this, "Data Delete Successfuly..",30).show();
	      			//Toast.makeText(getBaseContext(),"Data Remove successfuly",20).show();	      			
	      			
		}
	});

	      	history.setOnClickListener(new OnClickListener() {
	    		
	      		public void onClick(View arg0) {
	      			Log.d("Check","Button history Click");
	      			
	      			Toast.makeText(CalculatorV3Activity.this, "History is Open..", Toast.LENGTH_LONG).show();
	      			Intent intent = new Intent(getApplicationContext(),historyActivity.class);
	    			startActivity(intent);
	    			
	    			
	    			
		}
	});



			}
			catch(Exception e1){
				
			}
			
		
		
		}
			private void operation(int newOperator) {
				
				if(optr.equals("+")){
					num2 = Double.parseDouble(res.getText().toString());
					res.setText("");
					num1=num1+num2;
					res.setText("=" +Double.toString(num1));
					
					}
				
				else if(optr.equals("-")){
					num2 = Double.parseDouble(res.getText().toString());
					res.setText("");
					num1=num1-num2;
					res.setText("=" +Double.toString(num1));
					
					}
				else if(optr.equals("*")){
					num2 = Double.parseDouble(res.getText().toString());
					res.setText("");
					num1=num1*num2;
					res.setText("= "+Double.toString(num1));
					
					}
				else if(optr.equals("/")){
					num2 = Double.parseDouble(res.getText().toString());
					res.setText("");
					num1=num1/num2;
					res.setText("=" +Double.toString(num1));
					
					}
				}

			
			@Override
			public boolean onCreateOptionsMenu(Menu menu) {
				  MenuInflater inflater = getMenuInflater();
			        inflater.inflate(R.menu.main, menu);
			        return true;
				
			}
			
			@Override
			public boolean onOptionsItemSelected(MenuItem item) {
				int id = item.getItemId();
				if(id==R.id.action_about){
					Toast.makeText(getBaseContext(), "Nazmus Sakib Parves \n\nAIUB \n13-24470-2", Toast.LENGTH_LONG).show();
				}
				return super.onOptionsItemSelected(item);
			}

			

			@Override
			protected void onSaveInstanceState(Bundle outState) {
				// TODO Auto-generated method stub
				super.onSaveInstanceState(outState);
				outState.putInt("counter", counter);
				Log.d("oncreate",counter+ "was saved");
				
			}
			
			@Override
			protected void onRestoreInstanceState(Bundle savedInstanceState) {
				// TODO Auto-generated method stub
				super.onRestoreInstanceState(savedInstanceState);
				counter = savedInstanceState.getInt("counter");
				Log.d("oncreate",counter+ "was restored");
				
			}
				
		
			

	}

