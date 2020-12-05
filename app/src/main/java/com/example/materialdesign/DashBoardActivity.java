package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.materialdesign.Adapter.CategoriesAdapter;
import com.example.materialdesign.Adapter.FeaturedAdapter;
import com.example.materialdesign.Adapter.MostViewedAdapter;
import com.example.materialdesign.HelperClass.CategoriesHelperClass;
import com.example.materialdesign.HelperClass.FeaturedHelperClass;
import com.example.materialdesign.HelperClass.MostViewedHelperClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import static com.example.materialdesign.R.layout.activity_dash_board;

public class DashBoardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    FeaturedAdapter adapter;
    MostViewedAdapter adapterMV;
    CategoriesAdapter adapter3;
    ImageView menuIcon;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(activity_dash_board);


        featuredRecycler = findViewById(R.id.featuredRecyclerId);
        mostViewedRecycler = findViewById(R.id.mostViewedRecyclerId);
        categoriesRecycler = findViewById(R.id.categoriesRecyclerId);
        menuIcon = findViewById(R.id.menuIcon_Id);
        contentView= findViewById(R.id.content_Id);

        drawerLayout = findViewById(R.id.drawerLayout_Id);
        navigationView = findViewById(R.id.navigationView_Id);


        navigationDrawer();

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.navHome);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        animateNavigationDrawer();
    }
    private void animateNavigationDrawer(){
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocataions = new ArrayList<>();

        featuredLocataions.add(new FeaturedHelperClass(R.drawable.shakil, "Isfak Shakil", "ESPNcricinfo is a sports news website exclusively for the game of cricket. The site features news, articles, live coverage of cricket matches"));
        featuredLocataions.add(new FeaturedHelperClass(R.drawable.h, "Isfak Shakil", "ESPNcricinfo is a sports news website exclusively for the game of cricket. The site features news, articles, live coverage of cricket matches"));
        featuredLocataions.add(new FeaturedHelperClass(R.drawable.isfak, "Isfak Shakil", "ESPNcricinfo is a sports news website exclusively for the game of cricket. The site features news, articles, live coverage of cricket matches"));
        featuredLocataions.add(new FeaturedHelperClass(R.drawable.sk, "Isfak Shakil", "ESPNcricinfo is a sports news website exclusively for the game of cricket. The site features news, articles, live coverage of cricket matches"));
        featuredLocataions.add(new FeaturedHelperClass(R.drawable.shakil, "Isfak Shakil", "ESPNcricinfo is a sports news website exclusively for the game of cricket. The site features news, articles, live coverage of cricket matches"));

        adapter = new FeaturedAdapter(featuredLocataions);
        featuredRecycler.setAdapter(adapter);

        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.shakil, "McDonald's", "hfdhsahfsald"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.messi, "Leonel Messi", "hfdhsahfsald"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.sk, "Shakil isfak", "hfdhsahfsald"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.isfak, "Edenrobe", "ajdkasfke"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.h, "Isfak Shakil", "asfjkje"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.isfak, "Walmart", "afjdlajf"));

        adapterMV = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapterMV);
    }

    private void categoriesRecycler() {

        //All Gradients
//        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
//        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
//        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
//        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});

        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass("Restaurant", R.drawable.restaurant_icon));
        categoriesHelperClasses.add(new CategoriesHelperClass("Sports", R.drawable.sports_icon));
        categoriesHelperClasses.add(new CategoriesHelperClass("School", R.drawable.school_icon));
        categoriesHelperClasses.add(new CategoriesHelperClass("Airport", R.drawable.airport_icon));
        categoriesHelperClasses.add(new CategoriesHelperClass("Shopping", R.drawable.shop_icon));
        categoriesHelperClasses.add(new CategoriesHelperClass("Hotel", R.drawable.hotel_icon));


//        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.school_image, "Education"));
//        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.hospital_image, "HOSPITAL"));
//        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.restaurant_image, "Restaurant"));
//        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4, R.drawable.shopping_image, "Shopping"));
//        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.transport_image, "Transport"));


        adapter3 = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setAdapter(adapter3);

    }

    public void plusIcon(View view) {
        startActivity(new Intent(DashBoardActivity.this, WelcomeScreenActivity.class));
    }


}