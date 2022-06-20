package com.example.moraja3a_emf_passage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ountuch_listiner_moraja3A extends AppCompatActivity {
    ImageView i;
    int[] images= {R.drawable.im1,R.drawable.im2,R.drawable.im3};
    int pos = 0;
    float dx, dy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ountuch_listiner_moraja3);


        i = findViewById(R.id.img);

        i.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        dx = motionEvent.getX() - i.getX();
                        dy = motionEvent.getY() - i.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        i.setX(motionEvent.getX()-dx);
                        i.setY(motionEvent.getY()-dy);
                }
                return true;
            }
        });
    }
}