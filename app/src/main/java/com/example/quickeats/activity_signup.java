package com.example.quickeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_signup extends AppCompatActivity {

    private EditText etName, etEmail, etAddress, etMobile, etPassword;
    private Button btnRegister;
    private ImageView profileImage;
    private FloatingActionButton btnAddPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etAddress = findViewById(R.id.et_address);
        etMobile = findViewById(R.id.et_mobile);
        etPassword = findViewById(R.id.et_password);
        btnRegister = findViewById(R.id.btn_register_submit);
        profileImage = findViewById(R.id.profile_image);
        btnAddPhoto = findViewById(R.id.btn_add_photo);

        btnAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_signup.this, "Choose Image from Gallery", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // التحقق من تعبئة الحقول الأساسية
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(activity_signup.this, "الرجاء تعبئة المعلومات الأساسية", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(activity_signup.this, "أهلاً بك " + name + "، تم إنشاء الحساب!", Toast.LENGTH_LONG).show();

                    // الانتقال لصفحة Login لكي يسجل المستخدم دخوله
                    Intent intent = new Intent(activity_signup.this, activity_login.class);
                    startActivity(intent);

                    // ننهي صفحة التسجيل
                    finish();
                }
            }
        });
    }
}