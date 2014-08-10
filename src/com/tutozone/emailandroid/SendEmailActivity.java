package com.tutozone.emailandroid;
 


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
 
public class SendEmailActivity extends Activity {
 
	Button buttonSend;
	EditText textTo;
	EditText textSubject;
	EditText textMessage;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
 
		buttonSend = (Button) findViewById(R.id.buttonSend);
		textTo = (EditText) findViewById(R.id.editTextTo);
		textSubject = (EditText) findViewById(R.id.editTextSubject);
		textMessage = (EditText) findViewById(R.id.editTextMessage);
 
		buttonSend.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
 
			  sendEmail();
			}
		});
	}
	
	public void sendEmail()
	{
		String to = textTo.getText().toString();
		String subject = textSubject.getText().toString();
		String message = textMessage.getText().toString();
		//String toCc = "email de destinataire en CC";
		//String toCci = "email de destinataire en CCi";
		Intent email = new Intent(Intent.ACTION_SEND);
		email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
		//email.putExtra(Intent.EXTRA_CC, new String[]{ toCc});
		//email.putExtra(Intent.EXTRA_BCC, new String[]{toCci});
		//email.putExtra(Intent.EXTRA_STREAM, "file:///sdcard/file.pdf");
		email.putExtra(Intent.EXTRA_SUBJECT, subject);
		email.putExtra(Intent.EXTRA_TEXT, message);
		 
		email.setType("message/rfc822");
		  
		startActivity(Intent.createChooser(email, "Choisissez un client de messagerie:"));
	}
}