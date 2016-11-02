package com.example.dwight.bathroomappv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AmenityList extends AppCompatActivity {

    public TextView textTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amenity_list);

        textTest();
    }

    public void textTest()
    {
        textTest = (TextView) findViewById(R.id.testText);

        String chosenBuilding = getIntent().getStringExtra("buildingSelected");
        textTest.setText("You Selected " + chosenBuilding + "!");
    }

}
