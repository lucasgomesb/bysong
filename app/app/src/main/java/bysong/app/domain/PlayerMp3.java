package bysong.app.domain;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.IOException;

import bysong.app.R;

/**
 * Created by Tiago on 15/08/2016.
 */
public class PlayerMp3 implements MediaPlayer.OnBufferingUpdateListener,
        MediaPlayer.OnSeekCompleteListener {

    // Constante para ver os logs
    private static final String CATEGORIA = "bysong";
    // Declara um objeto MediaPlayer
    private MediaPlayer player;
    private static PlayerMp3 playerMp3;

    private PlayerMp3(MediaPlayer.OnPreparedListener onPreparedListener,
                      MediaPlayer.OnCompletionListener onCompletionListener) {

        player = new MediaPlayer();
        player.setOnPreparedListener(onPreparedListener);
        player.setOnCompletionListener(onCompletionListener);

    }

    public static synchronized PlayerMp3 getInstance(MediaPlayer.OnPreparedListener onPreparedListener,
                                                     MediaPlayer.OnCompletionListener onCompletionListener) {

        if (playerMp3 == null) {

            playerMp3 = new PlayerMp3(onPreparedListener, onCompletionListener);

        }

        return playerMp3;

    }

    public void killMyInstance() {

        playerMp3 = null;

    }

    public void start(String url) {

        try {

            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(url);
            player.prepareAsync();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void start(FileDescriptor asset, long offSet, long length) {

        try {

            player.setDataSource(asset, offSet, length);
            player.prepareAsync();

        } catch (IOException e) {

            Log.d(CATEGORIA, e.getMessage(), e);

        }

    }

    // Pausa a música e altera o status
    public void pause() {

        Log.d(CATEGORIA, "pause()");
        player.pause();

    }
    // Para a música e altera o status
    public void stop() {

        Log.d(CATEGORIA, "stop()");
        player.stop();
        player.release();
        player = null;

    }

    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {

        Log.d(CATEGORIA, "onBufferingUpdate()");

    }

    @Override
    public void onSeekComplete(MediaPlayer mediaPlayer) {

        Log.d(CATEGORIA, "onSeekComplete()");

    }

}
