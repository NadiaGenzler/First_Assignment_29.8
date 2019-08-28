package com.example.fruits_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        int chosenFruitID= getIntent().getExtras().getInt(MainActivity.KEY_FOR_PHOTO);
        String chosenFruitName=getIntent().getExtras().getString(MainActivity.KEY_FOR_NAME);
        String chosenFruitCal=getIntent().getExtras().getString(MainActivity.KEY_FOR_CALORIES);


        TextView tvName=findViewById(R.id.fruitName2);
        tvName.setText(chosenFruitName);

        TextView tvCal=findViewById(R.id.fruitCalo2);
        tvCal.setText(chosenFruitCal);

        ImageView im=findViewById(R.id.fruitPH2);
        im.setImageResource(chosenFruitID);

    }
}
