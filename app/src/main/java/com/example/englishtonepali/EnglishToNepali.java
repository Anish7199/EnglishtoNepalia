package com.example.englishtonepali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class EnglishToNepali extends AppCompatActivity {
    private ListView listSection;
    private Map <String, String> dictionary;

    public static final String words[] = {
            "Yeta aaunus" , "Come Here",
            "China" , "Beijing",
            "India" , "New Delhi",
            "UK" , "London",
            "US" , "Washington DC",
            "Canada" , "Ottawa",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_to_nepali);

        listSection = findViewById(R.id.listSection);
        dictionary = new HashMap<>();

        for (int i=0; i< words.length; i+=2){
            dictionary.put(words[i], words[i+1]);
        }
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList(dictionary.keySet())
        );
        listSection.setAdapter(adapter);

        //Click Event

        listSection.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = parent.getItemAtPosition(position).toString();//Get Current Position
                String meaning = dictionary.get(key);  //Get meaning of Current Position


                //Intent will call
                Intent intent = new Intent(EnglishToNepali.this, MeaningActivity.class);

                intent.putExtra("anil",meaning);
                startActivity(intent);
            }
        });
    }
}
