package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {
    RecyclerView featuredRecycler,mostViewedRecycler,categoriesRecycler;
    FeaturedAdapter adapter;
    MostViewedAdapter adapterMV;
    CategoriesAdapter adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dash_board);

        featuredRecycler=findViewById(R.id.featuredRecyclerId);
        mostViewedRecycler=findViewById(R.id.mostViewedRecyclerId);
        categoriesRecycler=findViewById(R.id.categoriesRecyclerId);

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocataions=new ArrayList<>();

        featuredLocataions.add(new FeaturedHelperClass(R.drawable.shakil,"Isfak Shakil","ESPNcricinfo is a sports news website exclusively for the game of cricket. The site features news, articles, live coverage of cricket matches"));
        featuredLocataions.add(new FeaturedHelperClass(R.drawable.h,"Isfak Shakil","ESPNcricinfo is a sports news website exclusively for the game of cricket. The site features news, articles, live coverage of cricket matches"));
        featuredLocataions.add(new FeaturedHelperClass(R.drawable.isfak,"Isfak Shakil","ESPNcricinfo is a sports news website exclusively for the game of cricket. The site features news, articles, live coverage of cricket matches"));
        featuredLocataions.add(new FeaturedHelperClass(R.drawable.sk,"Isfak Shakil","ESPNcricinfo is a sports news website exclusively for the game of cricket. The site features news, articles, live coverage of cricket matches"));
        featuredLocataions.add(new FeaturedHelperClass(R.drawable.shakil,"Isfak Shakil","ESPNcricinfo is a sports news website exclusively for the game of cricket. The site features news, articles, live coverage of cricket matches"));

    adapter=new FeaturedAdapter(featuredLocataions);
    featuredRecycler.setAdapter(adapter);

        GradientDrawable gradientDrawable=new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400,0xffaff600});

    }
    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.shakil, "McDonald's","hfdhsahfsald"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.messi, "Leonel Messi","hfdhsahfsald"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.sk, "Shakil isfak","hfdhsahfsald"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.isfak, "Edenrobe","ajdkasfke"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.h, "Isfak Shakil","asfjkje"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.isfak, "Walmart","afjdlajf"));

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
        categoriesHelperClasses.add(new CategoriesHelperClass("Restaurant" ,R.drawable.restaurant_icon ));
        categoriesHelperClasses.add(new CategoriesHelperClass("Sports" ,R.drawable.sports_icon ));
        categoriesHelperClasses.add(new CategoriesHelperClass("School" ,R.drawable.school_icon ));
        categoriesHelperClasses.add(new CategoriesHelperClass("Airport" ,R.drawable.airport_icon ));
        categoriesHelperClasses.add(new CategoriesHelperClass("Shopping" ,R.drawable.shop_icon ));
        categoriesHelperClasses.add(new CategoriesHelperClass("Hotel" ,R.drawable.hotel_icon ));


//        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.school_image, "Education"));
//        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.hospital_image, "HOSPITAL"));
//        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.restaurant_image, "Restaurant"));
//        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4, R.drawable.shopping_image, "Shopping"));
//        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.transport_image, "Transport"));



        adapter3 = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setAdapter(adapter3);

    }
}