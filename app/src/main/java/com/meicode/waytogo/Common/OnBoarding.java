package com.meicode.waytogo.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meicode.waytogo.HelperClasses.SliderAdapter;
import com.meicode.waytogo.R;
import com.meicode.waytogo.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letgetstarted;
    Animation animation;
    int current;


    @Override
//    -----
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

//        hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout =findViewById(R.id.dots);
        letgetstarted =findViewById(R.id.get_started_btn);

//        call adapter
        sliderAdapter =new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }
//    ------
    public void skip(View view){
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }

    public void next(View view){
    viewPager.setCurrentItem(current + 1);

    }


//    -----
    private void addDots(int position){
        dots = new TextView[4];
        dotsLayout.removeAllViews();
//        ----
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }
//   ------
        if (dots.length >0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
//        -----
    }
//   -----
        ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
//        ----
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
// ----
        @Override
        public void onPageSelected(int position) {
            addDots(position);
            current =position;

            if (position == 0){
                animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                letgetstarted.setAnimation(animation);
                letgetstarted.setVisibility(View.VISIBLE);
            }
            else if (position ==1){
                animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                letgetstarted.setAnimation(animation);
                letgetstarted.setVisibility(View.VISIBLE);
            }
//            else if (position ==2){
//                letgetstarted.setVisibility(View.VISIBLE);
//            }
            else{
                animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                letgetstarted.setAnimation(animation);
                letgetstarted.setVisibility(View.VISIBLE);
            }
        }
// ----
        @Override
        public void onPageScrollStateChanged(int state) {

        }
//        -----
    };

    public void moveToDashboard(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();

    }
}