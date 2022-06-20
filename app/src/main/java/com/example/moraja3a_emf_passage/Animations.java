package com.example.moraja3a_emf_passage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class Animations extends AppCompatActivity {


    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);

        im = findViewById(R.id.img);
    }

    public void anim1(View view) {

        RotateAnimation r = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,1f,RotateAnimation.RELATIVE_TO_SELF,0f);

        r.setDuration(5000);
        im.startAnimation(r);
        //AlphaAnimation a = new AlphaAnimation(1f,0f);
        //a.setDuration(5000);
        //a.setFillAfter(true);
       // im.startAnimation(a);
    }

    public void anim2(View view) {

        AlphaAnimation an = new AlphaAnimation(0f,1f);
        an.setDuration(5000);
        an.setFillAfter(true);
        im.startAnimation(an);
    }

    public void zoom1(View view) {
        ScaleAnimation s = new ScaleAnimation(0.5f,1.5f,0.5f,1.5f);
        s.setDuration(5000);
        im.startAnimation(s);
    }

    public void trans1(View view) {
        TranslateAnimation t = new TranslateAnimation(10f,200f,200f,10f);
        t.setDuration(5000);
        im.startAnimation(t);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.btn_home:
                Toast.makeText(this, "m coming home", Toast.LENGTH_SHORT).show();break;
            case R.id.hh:
                Toast.makeText(this, "hhhhhhhhhhhhhh", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}