package com.acpitzone.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SMS extends AppCompatActivity {

    EditText phone,otp;
    Button req,verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m_s);

        phone=findViewById(R.id.editTextphone);
        String mobile=phone.getText().toString();

        String op=otp.getText().toString();

        req=findViewById(R.id.reqotp);


        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String apliKey="apikey"+"";
                    String message="&message="+"This your otp";
                    String sender="&sender"+"ChartU";
                    String number="&number"+"8951269621";




                }catch (Exception e){



                }




            }
        });

    }
}