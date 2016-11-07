package bysong.app.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bysong.app.R;
import bysong.app.activity.MainActivity;
import bysong.app.domain.PlayerMp3;
import bysong.app.visualControls.PopupWindowAnswerResult;
import bysong.app.visualControls.TextViewAnimated;
import bysong.app.visualControls.Word;

import static bysong.app.fragments.PostSplashFirstAccessFragment.Verse.QUESTION_TYPE_AUDIO_TO_SELECT;
import static bysong.app.fragments.PostSplashFirstAccessFragment.Verse.QUESTION_TYPE_PORTUGUESE_TEXT_TO_SELECT;


/**
 * Created by Tiago on 17/08/2016.
 */
public class PostSplashFirstAccessFragment extends BaseFragment implements TextViewAnimated.OnTextFinishedListener {


    View view;
    Button mbtSkipTutorial;
    Button mbtSendAnswer;
    ImageView mReplayVerse;
    TextView mtvVerseQuestion;
    TextView mtvVerseInstruction;
    TextViewAnimated mtvSongVerse;
    RadioGroup mrgWords;
    RadioButton mrbOption1;
    RadioButton mrbOption2;
    RadioButton mrbOption3;
    RadioButton mrbOption4;
    RelativeLayout mllMainRelativeLayout;
    LinearLayout mllMainLinearLayout;
    LinearLayout mllTutorialVerse;
    Verse mVerseTutorialArray[];
    int mActualVerseIndex;
    int mVerseCount = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_post_splash_first_access, container, false);

        mtvVerseQuestion = (TextView) view.findViewById(R.id.tvVerseQuestion);
        mtvVerseInstruction = (TextView) view.findViewById(R.id.tvVerseInstruction);

        mbtSkipTutorial = (Button) view.findViewById(R.id.btSkipTutorial);
        mbtSkipTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skipTutorial();
            }
        });

        mReplayVerse = (ImageView) view.findViewById(R.id.replay_verse);
        mReplayVerse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playActualVerse();
            }
        });

        mbtSendAnswer = (Button) view.findViewById(R.id.btSendAnswer);
        mbtSendAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendAnswer();
            }
        });

        mrgWords = (RadioGroup) view.findViewById(R.id.rgWords);
        mrgWords.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                changeWordRadio(group, checkedId);
            }
        });

        mrbOption1 = (RadioButton) view.findViewById(R.id.rbOption1);
        mrbOption2 = (RadioButton) view.findViewById(R.id.rbOption2);
        mrbOption3 = (RadioButton) view.findViewById(R.id.rbOption3);
        mrbOption4 = (RadioButton) view.findViewById(R.id.rbOption4);

        mtvSongVerse = (TextViewAnimated) view.findViewById(R.id.tvSongVerse);
        mllMainLinearLayout = (LinearLayout) view.findViewById(R.id.llMainLinearLayout);
        mllMainRelativeLayout = (RelativeLayout) view.findViewById(R.id.llMainRelativeLayout);

        mllTutorialVerse = (LinearLayout) view.findViewById(R.id.llTutorialVerse);

        mllTutorialVerse.setVisibility(View.INVISIBLE);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();


        this.startTutorial();
    }

    private void startTutorial() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mVerseTutorialArray = new Verse[mVerseCount];
        Verse verseTutorial;

        // -------------------------------------------------
        // Canção 1
        // -------------------------------------------------
        verseTutorial = new Verse();
        verseTutorial.resourceFileID = R.raw.sam_smith_im_not_the_only_one;
        verseTutorial.words = new Word[7];

        verseTutorial.words[0] = new Word("I", 450);
        verseTutorial.words[1] = new Word("know", 350);
        verseTutorial.words[2] = new Word("i'm", 400);
        verseTutorial.words[3] = new Word("not", 400);
        verseTutorial.words[4] = new Word("the", 300);
        verseTutorial.words[5] = new Word("???", 900);
        verseTutorial.words[6] = new Word("???", 700);
        verseTutorial.questionType = QUESTION_TYPE_AUDIO_TO_SELECT;
        verseTutorial.verseQuestion = "Casar com aquela garota, casar com ela ..........";
        verseTutorial.introductionDuration = 200;
        verseTutorial.startTime = 130000;
        verseTutorial.duration = 4300;
        verseTutorial.answerOptions = new AnswerOption[4];
        verseTutorial.answerOptions[0] = new AnswerOption("anyone");
        verseTutorial.answerOptions[1] = new AnswerOption("only one");
        verseTutorial.answerOptions[2] = new AnswerOption("on new run");
        verseTutorial.answerOptions[3] = new AnswerOption("lonely one");
        verseTutorial.correctAnswer = verseTutorial.answerOptions[1];

        mVerseTutorialArray[0] = verseTutorial;

        // -------------------------------------------------
        // Canção 2
        // -------------------------------------------------
        verseTutorial = new Verse();
        verseTutorial.resourceFileID = R.raw.bob_marley_is_this_love;
        verseTutorial.words = new Word[4];
        verseTutorial.words[0] = new Word("I", 400);
        verseTutorial.words[1] = new Word("wanna", 400);
        verseTutorial.words[2] = new Word("love", 400);
        verseTutorial.words[3] = new Word("you", 400);
        verseTutorial.questionType = QUESTION_TYPE_PORTUGUESE_TEXT_TO_SELECT;
        verseTutorial.verseQuestion = "Eu quero ........ você";
        verseTutorial.introductionDuration = 1400;
        verseTutorial.startTime = 20000;
        verseTutorial.duration = 3300;
        verseTutorial.answerOptions = new AnswerOption[4];
        verseTutorial.answerOptions[0] = new AnswerOption("cantar com");
        verseTutorial.answerOptions[1] = new AnswerOption("amar");
        verseTutorial.answerOptions[2] = new AnswerOption("levar");
        verseTutorial.answerOptions[3] = new AnswerOption("ver");
        verseTutorial.correctAnswer = verseTutorial.answerOptions[1];

        mVerseTutorialArray[1] = verseTutorial;

        // -------------------------------------------------
        // Canção 3
        // -------------------------------------------------
        verseTutorial = new Verse();
        verseTutorial.resourceFileID = R.raw.magic_rude;
        verseTutorial.words = new Word[6];
        verseTutorial.words[0] = new Word("Marry", 450);
        verseTutorial.words[1] = new Word("that", 200);
        verseTutorial.words[2] = new Word("girl,\n", 750);
        verseTutorial.words[3] = new Word("marry", 400);
        verseTutorial.words[4] = new Word("her", 450);
        verseTutorial.words[5] = new Word("anyway", 500);
        verseTutorial.questionType = QUESTION_TYPE_PORTUGUESE_TEXT_TO_SELECT;
        verseTutorial.verseQuestion = "Casar com aquela garota, casar com ela ..........";
        verseTutorial.introductionDuration = 50;
        verseTutorial.startTime = 55000;
        verseTutorial.duration = 3300;
        verseTutorial.answerOptions = new AnswerOption[4];
        verseTutorial.answerOptions[0] = new AnswerOption("mais uma vez");
        verseTutorial.answerOptions[1] = new AnswerOption("para sempre");
        verseTutorial.answerOptions[2] = new AnswerOption("amanhã");
        verseTutorial.answerOptions[3] = new AnswerOption("de qualquer jeito");
        verseTutorial.correctAnswer = verseTutorial.answerOptions[3];

        mVerseTutorialArray[2] = verseTutorial;

        mActualVerseIndex = 0;
        this.playActualVerse();
    }

    private void playActualVerse() {

        mllTutorialVerse.setVisibility(View.INVISIBLE);

        if (mActualVerseIndex == mVerseCount) {
            this.openMainActivity();
            return;
        }

        Verse verseTutorial = mVerseTutorialArray[mActualVerseIndex];



        switch (verseTutorial.questionType)
        {
            case QUESTION_TYPE_AUDIO_TO_SELECT:
                mtvVerseInstruction.setText("Selecione o trecho que falta:");
                mtvVerseQuestion.setText("");
                break;
            case QUESTION_TYPE_PORTUGUESE_TEXT_TO_SELECT:
                mtvVerseInstruction.setText("Selecione o trecho que falta:");
                mtvVerseQuestion.setText(verseTutorial.verseQuestion);
                break;
        }


        mrbOption1.setText(verseTutorial.answerOptions[0].text);
        mrbOption2.setText(verseTutorial.answerOptions[1].text);
        mrbOption3.setText(verseTutorial.answerOptions[2].text);
        mrbOption4.setText(verseTutorial.answerOptions[3].text);


        mrbOption1.setChecked(false);
        mrbOption2.setChecked(false);
        mrbOption3.setChecked(false);
        mrbOption4.setChecked(false);
        mrgWords.clearCheck();
        this.enableButtonSendAnswer(false);

        PlayerMp3 playerPreview = new PlayerMp3(this.getContext());
        playerPreview.playLocalFile(verseTutorial.resourceFileID, verseTutorial.startTime, verseTutorial.duration);

        mtvSongVerse.setDelay(verseTutorial.introductionDuration);
        mtvSongVerse.showTextWordByWord(verseTutorial.words, this);
    }

    @Override
    public void onTextFinished() {

        mllTutorialVerse.setVisibility(View.VISIBLE);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(2000);
        mllTutorialVerse.startAnimation(fadeIn);

    }

    private void skipTutorial() {
        this.openMainActivity();
    }

    private void openMainActivity() {
        startActivity(new Intent(getContext(), MainActivity.class));
    }

    private void sendAnswer() {

        this.enableButtonSendAnswer(false);

        Verse verseTutorial = mVerseTutorialArray[mActualVerseIndex];

        PopupWindowAnswerResult popupWindowAnswerResult = new PopupWindowAnswerResult(getContext());
        popupWindowAnswerResult.setOnDismissListener(new PopupWindowAnswerResult.OnDismissListener() {
            @Override
            public void onDismiss() {
                mActualVerseIndex++;
                playActualVerse();
            }
        });

        int radioButtonIDChecked = mrgWords.getCheckedRadioButtonId();
        int radioButtonIDCorrectAnswer = 0;

        if (mrbOption1.getText() == verseTutorial.correctAnswer.text) {
            radioButtonIDCorrectAnswer = R.id.rbOption1;
        } else if (mrbOption2.getText() == verseTutorial.correctAnswer.text) {
            radioButtonIDCorrectAnswer = R.id.rbOption2;
        } else if (mrbOption3.getText() == verseTutorial.correctAnswer.text) {
            radioButtonIDCorrectAnswer = R.id.rbOption3;
        } else if (mrbOption4.getText() == verseTutorial.correctAnswer.text) {
            radioButtonIDCorrectAnswer = R.id.rbOption4;
        }

        if (radioButtonIDChecked <= 0) {
            toast("Selecione uma resposta");
            return;
        }

        boolean correctAnswer = false;
        if (radioButtonIDChecked == radioButtonIDCorrectAnswer) {
            correctAnswer = true;
        }

        if (correctAnswer) {
            popupWindowAnswerResult.showMessage(mllMainLinearLayout, PopupWindowAnswerResult.MessageType.CORRECT_ANSWER);
        } else {

            RadioButton rbCorrectAnswer = (RadioButton) mrgWords.findViewById(radioButtonIDCorrectAnswer);
            String correctText = rbCorrectAnswer.getText().toString();
            //builder.setMessage("Você errou! O correto era \"" + correctText + "\".");
            //builder.setTitle("Que pena...");
            popupWindowAnswerResult.showMessage(mllMainLinearLayout, PopupWindowAnswerResult.MessageType.WRONG_ANSWER);
        }


    }

    private void changeWordRadio(RadioGroup group, int checkedId) {
        View radioButton = group.findViewById(checkedId);
        int index = group.indexOfChild(radioButton);

        this.enableButtonSendAnswer(true);

        switch (index) {
            case 0: // first button
                break;
            case 1: // secondbutton
                break;
        }
    }

    private void enableButtonSendAnswer(boolean enable) {
        if (enable) {
            mbtSendAnswer.setTextColor(Color.parseColor("#167e41"));
            mbtSendAnswer.setBackgroundColor(Color.parseColor("#c2ffd2"));
        } else {
            mbtSendAnswer.setTextColor(Color.parseColor("#939393"));
            mbtSendAnswer.setBackgroundColor(Color.parseColor("#d1d1d1"));

        }

    }

    class Verse {
        int resourceFileID;
        //  String text;
        String verseQuestion;
        int introductionDuration;
        int startTime;
        int duration;
        int questionType;
        public static final int QUESTION_TYPE_AUDIO_TO_SELECT = 1;
        public static final int QUESTION_TYPE_PORTUGUESE_TEXT_TO_SELECT = 2;
        Word words[];
        AnswerOption answerOptions[];
        AnswerOption correctAnswer;
    }

    class AnswerOption {
        String text;

        public AnswerOption(String text) {
            this.text = text;
        }
    }


}
