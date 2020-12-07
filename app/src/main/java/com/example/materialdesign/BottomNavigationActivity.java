package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class BottomNavigationActivity extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bottom_navigation);
        chipNavigationBar=findViewById(R.id.bottom_nav_Id);
        chipNavigationBar.setItemSelected(R.id.botton_nav_dashboard_Id,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DashBoardFragment()).commit();
        bottomMenu();
    }

    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment=null;
                switch (i){
                    case R.id.botton_nav_dashboard_Id:
                    fragment=new  DashBoardFragment();
                    break;
                    case R.id.botton_nav_prfile_Id:
                    fragment=new ProfileFragment();
                    break;  case R.id.botton_nav_manage_Id:
                    fragment=new ManageFragment();
                    break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });
    }
}