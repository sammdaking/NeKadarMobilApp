package com.example.nekadarjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.nekadarjavaapp.databinding.ActivityHomeBinding;
import com.example.nekadarjavaapp.databinding.ActivityMainBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        replaceFragment(new HomeFragment());


        binding.bottomNavigationView.setOnItemReselectedListener(item -> {

        switch (item.getItemId()){

            case R.id.home:
                replaceFragment(new HomeFragment());
                break;
            case R.id.chat:
                replaceFragment(new ChatFragment());
                break;
            case R.id.account:
                replaceFragment(new AccountFragment());
                break;


        }

           // return true;
        });
    }


    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}