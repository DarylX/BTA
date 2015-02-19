package com.darylx.bta.util;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.darylx.bta.R;

/**
 * Created by Daryl on 2/17/2015.
 */
public class CabinetListAdapter extends RecyclerView.Adapter<CabinetListAdapter.ViewHolder> {
// Fields

// Constructors
    public CabinetListAdapter(){

    }

// Overriden Methods
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        CardView v = (CardView)LayoutInflater.from(context).inflate(R.layout.cabinet_drink_cardview,viewGroup,false);
        ImageButton ib = (ImageButton)v.findViewById(R.id.cabinet_delete_card_btn);
        ViewCompat.setElevation(ib,20f);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ViewHolder(CardView v) {
            super(v);
        }
    }
}
