package com.example.kp.exo03_frament;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private List<Fragment> listFragment = new ArrayList<>();

    private static int i = 0;



    @Override

    protected void onCreate(Bundle savedInstanceState) {



        //TODO faire tourner l'application avec attach et detach

        //TODO mettre des textview dans les fragment



        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button buttonNext = (Button) findViewById(R.id.main_activity_button_next);

        final Button buttonPrevious = (Button) findViewById(R.id.main_activity_button_previous);



        //Pour faire un tableau avec les fragment et selectionner celui à afficher, il faut utiliser attach et detach

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



        Fragment fragment1 = new FragmentOne();

        Fragment fragment2 = new FragmentTwo();

        Fragment fragment3 = new FragmentThree();

        listFragment.add(fragment1);

        listFragment.add(fragment2);

        listFragment.add(fragment3);



        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.add(R.id.fragment_container, listFragment.get(i)).commit();



        buttonNext.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                i++;

                FragmentTransaction transaction2 = getFragmentManager().beginTransaction();

                transaction2.replace(R.id.fragment_container, listFragment.get(i%3)).addToBackStack(null);

                transaction2.commit();

            }

        });



        buttonPrevious.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                i+=2;

                FragmentTransaction transaction2 = getFragmentManager().beginTransaction();

                //Replace appel remove puis add

                transaction2.replace(R.id.fragment_container, listFragment.get(i%3)).addToBackStack(null);

                transaction2.commit();

            }

        });

    }
}