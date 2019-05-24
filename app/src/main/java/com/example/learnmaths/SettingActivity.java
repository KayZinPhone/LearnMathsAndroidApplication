package com.example.learnmaths;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SettingActivity extends AppCompatActivity {

    private ImageView btnBack;
    private ImageView btnBackgroundBall;
    private ImageView btnBackgroundBubble;
    private ImageView btnEasy;
    private ImageView btnMedium;
    private ImageView btnHard;

    private String background;
    private String level;


    private boolean isBackgroundChosen = false;
    private boolean isLevelChosen = false;
    private boolean isBubbleBackgroundChosen = false;
    private boolean isBallBackgroundChosen = false;
    private boolean isEasyChosen = false;
    private boolean isMediumChosen = false;
    private boolean isHardChosen = false;

   // private SharedPreferences mPreferences;
  //  private SharedPreferences.Editor mEditor;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

//        mPreferences = PreferenceManager.getDefaultSharedPreferences(SettingActivity.this);
//        mEditor = mPreferences.edit();
//
//
//        background = mPreferences.getString(getString(R.string.background), "Bubble");
//        level = mPreferences.getString(getString(R.string.level), "Easy");
//        mEditor.commit();


        btnBack = findViewById(R.id.back_button);
        btnBackgroundBubble = findViewById(R.id.bubble_background);
        btnBackgroundBall = findViewById(R.id.ball_background);
        btnEasy = findViewById(R.id.easy_image);
        btnMedium = findViewById(R.id.medium_image);
        btnHard = findViewById(R.id.hard_image);

        btnBackgroundBubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background = "Bubble";
                isBubbleBackgroundChosen = true;
                isBallBackgroundChosen = false;
                isBackgroundChosen = true;
                System.out.println("Clicked Bubble"+ isBackgroundChosen);

            }
        });
        btnBackgroundBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background = "Ball";
                isBallBackgroundChosen = true;
                isBubbleBackgroundChosen = false;
                isBackgroundChosen = true;
                System.out.println("Clicked Ball \t"+ isBackgroundChosen);
            }
        });

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = "Easy";
                isEasyChosen = true;
                isMediumChosen = false;
                isHardChosen = false;
                isLevelChosen = true;
                System.out.println("Clicked Easy"+ isLevelChosen);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = "Medium";
                isMediumChosen = true;
                isEasyChosen = false;
                isHardChosen = false;
                isLevelChosen = true;
                System.out.println("Clicked Medium"+ isLevelChosen);
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = "Hard";
                isHardChosen = true;
                isMediumChosen = false;
                isEasyChosen = false;
                isLevelChosen = true;
                System.out.println("Clicked Hard"+ isLevelChosen);
            }
        });


//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
//
//                //Test if the background or level chosen
//                if(!isBackgroundChosen && !isLevelChosen)
//                {
//                    background = mPreferences.getString(getString(R.string.background), "Bubble");
//                    level = mPreferences.getString(getString(R.string.level), "Easy");
//                    System.out.println("Background: "+ getString(R.string.background));
//                    System.out.println("Level: "+ getString(R.string.level));
//                    startActivity(intent);
//                }
//                else if(isBackgroundChosen || !isLevelChosen)
//                {
//                    if(isBubbleBackgroundChosen)
//                    {
//                        mEditor.putString(getString(R.string.background), background);
//                        mEditor.commit();
//                        System.out.println("Background: "+ background);
//                        System.out.println("Level: "+ level);
//                        startActivity(intent);
//
//                    }
//                    else
//                    {
//                        mEditor.putString(getString(R.string.background), background);
//                        mEditor.commit();
//                        System.out.println("Background: "+ getString(R.string.background));
//                        System.out.println("Level: "+ getString(R.string.level));
//                        startActivity(intent);
//                    }
//                }
//                else if(isLevelChosen || !isBackgroundChosen)
//                {
//                    if(isEasyChosen)
//                    {
//                        mEditor.putString(getString(R.string.level), level);
//                        mEditor.commit();
//                        System.out.println("Background: "+ getString(R.string.background));
//                        System.out.println("Level: "+ getString(R.string.level));
//                        startActivity(intent);
//
//                    }
//                    else if(isMediumChosen)
//                    {
//                        mEditor.putString(getString(R.string.level), level);
//                        mEditor.commit();
//                        System.out.println("Background: "+ getString(R.string.background));
//                        System.out.println("Level: "+ getString(R.string.level));
//                        startActivity(intent);
//                    }
//                    else{
//                        mEditor.putString(getString(R.string.level), level);
//                        mEditor.commit();
//                        System.out.println("Background: "+ getString(R.string.background));
//                        System.out.println("Level: "+ getString(R.string.level));
//                        startActivity(intent);
//                    }
//
//                }
//                else if(isBackgroundChosen && isLevelChosen)
//                {
//                   if(isBubbleBackgroundChosen)
//                   {
//                       if(isEasyChosen)
//                       {
//                           mEditor.putString(getString(R.string.background), background);
//                           mEditor.putString(getString(R.string.level), level);
//                           mEditor.commit();
//                           System.out.println("Background: "+ getString(R.string.background));
//                           System.out.println("Level: "+ getString(R.string.level));
//                           startActivity(intent);
//                       }
//                       else if(isMediumChosen)
//                       {
//                           mEditor.putString(getString(R.string.background), background);
//                           mEditor.putString(getString(R.string.level), level);
//                           mEditor.commit();
//                           System.out.println("Background: "+ getString(R.string.background));
//                           System.out.println("Level: "+ getString(R.string.level));
//                           startActivity(intent);
//
//                       }
//                       else{
//                           mEditor.putString(getString(R.string.background), background);
//                           mEditor.putString(getString(R.string.level), level);
//                           mEditor.commit();
//                           System.out.println("Background: "+ getString(R.string.background));
//                           System.out.println("Level: "+ getString(R.string.level));
//                           startActivity(intent);
//
//                       }
//                   }
//                   else
//                   {
//                       if(isEasyChosen)
//                       {
//                           mEditor.putString(getString(R.string.background), background);
//                           mEditor.putString(getString(R.string.level), level);
//                           mEditor.commit();
//                           System.out.println("Background: "+ getString(R.string.background));
//                           System.out.println("Level: "+ getString(R.string.level));
//                           startActivity(intent);
//                       }
//                       else if(isMediumChosen)
//                       {
//                           mEditor.putString(getString(R.string.background), background);
//                           mEditor.putString(getString(R.string.level), level);
//                           mEditor.commit();
//                           System.out.println("Background: "+ getString(R.string.background));
//                           System.out.println("Level: "+ getString(R.string.level));
//                           startActivity(intent);
//
//                       }
//                       else{
//                           mEditor.putString(getString(R.string.background), background);
//                           mEditor.putString(getString(R.string.level), level);
//                           mEditor.commit();
//                           System.out.println("Background: "+ getString(R.string.background));
//                           System.out.println("Level: "+ getString(R.string.level));
//                           startActivity(intent);
//
//                       }
//                   }
//
//                }
//            }
//        });
//
//
//
   }
}
