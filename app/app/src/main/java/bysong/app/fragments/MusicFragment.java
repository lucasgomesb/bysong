package bysong.app.fragments;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import bysong.app.R;
import bysong.app.domain.PlayerMp3;

/**
 * Created by Tiago on 09/09/2016.
 */
public class MusicFragment extends Fragment implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private static final String TAG = "songplayer";

    private TextView letra;
    private Button btn_tocar_musica;
    private PlayerMp3 playerMp3;
    private boolean isPlaying;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_music, container, false);
        letra = (TextView) view.findViewById(R.id.letra);
        btn_tocar_musica = (Button) view.findViewById(R.id.btn_tocar_trecho_musica);
        btn_tocar_musica.setOnClickListener(onClickTocar());
        tocarMusica();
        return view;

    }

    private void tocarMusica() {

        try {

            isPlaying = true;
            playerMp3 = PlayerMp3.getInstance((MediaPlayer.OnPreparedListener) MusicFragment.this,
                    (MediaPlayer.OnCompletionListener)MusicFragment.this);
            AssetFileDescriptor asset = getActivity().getAssets().openFd("pra_nao_morrer_de_paixao_refrao.mp3");
            playerMp3.start(asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength());

        } catch (IOException e) { e.printStackTrace(); }

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

        Log.d(TAG, "onCompletion()");
        playerMp3.stop();
        playerMp3.killMyInstance();
        letra.setVisibility(View.VISIBLE);
        btn_tocar_musica.setEnabled(true);

    }


    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

        Log.d(TAG, "onPrepared()");
        isPlaying = true;
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

    }

    private View.OnClickListener onClickTocar() {

        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                tocarMusica();
                //letra.setVisibility(View.INVISIBLE);
                btn_tocar_musica.setEnabled(false);

            }

        };

    }

}
