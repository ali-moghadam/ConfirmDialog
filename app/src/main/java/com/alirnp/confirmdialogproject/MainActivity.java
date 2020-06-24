package com.alirnp.confirmdialogproject;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.alirnp.confirmdialog.ConfirmDialog;
import com.alirnp.confirmdialog.OnClickListener;


public class MainActivity extends AppCompatActivity {

   public static StateListDrawable makeSelector(int color) {
      StateListDrawable res = new StateListDrawable();
      res.setExitFadeDuration(400);
      res.setAlpha(45);
      res.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(color));
      res.addState(new int[]{}, new ColorDrawable(Color.TRANSPARENT));
      return res;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);


      Button button = findViewById(R.id.button);
      button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            openDialog();
         }
      });
   }

   private void openDialog() {
      ConfirmDialog dialog = new ConfirmDialog.Builder("Are you sure to delete item ?")

              .setTextPositiveButton("Confirm")
              .setTextNegativeButton("Cancel")
              .setTypeface(Typeface.SANS_SERIF)

              .setColorPositiveButton(getResources().getColor(R.color.colorPrimary))
              .setColorNegativeButton(getResources().getColor(R.color.gray))

              .setColorTextPositiveButton(getResources().getColor(android.R.color.white))
              .setColorTextNegativeButton(getResources().getColor(android.R.color.tab_indicator_text))

              .setColorRipplePositiveButton(getResources().getColor(android.R.color.white))
              .setColorRippleNegativeButton(getResources().getColor(R.color.colorPrimary))

              .setIcon(R.drawable.ic_alert)
              .setIconColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))

              .setMessageBody("For more information about this library, read the document in github.")

              .setPositiveButtonListener(new OnClickListener() {
                 @Override
                 public void onClick(DialogFragment dialog, View view) {
                    Toast.makeText(MainActivity.this, "mButtonPositive", Toast.LENGTH_SHORT).show();
                 }
              })
              .setNegativeButtonListener(new OnClickListener() {
                 @Override
                 public void onClick(DialogFragment dialog, View view) {
                    dialog.dismiss();
                 }
              }).build();

      dialog.show(getSupportFragmentManager(), null);
   }
}
