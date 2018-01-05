package com.example.goran.vezba.Listeners;

import com.example.goran.vezba.Modeli.Restorani;

/**
 * Created by goran on 18.12.17.
 */

public interface RestoraniOnClickListener {

    public void onRestoranClick(Restorani restoran, int position);
    public void onRestoranLongClick(Restorani restoran, int position);

}
