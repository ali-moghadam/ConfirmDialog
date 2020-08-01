package com.alirnp.confirmdialogproject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.alirnp.confirmdialog.ConfirmDialog;


public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      Button button = findViewById(R.id.button);
      button.setOnClickListener(v -> openDialog());
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
              .setPositiveButtonListener("Positive", (dialog1, view) -> Toast.makeText(MainActivity.this, "Positive Button Clicked", Toast.LENGTH_SHORT).show())
              .setNegativeButtonListener("Negative", (dialog12, view) -> {
                 Toast.makeText(MainActivity.this, "Negative Button Clicked", Toast.LENGTH_SHORT).show();
                 dialog12.dismiss();
              })
              .build();

      dialog.show(getSupportFragmentManager(), null);

   }

}
