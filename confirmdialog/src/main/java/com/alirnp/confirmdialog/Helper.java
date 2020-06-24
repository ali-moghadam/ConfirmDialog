package com.alirnp.confirmdialog;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.widget.Button;

public class Helper {

   public static void setRippleColor(Button button, int color) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

         button.setBackground(new RippleDrawable(ColorStateList.valueOf(color), button.getBackground(), null));
      } else {
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            button.setBackground(makeSelector(color));
         } else {
            button.setBackgroundDrawable(makeSelector(color));
         }
      }
   }

   private static StateListDrawable makeSelector(int color) {
      StateListDrawable res = new StateListDrawable();
      res.setExitFadeDuration(400);
      res.setAlpha(45);
      res.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(color));
      res.addState(new int[]{}, new ColorDrawable(Color.TRANSPARENT));
      return res;
   }
}
