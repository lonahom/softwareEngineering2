package com.example.nahomnegussie.se2sr_cl;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClientActivity extends AppCompatActivity {
    LinearLayout linearLayout;Intent intent;TCPClient tcpClient;EditText messageBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        messageBox=(EditText) findViewById(R.id.messageBox);
        intent = getIntent();
        linearLayout=(LinearLayout) findViewById(R.id.llMessageArea);
        new ASYNK().execute();
        //new SenderTask().execute("tewdemam");

    }
    public void onSend(View view){
        //tcpClient.sendMessage(messageBox.getText().toString());
        new SenderTask().execute("tewdemam");

        TextView textView=new TextView(getApplicationContext());
        textView.setText(messageBox.getText().toString());
        textView.setPadding(6,6,6,6);
        textView.setGravity(Gravity.RIGHT);
        textView.setTextSize(16);
        linearLayout.addView(textView);
    }
    private class SenderTask extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... params) {
            System.out.println("sendng");
            tcpClient.sendMessage(params[0]);
            return null;
        }

    }
    private class ASYNK extends AsyncTask<LinearLayout,String,String> {

        @Override
        protected String doInBackground(final LinearLayout... params) {
            final Context context;

             tcpClient=new TCPClient(new TCPClient.OnMessageReceived() {
                @Override
                public void messageReceived(String message) {
                    publishProgress(message);
                }
            },intent.getStringExtra("ip"),Integer.parseInt(intent.getStringExtra("port")));
            tcpClient.run();
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            TextView textView=new TextView(getApplicationContext());
            textView.setText(values[0]);
            textView.setPadding(6,6,6,6);
            textView.setBackgroundColor(900);
            textView.setTextSize(16);
            linearLayout.addView(textView);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
        }

    }
}
