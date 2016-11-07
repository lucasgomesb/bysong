package bysong.app.visualControls;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewAnimated extends TextView {

    private String mText;
    private int mIndex;
    private long mDelay = 500;
    OnTextFinishedListener onTextFinishedListener;

    public interface OnTextFinishedListener {
        void onTextFinished();
    }

    public TextViewAnimated(Context context) {
        super(context);
    }

    public TextViewAnimated(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDelay(long millis) {
        mDelay = millis;
    }

    private Handler mHandler;

    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if (mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public void showText(String text) {
        this.mText = text;
        mIndex = 0;

        setText("");
        mHandler.removeCallbacks(wordAdder);
        mHandler.postDelayed(wordAdder, mDelay);
    }

    public void showTextWordByWord(String text, OnTextFinishedListener onTextFinishedListener) {
        this.mText = text;
        this.onTextFinishedListener = onTextFinishedListener;

        mIndex = 0;

        setText("");

        mHandler = new Handler();
        mHandler.removeCallbacks(wordAdder);
        mHandler.postDelayed(wordAdder, mDelay);
    }

    private Word mwords[];

    public void showTextWordByWord(Word words[], OnTextFinishedListener onTextFinishedListener) {
        this.mwords = words;
        this.onTextFinishedListener = onTextFinishedListener;
        mIndex = 0;

        setText("");
        mHandler = new Handler();
        mHandler.removeCallbacks(wordAdder2);
        mHandler.postDelayed(wordAdder2, mDelay);
    }

    private Runnable wordAdder2 = new Runnable() {
        private String actualText;

        @Override
        public void run() {

            if (mIndex == mwords.length) {
                setText(actualText);
                actualText = "";
                onTextFinishedListener.onTextFinished();
                return;
            }

            String newWord = mwords[mIndex].text;
            int startWordPosition;
            int endWordPosition;

            if (actualText == null) {
                actualText = newWord;
                startWordPosition = 0;
                endWordPosition = newWord.length();
            } else {
                actualText += " ";
                startWordPosition = actualText.length();
                endWordPosition = startWordPosition + newWord.length();
                actualText = actualText + newWord;
            }

            SpannableString formattedString = new SpannableString(actualText);
            formattedString.setSpan(new RelativeSizeSpan(1.5f), startWordPosition, endWordPosition, 0);
            formattedString.setSpan(new ForegroundColorSpan(Color.RED), startWordPosition, endWordPosition, 0);

            setText(formattedString);


            mHandler.postDelayed(wordAdder2, mwords[mIndex].duration);
            mIndex++;
        }
    };

    private Runnable wordAdder = new Runnable() {
        private String actualText;

        @Override
        public void run() {

            if (mIndex == getWordsCount(mText)) {
                setText(actualText);
                actualText = "";
                onTextFinishedListener.onTextFinished();
                return;
            }

            String newWord = mText.split(" ")[mIndex];
            int startWordPosition;
            int endWordPosition;

            if (actualText == null) {
                actualText = newWord;
                startWordPosition = 0;
                endWordPosition = newWord.length();
            } else {
                actualText += " ";
                startWordPosition = actualText.length();
                endWordPosition = startWordPosition + newWord.length();
                actualText = actualText + newWord;
            }

            SpannableString formattedString = new SpannableString(actualText);
            formattedString.setSpan(new RelativeSizeSpan(1.5f), startWordPosition, endWordPosition, 0);
            formattedString.setSpan(new ForegroundColorSpan(Color.RED), startWordPosition, endWordPosition, 0);

            setText(formattedString);

            mIndex++;
            mHandler.postDelayed(wordAdder, mDelay);

        }
    };

    private int getWordsCount(String text) {
        return text.split(" ").length;
    }


}