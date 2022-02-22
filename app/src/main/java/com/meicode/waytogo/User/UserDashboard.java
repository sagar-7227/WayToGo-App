package com.meicode.waytogo.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.meicode.waytogo.Admin.Team;
import com.meicode.waytogo.Common.LoginSignup.Login;
import com.meicode.waytogo.Common.LoginSignup.RetailerStartUpScreen;
import com.meicode.waytogo.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.meicode.waytogo.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.meicode.waytogo.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.meicode.waytogo.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.meicode.waytogo.HelperClasses.HomeAdapter.MostViewedAdpater;
import com.meicode.waytogo.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.meicode.waytogo.LocationOwner.find_place;
import com.meicode.waytogo.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    static final float END_SCALE = 0.7f;
//    private GradientDrawable gradient1, gradient2, gradient3, gradient4;


    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

//        hooks
        featuredRecycler =findViewById(R.id.featuredRecycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        naviagtionDrawer();
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
    }

//    navigation drawer fucntion
    private void naviagtionDrawer() {

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
//            magazine part
            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(), csi_magazine.class));
                break;

//                location item should be added here
            case R.id.nav_add_missing_place:
                startActivity(new Intent(getApplicationContext(), find_place.class));
                break;
//               move to dashboard
            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                break;
//                login from nav..
            case R.id.nav_login:
                startActivity(new Intent(getApplicationContext(), Login.class));
                break;
//          teams part ...
            case R.id.nav_team:
                startActivity(new Intent(getApplicationContext(), Team.class));
                break;

//          website btn....
            case R.id.nav_profile:
                Uri uri = Uri.parse("https://www.instagram.com/csi_krmu/?utm_medium=copy_link");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
        }

        return true;
    }

    private void animateNavigationDrawer() {

        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimaryDark));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }


    //    category adapter
private void categoriesRecycler() {

    ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
    categoriesHelperClasses.add(new CategoriesHelperClass( R.mipmap.gdevent_foreground, "ARGUABLY\nRIGHT"));
    categoriesHelperClasses.add(new CategoriesHelperClass( R.mipmap.javascript_foreground, "4-Day JS"));
    categoriesHelperClasses.add(new CategoriesHelperClass( R.mipmap.liveproject_foreground, "LIVE \nPROJECT"));

    categoriesRecycler.setHasFixedSize(true);
    adapter = new CategoriesAdapter(categoriesHelperClasses);
    categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    categoriesRecycler.setAdapter(adapter);

}

// most viewed class
    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.mipmap.hack_foreground, "KRMU-HACK","KRMU HACK HACKATHON ,22 FEBURARY EVENT INAUGURATION ..."));
        mostViewedLocations.add(new MostViewedHelperClass(R.mipmap.hack_foreground, "KRMU-HACK","KRMU HACK HACKATHON ,23 FEBURARY MORE EVENTS..."));
//        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.next_arrow, "J.","asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
//        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.skip_btn, "Walmart","asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));

        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }

// featured recycler class
    private void featuredRecycler(){
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.mipmap.wait1_foreground, "WAIT", "WAITING STAGE"));
        featuredLocations.add(new FeaturedHelperClass(R.mipmap.wait1_foreground, "WAIT", "WAITING STAGE"));
        featuredLocations.add(new FeaturedHelperClass(R.mipmap.wait1_foreground, "WAIT", "WAITING STAGE"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }

    public void callRetailerScreen(View view){
        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
    }


    public void goTomagazine(View view) {

        startActivity(new Intent(getApplicationContext(), csi_magazine.class));
    }

    public void find_place(View view) {
        startActivity(new Intent(getApplicationContext(), find_place.class));
    }

    public void gototeam(View view) {
        startActivity(new Intent(getApplicationContext(), Team.class));
    }

    public void goTologin(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
    }
}