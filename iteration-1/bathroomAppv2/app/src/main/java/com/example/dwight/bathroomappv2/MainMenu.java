package com.example.dwight.bathroomappv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity
{

    public Button bathroomButton;
    public Button computerLabButton;
    public Button foodButton;
    public Button chargingButton;
    public Button wifiButton;
    public String selected;

    public void onBathroomClick()
    {
        bathroomButton = (Button) findViewById(R.id.bathroomButton);
        bathroomButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent buildSelect = new Intent(MainMenu.this, BuildingSelection.class);
                startActivity(buildSelect);
            }
        });
    }

    public void onCompLabClick()
    {
        computerLabButton = (Button) findViewById(R.id.computerLabButton);
        computerLabButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent buildSelect = new Intent(MainMenu.this, BuildingSelection.class);
                startActivity(buildSelect);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        onBathroomClick();
        onCompLabClick();
    }



}
