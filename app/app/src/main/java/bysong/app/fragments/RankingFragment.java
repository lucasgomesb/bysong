package bysong.app.fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.Comparator;
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


    public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
        private Drawable mDivider;

        public SimpleDividerItemDecoration(Context context) {
            mDivider = ContextCompat.getDrawable(context,R.drawable.line_divider);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = 30;
            int right = parent.getWidth() - 30;

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }


}
