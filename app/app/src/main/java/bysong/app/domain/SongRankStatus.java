package bysong.app.domain;

import bysong.app.R;

/**
 * Created by Lucas on 14/08/2016.
 * Classe SongRankStatus alterada de enum para classe comum mantendo
 * os atributos
 */
public class SongRankStatus {

    public static final int DOWN = 0;
    public static final int NO_CHANGES = 1;
    public static final int UP = 2;

    public static int getStatus(int status) {

        switch (status) {
            case DOWN:
                return R.drawable.song_item_status_rank_down;
            case NO_CHANGES:
                return R.drawable.song_item_status_rank_nochanges;
            case UP:
                return R.drawable.song_item_status_rank_up;
        }

        return 0;

    }

}
