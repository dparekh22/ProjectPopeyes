package com.dparekh22.petthecat;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;



public class MainActivity extends Activity {

    MediaPlayer mySound;

    Button button1;
    int count = 0;
    EditText scoreText;
    TextView text1;
    TextView textTitle;
    ImageView imageView;




    private static final String FORMAT = "%02d:%02d:%02d";


    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        Log.w("Hello", "onCreate()");
        setContentView(R.layout.activity_main);


        mySound = MediaPlayer.create(this, R.raw.thebuzz);
        mySound.start();
        scoreText = (EditText) findViewById(R.id.editText);
        textTitle = (TextView) findViewById(R.id.myTextTitle);

        text1 = (TextView) findViewById(R.id.textView1);
        scoreText.setText(Integer.toString(count));


       //imageView = (ImageView) findViewById(R.id.cat_image);
        //imageView.setImageDrawable(R.drawable.cat);

        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {

                text1.setText("" + String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));


            }

            public void onFinish() {
                text1.setText("done!");
            }
        };

    }

    public void incrementCounter(View v)

    {
        Log.w("Hello", "buttonOnClick()");

        count++;
        scoreText.setText(Integer.toString(count));


    }

    @Override
    public void onPause()
    {
        mySound.stop();
    }
    public void onDestroy()
    {
        mySound.stop();
    }

}
