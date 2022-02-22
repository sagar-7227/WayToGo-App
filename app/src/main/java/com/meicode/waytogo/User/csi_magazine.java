package com.meicode.waytogo.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.meicode.waytogo.Databases.magazineimages.first_news_of_magazine;
import com.meicode.waytogo.Databases.magazineimages.second_news_of_magazine;
import com.meicode.waytogo.R;

public class csi_magazine extends AppCompatActivity {

    ImageView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all_csi_magazine);

//        Hooks
        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                csi_magazine.super.onBackPressed();
            }
        });
    }

    public void magazine1(View view) {

        startActivity(new Intent(getApplicationContext(), first_news_of_magazine.class));
    }

    public void magazine2(View view) {
        startActivity(new Intent(getApplicationContext(), second_news_of_magazine.class));
    }

}