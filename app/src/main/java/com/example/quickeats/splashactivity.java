package com.example.quickeats;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //  (activity_splash2)
                Intent intent = new Intent(splashactivity.this, activity_splash2.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}