package bysong.app.activity.notification;

import android.os.Bundle;
import android.app.Activity;

import bysong.app.R;

public class NotificationView extends Activity{
   @Override
   public void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.notification);
   }
}