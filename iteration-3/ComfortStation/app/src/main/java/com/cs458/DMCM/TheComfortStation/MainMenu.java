/* 
Created by: Dwight Hall
Updated By: Mike Tjoelker, Cameron Shivley, Matt Morrision
Last Updated: 12-3-16

Purpose: Creates a page that displays anumber of buttons for the user to slect from for there chosen amenity.
Also Inserts all data into the database.
*/

package com.cs458.DMCM.TheComfortStation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.Toast;

import com.example.dwight.bathroomappv2.R;

import java.util.List;

/*
	Class That Builds a Main Menu for locating amenities on HSU.
	Also populates database.
*/
public class MainMenu extends AppCompatActivity {

    // Declares The Main Menu buttons
    public Button bathroomButton;
    public Button computerLabButton;
    public Button foodButton;
    public Button chargingStationButton;
    public Button wifiButton;

/*
	Called upon starting the page
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setTitle("The Comfort Station");
        onBathroomClick();
        onCompLabClick();
        onChargingStationClick();
        onFoodClick();
        onWifiClick();
		
	//create db
	DBHandler db = createDB();

        /*
		TESTING for getAllBuildings
	*/
        Log.d("Reading: ", "Reading all buildings..");
        List<Building> buildings = db.getAllBuildings();

        for (Building building : buildings)
        {
            String log = "Id: " + building.getID() + ", Name: " + building.getName();
            Log.d("Building:: ", log);
        }

        /*
		TESTING for getAllFloors
	*/
        Log.d("Reading: ", "Reading all floors..");
        List<Floor> floors = db.getAllFloors();

        for (Floor floor : floors)
        {
            String log = "Floor Id: " + floor.getFloorId() + ", Floor Num: " + floor.getFloorNum() + ", Build Id: " + floor.getBuildID();
            Log.d("Floor:: ", log);
        }

    }

    /*
    	Method for the Bathroom Button, when clicked will take user to new page of buildings that have bathrooms.
    */
    public void onBathroomClick() {
        bathroomButton = (Button) findViewById(R.id.bathroomButton);
        bathroomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buildSelect = new Intent(MainMenu.this, BuildingSelection.class);
                buildSelect.putExtra("buttonPressed", "bathroom");
                startActivity(buildSelect);
            }
        });
    }

    /*
    	Method for the computer Lab Button, when clicked will take user to new page of buildings that have Computer Labs.
    */
    public void onCompLabClick() {
        computerLabButton = (Button) findViewById(R.id.computerLabButton);
        computerLabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buildSelect = new Intent(MainMenu.this, BuildingSelection.class);
                buildSelect.putExtra("buttonPressed", "comp");
                startActivity(buildSelect);
            }
        });
    }

    /*
    	Method for the Food Button, 
	When clicked will create popup saying "Future Feature!"
    */
    public void onFoodClick()
    {
        foodButton = (Button) findViewById(R.id.foodButton);
        foodButton.setOnClickListener(new View.OnClickListener() 
	{
            @Override
            public void onClick(View v) {
                /*
                Intent buildSelect = new Intent(MainMenu.this, BuildingSelection.class);
                buildSelect.putExtra("buttonPressed", "food");
                startActivity(buildSelect);
                */
                Toast.makeText(foodButton.getContext(), "Future Feature!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
    	Method for the Charging Station Button, 
	When clicked will create popup saying "Future Feature!"
    */
    public void onChargingStationClick() {
        chargingStationButton = (Button) findViewById(R.id.chargingButton);
        chargingStationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent buildSelect = new Intent(MainMenu.this, BuildingSelection.class);
                buildSelect.putExtra("buttonPressed", "charging");
                startActivity(buildSelect);
                */
                Toast.makeText(chargingStationButton.getContext(), "Future Feature!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onWifiClick() {
        wifiButton = (Button) findViewById(R.id.wifiButton);
        wifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent buildSelect = new Intent(MainMenu.this, BuildingSelection.class);
                buildSelect.putExtra("buttonPressed", "wifi");
                startActivity(buildSelect);
                */
                Toast.makeText(wifiButton.getContext(), "Future Feature!", Toast.LENGTH_SHORT).show();
            }
        });
    }



    /*
        Created to build and insert in to database
     */
    public DBHandler createDB()
    {
        //create db
        DBHandler db = new DBHandler(this);

        //adding building rows
        db.addBuilding(new Building(1111,"Founders Hall"));
        db.addBuilding(new Building(1112, "Behavioral & Social Sciences"));
        db.addBuilding(new Building(1113, "Gist Hall"));
        db.addBuilding(new Building(1114, "Siemens Hall"));
        db.addBuilding(new Building(1115, "Forestry"));
        db.addBuilding(new Building(1116, "Harry Griffith Hall"));
        db.addBuilding(new Building(1117, "Theater Arts"));
        db.addBuilding(new Building(1118, "Library"));
        db.addBuilding(new Building(1119, "Student & Business Resources"));
        /*
        db.addBuilding(new Building(1120, "Natural Resources"));
         */

        //adding floor rows

        //Founders Hall
        db.addFloor(new Floor(2111,"G",1111));
        db.addFloor(new Floor(2112,"1",1111));
        db.addFloor(new Floor(2113,"2",1111));

        //Behavioral & Social Sciences
        db.addFloor(new Floor(2114,"1",1112));
        db.addFloor(new Floor(2115,"2",1112));
        db.addFloor(new Floor(2116,"3",1112));
        db.addFloor(new Floor(2117,"4",1112));
        db.addFloor(new Floor(2118,"5",1112));

        //Gist Hall
        db.addFloor(new Floor(2119,"1",1113));
        db.addFloor(new Floor(2121,"2",1113));

        //Siemens Hall
        db.addFloor(new Floor(2122,"1",1114));
        db.addFloor(new Floor(2123,"2",1114));

        //Forestry
        db.addFloor(new Floor(2124,"G",1115));
        db.addFloor(new Floor(2125,"1",1115));

        //Harry Griffith Hall
        db.addFloor(new Floor(2126,"1",1116));
        db.addFloor(new Floor(2127,"2",1116));

        //Theater Arts
        db.addFloor(new Floor(2128,"G",1117));
        db.addFloor(new Floor(2129,"1",1117));
        db.addFloor(new Floor(2130,"2",1117));

        //Library
        db.addFloor(new Floor(2131,"G",1118));
        db.addFloor(new Floor(2132,"1",1118));
        db.addFloor(new Floor(2133,"2",1118));
        db.addFloor(new Floor(2134,"3",1118));

        //Student & Business Resources
        db.addFloor(new Floor(2135,"1",1119));
        db.addFloor(new Floor(2136,"2",1119));
        db.addFloor(new Floor(2137,"3",1119));
        db.addFloor(new Floor(2138,"4",1119));

        /*
        //Natural Resources
        db.addFloor(new Floor(2139,"1",1120));
        db.addFloor(new Floor(2140,"2",1120));
        */

        //adding room tables

        //Founders Hall 
        db.addRoom(new Room(3111,"4","B","0",2111));
        db.addRoom(new Room(3112,"26A","B","0",2111));
        db.addRoom(new Room(3113,"113A","B","0",2112));
        db.addRoom(new Room(3114,"124A","B","0",2112));
        db.addRoom(new Room(3115,"164A","B","0",2112));
        db.addRoom(new Room(3116,"176A","B","0",2112));
        db.addRoom(new Room(3117,"?","B","0",2113));

        //Behavioral & Social Sciences
        db.addRoom(new Room(3118,"?","B","1",2114));
        db.addRoom(new Room(3119,"?","B","1",2114));
        db.addRoom(new Room(3120,"?","B","1",2115));
        db.addRoom(new Room(3121,"?","B","1",2115));
        db.addRoom(new Room(3122,"315","L","1",2116));
        db.addRoom(new Room(3123,"317","L","1",2116));
        db.addRoom(new Room(3124,"?","B","1",2116));
        db.addRoom(new Room(3125,"?","B","1",2116));
        db.addRoom(new Room(3126,"?","B","1",2117));
        db.addRoom(new Room(3127,"?","B","1",2117));
        db.addRoom(new Room(3128,"?","B","1",2118));
        db.addRoom(new Room(3129,"?","B","1",2118));

        //Gist Hall
        db.addRoom(new Room(3130,"126","B","0",2119));
        db.addRoom(new Room(3131,"127","B","0",2119));
        db.addRoom(new Room(3132,"204","B","0",2121));
        db.addRoom(new Room(3133,"229","B","0",2121));
        db.addRoom(new Room(3134,"226","B","0",2121));

        //Siemens Hall
        db.addRoom(new Room(3135,"101","B","0",2122));
        db.addRoom(new Room(3136,"102","B","0",2122));
        db.addRoom(new Room(3137,"201","B","0",2123));
        db.addRoom(new Room(3138,"209","B","0",2123));

        //Forestry
        db.addRoom(new Room(3139,"?","B","0",2124));
        db.addRoom(new Room(3140,"?","B","0",2125));

        //Harry Griffith Hall
        db.addRoom(new Room(3141,"?","B","0",2126));
        db.addRoom(new Room(3142,"?","B","0",2126));
        db.addRoom(new Room(3143,"?","B","0",2127));
        db.addRoom(new Room(3144,"?","B","0",2127));

        //Theater Arts
        db.addRoom(new Room(3145,"?","B","0",2128));
        db.addRoom(new Room(3146,"?","B","0",2128));
        db.addRoom(new Room(3147,"?","B","0",2129));
        db.addRoom(new Room(3148,"?","B","0",2129));
        db.addRoom(new Room(3149,"?","B","0",2130));
        db.addRoom(new Room(3150,"?","B","0",2130));

        //Library
        db.addRoom(new Room(3151,"?","B","0",2131));
        db.addRoom(new Room(3152,"?","B","0",2131));
        db.addRoom(new Room(3153,"?","B","0",2132));
        db.addRoom(new Room(3154,"?","B","0",2132));
        db.addRoom(new Room(3155,"121","L","1",2132));
        db.addRoom(new Room(3156,"122","L","1",2132));
        db.addRoom(new Room(3157,"120","L","1",2132));
        db.addRoom(new Room(3158,"?","B","0",2133));
        db.addRoom(new Room(3159,"?","B","0",2133));
        db.addRoom(new Room(3160,"205","L","1",2133));
        db.addRoom(new Room(3161,"?","B","1",2134));
        db.addRoom(new Room(3162,"?","B","0",2134));

        //Student & Business Resources
        db.addRoom(new Room(3163,"?","B","0",2135));
        db.addRoom(new Room(3164,"?","B","0",2135));
        db.addRoom(new Room(3165,"?","B","0",2136));
        db.addRoom(new Room(3166,"?","B","0",2136));
        db.addRoom(new Room(3167,"?","B","0",2137));
        db.addRoom(new Room(3168,"?","B","0",2137));
        db.addRoom(new Room(3169,"?","B","0",2138));
        db.addRoom(new Room(3170,"?","B","0",2138));

        //adding bathroom tables

        //Founders Hall
        db.addBathroom(new Bathroom(4111,"M","1","1","0","0","0",3111));
        db.addBathroom(new Bathroom(4112,"W","1","1","0","0","0",3112));
        db.addBathroom(new Bathroom(4113,"M","1","1","0","0","0",3113));
        db.addBathroom(new Bathroom(4114,"W","1","1","0","0","0",3114));
        db.addBathroom(new Bathroom(4115,"M","1","1","0","0","0",3115));
        db.addBathroom(new Bathroom(4116,"W","1","1","0","0","0",3116));
        db.addBathroom(new Bathroom(4117,"U","1","0","0","0","0",3117));

        //Behavioral & Social Sciences
        db.addBathroom(new Bathroom(4118,"M","1","1","0","0","0",3118));
        db.addBathroom(new Bathroom(4119,"W","1","1","0","0","0",3119));
        db.addBathroom(new Bathroom(4120,"M","1","1","0","0","0",3120));
        db.addBathroom(new Bathroom(4121,"W","1","1","0","0","0",3121));
        db.addBathroom(new Bathroom(4124,"M","1","1","0","0","0",3124));
        db.addBathroom(new Bathroom(4125,"W","1","1","0","0","0",3125));
        db.addBathroom(new Bathroom(4126,"M","1","1","0","0","0",3126));
        db.addBathroom(new Bathroom(4127,"W","1","1","0","0","0",3127));
        db.addBathroom(new Bathroom(4128,"M","1","1","0","0","0",3128));
        db.addBathroom(new Bathroom(4129,"W","1","1","0","0","0",3129));

        //Gist Hall
        db.addBathroom(new Bathroom(4130,"M","1","?","?","?","?",3130));
        db.addBathroom(new Bathroom(4131,"W","1","?","?","?","?",3131));
        db.addBathroom(new Bathroom(4132,"W","1","?","?","?","?",3132));
        db.addBathroom(new Bathroom(4133,"M","1","?","?","?","?",3133));
        db.addBathroom(new Bathroom(4134,"M","1","?","?","?","?",3134));

        //Siemens Hall
        db.addBathroom(new Bathroom(4135,"M","1","1","?","0","0",3135));
        db.addBathroom(new Bathroom(4136,"W","1","1","?","0","0",3136));
        db.addBathroom(new Bathroom(4137,"W","1","1","?","0","0",3137));
        db.addBathroom(new Bathroom(4138,"M","1","1","?","0","0",3138));

        //Forestry
        db.addBathroom(new Bathroom(4139,"W","1","1","0","1","1",3139));
        db.addBathroom(new Bathroom(4140,"M","1","1","0","1","1",3140));

        //Harry Griffith Hall
        db.addBathroom(new Bathroom(4141,"M","1","1","?","0","0",3141));
        db.addBathroom(new Bathroom(4142,"W","1","1","?","0","0",3142));
        db.addBathroom(new Bathroom(4143,"M","1","1","0","0","0",3143));
        db.addBathroom(new Bathroom(4144,"W","1","1","0","0","0",3144));

        //Theater Arts
        db.addBathroom(new Bathroom(4145,"M","1","1","0","0","0",3145));
        db.addBathroom(new Bathroom(4146,"W","1","1","0","0","0",3146));
        db.addBathroom(new Bathroom(4147,"M","1","1","0","0","0",3147));
        db.addBathroom(new Bathroom(4148,"W","1","1","0","0","0",3148));
        db.addBathroom(new Bathroom(4149,"M","1","1","0","0","0",3149));
        db.addBathroom(new Bathroom(4150,"W","1","1","0","0","0",3150));

        //Library
        db.addBathroom(new Bathroom(4151,"M","1","?","?","?","?",3151));
        db.addBathroom(new Bathroom(4152,"W","1","?","?","?","?",3152));
        db.addBathroom(new Bathroom(4153,"M","1","1","1","0","0",3153));
        db.addBathroom(new Bathroom(4154,"W","1","1","1","0","0",3154));
        db.addBathroom(new Bathroom(4158,"M","1","1","0","0","0",3158));
        db.addBathroom(new Bathroom(4159,"W","1","1","0","0","0",3159));
        db.addBathroom(new Bathroom(4161,"M","1","1","0","0","0",3161));
        db.addBathroom(new Bathroom(4162,"W","1","1","0","0","0",3162));

        //Student & Business Resources
        db.addBathroom(new Bathroom(4163,"W","1","1","?","0","0",3163));
        db.addBathroom(new Bathroom(4164,"M","1","1","?","0","0",3164));
        db.addBathroom(new Bathroom(4165,"M","?","1","0","0","0",3165));
        db.addBathroom(new Bathroom(4166,"W","?","1","0","0","0",3166));
        db.addBathroom(new Bathroom(4167,"M","?","1","0","0","0",3167));
        db.addBathroom(new Bathroom(4168,"W","?","1","0","0","0",3168));
        db.addBathroom(new Bathroom(4169,"M","?","1","0","0","0",3169));
        db.addBathroom(new Bathroom(4170,"W","?","1","0","0","0",3170));

        //adding computer lab tables

        //Behavioral & Social Sciences
        db.addCompLab(new CompLab(4122,14,3122)); //rm 315
        db.addCompLab(new CompLab(4123,29,3123)); //rm 317

        //Library
        db.addCompLab(new CompLab(4155,22,3155));
        db.addCompLab(new CompLab(4156,10,3156));
        db.addCompLab(new CompLab(4157,5,3157));
        db.addCompLab(new CompLab(4160,6,3160));

        return db;
    }
}
