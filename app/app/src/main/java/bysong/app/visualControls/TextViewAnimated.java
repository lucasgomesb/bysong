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

    private String text;
    private int index;
    private long delay = 500;
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
        delay = millis;
    }

    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(text.subSequence(0, index++));
            if (index <= text.length()) {
                mHandler.postDelayed(characterAdder, delay);
            }
        }
    };

    public void showText(String text) {
        this.text = text;
        index = 0;

        setText("");
        mHandler.removeCallbacks(wordAdder);
        mHandler.postDelayed(wordAdder, delay);
    }

    public void showTextWordByWord(String text, OnTextFinishedListener onTextFinishedListener) {
        this.text = text;
        this.onTextFinishedListener = onTextFinishedListener;

        index = 0;
        setText("");
        mHandler.removeCallbacks(wordAdder);
        mHandler.postDelayed(wordAdder, delay);
    }

    private Runnable wordAdder = new Runnable() {
        private String actualText;

        @Override
        public void run() {

            if (index == getWordsCount(text)) {
                setText(actualText);
                onTextFinishedListener.onTextFinished();
                return;
            }

            String newWord = text.split(" ")[index];
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

            index++;
            mHandler.postDelayed(wordAdder, delay);

        }
    };

    private int getWordsCount(String text) {
        return text.split(" ").length;
    }

}