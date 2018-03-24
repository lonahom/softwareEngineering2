package com.example.nahomnegussie.se2sr_cl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    String ip,port,action="Cl";
    EditText etIp,etPort;
    Button btConnect;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etIp=(EditText) findViewById(R.id.etIp);
        etPort= ( EditText) findViewById(R.id.etPo);



        aSwitch=(Switch) findViewById(R.id.swIsServer);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if(aSwitch.isChecked()){
                        action="Sr";
                        etIp.setVisibility(View.INVISIBLE);
                    }
                    else{
                        action="Cl";
                        etIp.setVisibility(View.VISIBLE);
                    }
                }

        });



        btConnect=(Button) findViewById(R.id.btConnect);
        btConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                if(action.equals("Cl"))
                    intent=new Intent(getApplicationContext(),ClientActivity.class);
                else
                    intent=new Intent(getApplicationContext(),ServerActivity.class);
                ip=etIp.getText().toString();
                port=etPort.getText().toString();
                intent.putExtra("ip",ip);
                intent.putExtra("port",port);
                startActivity(intent);



            }
        });

    }
}
