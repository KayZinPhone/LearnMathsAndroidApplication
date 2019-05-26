package com.example.learnmaths;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

  //  private SharedPreferences mPreferences;
   // private SharedPreferences.Editor mEditor;

    private MediaPlayer mediaPlayer;
    private TextView txtTimeCount;
    private Random r = new Random();

    //Initialize Class
    private Handler handler = new Handler();
    private Timer timer = new Timer();

    //Screen Size
    private int screenWidth;
    private int screenHeight;

    //Bubble Size
    private int img1W;
    private int img1H;
    private int img2W;
    private int img2H;
    private int img3W;
    private int img3H;
    private int img4W;
    private int img4H;
    private int img5W;
    private int img5H;

    //Bubble
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    private TextView[] object = {textView1, textView2, textView3, textView4, textView5};

    //Pause Button
    private ImageView btnPause;

    //Size

    //Position
    private float img1PosX;
    private float img1PosY;
    private float img2PosX;
    private float img2PosY;
    private float img3PosX;
    private float img3PosY;
    private float img4PosX;
    private float img4PosY;
    private float img5PosX;
    private float img5PosY;

    //Move Direction //nextInt((max - min) + 1) + min;
    private float img1DirX = (float) r.nextInt((10-5)+1)+5;
    private float img1DirY = (float) r.nextInt((10-5)+1)+5;
    private float img2DirX = (float) r.nextInt((10-5)+1)+5;
    private float img2DirY = (float) r.nextInt((10-5)+1)+5;
    private float img3DirX = (float) r.nextInt((10-5)+1)+5;
    private float img3DirY = (float) r.nextInt((10-5)+1)+5;
    private float img4DirX = (float) r.nextInt((10-5)+1)+5;
    private float img4DirY = (float) r.nextInt((10-5)+1)+5;
    private float img5DirX = (float) r.nextInt((10-5)+1)+5;
    private float img5DirY = (float) r.nextInt((10-5)+1)+5;

//    private float img1PosX = (float) r.nextInt((10-5)+1)+5;
//    private float img1PosY = (float) r.nextInt((10-5)+1)+5;
//    private float img2PosX = (float) r.nextInt((10-5)+1)+5;
//    private float img2PosY = (float) r.nextInt((10-5)+1)+5;
//    private float img3PosX = (float) r.nextInt((10-5)+1)+5;
//    private float img3PosY = (float) r.nextInt((10-5)+1)+5;
//    private float img4PosX = (float) r.nextInt((10-5)+1)+5;
//    private float img4PosY = (float) r.nextInt((10-5)+1)+5;
//    private float img5PosX = (float) r.nextInt((10-5)+1)+5;
//    private float img5PosY = (float) r.nextInt((10-5)+1)+5;

    //private float img1DirX, img1DirY, img2DirX, img2DirY, img3DirX, img3DirY, img4DirX, img4DirY, img5DirX, img5DirY;

    //private int[] easy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 20, 23, 24, 30, 35, 36, 40, 47}; // total = 20
    //private int[] medium = {12, 20, 23, 24, 30, 35, 36, 40, 47, 48, 50, 12+3, 11+5, 10+4, 9+4,20-3,50-21,33+12,1+25,63-14}; //total = 20
    //private int[] hard = {29+14, 17+15, 43+37, 28+16, 75-28, 12+14, 63-14, 54-17, 38-26, 79-23, 2*14+23, 44-6*3, 19*6-89, 230-17*13, 109, 35, 76, 93, 45+12-9, 53+3-26}; //total = 20
                        //   43,    32,    80,    44,    47,    26,    49,    37,    12,    56,      51,     37,      25,         9, 109, 35, 76, 93,      48,     30);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mEditor = mPreferences.edit();

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        img1W = textView1.getLayoutParams().width;
        img1H = textView1.getLayoutParams().height;
        img2W = textView2.getLayoutParams().width;
        img2H = textView2.getLayoutParams().height;
        img3W = textView3.getLayoutParams().width;
        img3H = textView3.getLayoutParams().height;
        img4W = textView4.getLayoutParams().width;
        img4H = textView4.getLayoutParams().height;
        img5W = textView5.getLayoutParams().width;
        img5H = textView5.getLayoutParams().height;

        btnPause = findViewById(R.id.pause_image);

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder message = new AlertDialog.Builder(GameActivity.this);
                message.setMessage("Paused").setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intentMain = new Intent(GameActivity.this, MainActivity.class);
                                startActivity(intentMain);
                            }
                        }).setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                }).show();
                timer.cancel();
            }
        });

        //Change Background
       // String background = mPreferences.getString(getString(R.string.background), "Bubble");
       // System.out.println("In Game Activity  \tBackground: "+background);
        //if(background == "Ball")
        {
//            textView1.setBackgroundResource(R.drawable.basketball_background);
//            textView2.setBackgroundResource(R.drawable.basketball_background);
//            textView3.setBackgroundResource(R.drawable.basketball_background);
//            textView4.setBackgroundResource(R.drawable.basketball_background);
//            textView5.setBackgroundResource(R.drawable.basketball_background);

//            textView1.setBackground(getDrawable(R.drawable.basketball_background));
//            textView2.setBackground(getDrawable(R.drawable.basketball_background));
//            textView3.setBackground(getDrawable(R.drawable.basketball_background));
//            textView4.setBackground(getDrawable(R.drawable.basketball_background));
//            textView5.setBackground(getDrawable(R.drawable.basketball_background));

        }
//        else
//        {
//            textView1.setBackground(getDrawable(R.drawable.bubble));
//            textView2.setBackground(getDrawable(R.drawable.bubble));
//            textView3.setBackground(getDrawable(R.drawable.bubble));
//            textView4.setBackground(getDrawable(R.drawable.bubble));
//            textView5.setBackground(getDrawable(R.drawable.bubble));
//
////            textView1.setBackgroundResource(R.drawable.bubble);
////            textView2.setBackgroundResource(R.drawable.bubble);
////            textView3.setBackgroundResource(R.drawable.bubble);
////            textView4.setBackgroundResource(R.drawable.bubble);
////            textView5.setBackgroundResource(R.drawable.bubble);
//
//
//        }

       // String level= mPreferences.getString(getString(R.string.level), "Easy");
        //System.out.println("In Game Activity  \tLevel: "+level);
//        if(level == "Easy")
//        {
//            System.out.println("In Game Activity Easy");
//        }
//        else if(level == "Medium")
//        {
//            System.out.println("In Game Activity  Medium");
//        }
//        else
//        {
//            System.out.println("In Game Activity Hard");
//        }

        //Get Screen Size.
        WindowManager wm = getWindowManager();
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        System.out.println("Width"+ Integer.toString(screenWidth));
        System.out.println("Height"+Integer.toString(screenHeight));

        //Start the timer
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos1();
                        changePos2();
                        changePos3();
                        changePos4();
                        changePos5();


                    }
                });
            }
        }, 0, 20);

        txtTimeCount = findViewById(R.id.time_count);

        mediaPlayer = MediaPlayer.create(GameActivity.this,R.raw.main_song);


//        String soundStatus = mPreferences.getString(getString(R.string.soundStatus), "On");
//        if(soundStatus == "On")
//        {
//            mediaPlayer.start();
//        }
//        else
//        {
//            mediaPlayer.stop();
//        }


        CountDownTimer countDownTimer = new CountDownTimer(60*1000, 1000){
            public void onTick(long millisUntilFinished){
                txtTimeCount.setText(String.valueOf(millisUntilFinished/1000));
            }
            public  void onFinish(){
                //txtTimeCount.setText("FINISH!!");
                AlertDialog.Builder message = new AlertDialog.Builder(GameActivity.this);
                message.setMessage("Sorry! Time is over.").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(GameActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                }).show();
                timer.cancel();
            }
        }.start();
    }
    public void changePos1()
    {
       // img1PosY -= 10;

        // update position based on current direction
        img1PosX = img1PosX + img1DirX;
        img1PosY = img1PosY + img1DirY;

        System.out.println("Width: "+img1W);
        System.out.println("Height: "+img1H);
        System.out.println("Position X: "+img1PosX);
        System.out.println("Position Y: "+img1PosY);




        // bounce on left or right edge
        if ((img1DirX > 0 && img1PosX+img1W/2 > screenWidth) || (img1DirX < 0 && img1PosX-img1W/2 < 0)) {

            img1DirX = -1 * img1DirX;
        }

        // bounce on top or bottom edge
        if ((img1DirY > 0 && img1PosY+img1H/2 > screenHeight) || (img1DirY < 0 && img1PosY-img1H/2 < 0)) {
            img1DirY = -1 * img1DirY;
        }

        textView1.setX(img1PosX);
        textView1.setY(img1PosY);


    }
    public void changePos2()
    {
       // img2PosY -= 10;

        // update position based on current direction
        img2PosX = img2PosX + img2DirX;
        img2PosY = img2PosY + img2DirY;



        // bounce on left or right edge
        if ((img2DirX > 0 && img2PosX+img2W/2 > screenWidth) || (img2DirX < 0 && img2PosX-img2W/2 < 0)) {

            img2DirX = -1 * img2DirX;
        }

        // bounce on top or bottom edge
        if ((img2DirY > 0 && img2PosY+img2H/2 > screenHeight) || (img2DirY < 0 && img2PosY-img2H/2 < 0)) {
            img2DirY = -1 * img2DirY;
        }

        textView2.setX(img2PosX);
        textView2.setY(img2PosY);


    }
    public void changePos3()
    {
      //  img3PosY -= 10;

        // update position based on current direction
        img3PosX = img3PosX + img3DirX;
        img3PosY = img3PosY + img3DirY;



        // bounce on left or right edge
        if ((img3DirX > 0 && img3PosX+img3W/2 > screenWidth) || (img3DirX < 0 && img3PosX-img3W/2 < 0)) {

            img3DirX = -1 * img3DirX;
        }

        // bounce on top or bottom edge
        if ((img3DirY > 0 && img3PosY+img3H/2 > screenHeight) || (img3DirY < 0 && img3PosY-img3H/2 < 0)) {
            img3DirY = -1 * img3DirY;
        }

        textView3.setX(img3PosX);
        textView3.setY(img3PosY);


    }
    public void changePos4()
    {
       // img4PosY -= 10;

        // update position based on current direction
        img4PosX = img4PosX + img4DirX;
        img4PosY = img4PosY + img4DirY;



        // bounce on left or right edge
        if ((img4DirX > 0 && img4PosX+img4W/2 > screenWidth) || (img4DirX < 0 && img4PosX-img4W/2 < 0)) {

            img4DirX = -1 * img4DirX;
        }

        // bounce on top or bottom edge
        if ((img4DirY > 0 && img4PosY+img4H/2 > screenHeight) || (img4DirY < 0 && img4PosY-img4H/2 < 0)) {
            img4DirY = -1 * img4DirY;
        }

        textView4.setX(img4PosX);
        textView4.setY(img4PosY);


    }
    public void changePos5()
    {
     //   img5PosY -= 10;

        // update position based on current direction
        img5PosX = img5PosX + img5DirX;
        img5PosY = img5PosY + img5DirY;



        // bounce on left or right edge
        if ((img5DirX > 0 && img5PosX+img5W/2 > screenWidth) || (img5DirX < 0 && img5PosX-img5W/2 < 0)) {

            img5DirX = -1 * img5DirX;
        }

        // bounce on top or bottom edge
        if ((img5DirY > 0 && img5PosY+img5H/2 > screenHeight) || (img5DirY < 0 && img5PosY-img5H/2 < 0)) {
            img5DirY = -1 * img5DirY;
        }

        textView5.setX(img5PosX);
        textView5.setY(img5PosY);


    }
//    public void changePos2()
//    {
//
//        img2PosY -= 10;
//        if(textView2.getY() + textView2.getHeight() < 0){
//            img2PosX = (float) Math.floor(Math.random() * (screenWidth - textView2.getWidth()));
//            img2PosY = screenHeight + 100.0f;
//
//        }
//        textView2.setX(img2PosX);
//        textView2.setY(img2PosY);
//
//        // update position based on current direction
//        img2PosX = img2PosX + img2DirX;
//        img2PosY = img2PosY + img2DirY;
//
//        // bounce on left or right edge
//        if ((img2DirX > 0 && img2PosX/2 > screenWidth)
//                || (img2DirX < 0 && img2PosX/2 < 0)) {
//            img2DirX = -1 * img2DirX;
//        }
//
//        // bounce on top or bottom edge
//        if ((img2DirY > 0 && img2PosY/2 > screenHeight)
//                || (img2DirY < 0 && img2PosY/2 < 0)) {
//            img2DirY = -1 * img2DirY;
//        }
//    }
//    public void changePos3()
//    {
//
//        img3PosY -= 10;
//        if(textView3.getY() + textView3.getHeight() < 0){
//            img3PosX = (float) Math.floor(Math.random() * (screenWidth - textView3.getWidth()));
//            img3PosY = screenHeight + 100.0f;
//
//        }
//        textView3.setX(img3PosX);
//        textView3.setY(img3PosY);
//
//        // update position based on current direction
//        img3PosX = img3PosX + img3DirX;
//        img3PosY = img3PosY + img3DirY;
//
//        // bounce on left or right edge
//        if ((img3DirX > 0 && img3PosX/2 > screenWidth)
//                || (img3DirX < 0 && img3PosX/2 < 0)) {
//            img3DirX = -1 * img3DirX;
//        }
//
//        // bounce on top or bottom edge
//        if ((img3DirY > 0 && img3PosY/2 > screenHeight)
//                || (img3DirY < 0 && img3PosY/2 < 0)) {
//            img3DirY = -1 * img3DirY;
//        }
//    }
//    public void changePos4()
//    {
//
//        img4PosY -= 10;
//        if(textView4.getY() + textView4.getHeight() < 0){
//            img4PosX = (float)Math.floor(Math.random() * (screenWidth - textView4.getWidth()));
//            img4PosY = screenHeight + 100.0f;
//
//        }
//        textView4.setX(img4PosX);
//        textView4.setY(img4PosY);
//
//        // update position based on current direction
//        img4PosX = img4PosX + img4DirX;
//        img4PosY = img4PosY + img4DirY;
//
//        // bounce on left or right edge
//        if ((img4DirX > 0 && img4PosX/2 > screenWidth)
//                || (img4DirX < 0 && img4PosX/2 < 0)) {
//            img4DirX = -1 * img4DirX;
//        }
//
//        // bounce on top or bottom edge
//        if ((img4DirY > 0 && img4PosY/2 > screenHeight)
//                || (img4DirY < 0 && img4PosY/2 < 0)) {
//            img4DirY = -1 * img4DirY;
//        }
//    }
//    public void changePos5()
//    {
//
//        img5PosY -= 10;
//        if(textView5.getY() + textView5.getHeight() < 0){
//            img5PosX = (float)Math.floor(Math.random() * (screenWidth - textView5.getWidth()));
//            img5PosY = screenHeight + 100.0f;
//
//        }
//        textView5.setX(img5PosX);
//        textView5.setY(img5PosY);
//
//        // update position based on current direction
//        img5PosX = img5PosX + img5DirX;
//        img5PosY = img5PosY + img5DirY;
//
//        // bounce on left or right edge
//        if ((img5DirX > 0 && img5PosX/2 > screenWidth)
//                || (img5DirX < 0 && img5PosX/2 < 0)) {
//            img5DirX = -1 * img5DirX;
//        }
//
//        // bounce on top or bottom edge
//        if ((img5DirY > 0 && img5PosY/2 > screenHeight)
//                || (img5DirY < 0 && img5PosY/2 < 0)) {
//            img5DirY = -1 * img5DirY;
//        }
//    }
    public void ChangeBackground()
    {

    }
    public void setLevel()
    {

    }





//    public void changePosition(TextView tv, float x, float y, int dirX, int dirY)
//    {
//        y -= 10;
//        if(tv.getY() + tv.getHeight() < 0){
//            x = (float)Math.floor(Math.random() * (screenWidth - tv.getWidth()));
//            y = screenHeight + 100.0f;
//
//        }
//        tv.setX(x);
//        tv.setY(y);
//
//        // update position based on current direction
//        x = x + dirX;
//        y = y + dirY;
//
//        // bounce on left or right edge
//        if ((dirX > 0 && x/2 > screenWidth)
//                || (dirX < 0 && x/2 < 0)) {
//            dirX = (-1) * dirX;
//        }
//
//        // bounce on top or bottom edge
//        if ((dirY > 0 && y/2 > screenHeight)
//                || (dirY < 0 && y/2 < 0)) {
//            dirY = (-1) * dirY;
//        }
//    }
}
