package com.darylx.bta.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

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
        final RelativeLayout vcv = (RelativeLayout)LayoutInflater.from(context).inflate(R.layout.cabinet_drink_cardview,viewGroup,false);
        final ImageButton ib = (ImageButton)vcv.findViewById(R.id.cabinet_delete_card_btn);
        final Button btn = (Button)vcv.findViewById(R.id.dismiss);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // previously invisible view
                final View myView = vcv.findViewById(R.id.hidden);
                ib.setEnabled(true);
                btn.setEnabled(false);

                // get the center for the clipping circle
                int cx = (btn.getLeft() + btn.getRight()) / 2;
                int cy = (btn.getTop() + btn.getBottom()) / 2;

                // get the initial radius for the clipping circle
                int initialRadius = myView.getWidth();

                // create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);

                // make the view invisible when the animation is done
                anim.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        myView.setVisibility(View.INVISIBLE);
                    }
                });
                anim.start();
            }
        });

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // previously invisible view
                View myView = vcv.findViewById(R.id.hidden);
                ib.setEnabled(false);
                btn.setEnabled(true);


// get the center for the clipping circle
                int cx = (ib.getLeft() + ib.getRight()) / 2;
                int cy = (ib.getTop() + ib.getBottom()) / 2;

// get the final radius for the clipping circle
                int finalRadius = Math.max(vcv.getWidth(), vcv.getHeight());

// create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);

// make the view visible and start the animation
                myView.setVisibility(View.VISIBLE);
                anim.start();
            }
        });

        return new ViewHolder(vcv);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(RelativeLayout v) {
            super(v);
        }
    }
}
