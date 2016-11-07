package bysong.app.visualControls;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import bysong.app.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PopupWindowAnswerResult{

    private Context mContext;
    private PopupWindow mPopupWindow;
    private Button mButtonContinue;
    private OnDismissListener mOnDismissListener;

    public PopupWindowAnswerResult(Context context) {
        this.mContext = context;


    }

    public void showMessage(ViewGroup llMainLinearLayout, int messageType) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

        View customView = null;
        switch (messageType) {
            case MessageType.CORRECT_ANSWER:
                customView = inflater.inflate(R.layout.dialog_correct_answer, null);
                break;
            case MessageType.WRONG_ANSWER:
                customView = inflater.inflate(R.layout.dialog_wrong_answer, null);
                break;
        }

        customView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.dialog_open_animation));
        mButtonContinue = (Button) customView.findViewById(R.id.btContinue);
        mButtonContinue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mPopupWindow.dismiss();
            }

        });

        mPopupWindow = new PopupWindow(
                customView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mOnDismissListener.onDismiss();
            }
        });

        // Set an elevation value for popup window
        // Call requires API level 21
        if (Build.VERSION.SDK_INT >= 21) {
            mPopupWindow.setElevation(5.0f);
        }

        View.OnTouchListener customPopUpTouchListenr = new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {

                return false;
            }

        };
        mPopupWindow.showAtLocation(llMainLinearLayout, Gravity.CENTER, 0, 0);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setTouchInterceptor(customPopUpTouchListenr);
    }


    public static class MessageType {

        public static final int CORRECT_ANSWER = -1;
        public static final int WRONG_ANSWER = -2;
    }

    public void setOnDismissListener(PopupWindowAnswerResult.OnDismissListener onDismissListener) {
        mOnDismissListener = onDismissListener;
    }

    public interface OnDismissListener {
        void onDismiss();
    }
}