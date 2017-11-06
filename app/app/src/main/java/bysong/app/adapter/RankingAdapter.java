package bysong.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import bysong.app.R;
import bysong.app.application.Application;
import bysong.app.domain.User;

/**
 * Created by Tiago on 17/08/2016.
 * Classe SongsAdapter que herda de RecyclerView.Adapter para tratar as ações nos itens da lista
 * por não possuir métodos de interação (listener) é necessário implementar uma interface de callback
 */
public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.UserViewHolder> {

    private Context context;
    private List<User> users;

    public RankingAdapter(Context context, List<User> users) {

        this.context = context;
        this.users = users;

    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_list_ranking, parent, false);
        //  view.setBackgroundColor(Color.parseColor("#123456"));
        UserViewHolder holder = new UserViewHolder(view);

//        view.setBackgroundColor(Color.parseColor("#efefef"));

        return holder;

    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        User user = users.get(position);
        holder.image_file_user.setImageResource(context.getResources().getIdentifier(user.getImageFileName(), "drawable", "bysong.app"));
        holder.user_code.setText(user.getUserCode());
        holder.user_name.setText(user.getFirstName() + " " + user.getLastName());
        holder.user_points.setText(new DecimalFormat("#,###").format(user.getScore()));
        holder.ranking_position.setText(String.valueOf(user.getRankPosition()));

        User loggedUser = Application.getInstance().getLoggedUser();
        int position2 = getItemCount();

        switch (position) {
            case 0:
                holder.img_trophy.setVisibility(View.VISIBLE);
                holder.img_trophy.setImageResource(R.drawable.gold_trophy);
                holder.ranking_position.setVisibility(View.GONE);

                break;
            case 1:
                holder.img_trophy.setVisibility(View.VISIBLE);
                holder.img_trophy.setImageResource(R.drawable.silver_trophy);
                holder.ranking_position.setVisibility(View.GONE);
                break;
            case 2:
                holder.img_trophy.setVisibility(View.VISIBLE);
                holder.img_trophy.setImageResource(R.drawable.bronze_trophy);
                holder.ranking_position.setVisibility(View.GONE);
                break;
            default:
                holder.img_trophy.setVisibility(View.GONE);
                holder.ranking_position.setVisibility(View.VISIBLE);
                break;
        }

        if (user.getUserCode().equals(loggedUser.getUserCode()))
            holder.itemView.setBackgroundColor(Color.parseColor("#e1ffef"));
        //else
        //  holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));

    }

    @Override
    public int getItemCount() {

        return users == null ? 0 : users.size();

    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_file_user, img_trophy;
        private TextView user_code, user_name, user_points, ranking_position;

        public UserViewHolder(View itemView) {

            super(itemView);
            image_file_user = (ImageView) itemView.findViewById(R.id.img_file_user);
            img_trophy = (ImageView) itemView.findViewById(R.id.img_trophy);
            user_code = (TextView) itemView.findViewById(R.id.user_code);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            user_points = (TextView) itemView.findViewById(R.id.user_points);
            ranking_position = (TextView) itemView.findViewById(R.id.ranking_position);

        }

    }

}
