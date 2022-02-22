package com.meicode.waytogo.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.meicode.waytogo.R;
import com.meicode.waytogo.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
     private static int SPLASH_TIMEW =3000;

//    variables
    ImageView backgroungImage;
    TextView design_by;
//    animations
    Animation sideAnim, bottomAnim;
    SharedPreferences onbaord;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.spash_screen);


//        hooks --
//        backgroungImage = findViewById(R.id.);
//          design_by = findViewById(R.id.design_By);

//          Animations
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim =AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

//        set animations on elemnets --

//        backgroungImage.setAnimation(sideAnim);
//          design_by.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                onbaord =getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime = onbaord.getBoolean("firstTime",true);

                if (isFirstTime){

                    SharedPreferences.Editor editor = onbaord.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, SPLASH_TIMEW);

    }

}