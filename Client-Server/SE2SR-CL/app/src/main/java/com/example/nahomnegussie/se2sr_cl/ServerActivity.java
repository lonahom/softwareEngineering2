package com.example.nahomnegussie.se2sr_cl;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ServerActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
        ASYNK asynk=new ASYNK();

        intent = getIntent();
        linearLayout=(LinearLayout) findViewById(R.id.llMessageArea);
        asynk.execute(linearLayout);
    }
    private class ASYNK extends AsyncTask<LinearLayout,String,String>{

        @Override
        protected String doInBackground(final LinearLayout... params) {
            final Context context;

            final TCPServer tcpServer=new TCPServer(new TCPServer.OnMessageReceived() {
                @Override
                public void messageReceived(String message) {

                    publishProgress(message);

                }
            },Integer.parseInt(intent.getStringExtra("port")));
            tcpServer.run();
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            System.out.println(values[0]+"twtew");
            TextView textView=new TextView(getApplicationContext());
            Button button=new Button(getApplicationContext());
            button.setText(values[0]);
            linearLayout.addView(button);
            linearLayout.setBackgroundColor(013);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String aVoid) {


            super.onPostExecute(aVoid);
        }

    }


}
