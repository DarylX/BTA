package com.darylx.bta;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageButton;

import com.darylx.bta.controllers.PageSwitchController;

public class BTApplication extends ActionBarActivity {

    PageSwitchController pageSwitcher;
    ViewPager pager;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btapplication);

        pageSwitcher = new PageSwitchController(this.getSupportFragmentManager());
        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(pageSwitcher);

        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                // Or read size directly from the view's width/height
                int size = getResources().getDimensionPixelSize(R.dimen.diameter);
                outline.setOval(0, 0, size, size);
            }
        };

        ImageButton addButton = (ImageButton)findViewById(R.id.add_fab);
        addButton.setOutlineProvider(viewOutlineProvider);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_btapplication, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
