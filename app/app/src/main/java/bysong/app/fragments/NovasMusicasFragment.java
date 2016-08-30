package bysong.app.fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import bysong.app.R;
import bysong.app.adapter.SongsAdapter;
import bysong.app.adapter.ImagePageAdapter;
import bysong.app.domain.PlayerMp3;
import bysong.app.domain.Song;

/**
 * Created by Tiago on 10/08/2016.
 */
public class NovasMusicasFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Song> songs;
    private PlayerMp3 playerMp3;
    private int[] imagens = new int[]{
            R.drawable.music_icon,
            R.drawable.music_icon_2,
            R.drawable.document_audio
    };

    private ImageView img1, img2, img3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_imagem_1, container, false);

        img1 = (ImageView) view.findViewById(R.id.img1);
        img2 = (ImageView) view.findViewById(R.id.img2);
        img3 = (ImageView) view.findViewById(R.id.img3);

        // ViewPager
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new ImagePageAdapter(getContext(), imagens));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {

                    case 0:
                        img1.setImageResource(R.drawable.checkbox_blank_circle);
                        img2.setImageResource(R.drawable.checkbox_blank_circle_outline);
                        img3.setImageResource(R.drawable.checkbox_blank_circle_outline);
                        break;
                    case 1:
                        img1.setImageResource(R.drawable.checkbox_blank_circle_outline);
                        img2.setImageResource(R.drawable.checkbox_blank_circle);
                        img3.setImageResource(R.drawable.checkbox_blank_circle_outline);
                        break;
                    case 2:
                        img1.setImageResource(R.drawable.checkbox_blank_circle_outline);
                        img2.setImageResource(R.drawable.checkbox_blank_circle_outline);
                        img3.setImageResource(R.drawable.checkbox_blank_circle);
                        break;


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;

    }

    private SongsAdapter.OnClickSongs onClickSongsMuisc() {

        return new SongsAdapter.OnClickSongs() {

            @Override
            public void onClickPlay(SongsAdapter.SongsViewHolder holder, int id) {

                //playerMp3.start("");
                holder.song_item_audio.setVisibility(View.GONE);
                holder.song_item_audio_pause.setVisibility(View.VISIBLE);

            }

            @Override
            public void onClickPause(SongsAdapter.SongsViewHolder holder, int id) {

                playerMp3.pause();
                holder.song_item_audio.setVisibility(View.VISIBLE);
                holder.song_item_audio_pause.setVisibility(View.GONE);

            }

        };

    }

}
