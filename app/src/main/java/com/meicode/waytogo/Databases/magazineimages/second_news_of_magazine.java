package com.meicode.waytogo.Databases.magazineimages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.meicode.waytogo.R;
import com.squareup.picasso.Picasso;

public class second_news_of_magazine extends AppCompatActivity {

    // Initializing the ImageView
    ImageView rImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second_news_of_magazine);

        rImage = findViewById(R.id.rImage);

        // to get the image from the database
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
//        take tke image  from the image item
        DatabaseReference getImage = databaseReference.child("image");

        getImage.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(rImage);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(second_news_of_magazine.this, "Error Loading Image", Toast.LENGTH_SHORT).show();
            }
        });
//     image is received from it.

    }

    public void goToLink(View view) {
        Uri uri = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScMblDM0V-yPFcnXCw_ShI9Gji2NP96D8cCXx-n9V-YX9jiLg/viewform");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
}