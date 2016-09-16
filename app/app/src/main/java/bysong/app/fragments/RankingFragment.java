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
import bysong.app.service.BySongServiceManager;

/**
 * Created by Tiago on 17/08/2016.
 */
public class RankingFragment extends Fragment implements CallBackInterface {

    private RecyclerView recyclerView;
    private List<User> usersList;
    private RankingAdapter adapter;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_ranking, container, false);

        BySongServiceManager bySongServiceManager = new BySongServiceManager();
        bySongServiceManager.getUserFriends(this);

        return view;
    }

    @Override
    public void executeCallBack(Object result) {

        usersList = (List<User>) result;

        adapter = new RankingAdapter(getContext(), usersList);
        recyclerView = (RecyclerView) view.findViewById(R.id.rancking_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

}
