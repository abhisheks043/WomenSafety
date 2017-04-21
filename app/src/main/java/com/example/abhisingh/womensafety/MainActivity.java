package com.example.abhisingh.womensafety;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    MediaPlayer mediaPlayer;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(R.string.app_name);

        mediaPlayer = MediaPlayer.create(this,R.raw.siren);
        dbHandler = new MyDBHandler(this,null,null,1);

    }

    public void playMusic(View v)
    {
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        else
            mediaPlayer.start();
    }

    public void sendHelp(View v)
    {
        String msg = "I AM IN DANGER!";
        String contacts = dbHandler.getData();

        Intent smsIntent=new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+contacts));
        smsIntent.putExtra("sms_body",msg);
        startActivity(smsIntent);

    }

    public void safeClicked(View v)
    {
        String msg = "I AM SAFE!";
        String contacts = dbHandler.getData();

        Intent smsIntent=new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+contacts));
        smsIntent.putExtra("sms_body",msg);
        startActivity(smsIntent);
    }

    public void nextActivity(View v)
    {
        Intent i =new Intent(this,Activity2.class);
        startActivity(i);
    }




}
