package com.example.goran.vezba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.goran.vezba.Adapteri.RVRestoraniAdapter;
import com.example.goran.vezba.Listeners.RestoraniOnClickListener;
import com.example.goran.vezba.Modeli.Restorani;
import com.example.goran.vezba.Modeli.RestoraniModel;
import com.example.goran.vezba.PreferencesModeli.RestoraniPreferences;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv)RecyclerView moeRView;
    RestoraniModel model = new RestoraniModel();
    RVRestoraniAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new RVRestoraniAdapter(this, new RestoraniOnClickListener() {
            @Override
            public void
            onRestoranClick(Restorani restoran, int position) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("pozicija", position);
                startActivityForResult(intent, 1000);}

            @Override
            public void onRestoranLongClick(Restorani restoran, final int position) {

                        model.restaurants.remove(position);
                        RestoraniPreferences.addRestoran(model, MainActivity.this);
                        adapter.setItems(generateList());
                        adapter.notifyDataSetChanged();
                    }
                });

        adapter.setItems(generateList());
        moeRView.setHasFixedSize(true);
        moeRView.setLayoutManager(new LinearLayoutManager(this));
        moeRView.setAdapter(adapter);



    }

    ArrayList<Restorani> generateList() {model = RestoraniPreferences.getRestoran(this);
        return model.restaurants;}


}
