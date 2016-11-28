package com.example.dwight.bathroomappv2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class AmenityList extends AppCompatActivity {

    public TextView textTest;
    public TextView databaseTest;
    public String[] extraList;
    DBHandler db = new DBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amenity_list);

        String chosenAmenity = BuildingSelection.amenityPicked;

        if(chosenAmenity.equals("bathroom"))
        {
            bathSelected();
        }
        else if(chosenAmenity.equals("comp"))
        {
            compSelected();
        }

        //textTest();
        //databaseTest();

    }
    public void compSelected()
    {
        String chosenBuilding = getIntent().getStringExtra("buildingSelected");
        String[] itemList = db.getCompBasics(chosenBuilding);

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

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override //this is all created after typing "new AdapterView..."
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // int i is the positions of the list items
                String item = (String) adapterView.getItemAtPosition(i);

                // show selected item on this activity
                //Toast.makeText(view.getContext(),"You selected "+ item, Toast.LENGTH_SHORT).show();

                // query more info on selected bathroom to show more info.
                String chosenBuilding = getIntent().getStringExtra("buildingSelected");
                String[] extraList = db.getCompLabExtras(chosenBuilding);
                String info = extraList[i];

                //show extra info in popup bubble
                Toast.makeText(view.getContext(),info, Toast.LENGTH_SHORT).show();

                /*
                //    OR can go to new activity
                // right click "java" -> New -> Activity -> Empty Activity
                //
                // go to second activity is item 1 is selected
                if(i == 1)
                {
                    Intent itemSelect = new Intent(view.getContext(),itemSelection.class);
                    startActivity(itemSelect);
                }


            }
        });
        */
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

                // show selected item on this activity
                //Toast.makeText(view.getContext(),"You selected "+ item, Toast.LENGTH_SHORT).show();

                // query more info on selected bathroom to show more info.
                String chosenBuilding = getIntent().getStringExtra("buildingSelected");
                String[] extraList = db.getBathroomExtras(chosenBuilding);
                String info = extraList[i];

                //show extra info in popup bubble
                Toast.makeText(view.getContext(),info, Toast.LENGTH_SHORT).show();

                /*
                //    OR can go to new activity
                // right click "java" -> New -> Activity -> Empty Activity
                //
                // go to second activity is item 1 is selected
                if(i == 1)
                {
                    Intent itemSelect = new Intent(view.getContext(),itemSelection.class);
                    startActivity(itemSelect);
                }
                */

            }
        });
    }

    /*
    // Testing methods

    public void databaseTest()
    {
        databaseTest = (TextView) findViewById(R.id.testDatabase);

        String chosenAmenity = BuildingSelection.amenityPicked;
        String chosenBuilding = getIntent().getStringExtra("buildingSelected");
        int bathroomCount = db.getBathroomCount(chosenBuilding);

        databaseTest.setText("There are " + bathroomCount + " bathrooms in " + chosenBuilding + "!");
    }

    public void textTest()
    {
        textTest = (TextView) findViewById(R.id.testText);

        String chosenBuilding = getIntent().getStringExtra("buildingSelected");
        textTest.setText("You Selected " + chosenBuilding + "!");
    }
    */

}
