package bysong.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bysong.app.R;
import bysong.app.domain.User;

/**
 * Created by Tiago on 17/08/2016.
 * Classe SongsAdapter que herda de RecyclerView.Adapter para tratar as ações nos itens da lista
 * por não possuir métodos de interação (listener) é necessário implementar uma interface de callback
 */
public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.UserViewHolder> {

    private Context context;
    private List<User> users;
    private OnClickUser onClickUser;

    private interface OnClickUser {

        void onClickUser(UserViewHolder holder, int id);

    }

    public RankingAdapter(Context context, List<User> users) {

        this.context = context;
        this.users = users;

    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.linha_lista_ranking, parent, false);
        UserViewHolder holder = new UserViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        User user = users.get(position);
        holder.image_file_user.setImageResource(user.getImageFileName());
        holder.user_name.setText(user.getFirstName());
        holder.user_points.setText(String.valueOf(user.getScore()));
        if (user.getRankPosition() == 1) {

            holder.ranking_position.setText(String.valueOf(user.getRankPosition()) + "st");

        } else if (user.getRankPosition() == 2) {

            holder.ranking_position.setText(String.valueOf(user.getRankPosition()) + "nd");

        } else if (user.getRankPosition() > 2) {

            holder.ranking_position.setText(String.valueOf(user.getRankPosition()) + "th");

        }

    }

    @Override
    public int getItemCount() {

        return users == null ? 0 : users.size();

    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_file_user;
        private TextView user_name, user_points, ranking_position;

        public UserViewHolder(View itemView) {

            super(itemView);
            image_file_user = (ImageView) itemView.findViewById(R.id.img_file_user);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            user_points = (TextView) itemView.findViewById(R.id.user_points);
            ranking_position = (TextView) itemView.findViewById(R.id.ranking_position);

        }

    }

}
