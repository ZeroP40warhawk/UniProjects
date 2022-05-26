package com.example.rory.swipy_dex;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import static com.example.rory.swipy_dex.R.id;
import static com.example.rory.swipy_dex.R.layout;

public class AllAudio extends AppCompatActivity {
    MediaPlayer mPlayer2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_all_audio);

        GridView gridview = (GridView) findViewById(id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                stopPlaying();
                if (position == 0) {
                    mPlayer2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("bulb", "raw", getPackageName()));
                    mPlayer2.start();
                }
                else if (position == 1) {
                    mPlayer2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("ivy", "raw", getPackageName()));
                    mPlayer2.start();
                }
                else if (position == 2) {
                    mPlayer2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("ven", "raw", getPackageName()));
                    mPlayer2.start();
                }
                else if (position == 3) {
                    mPlayer2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("chara", "raw", getPackageName()));
                    mPlayer2.start();
                }
                else if (position == 4) {
                    mPlayer2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("charam", "raw", getPackageName()));
                    mPlayer2.start();
                }
                else if (position == 5) {
                    mPlayer2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("charz", "raw", getPackageName()));
                    mPlayer2.start();
                }
                else if (position == 6) {
                    mPlayer2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("sqrt", "raw", getPackageName()));
                    mPlayer2.start();
                }
                else if (position == 7) {
                    mPlayer2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("wart", "raw", getPackageName()));
                    mPlayer2.start();
                }
                else if (position == 8) {
                    mPlayer2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("blast", "raw", getPackageName()));
                    mPlayer2.start();
                }
                else if (position == 9) {
                    mPlayer2 = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("cater", "raw", getPackageName()));
                    mPlayer2.start();
                }
            }

        });


    }

    @Override
    protected void onPause() {
        if (this.isFinishing() && mPlayer2 != null){ //basically BACK was pressed from this activity
            mPlayer2.stop();
            Toast.makeText(AllAudio.this, "Returning To Main Menu", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(AllAudio.this, "Returning To Main Menu", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    private void stopPlaying() {
        if (mPlayer2 != null) {
            mPlayer2.stop();
            mPlayer2.release();
            mPlayer2 = null;
        }
    }
}