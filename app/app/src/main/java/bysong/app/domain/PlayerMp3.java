package bysong.app.domain;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import bysong.app.R;

/**
 * Created by Tiago on 15/08/2016.
 */
public class PlayerMp3 implements MediaPlayer.OnCompletionListener {

    // Constante para ver os logs
    private static final String CATEGORIA = "bysong";
    // Constantes para controle do ciclo de vida do player mp3
    private static final int NOVO     = 0;
    private static final int INICIADO = 1;
    private static final int PAUSADO  = 2;
    private static final int PARADO   = 3;
    // Inicia com o status zerado
    private int status = NOVO;
    // Declara um objeto MediaPlayer
    private MediaPlayer player;
    // Caminho da música
    private String mp3;

    public PlayerMp3(Context context) {

        // Cria o MediaPlayer
        player = MediaPlayer.create(context, R.raw.hello);
        // Executa o listener quando terminar a música
        player.setOnCompletionListener(this);

    }

    public void start(String mp3) {

        this.mp3 = mp3;

        try {

            switch (status) {
                case INICIADO:
                    player.stop();
                    break;
                case PARADO:
                    player.reset();
                    break;
                case NOVO:
                    //player.setDataSource(mp3);
                    //player.prepare();
                    player.start();
                    break;
                case PAUSADO:
                    player.start();
                    break;
            }

            status = PAUSADO;

        } catch (Exception e){

            Log.d(CATEGORIA, e.getMessage(), e);

        }

    }

    // Pausa a música e altera o status
    public void pause() {

        player.pause();
        status = PAUSADO;

    }
    // Para a música e altera o status
    public void stop() {

        player.stop();
        status = PARADO;

    }
    // Encerra o MediaPlayer e libera memória
    public void close() {

        stop();
        player.release();
        player = null;

    }
    // Retorna true se a música está todanco ou se está em pause
    public boolean isPlaying() {

        return status == INICIADO || status == PAUSADO;

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

        Log.d(CATEGORIA, "Fim da música: " + mp3);

    }

}
