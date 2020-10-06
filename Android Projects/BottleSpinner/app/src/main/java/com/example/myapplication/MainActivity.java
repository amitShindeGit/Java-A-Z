package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int lastDir;
    private boolean spinning;
    Random rand = new Random();
    ImageView bottleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottleImageView = findViewById(R.id.bottleImageView);
    }

    public void rotateBottle(View view){
       if(!spinning) {
           int newDir = rand.nextInt(1800);
           float pivotX = bottleImageView.getWidth() / 2;
           float pivotY = bottleImageView.getHeight() / 2;

           Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
           rotate.setDuration(2500);
           rotate.setFillAfter(true);
           rotate.setAnimationListener(new Animation.AnimationListener() {
               @Override
               public void onAnimationStart(Animation animation) {
                   spinning = true;
               }

               @Override
               public void onAnimationEnd(Animation animation) {
                   spinning = false;
               }

               @Override
               public void onAnimationRepeat(Animation animation) {

               }
           });

           lastDir = newDir;
           bottleImageView.startAnimation(rotate);
       }

    }
}
