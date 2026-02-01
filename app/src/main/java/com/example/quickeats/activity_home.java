package com.example.quickeats;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView; // تم الإضافة
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList; // تم الإضافة

public class activity_home extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private GridView gridView; // تم الإضافة لتعريف الشبكة
    private ArrayList<Food> foodList; // تم الإضافة لتعريف القائمة

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //  إعداد الـ Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  إعداد القائمة الجانبية (Drawer)
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        toolbar.setNavigationOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_logout) {
                finish();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });


        //  ربط الـ GridView من ملف الـ XML
        gridView = findViewById(R.id.food_grid);

        //  تعبئة قائمة الوجبات (ArrayList)
        foodList = new ArrayList<>();
        foodList.add(new Food("Mixed Fried Meat", "25 $", R.drawable.food1));
        foodList.add(new Food("Italian Pizza", "30 $", R.drawable.food2));
        foodList.add(new Food("Vegetarian Salad", "15 $", R.drawable.food3));
        foodList.add(new Food("Beef Burger", "25 $", R.drawable.food4));
        foodList.add(new Food("Chicken Platter", "20 $", R.drawable.food5));
        foodList.add(new Food("Pasta Extra", "22 $", R.drawable.food6));
        foodList.add(new Food("Shawarma Wrap", "15 $", R.drawable.food7));
        foodList.add(new Food("Steak House", "45 $", R.drawable.food8));
        foodList.add(new Food("Calzone", "35 $", R.drawable.food9));

        //  ربط البيانات بالـ Adapter
        FoodAdapter adapter = new FoodAdapter(this, foodList);
        gridView.setAdapter(adapter);

        // إضافة حدث عند الضغط على أي وجبة (Java Event)
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedFood = foodList.get(position).getName();
            Toast.makeText(activity_home.this, "You clicked: " + selectedFood, Toast.LENGTH_SHORT).show();
        });

        // --------------------------------------------------
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_logout) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}