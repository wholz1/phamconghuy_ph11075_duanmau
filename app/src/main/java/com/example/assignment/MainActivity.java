package com.example.assignment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.assignment.Database.MySQLite;
import com.example.assignment.Fragment.Fragment_QlHoaDon;
import com.example.assignment.Fragment.Fragment_QlSachTK;
import com.example.assignment.Fragment.Fragment_QlTheLoaiS;
import com.example.assignment.Fragment.Fragment_QlUser;
import com.example.assignment.Fragment.Fragment_ThongKe;
import com.example.assignment.Fragment.Fragment_nhapSach;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FrameLayout frameLayout;
    Fragment fragment = new Fragment_QlUser();
    FragmentManager fragmentManage;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySQLite mySqlite = new MySQLite(this);
        anhXa();
        actionToolBar();
        // add fragment thống kê mặc định
        fragment = new Fragment_QlUser();
        addFragment(fragment);
    }

    public void actionToolBar() {
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
//        ab.setHomeAsUpIndicator(R.drawable.ic_menu_foreground);
        ab.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_menu_foreground);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // khi nhấn vào item trong navigation
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_quanlind) {
                    fragment = new Fragment_QlUser();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id == R.id.menu_nhapsach) {
                    fragment = new Fragment_nhapSach();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id == R.id.menu_qlhoadon) {
                    fragment = new Fragment_QlHoaDon();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id == R.id.menu_qltonkho) {
                    fragment = new Fragment_QlSachTK();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id == R.id.menu_qltheloai) {
                    fragment = new Fragment_QlTheLoaiS();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id == R.id.menu_thongke) {
                    fragment = new Fragment_ThongKe();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    exitApp();
                }
                addFragment(fragment);
                return false;
            }
        });
    }

    public void addFragment(Fragment fragment) {
        fragmentManage = getSupportFragmentManager();
        fragmentTransaction = fragmentManage.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutMain, fragment);
        fragmentTransaction.commit();
    }

    public void anhXa() {
        toolbar = findViewById(R.id.toolBar);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        frameLayout = findViewById(R.id.frameLayoutMain);
    }

    public void exitApp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.icon_exit);
        builder.setTitle("Thoát app !");
        builder.setMessage("Bạn có chắc chắn muốn thoát?");
        builder.setCancelable(false);
        builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onBackPressed();
            }
        });
        builder.show();
    }

}
