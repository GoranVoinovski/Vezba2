package com.example.goran.vezba.Adapteri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goran.vezba.Listeners.OnImageClickListener;
import com.example.goran.vezba.Modeli.Menu;
import com.example.goran.vezba.Modeli.RestoraniModel;
import com.example.goran.vezba.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Goran on 1/5/2018.
 */

public class MeniAdapter extends RecyclerView.Adapter<MeniAdapter.ViewHolder> {
    RestoraniModel model = new RestoraniModel();
    Context context;
    OnImageClickListener onImageClickListener;

    public void setItems(ArrayList<Menu> menija){model.menu = menija;}

    public MeniAdapter(Context context, OnImageClickListener _onImageClickListener) {
        this.context = context;
        this.onImageClickListener = _onImageClickListener;
    }

    @Override
    public MeniAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hrana, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MeniAdapter.ViewHolder holder, final int position) {
        final Menu menu = model.menu.get(position);

        Picasso.with(context).load(menu.getLink()).centerInside().fit().into(holder.hranaimg);
        holder.hrananame.setText(menu.getFoodname());
        holder.cena.setText(menu.getPrice());

        holder.hranaimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick(menu,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.menu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.slikahrana)ImageView hranaimg;
        @BindView(R.id.nazivhrana)TextView hrananame;
        @BindView(R.id.cenahrana)TextView cena;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
