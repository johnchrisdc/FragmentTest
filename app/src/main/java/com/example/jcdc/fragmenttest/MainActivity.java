package com.example.jcdc.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity implements Drawer.OnDrawerItemClickListener{

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    private Fragment fragment_one;
    private Fragment fragment_two;

    private Drawer result;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();

        fragment_one = fragmentManager.findFragmentById(R.id.fragment_one);
        fragment_two = fragmentManager.findFragmentById(R.id.fragment_two);

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("One");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(1).withName("Two");

        new DrawerBuilder().withActivity(this).build();
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2
                )
                .withOnDrawerItemClickListener(this)
                .build();
        result.setSelection(0, true);
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                fragmentTransaction.show(fragment_one);
                fragmentTransaction.hide(fragment_two);

                break;
            case 1:
                fragmentTransaction.show(fragment_two);
                fragmentTransaction.hide(fragment_one);

                break;
        }
        fragmentTransaction.commit();

        result.closeDrawer();
        return true;
    }
}
