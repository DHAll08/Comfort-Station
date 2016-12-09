/* 
Created by: Dwight Hall
Updated By: Mike Tjoelker, Cameron Shively, Matt Morrision
Last Updated: 12-3-16
Purpose: Creates a page that displays a drop down of buildings for the user to select.
*/

package com.cs458.DMCM.TheComfortStation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dwight.bathroomappv2.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;


// Class that creates a page of buildings which all have the amenity chosen From the Main Menu.
public class BuildingSelection extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // Declares the Objects used on the page.
    public Spinner buildingDropDown;
    public Button submitButton;
    public TextView textview;
    public static String text;
    DBHandler db = new DBHandler(this);
    public static String amenityPicked;
    public boolean bssButton = false;
    public boolean libraryButton = false;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    // Main Function.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_selection);
        setTitle("The Comfort Station");

        amenityPicked = getIntent().getStringExtra("buttonPressed");

        addItemsToBuildingDropDown();

        onLibraryClick();
        onBSSClick();
        onSubmitClick();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // Dynamically adds the buildings with chosen amenity into the Building Drop Down.
    public void addItemsToBuildingDropDown() {
        buildingDropDown = (Spinner) findViewById(R.id.buildingDropDown);
        ArrayAdapter<String> adapter;
        List<String> list;

        list = new ArrayList<String>();

        String chosenButton = getIntent().getStringExtra("buttonPressed");

        if (chosenButton.equals("bathroom"))
        {
            List<Building> buildings = db.getAllBuildings();
            for (Building building : buildings)
            {
                String name =  building.getName();
                list.add(name);
            }
        }

        if (chosenButton.equals("comp"))
        {
            List<Building> buildings = db.getAllCompLabBuildings();
            for (Building building : buildings)
            {
                String name =  building.getName();
                list.add(name);
            }
        }

        if (chosenButton.equals("charging"))
        {
            list.add("Charging Station Test");
            list.add("Libary");
            list.add("Depot");
        }

        if (chosenButton.equals("food"))
        {
            list.add("Food Test");
            list.add("Market Place");
            list.add("Depot");
        }

        if (chosenButton.equals("wifi"))
        {
            list.add("Wifi is everywhere.");
        }


        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        buildingDropDown.setAdapter(adapter);
        buildingDropDown.setOnItemSelectedListener(this);
    }

    public void onSubmitClick() {
        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submitPressed = new Intent(BuildingSelection.this, AmenityList.class);
                submitPressed.putExtra("buildingSelected",text);
                startActivity(submitPressed);
            }
        });
    }

    /*

     ***********************
        Iteration 3 Extra
        - select building
          from map
     ***********************

    */
    public void onBSSClick()
    {
        submitButton = (Button) findViewById(R.id.BSS);
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buildingDropDown.setSelection(0,true);
            }
        });
    }
    public void onLibraryClick()
    {
        submitButton = (Button) findViewById(R.id.Library);
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buildingDropDown.setSelection(1,true);
            }
        });
    }

    /*

     ***********************
      END Iteration 3 Extra
     ***********************

    */


    @Override
        public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
            //text = parent.getItemAtPosition(position).toString();

            TextView selectedText = (TextView) view;
            //Toast.makeText(this, "You Selected " + selectedText.getText(), Toast.LENGTH_SHORT).show();
            text = selectedText.getText().toString();
            //textview = (TextView) findViewById(R.id.textview);
            // textview.setText(text);
        }

        @Override
        public void onNothingSelected (AdapterView < ? > parent){

        }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("BuildingSelection Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}






