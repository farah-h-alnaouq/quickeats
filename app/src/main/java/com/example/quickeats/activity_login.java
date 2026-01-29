package com.example.quickeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_login extends AppCompatActivity {

    //  تعريف العناصر (Views)
    EditText emailField, passwordField;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //  ربط العناصر بالـ IDs الموجودة في ملف XML
        emailField = findViewById(R.id.et_login_email);
        passwordField = findViewById(R.id.et_login_password);
        loginBtn = findViewById(R.id.btn_login_submit);

        //  برمجة زر تسجيل الدخول
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                //  التحقق من البيانات (Validation)
                if (email.isEmpty() || password.isEmpty()) {
                    // رسالة تنبيه إذا كانت الحقول فارغة
                    Toast.makeText(activity_login.this, "الرجاء تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
                } else if (!email.contains("@")) {
                    Toast.makeText(activity_login.this, "البريد الإلكتروني غير صحيح", Toast.LENGTH_SHORT).show();
                } else {
                    //إذا البيانات صحيحة، ننتقل للصفحة الرئيسية
                    Toast.makeText(activity_login.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();

                    // Intent للانتقال من صفحة Login إلى صفحة Home
                    Intent intent = new Intent(activity_login.this, activity_home.class);
                    startActivity(intent);

                    // نستخدم finish() لكي لا يتمكن المستخدم من العودة لصفحة Login بعد الدخول
                    finish();
                }
            }
        });
    }
}