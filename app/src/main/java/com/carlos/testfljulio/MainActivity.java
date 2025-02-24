package com.carlos.testfljulio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.carlos.testfljulio.activity.DetailActivity;
import com.carlos.testfljulio.adaptador.RecyclerAdapter;
import com.carlos.testfljulio.model.itemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<itemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initValues();
        initListener();
    }


    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }
    private List<itemList> getItems() {
        List<itemList> itemLists = new ArrayList<>();
        itemLists.add(new itemList("Saga de Broly", "Ultima pelicula de DB, peleas epicas.", "SSG", R.drawable.saga_broly));
        itemLists.add(new itemList("Super sayayines 4", "La ultima transformacion de la saga no canon.", "SS", R.drawable.ssj4s));
        itemLists.add(new itemList("Super Sayayiness Blues", "Goku y Vegeta, la transformacion de dioses.", "SSG", R.drawable.ssj_blues));
        itemLists.add(new itemList("Goku ultrainstinto", "Infaltablñe power-up a Goku.", "UI", R.drawable.ultrainsitinto));
        itemLists.add(new itemList("Super Vegeta Blue x2", "Diferentes transformaciones de super Vegeta.", "SSG", R.drawable.super_vegeta));
        itemLists.add(new itemList("Vegeta sapbe", "Vegeta sapbe o no sapbe xD.", "SSG", R.drawable.vegeta_blue));
        itemLists.add(new itemList("Saga de Broly", "Ultima pelicula de DB, peleas epicas.", "SSG", R.drawable.saga_broly));
        itemLists.add(new itemList("Super sayayines 4", "La ultima transformacion de la saga no canon.", "SS", R.drawable.ssj4s));
        itemLists.add(new itemList("Super Sayayiness Blues", "Goku y Vegeta, la transformacion de dioses.", "SSG", R.drawable.ssj_blues));
        itemLists.add(new itemList("Goku ultrainstinto", "Infaltablñe power-up a Goku.", "UI", R.drawable.ultrainsitinto));
        itemLists.add(new itemList("Super Vegeta Blue x2", "Diferentes transformaciones de super Vegeta.", "SSG", R.drawable.super_vegeta));
        itemLists.add(new itemList("Vegeta sapbe", "Vegeta sapbe o no sapbe xD.", "SSG", R.drawable.vegeta_blue));

        return itemLists;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }

    @Override
    public void itemClick(itemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }
}