package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.Random;

public class MusicService extends Service {
  static MediaPlayer mediaPlayer;

  int music[] = {
          R.raw.music1,
          R.raw.music2,
          R.raw.music3,
  };
  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    int random = new Random().nextInt(music.length);

    if (mediaPlayer != null) {
      mediaPlayer.stop();
      mediaPlayer.release();
    }
    mediaPlayer = MediaPlayer.create(this, music[random]);
    mediaPlayer.setLooping(true);
    mediaPlayer.start();
    return START_NOT_STICKY;
  }

  @Override
  public void onDestroy() {
    mediaPlayer.stop();
    super.onDestroy();
  }
}
