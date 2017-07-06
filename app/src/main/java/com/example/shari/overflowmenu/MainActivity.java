package com.example.shari.overflowmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.onClick;
import static android.R.id.button1;

public class MainActivity extends AppCompatActivity {
private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View v){
                PopupMenu popup = new PopupMenu(MainActivity.this, button1);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
             popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                 public boolean onMenuItemClick(MenuItem item) {
                     Toast.makeText(MainActivity.this, "You clicked : " + item.getTitle(), Toast.LENGTH_LONG).show();
                     return true;
                 }
             });
                popup.show();

            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);
        switch (item.getItemId()){
            case R.id.menu_red:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.RED);
                return true;

            case R.id.menu_green:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.menu_yellow:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
