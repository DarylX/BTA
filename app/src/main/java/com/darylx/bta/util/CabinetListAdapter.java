package com.darylx.bta.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
        final Context context = viewGroup.getContext();

        if (i == 0 || i == 2) {
            return new ViewHolder((RelativeLayout)LayoutInflater.from(context).inflate(R.layout.card_cabinet_profile, viewGroup, false));
        }

        RelativeLayout vcv = (RelativeLayout)LayoutInflater.from(context).inflate(R.layout.card_cabinet_drink,viewGroup,false);

        return new ViewHolder(vcv);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if(i != 0 && i != this.getItemCount()-1)
           viewHolder.changeDrinkText("Drink number " + i);
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 0;
        } else if (position == this.getItemCount()-1){
            return 2;
        }
        return 1;
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout layout;

        public ViewHolder(RelativeLayout v) {
            super(v);
            layout = v;
        }

        public void changeDrinkText(String s){
            ((TextView)layout.findViewById(R.id.cabinet_card_main_txt)).setText(s);
        }
    }


}
