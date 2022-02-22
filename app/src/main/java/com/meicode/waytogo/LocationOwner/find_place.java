package com.meicode.waytogo.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.meicode.waytogo.R;

public class find_place extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_find_place);
    }
//for canteen
    public void find_canteen(View view) {

        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.2718948,77.0687855");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);

    }

// for sports room
    public void find_sorts_room(View view) {

        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.2712297,77.0680007");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);

    }

//    find parking
    public void find_parking(View view) {

        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.2718948,77.068842");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);

    }

// for back press options
    public void back_pressed_location(View view) {
        find_place.super.onBackPressed();

    }
// for medical room
    public void find_medical_room(View view) {

        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.2710313,77.0687855");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }
// find reception...
    public void find_reception(View view) {

        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.347792,77.328998");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }
// for library...
    public void find_library(View view) {

        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.347792,77.328998");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }
// cricket ground
    public void find_cricketground(View view) {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.2710313,77.0687855");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);

    }
// basketball ground
    public void find_basket_ball_ground(View view) {

        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.2710313,77.0687855");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

//    find hostel
    public void find_hostel(View view) {

        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.2710313,77.0687855");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

//    find rest park
    public void find_resting_area(View view) {

        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.347792,77.328998");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

//    find b block
    public void find_Block(View view) {

        Uri gmmIntentUri = Uri.parse("google.navigation:q=28.2710313,77.0687855");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }
}