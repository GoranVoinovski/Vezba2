package com.example.goran.vezba;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.goran.vezba.Adapteri.MeniAdapter;
import com.example.goran.vezba.Listeners.OnImageClickListener;
import com.example.goran.vezba.Modeli.Menu;
import com.example.goran.vezba.Modeli.Restorani;
import com.example.goran.vezba.Modeli.RestoraniModel;
import com.example.goran.vezba.PreferencesModeli.RestoraniPreferences;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.slikaRestoran)ImageView slika;
    @BindView(R.id.imerestoran)TextView ime;
    @BindView(R.id.rejting)TextView rating;
    @BindView(R.id.city)TextView grad;
    @BindView(R.id.rvMeni)RecyclerView recViewMeni;
    RestoraniModel restorani;
    Restorani restoran;
    MeniAdapter adapter;
    int pozicija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        restorani = RestoraniPreferences.getRestoran(this);

        Intent intent = getIntent();
        if (intent.hasExtra("pozicija")) {
            pozicija = intent.getIntExtra("pozicija", 0);

            restoran = restorani.restaurants.get(pozicija);
            Picasso.with(this).load(restoran.getLogo()).centerInside().fit().into(slika);
            ime.setText(restoran.getName());
            rating.setText(restoran.getRating());
            grad.setText(restoran.getCity());
        }

        adapter = new MeniAdapter(this, new OnImageClickListener() {
            @Override
            public void onImageClick(Menu meni, int position) {
                Toast.makeText(Main2Activity.this, "You clicke on " + position + " " + meni.getFoodname(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onImageLongClick(Menu meni, int position) {

            }
        });

        adapter.setItems(restoran.menu);
        recViewMeni.setHasFixedSize(true);
        recViewMeni.setLayoutManager(new LinearLayoutManager(this));
        recViewMeni.setAdapter(adapter);
    }
}
