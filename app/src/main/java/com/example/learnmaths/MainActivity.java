package com.example.learnmaths;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static com.example.learnmaths.R.drawable.sound_off_button;
import static com.example.learnmaths.R.drawable.sound_on_button;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";

  //  private SharedPreferences mPreferences;
  //  private SharedPreferences.Editor mEditor;

    private MediaPlayer mediaPlayer;
    private ImageView btnPlay;
    private ImageView btnSound;
    private ImageView btnSetting;
    private ImageView btnLeaderBoard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // mPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        //mEditor = mPreferences.edit();


        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.main_song);
        mediaPlayer.start();
        //String sound = mPreferences.getString(getString(R.string.soundStatus), "On");


        btnPlay = findViewById(R.id.play_image);
        btnSetting = findViewById(R.id.setting_image);
        btnSound = findViewById(R.id.sound_on_image);
        btnLeaderBoard = findViewById(R.id.leaderboard_image);


        btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView=  findViewById(R.id.sound_on_image);
                imageView.setImageResource(sound_off_button);
                if(mediaPlayer.isPlaying())
                {
                    //stop or pause your media player mediaPlayer.stop(); or mediaPlayer.pause();
                    //mEditor.putString(getString(R.string.soundStatus), "Off");
                    //mEditor.commit();
                    mediaPlayer.pause();
                    imageView.setImageResource(sound_off_button);


                }
                else
                {
                    //mEditor.putString(getString(R.string.soundStatus), "On");
                    //mEditor.commit();
                    mediaPlayer.start();
                    imageView.setImageResource(sound_on_button);

                }

            }
        });



        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game_intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(game_intent);
                mediaPlayer.stop();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting_intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(setting_intent);
            }
        });


    }
}
