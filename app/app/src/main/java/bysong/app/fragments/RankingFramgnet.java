package bysong.app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bysong.app.R;
import bysong.app.adapter.RankingAdapter;
import bysong.app.domain.User;

/**
 * Created by Tiago on 17/08/2016.
 */
public class RankingFramgnet extends Fragment {

    private RecyclerView recyclerView;
    private List<User> users;
    private RankingAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        users = User.getUser();
        adapter = new RankingAdapter(getContext(), users);
        recyclerView = (RecyclerView) view.findViewById(R.id.rancking_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return view;

    }
}
