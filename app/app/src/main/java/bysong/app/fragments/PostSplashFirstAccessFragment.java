package bysong.app.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import bysong.app.R;
import bysong.app.activity.MainActivity;
import bysong.app.domain.PlayerMp3;
import bysong.app.visualControls.TextViewAnimated;

/**
 * Created by Tiago on 17/08/2016.
 */
public class PostSplashFirstAccessFragment extends Fragment implements TextViewAnimated.OnTextFinishedListener {

    private final String TAG = "songplayer";
    View view;
    Button btSkipTutorial;
    Button btSendAnswer;
    TextViewAnimated tvSongVerse;
    RadioGroup rgWords;
    LinearLayout llMainLayout;
    LinearLayout llTutorialVerse;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_post_splash_first_access, container, false);

        btSkipTutorial = (Button) view.findViewById(R.id.btSkipTutorial);
        btSkipTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skipTutorial();
            }
        });

        btSendAnswer = (Button) view.findViewById(R.id.btSendAnswer);
        btSendAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendAnswer();
            }
        });

        rgWords = (RadioGroup) view.findViewById(R.id.rgWords);
        rgWords.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                changeWordRadio(group, checkedId);
            }
        });

        tvSongVerse = (TextViewAnimated) view.findViewById(R.id.tvSongVerse);
        llMainLayout = (LinearLayout) view.findViewById(R.id.llMainLayout);
        llTutorialVerse = (LinearLayout) view.findViewById(R.id.llTutorialVerse);

        llTutorialVerse.setVisibility(View.INVISIBLE);

        this.tutorialFromBobMarley();

        return view;
    }

    private void tutorialFromBobMarley() {

        PlayerMp3 playerPreview = new PlayerMp3(this.getContext());
        playerPreview.playLocalFile(R.raw.bob_marley_is_this_love, 20000, 3300);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tvSongVerse.setDelay(300);
        tvSongVerse.showTextWordByWord("I wanna love you!", this);
    }

    @Override
    public void onTextFinished() {
        llTutorialVerse.setVisibility(View.VISIBLE);
    }

    private void skipTutorial() {
        startActivity(new Intent(getContext(), MainActivity.class));
    }

    private void sendAnswer() {

    }

    private void changeWordRadio(RadioGroup group, int checkedId) {
        View radioButton = group.findViewById(checkedId);
        int index = group.indexOfChild(radioButton);

        btSendAnswer.setTextColor(Color.parseColor("#167e41"));
        btSendAnswer.setBackgroundColor(Color.parseColor("#c2ffd2"));


        switch (index) {
            case 0: // first button
                break;
            case 1: // secondbutton
                break;
        }
    }

}
