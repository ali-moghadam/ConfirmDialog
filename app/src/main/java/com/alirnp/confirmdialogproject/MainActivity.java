package com.alirnp.confirmdialogproject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.alirnp.confirmdialog.ConfirmDialog;
import com.alirnp.confirmdialog.OnClickListener;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      Button button = findViewById(R.id.button);
      button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

            new Timer().schedule(new TimerTask() {
               @Override
               public void run() {
                  runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                        openDialog();
                     }
                  });
               }
            }, 5000);

         }
      });
   }

   private void openDialog() {
      ConfirmDialog dialog = new ConfirmDialog.Builder(this, "Are you sure to delete item ?")

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

              .setPositiveButtonListener("Positive", new OnClickListener() {
                 @Override
                 public void onClick(DialogFragment dialog, View view) {
                    Toast.makeText(MainActivity.this, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
                 }
              })

              .setNegativeButtonListener("Negative", new OnClickListener() {
                 @Override
                 public void onClick(DialogFragment dialog, View view) {
                    Toast.makeText(MainActivity.this, "Negative Button Clicked", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                 }
              })

              .build();


      dialog.show(getSupportFragmentManager(), null);

   }

}
