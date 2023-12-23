package com.example.mangareader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mangareader.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    GridView mangaItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        replaceFragment(new MangaFragment());
        setContentView(binding.getRoot());

        String[] mangaName = {"Manga 1", "Manga 2", "Manga 3", "Manga 4", "Manga 5", "Manga 6", "Manga 7"};
        int[] mangaImage = {R.drawable.ic_manga_foreground,R.drawable.ic_manga_foreground,R.drawable.ic_manga_foreground,R.drawable.ic_manga_foreground,R.drawable.ic_manga_foreground,R.drawable.ic_manga_foreground,R.drawable.ic_manga_foreground,R.drawable.ic_manga_foreground,
                R.drawable.ic_manga_foreground};
        GridAdapter gridAdapter = new GridAdapter(mangaName, mangaImage,this,this.getLayoutInflater());
        mangaItems = (GridView) findViewById(R.id.manga_items);
        mangaItems.setAdapter(gridAdapter);
        binding.btmNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.btm_nav_manga){
                replaceFragment(new MangaFragment());
            } else if (id == R.id.btm_nav_search) {
                replaceFragment(new SearchFragment());
            }
            else if (id == R.id.btm_nav_profile){
                replaceFragment(new ProfileFragment());
            }
            return true;

        });




    }
    protected void replaceFragment(Fragment f){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, f);
        ft.commit();
    }
}