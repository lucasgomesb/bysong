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

import com.facebook.AccessToken;
import com.facebook.Profile;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bysong.app.R;
import bysong.app.adapter.RankingAdapter;
import bysong.app.domain.User;
import bysong.app.service.BySongServiceManager;
import bysong.app.visualControls.SimpleDividerItemDecoration;

/**
 * Created by Tiago on 17/08/2016.
 */
public class RankingFragment extends Fragment implements CallBackInterface {

    private RecyclerView recyclerView;
    private List<User> usersList;
    private RankingAdapter adapter;
    Profile facebookProfile;
    AccessToken facebookAccessToken;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_ranking, container, false);

        BySongServiceManager bySongServiceManager = new BySongServiceManager();
        bySongServiceManager.getUserFriends(this);

        facebookAccessToken = AccessToken.getCurrentAccessToken();
        facebookProfile = Profile.getCurrentProfile();

        if (facebookProfile != null) {

        }
        else
        {

        }

        return view;
    }

    @Override
    public void executeCallBack(Object result, Type type) {

        usersList = (List<User>) result;

        // Ordena a lista de usuários
        Collections.sort(usersList, new Comparator<User>() {
            @Override
            public int compare(User lhs, User rhs) {
                return lhs.getRankPosition() > rhs.getRankPosition() ? 1 : -1;
            }
        });

        adapter = new RankingAdapter(getContext(), usersList);
        recyclerView = (RecyclerView) view.findViewById(R.id.rancking_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
    }





}
