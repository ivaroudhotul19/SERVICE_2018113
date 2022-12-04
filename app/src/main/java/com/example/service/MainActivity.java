package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  Button play, pause, stop;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    play = findViewById(R.id.btn_play);
    pause = findViewById(R.id.btn_pause);
    stop = findViewById(R.id.btn_stop);

    play.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startService(new Intent(MainActivity.this,MusicService.class));
      }
    });

    pause.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (MusicService.mediaPlayer.isPlaying()) {
          MusicService.mediaPlayer.pause();
          pause.setText("Continue");
        } else {
          MusicService.mediaPlayer.start();
          pause.setText("Pause");
        }
      }
    });

    stop.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        stopService(new Intent(MainActivity.this,MusicService.class));
      }
    });
  }
}