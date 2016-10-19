package bysong.app.domain;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.IOException;

import bysong.app.R;

/**
 * Created by Tiago on 15/08/2016.
 */
public class PlayerMp3 implements MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener,
        MediaPlayer.OnSeekCompleteListener {

    // Constante para ver os logs
    Context context;
    private static final String CATEGORIA = "bysong";
    // Declara um objeto MediaPlayer
    private MediaPlayer player;
    private int currentTime;
    MediaPlayer.OnPreparedListener onPreparedListener;
    private static PlayerMp3 playerMp3;

    public PlayerMp3(Context context, MediaPlayer.OnPreparedListener onPreparedListener) {

        this.context = context;
        this.onPreparedListener = onPreparedListener;
        this.prepareMediaPlayer();
    }

    public PlayerMp3(Context context) {
        this.context = context;
    }

    public static synchronized PlayerMp3 getInstance(MediaPlayer.OnPreparedListener onPreparedListener,
                                                     MediaPlayer.OnCompletionListener onCompletionListener) {

        if (playerMp3 == null) {

            playerMp3 = new PlayerMp3(onPreparedListener, onCompletionListener);

        }

        return playerMp3;

    }

    private PlayerMp3(MediaPlayer.OnPreparedListener onPreparedListener,
                      MediaPlayer.OnCompletionListener onCompletionListener) {

        player = new MediaPlayer();
        player.setOnPreparedListener(onPreparedListener);
        player.setOnCompletionListener(onCompletionListener);

    }


    public void killMyInstance() {

        playerMp3 = null;

    }

    public PlayerMp3(Context context, int mp3, MediaPlayer.OnPreparedListener onPreparedListener) {

        // Cria o MediaPlayer
        player = MediaPlayer.create(context, mp3);

        this.prepareMediaPlayer();

    }

    private void prepareMediaPlayer() {
        // Cria o MediaPlayer
        player = new MediaPlayer();

        // Executa o listener quando terminar a música
        player.setOnCompletionListener(this);
        player.setOnPreparedListener(this.onPreparedListener);
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

    public void start(FileDescriptor asset, long offSet, long length) {

        try {
            if (player.isPlaying()) {
                this.stop();
                this.prepareMediaPlayer();
            }

            player.setDataSource(asset, offSet, length);
            player.prepareAsync();

        } catch (IOException e) {
            Log.d(CATEGORIA, e.getMessage(), e);
        }
    }

    public void start() {
        player.start();
    }

    public void playLocalFile(int resourceFileID, int startTime, int duration) {

        player = MediaPlayer.create(this.context, resourceFileID);

        if (startTime > 0) {
            player.seekTo(startTime);
        }

        player.start();

        if (startTime > 0 && duration > 0) {
            Handler handler = new Handler();
            handler.postDelayed(stopPlayerTask, duration);
        }
    }

    public void playLocalFile(int resourceFileID) {
        this.playLocalFile(resourceFileID, 0, 0);
    }

    Runnable stopPlayerTask = new Runnable() {
        @Override
        public void run() {
            player.pause();
        }
    };

    // Pausa a música e altera o status
    public void pause() {

        if (player != null)
            player.pause();

    }

    // Para a música e altera o status
    public void stop() {

        if (player.isPlaying()) {
            player.stop();
            player.reset();
        }

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

        Log.d(CATEGORIA, "onCompletion()");
        stop();

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
