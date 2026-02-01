package com.example.quickeats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    Context context;
    ArrayList<Food> foodList;

    public FoodAdapter(Context context, ArrayList<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @Override
    public int getCount() { return foodList.size(); }

    @Override
    public Object getItem(int i) { return foodList.get(i); }

    @Override
    public long getItemId(int i) { return i; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_food, viewGroup, false);
        }

        Food currentFood = foodList.get(i);

        ImageView img = view.findViewById(R.id.food_img);
        TextView name = view.findViewById(R.id.food_name);
        TextView price = view.findViewById(R.id.food_price);

        img.setImageResource(currentFood.getImage());
        name.setText(currentFood.getName());
        price.setText(currentFood.getPrice());

        return view;
    }
}