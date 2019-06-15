package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.img);
        Drawable drawable = getResources().getDrawable(R.drawable.timg);
        BitmapDrawable  bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = changeBitmapColor(bitmapDrawable.getBitmap(),Color.parseColor("#ff3e4245"),Color.parseColor("#9900ff00"));
        bitmapDrawable = new BitmapDrawable(bitmap);
        imageView.setBackground(bitmapDrawable);
    }

    public static Bitmap changeBitmapColor(Bitmap origBm,int oldColor, int newColor) {
        Bitmap copyBm = origBm.copy(Bitmap.Config.ARGB_8888, true);
        final int w = copyBm.getWidth();
        final int h = copyBm.getHeight();
        for(int i=0; i<w; i++) {
            for(int j=0; j<h; j++) {
                int pixel = copyBm.getPixel(i, j);
                int a = Color.alpha(pixel);
                int r = Color.red(pixel);
                int g = Color.green(pixel);
                int b = Color.blue(pixel);

                int oldA = Color.alpha(oldColor);
                int oldR = Color.red(oldColor);
                int oldG = Color.green(oldColor);
                int oldB = Color.blue(oldColor);
//                Log.i("colordata",a +"-"+r+"-"+g+"-"+b);
//                Log.i("colordataOld",oldA +"-"+oldR+"-"+oldG+"-"+oldB);
//                Log.i("colordataNew",newA +"-"+newR+"-"+newG+"-"+newB);
                if(a == oldA && r == oldR && g == oldG && b == oldB) {
                    copyBm.setPixel(i, j, newColor);
                }
            }
        }
        origBm = copyBm;
        return origBm;
    }
}
