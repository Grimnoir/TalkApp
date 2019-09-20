package com.example.talkapp;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText jetspeak;
	Button jbtnspeak;
	String sSpeak="";
	TextToSpeech tts = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetspeak=(EditText)findViewById(R.id.etspeak);
        jbtnspeak=(Button)findViewById(R.id.btnspeak);
        
        jbtnspeak.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
					doTalk();
			}
    });
        }
protected void doTalk() {
		// TODO Auto-generated method stub
	
	boolean flag=false;
	flag=getSpeak();
	if(flag)
	{
		tts=new TextToSpeech(MainActivity.this,new TextToSpeech.OnInitListener() {
		
		@Override
		public void onInit(int arg0) {
			
			if(arg0!=TextToSpeech.ERROR)
			{
				tts.setLanguage(Locale.ENGLISH);
			tts.speak(sSpeak,TextToSpeech.QUEUE_FLUSH,null);
			}
			else
				Toast.makeText(getApplicationContext(), "Cannot Speak",Toast.LENGTH_LONG).show();
			
		}
	});
	}	
	}
private boolean getSpeak()
{
	boolean flag=false;
	try
	{
		sSpeak=jetspeak.getText().toString();
		if(sSpeak.length()>0)
			flag=true;
		else
			Toast.makeText(MainActivity.this,"|Enter Text to Speak",Toast.LENGTH_LONG).show();
		
}
catch(Exception e)
{
Toast.makeText(MainActivity.this,"TextField cannot be empty!Enter Text again"+e.toString(),Toast.LENGTH_LONG).show();
}
	return flag;
}
}
