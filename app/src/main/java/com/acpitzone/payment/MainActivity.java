package com.acpitzone.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    String amount;
    int finalamount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button payment=findViewById(R.id.payment);
        EditText editText=findViewById(R.id.getamount);


        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount=editText.getText().toString();
                finalamount=Integer.parseInt(amount);
                Log.d("Tag",finalamount+" ");

                startpayment(finalamount);
            }
        });
    }

    private void startpayment(int finalamount) {

        Checkout checkout=new Checkout();
        checkout.setKeyID("rzp_test_EQfFkb4Bsmz72H");
        checkout.setImage(R.drawable.rzp_logo);


        try {
            JSONObject options = new JSONObject();

            options.put("name", "Nafas");
            options.put("description", "Buy the best product!");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", finalamount*100);//pass amount in currency subunits


            options.put("prefill.email", "sample@gmail.com");
            options.put("prefill.contact","123456666");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);
            // options.put("order_id","**razorpay_order_id**");

            checkout.open(MainActivity.this, options);

        } catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }



    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}