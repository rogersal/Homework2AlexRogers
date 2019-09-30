package com.example.homework2;
// Author: Alex Rogers, CS 301

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class Face extends SurfaceView {
    private int skinColor ;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;
    private FaceModel model = new FaceModel();

    public FaceModel getModel(){return model;}

    public Face(Context context, AttributeSet attrs){
    super(context, attrs);
    randomize();
    setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
    }
    public void randomize(){
        Random rand = new Random();

            skinColor = Color.rgb(rand.nextInt(255), rand.nextInt(255),rand.nextInt(255));
            eyeColor = Color.rgb(rand.nextInt(255), rand.nextInt(255),rand.nextInt(255));
            hairColor = Color.rgb(rand.nextInt(255), rand.nextInt(255),rand.nextInt(255));
            hairStyle = Color.rgb(rand.nextInt(255), rand.nextInt(255),rand.nextInt(255));

    }
    public void onDraw(Canvas k){
        Paint eyeWhite = new Paint();
        eyeWhite.setColor(Color.WHITE);//eye whites
        Paint mouth = new Paint();
        mouth.setColor(Color.RED);//eye whites

        k.drawCircle(1000,250, 200, convertPaint(skinColor) );//draws a head
        k.drawCircle(900,250, 70, eyeWhite );//draws eye whites
        k.drawCircle(1100,250, 70, eyeWhite );
        k.drawCircle(900,255, 40, convertPaint(eyeColor) );//draws pupils
        k.drawCircle(1100,255, 40, convertPaint(eyeColor) );
        k.drawRect(950, 300, 1050, 320, mouth);
        if(hairStyle ==0) {
            k.drawRect(950, 30, 1050, 90, convertPaint(hairColor));
        }
        if(hairStyle ==1) {
            k.drawRect(900, 70, 1100, 80, convertPaint(hairColor));
        }
        if(hairStyle ==2) {
            k.drawRect(970, 30, 1030, 200, convertPaint(hairColor));
        }


    }

    public void setSkinColor(int red, int green, int blue) {
        this.skinColor =Color.rgb(red,green,blue);
    }
    public void setEyeColor(int red, int green, int blue) {
        this.eyeColor =Color.rgb(red,green,blue);
    }
    public void setHairColor(int red, int green, int blue) {
        this.hairColor =Color.rgb(red,green,blue);
    }

    public Paint convertPaint(int colorInt) {
        Paint paint = new Paint();
        paint.setColor(colorInt);

    return paint;
    }

    public int getSkinColor(){
        return skinColor;
    }

    public int getEyeColor() {
        return eyeColor;
    }

    public int getHairColor() {
        return hairColor;
    }

    public int getHairStyle() {
        return hairStyle;
    }

    public void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
    }
}
