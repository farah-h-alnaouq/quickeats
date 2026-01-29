package com.example.quickeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class activity_start extends AppCompatActivity {

    // تعريف الأزرار
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // ربط الأزرار بالـ IDs الموجودة في ملف XML
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        // برمجة زر تسجيل الدخول
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ننتقل من الصفحة الحالية إلى صفحة loginactivity
                Intent intent = new Intent(activity_start.this, activity_login.class);
                startActivity(intent);
            }
        });

        // برمجة زر إنشاء الحساب
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ننتقل من الصفحة الحالية إلى صفحة signupactivity
                Intent intent = new Intent(activity_start.this, activity_signup.class);
                startActivity(intent);
            }
        });
    }
}