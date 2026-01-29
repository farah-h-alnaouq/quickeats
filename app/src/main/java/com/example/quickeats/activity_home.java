package com.example.quickeats;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class activity_home extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //  تعريف الـ Toolbar وربطه
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  تعريف القائمة الجانبية (Drawer)
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        //  برمجة أيقونة الخطوط الثلاثة لفتح القائمة الجانبية
        toolbar.setNavigationOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        //  برمجة الضغط على خيارات القائمة الجانبية
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_cart) {
                Toast.makeText(this, "Cart selected", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_logout) {
                finish(); // يغلق الصفحة الحالية
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    //  إظهار "النقاط الثلاثة" في جهة اليمين
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //  برمجة ما يحدث عند الضغط على خيارات "النقاط الثلاثة"
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(this, "Going Home", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.nav_cart) {
            Toast.makeText(this, "Opening Previous Order", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.nav_orders) {
            Toast.makeText(this, "Showing Orders", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "Logging out", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}