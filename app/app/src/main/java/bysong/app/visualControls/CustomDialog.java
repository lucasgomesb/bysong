package bysong.app.visualControls;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import bysong.app.R;

public class CustomDialog extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes;

    public CustomDialog(Activity a) {

        super(a, R.style.CustomDialogTest);
//        super(a);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.c = a;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_correct_answer);


    }

    @Override
    public void onClick(View v) {
       // switch (v.getId()) {
           // case R.id.btn_yes:
                //c.finish();
            //    this.dismiss();
            //    break;
            //case R.id.btn_no:
              //  dismiss();
                //break;
   //         default:
       //         break;
    //    }
        dismiss();
    }
}