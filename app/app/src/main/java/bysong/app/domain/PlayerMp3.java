package bysong.app.domain;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

import bysong.app.R;

/**
 * Created by Tiago on 15/08/2016.
 */
public class PlayerMp3 implements MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener,
        MediaPlayer.OnSeekCompleteListener {

    // Constante para ver os logs
    private static final String CATEGORIA = "bysong";
    // Declara um objeto MediaPlayer
    private MediaPlayer player;
    private int currentTime;

    public PlayerMp3(Context context, MediaPlayer.OnPreparedListener onPreparedListener) {

        // Cria o MediaPlayer
        player = new MediaPlayer();
        // Executa o listener quando terminar a música
        player.setOnCompletionListener(this);
        player.setOnPreparedListener(onPreparedListener);
        player.setOnBufferingUpdateListener(this);
        player.setOnSeekCompleteListener(this);

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

    // Pausa a música e altera o status
    public void pause() {

        player.pause();

    }
    // Para a música e altera o status
    public void stop() {

        player.stop();
        player.release();
        player = null;

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

        Log.d(CATEGORIA, "onCompletion()");

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
