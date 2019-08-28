package com.example.fruits_listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String KEY_FOR_NAME="KEY_FOR_NAME";
    public final static String KEY_FOR_CALORIES="KEY_FOR_CALORIES";
    public final static String KEY_FOR_PHOTO="KEY_FOR_PHOTO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Fruit> listOfFruits=new ArrayList<>();

        listOfFruits.add(new Fruit("Orange","47 Calories",R.drawable.orange));
        listOfFruits.add(new Fruit("Cherry","50 Calories",R.drawable.cherry));
        listOfFruits.add(new Fruit("Banana","89 Calories",R.drawable.banana));
        listOfFruits.add(new Fruit("Apple","52 Calories",R.drawable.apple));
        listOfFruits.add(new Fruit("Kiwi","61 Calories",R.drawable.kiwi));
        listOfFruits.add(new Fruit("Pear","57 Calories",R.drawable.pear));
        listOfFruits.add(new Fruit("Strawberry","33 Calories",R.drawable.strawberry));
        listOfFruits.add(new Fruit("Lemon","29 Calories",R.drawable.lemon));
        listOfFruits.add(new Fruit("Apricot","48 Calories",R.drawable.apricot));
        listOfFruits.add(new Fruit("Mango","60 Calories",R.drawable.mango));
        listOfFruits.add(new Fruit("Papaya","50 Calories",R.drawable.papaya));


        List<HashMap<String ,String >> fullDictionary=new ArrayList<>();
        for(Fruit fruit:listOfFruits){
            HashMap<String,String> dic=new HashMap<>();
            dic.put(KEY_FOR_NAME,fruit.name);
            dic.put(KEY_FOR_CALORIES,fruit.calories);
            dic.put(KEY_FOR_PHOTO,String.valueOf(fruit.photo));
            fullDictionary.add(dic);
        }

        String[] from={KEY_FOR_NAME,KEY_FOR_CALORIES,KEY_FOR_PHOTO};
        int[] to={R.id.fruitName,R.id.fruitCalo,R.id.fruitPH};

        final SimpleAdapter adapter=new SimpleAdapter(getBaseContext(),fullDictionary,R.layout.my_new_layout,from,to);

        final ListView lv=findViewById(R.id.MyListV);
        lv.setAdapter(adapter);
        lv.setClickable(true);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent openDesc=new Intent(getBaseContext(),Main2Activity.class);

               openDesc.putExtra(KEY_FOR_NAME,listOfFruits.get(i).name);
               openDesc.putExtra(KEY_FOR_CALORIES,listOfFruits.get(i).calories);
               openDesc.putExtra(KEY_FOR_PHOTO,listOfFruits.get(i).photo);
               startActivity(openDesc);
            }
        });

        final AlertDialog.Builder b=new AlertDialog.Builder(this);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, final View view,final int i, long l) {

                b.setTitle("Delete "+listOfFruits.get(i).name+" ?");
                b.setMessage("Are you sure you want to delete "+listOfFruits.get(i).name+" ?");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int t) {
                        dialogInterface.dismiss();
                        listOfFruits.remove(listOfFruits.get(i));
                        Toast.makeText(getApplicationContext(),listOfFruits.get(i).name+" was Deleted", Toast.LENGTH_LONG).show();
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(),"ok, never mind",Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alert=b.create();
                alert.show();

                return true;
            }
        });

    }
}
