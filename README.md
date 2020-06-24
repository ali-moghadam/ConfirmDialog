# ConfirmDialog

<img src="https://raw.githubusercontent.com/alipapital/ConfirmDialog/master/files/confirm_dialog.png" width="500">

### How To Create Confirm Dialog ?

```java
      ConfirmDialog dialog = new ConfirmDialog.Builder("Are you sure to delete item ?")
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
                    Toast.makeText(MainActivity.this, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
                 }
              })
              .setNegativeButtonListener(new OnClickListener() {
                 @Override
                 public void onClick(DialogFragment dialog, View view) {
                    dialog.dismiss();
                 }
              }).build();

      dialog.show(getSupportFragmentManager(), null);
