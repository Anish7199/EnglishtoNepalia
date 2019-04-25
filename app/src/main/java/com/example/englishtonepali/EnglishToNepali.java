package com.example.englishtonepali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class EnglishToNepali extends AppCompatActivity {
    private ListView listSection;
    private Map <String, String> dictionary;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_to_nepali);

        listSection = findViewById(R.id.listSection);
        dictionary = new HashMap<>();
        readFromFile();

        }

    private void readFromFile() {
        try{
            FileInputStream fos = openFileInput("words.txt");
            InputStreamReader isr = new InputStreamReader(fos);
            BufferedReader br = new BufferedReader(isr);
            String line="";

            while ((line=br.readLine()) !=null){
                String[] parts = line.split("-");

            }

    }catch (IOException e){
            e.printStackTrace();
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
