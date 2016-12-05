/* 
Created by: Dwight Hall
Updated By: Mike Tjoelker, Cameron Shivley, Matt Morrision

Purpose: Creates a page that displays the chosen amenitys in selected building. 
*/

package com.cs458.DMCM.TheComfortStation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dwight.bathroomappv2.R;

public class AmenityList extends AppCompatActivity {

    public ImageButton homeButton;
    DBHandler db = new DBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amenity_list);
        setTitle("The Comfort Station");

        String chosenAmenity = BuildingSelection.amenityPicked;

        if(chosenAmenity.equals("bathroom"))
        {
            bathSelected();
        }
        else if(chosenAmenity.equals("comp"))
        {
            compSelected();
        }

        onHomeClick();

    }

    // Method for the Bathroom Button, when clicked will take user to new page of buildings that have bathrooms.
    public void onHomeClick() {
        homeButton = (ImageButton) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeSelect = new Intent(AmenityList.this, MainMenu.class);
                startActivity(homeSelect);
            }
        });
    }

    public void compSelected() {
        String chosenBuilding = getIntent().getStringExtra("buildingSelected");
        String[] itemList = db.getCompBasics(chosenBuilding);

        // Step 2:
        // Create ListView object
        ListView listView = (ListView) findViewById(R.id.listView);

        // Step 3:
        // Array Adapter - attach list to adapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList);


        // Step 4:
        // set the adapter to the listView
        listView.setAdapter(adapter);

        // Step 5:
        // set up listener for clicking items on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override //this is all created after typing "new AdapterView..."
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // int i is the positions of the list items
                String item = (String) adapterView.getItemAtPosition(i);

                // query more info on selected bathroom to show more info.
                String chosenBuilding = getIntent().getStringExtra("buildingSelected");
                String[] extraList = db.getCompExtras(chosenBuilding);
                String info = extraList[i];

                //show extra info in popup bubble
                Toast.makeText(view.getContext(),info, Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void bathSelected()
    {
        //Step 1:
        //  Create array to list in ListView
        //  This needs to be filled with rows from a db query

        String chosenBuilding = getIntent().getStringExtra("buildingSelected");
        String[] itemList = db.getBathroomBasics(chosenBuilding);


        // Step 2:
        // Create ListView object
        ListView listView = (ListView) findViewById(R.id.listView);

        // Step 3:
        // Array Adapter - attach list to adapter
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, itemList);


        // Step 4:
        // set the adapter to the listView
        listView.setAdapter(adapter);

        // Step 5:
        // set up listener for clicking items on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override //this is all created after typing "new AdapterView..."
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // int i is the positions of the list items
                String item = (String) adapterView.getItemAtPosition(i);

                // query more info on selected bathroom to show more info.
                String chosenBuilding = getIntent().getStringExtra("buildingSelected");
                String[] extraList = db.getBathroomExtras(chosenBuilding);
                String info = extraList[i];

                //show extra info in popup bubble
                Toast.makeText(view.getContext(), info, Toast.LENGTH_LONG).show();
            }
        });
    }

}
