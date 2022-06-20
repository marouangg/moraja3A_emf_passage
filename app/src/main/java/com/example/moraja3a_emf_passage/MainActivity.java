package com.example.moraja3a_emf_passage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void get(View v) {

        Intent i = null;

        switch (v.getId()){

            case R.id.btn_adds:i=new Intent(MainActivity.this,add_activity.class);break;
            case R.id.btn_edits:i=new Intent(MainActivity.this,edite_Activity.class);break;
            case R.id.btn_listes:i=new Intent(MainActivity.this,list_tous_Activity.class);break;

        }
       startActivity(i);
    }
}