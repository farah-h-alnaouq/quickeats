package com.example.quickeats;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class activity_splash2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // الانتقال لصفحة الترحيب
                Intent intent = new Intent(activity_splash2.this, activity_start.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}