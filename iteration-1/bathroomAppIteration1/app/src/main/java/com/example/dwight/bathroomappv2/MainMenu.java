package com.example.dwight.bathroomappv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


// Class That Builds a Main Menu for locating amenities on HSU.
public class MainMenu extends AppCompatActivity
{

    // Declares The Main Menu buttons
    public Button bathroomButton;
    public Button computerLabButton;

    // Main Function.
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        onBathroomClick();
        onCompLabClick();
    }

    // Method for the Bathroom Button, when clicked will take user to new page of buildings that have bathrooms.
    public void onBathroomClick()
    {
        bathroomButton = (Button) findViewById(R.id.bathroomButton);
        bathroomButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent buildSelect = new Intent(MainMenu.this, BuildingSelection.class);
                buildSelect.putExtra("buttonPressed","bathroom");
                startActivity(buildSelect);
            }
        });
    }

    // Method for the computer Lab Button, when clicked will take user to new page of buildings that have Computer Labs.
    public void onCompLabClick()
    {
        computerLabButton = (Button) findViewById(R.id.computerLabButton);
        computerLabButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent buildSelect = new Intent(MainMenu.this, BuildingSelection.class);
                buildSelect.putExtra("buttonPressed","comp");
                startActivity(buildSelect);
            }
        });
    }
}
