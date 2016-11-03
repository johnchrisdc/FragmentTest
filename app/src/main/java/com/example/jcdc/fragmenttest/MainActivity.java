package com.example.jcdc.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    private Fragment fragment_one;
    private Fragment fragment_two;

    private Button btn_switch;

    private boolean isDa = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_switch = (Button) findViewById(R.id.btn_switch);

        fragmentManager = getSupportFragmentManager();

        fragment_one = fragmentManager.findFragmentById(R.id.fragment_one);
        fragment_two = fragmentManager.findFragmentById(R.id.fragment_two);

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(fragment_one);
        fragmentTransaction.hide(fragment_two);
        fragmentTransaction.commit();

        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = fragmentManager.beginTransaction();
                if (isDa){
                    fragmentTransaction.show(fragment_one);
                    fragmentTransaction.hide(fragment_two);

                    fragmentTransaction.commit();
                }else {
                    fragmentTransaction.show(fragment_two);
                    fragmentTransaction.hide(fragment_one);

                    fragmentTransaction.commit();
                }
                isDa = !isDa;
            }
        });
    }
}
